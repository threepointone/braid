try {
    require("source-map-support").install();
} catch(err) {
	console.error(err.stack);
}
global.React = require('react');
require("./out/braid/goog/bootstrap/nodejs.js");
require("./out/braid/index.js");
goog.require("braid.core");
goog.require("cljs.nodejscli");