(ns braid.core  
  (:require [cljs.nodejs :as n]
            [ui.core :as ui]))

(n/enable-util-print!)
(defn -main [] nil)
(set! *main-cli-fn* -main)  

(defn search[term cb] 
  (-> (js/require "superagent") 
    (.get "http://nominatim.openstreetmap.org/search")
    (.query #js {:q term :format "json"})
    (.end cb)))


(let [
  clog (js/require "colors")
  dirname (js* "__dirname")
  path (js/require "path")
  debug ((js/require "debug") "braid")
  port (or (.. js/process -env -BRAIDPORT) 3693)
  express (js/require "express")
  app (express) 
  body-parser (js/require "body-parser")] 
  
  (doto app 
    (.set "views" "./views")
    (.set "view engine" "jade")
    (.use ((js/require "serve-favicon") "./public/favicon.ico"))
    (.use ((js/require "morgan") "dev"))
    (.use (.json body-parser))
    (.use (.urlencoded body-parser #js {:extended false}))
    (.use ((js/require "cookie-parser")))
    (.use (.static express "./public"))
    (.use (.static express "./out"))
    
    
    (.get "/" (fn [req res next]
      (.send res (ui/toHTML (ui/page (ui/ui "" [] (fn[]())))))))
    
    (.get "/:term" (fn [req res next]
      (let [term (.. req -params -term)]
        (ui/search term
          (fn [err response] (.send res (ui/toHTML (ui/page (ui/ui term response (fn[]()))))))))))

    ;; an api endpoint to use 
    (.get "/api/:term" (fn [req res next] 
      (search (.. req -params -term) (fn [err response] 
        (.send res (.-body response))))))
    
    
    
    ;; error handlers 
    
    ;; 404
    (.use (fn [req res next] 
      (let [err (new js/Error "Not Found")]
        (set! (.-status err) 404)
        (next err))))
    
    ;; 500 / catch all
    (.use (fn [err req res next] 
      (.error js/console (.-red (str (.-status err))) (.-url req) (.-red (.-message err)))
      (.status res (or (.-status err) 500))
      (.send res #js {:message err.message :error err})))
    
    ;; start it up
    (.set "port" port)
    (.listen port #(debug (str "express server listening on port " port)))))

 