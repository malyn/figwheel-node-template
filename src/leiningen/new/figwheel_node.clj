(ns leiningen.new.figwheel-node
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]))

(def render (renderer "figwheel-node"))

(defn figwheel-node [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (->files data
      ["dev/user.clj" (render "user.clj" data)]
      ["package.json" (render "package.json" data)]
      ["project.clj" (render "project.clj" data)]
      ["README.md" (render "README.md" data)]
      ["src/{{sanitized}}/core.cljs" (render "core.cljs" data)]
      [".gitignore" (render "gitignore" data)])))
