(ns {{name}}.dev
  (:require [figwheel.client]
            [{{name}}.core]))

(defn -main []
  (figwheel.client/start)
  ({{name}}.core/-main))

(set! *main-cli-fn* -main)
