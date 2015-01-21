
(ns braid.core
	(:require [cljs.nodejs :as n]))

(n/enable-util-print!)

(.log js/console (.cwd js/process))

(let [
	debug ((n/require "debug") "braid")
	express (n/require "express")
	app (express) 
	path (n/require "path")
	logger (n/require "morgan")
 	serve-favicon (n/require "serve-favicon")
 	cookie-parser (n/require "cookie-parser")
	body-parser (n/require "body-parser")
	module (js* "module")
 	; cwd (.cwd process)
	port (or (.. js/process -env -BRAIDPORT) 3693)]

	(doto app 
		(.set "views" "./views")
		(.set "view engine" "jade")
  	(.use (serve-favicon "./public/favicon.ico"))
		(.use (logger "dev"))
		(.use (.json body-parser))
		(.use (.urlencoded body-parser #js {:extended false}))
  	(.use (cookie-parser))
  	(.use (n/require "less-middleware" "./public"))
		(.use (.static express "./public"))
		(.use (fn [req res next] 
			(let [err (new js/Error "Not Found")]
				(set! (.-status err) 404)
				(next err))))
		(.use (fn [err req res next] 
			(.error js/console (.-stack err))
			(.status res (or (.-status err) 500))
			(.render res "error" #js {:message err.message :error err})))
		(.set "port" port)
		(.listen port #(debug (str "express server listening on port " port)))  
  )
	
	(set! (.-exports module) app))


(defn run [] nil)
(defn -main [] (run))
(set! *main-cli-fn* -main)