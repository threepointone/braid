(ns ui.core
  (:require [reagent.core :as reagent :refer [atom]]))

;; an endpoint to search for city data
(defn search[term cb] 
  (-> (js/require "superagent") 
    (.get "http://nominatim.openstreetmap.org/search")
    (.query #js {:q term :format "json"})
    (.end cb)))

(defn page [c]
  [:html
    [:head 
      [:meta {:charset "UTF-8"}]
      [:title "find yourself"]      
      [:link {:rel "stylesheet" :href "/stylesheets/style.css"}]]
    [:body 
     [:div {:id "container"} c]     
     [:script {:src "/ribbon.js"}]]])

(defn ui [data on-change]
  [:div {:class "container"} 
   [:div {:class "search"}
    [:input {:on-change on-change}]]
   [:div {:class "results"} (.stringify js/JSON data)]])

(defn toHTML [c]
  (str "<!doctype html>" (reagent/render-to-static-markup c))) 

(defn tostr [c]
  (str "<!doctype html>" (reagent/render-to-string c))) 


(defn toDOM [c el]
  (reagent/render-component c el))