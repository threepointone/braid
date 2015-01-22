(ns ribbon.core
  (:require [ui.core :as ui]))

;; [clojure.browser.repl :as repl]
;; (repl/connect "http://localhost:9000/repl")

(enable-console-print!)

(set! (.-React js/window) (js/require "react"))

(defn render[input data]
  (ui/toDOM 
    (ui/ui input data        	
      (fn [e] 
        (let [term (.. e -target -value)] 
          (.pushState js/history nil nil term)
          (ui/search term (fn [err res] (render term res))))))
    (.getElementById js/document "container")))

(def start (.slice (.. js/window -location -pathname ) 1))

(if start 
  (ui/search start (fn [err res] (render start res)))
  (render start []))



 