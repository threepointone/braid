(ns ui.core
  (:require [reagent.core :as reagent :refer [atom]]))

;; an endpoint to search for city data
(defn search[term cb] 
  (-> (js/require "superagent") 
    (.get (str "http://localhost:3693/api/" (js/encodeURIComponent term)))
    (.end (fn [err res] 
      (if err 
        (cb err) 
        (cb nil (js->clj (.-body res))))))))

(defn ui [term data on-change]
  [:div {:class "container"} 
   [:div {:class "search"}
    [:input {:on-change on-change :default-value term}]]
   [:pre {:class "results"} (.stringify js/JSON (clj->js data) nil "  ")]])

(defn toHTML [c]
  (str "<!doctype html>" (reagent/render-to-static-markup c))) 

(defn tostr [c]
  (str "<!doctype html>" (reagent/render-to-string c))) 


(defn toDOM [c el]
  (reagent/render-component c el))   