(ns leiningen.new.figwheel-node
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]))

(def render (renderer "figwheel-node"))

(defn figwheel-node [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (->files data
      ["package.json" (render "package.json" data)]
      ["project.clj" (render "project.clj" data)]
      ["src/{{sanitized}}/core.cljs" (render "core.cljs" data)]
      ["src.dev/{{sanitized}}/dev.cljs" (render "dev.cljs" data)]
      ["figwheel.js" (render "figwheel.js" data)]
      [".gitignore" (render "gitignore" data)])))
