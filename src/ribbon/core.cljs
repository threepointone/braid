(ns ribbon.core
  (:require [clojure.browser.repl :as repl]))

;; (repl/connect "http://localhost:9000/repl")

(defn foo [a b]
  (+ a b))

(enable-console-print!)

(println "Hello world!")

