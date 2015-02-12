(defproject braid "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2843"]
                 [reagent "0.5.0-alpha"]]

  :node-dependencies [[source-map-support "0.2.9"]]

  :plugins [[lein-cljsbuild "1.0.4"]]

  :source-paths ["src" "target/classes"]

  ; :clean-targets ["out/braid" "braid.js" "braid.min.js"]

  :cljsbuild {
    :builds [{:id "braid"
              :source-paths ["src/braid" "src/ui"]
              ; :notify-command ["node" "index.js"]
              :compiler {
                :output-to "out/braid/index.js"
                :output-dir "out/braid"
                :optimizations :none
                :target :nodejs
                :cache-analysis true                
                :source-map "out/braid/index.map"}}
             
             {:id "ribbon"
              :source-paths ["src/ribbon" "src/ui"]
              :compiler {
                :output-to "out/ribbon/index.js"
                :output-dir "out/ribbon"
                :optimizations :advanced
                :cache-analysis true
                :source-map "out/ribbon/index.map"}}
             
             ; {:id "release"
             ;  :source-paths ["src"]
             ;  :compiler {
             ;    :output-to "braid.min.js"
             ;    :pretty-print false              
             ;    :optimizations :advanced}}
             
             ]})
