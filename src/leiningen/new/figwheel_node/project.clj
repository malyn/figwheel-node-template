(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2755"]
                 [figwheel "0.2.3-SNAPSHOT"]]

  :plugins [[lein-cljsbuild "1.0.4"]
            [lein-figwheel "0.2.3-SNAPSHOT"]]

  :source-paths ["src"]

  :clean-targets ["out.dev"
                  "out.prod"
                  "server.js"]

  :cljsbuild {
    :builds [{:id "dev"
              :source-paths ["src" "src.dev"]
              :compiler {
                :output-to "out.dev/{{sanitized}}.js"
                :output-dir "out.dev"
                :target :nodejs
                :optimizations :none
                :source-map true}}
             {:id "prod"
              :source-paths ["src"]
              :compiler {
                :output-to "server.js"
                :output-dir "out.prod"
                :target :nodejs
                :optimizations :simple}}]})
