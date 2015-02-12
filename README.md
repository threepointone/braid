## braid


### browserify + clojurescript

to run the example, run `make dev`, and visit `http://localhost:3693/paris`. input more cities to search instantly.


dev usage - 

- create package.json with `npm init`
- `npm install` required modules 
- use `js/require` to require said modules
- `make require` - this parses out npm dependencies, and creates a compressed browserify bundle
- include `bundle.js` before compiled clojurescript file(s)
- done! no externs!
- works in all compilation modes
- bonus: "isomorphic"; here, ui.core is shared between browser and server; containing reagent components and a superagent http client



todo

- react-router
