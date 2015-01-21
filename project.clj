(defproject braid "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2695"]]

  :node-dependencies [[source-map-support "0.2.9"]]

  :plugins [[lein-cljsbuild "1.0.4"]]

  :source-paths ["src" "target/classes"]

  ; :clean-targets ["out/braid" "braid.js" "braid.min.js"]

  :cljsbuild {
    :builds [{:id "braid"
              :source-paths ["src"]
              :notify-command ["node" "index.js"]
              :compiler {
                :output-to "out/braid/index.js"
                :output-dir "out/braid"
                :optimizations :none
                :target :nodejs
                :cache-analysis true                
                :source-map true}}
             
             {:id "ribbon"
              :source-paths ["src"]
              :compiler {
                :output-to "out/ribbon/index.js"
                :output-dir "out/ribbon"
                :optimizations :none
                :cache-analysis true
                :source-map true}}
             
             ; {:id "release"
             ;  :source-paths ["src"]
             ;  :compiler {
             ;    :output-to "braid.min.js"
             ;    :pretty-print false              
             ;    :optimizations :advanced}}
             
             ]})
