# figwheel-node-template

A ClojureScript Node.js template for use with [lein-figwheel][].

[lein-figwheel]: https://github.com/bhauman/lein-figwheel

The template sets up a project with both development (`dev`) and
production (`prod`) targets.  The development target includes the
Figwheel auto-builder and code loader.  The production target produces a
standalone `server.js` file for use with the `node` executable (no Java
or ClojureScript dependencies required).


## Usage

Run the following to create a project:

```sh
$ lein new figwheel-node hello-world
$ cd hello-world
$ npm install
```

Start Figwheel in a terminal window:

```sh
$ lein figwheel
```

Start Node.js in another terminal window:

```sh
$ node target/server_dev/hello_world.js
```

Changes to your source files will trigger incremental compilation.  See
the [Figwheel docs][] for more information.

[Figwheel docs]: https://github.com/bhauman/lein-figwheel

Figwheel now exposes an nREPL endpoint, which means that you can use
Figwheel with tools like
[vim-fireplace](https://github.com/tpope/vim-fireplace).  Here is how
you start a `figwheel-node` project and connect to it from
`vim-fireplace` (using the `hello-world` sample from above):

1. `lein repl`
2. `(fig-start)`
3. `(cljs-repl)`
4. (In another window) `node target\js\compiled\hello_world.js ...`
5. (In Vim) `:Piggieback (figwheel-sidecar.repl-api/repl-env)`


## Production

Ready to produce a standalone `.js` file for use with Node.js, perhaps
as part of a Heroku or Azure Websites deployment?

```sh
$ lein cljsbuild once prod
```

The above command generates a `server.js` file in your project
directory.  You can then ship the entire project directory to your web
server, PaaS host, etc.  Note that Heroku looks for a Node.js app before
it looks for a Clojure app, so you can safely leave the `project.clj`
file in place as part of the deployment.


## FAQ

**Where's [lein-npm][]?**

Hosting providers like Heroku and Azure expect to see a `package.json`
file, which lein-npm purposefully hides in order to provide better
integration with Leiningen.  Forcing the user of this template to create
and manage their own `package.json` file means that the resulting
project directory is immediately compatible with standard Node.js
environments.

[lein-npm]: https://github.com/RyanMcG/lein-npm


## License

Copyright © 2015-2017 Michael Alyn Miller

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
