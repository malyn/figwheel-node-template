(ns user
  (:require [figwheel-sidecar.repl-api :as f]))

(defn fig-start
  []
  (f/start-figwheel!))

(defn fig-stop
  []
  (f/stop-figwheel!))

(defn cljs-repl
  []
  (f/cljs-repl))
