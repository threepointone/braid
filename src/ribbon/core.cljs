(ns ribbon.core
  (:require 
            [ui.core :as ui]))

;; [clojure.browser.repl :as repl]
;; (repl/connect "http://localhost:9000/repl")

(defn foo [a b]
  (+ a b))

(enable-console-print!)

(.log js/console 123)    

(set! (.-React js/window) (js/require "react"))

(ui/toDOM (ui/ui []) (.getElementById js/document "container"))