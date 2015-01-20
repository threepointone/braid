
(ns braid.core
	(:require [cljs.nodejs :as n]))


(n/enable-util-print!)


(let [express (n/require "express")
	app (express) 
	path (n/require "path")
	logger (n/require "morgan")
	body-parser (n/require "body-parser")
	__dirname (js* "__dirname")]

	(app.set "views" (path.join __dirname "views"))
	(app.set "view engine" "jade")
	(app.use (logger "dev"))
	(app.use (body-parser.json))
	(app.use (body-parser.urlencoded (#js { :encoded true })))
	(app.use (express.static (path.join __dirname "public")))

	(app.use (fn [req res next] 
		(let [err (new js/Error "Not Found")]
			(set! (.-status err) 400)
			(next err))))
 
 

	)


(defn run [] nil)









(defn -main [] (run))
(set! *main-cli-fn* -main)