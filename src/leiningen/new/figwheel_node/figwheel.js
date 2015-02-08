try {
    require("source-map-support").install();
} catch(err) {
}
require("./out.dev/goog/bootstrap/nodejs.js");
require("./out.dev/{{sanitized}}.js");
goog.require("{{sanitized}}.dev");
goog.require("cljs.nodejscli");
