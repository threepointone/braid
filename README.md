## braid


### browserify + clojurescript

to run the example, run `node index.js`, and visit `http://localhost:3693/paris`. input more cities to search instantly.


dev usage - 

- create package.json with `npm init`
- `npm install` required modules 
- use `js/require` to require said modules
- `make require` - this parses out npm dependencies, and creates a compressed browserify bundle
- include `bundle.js` before compiled clojurescript file(s)
- done! no externs!
- bonus: "isomorphic"; here, ui.core is shared between browser and server; containing reagent components and a superagent http client



todo

- react-router
- hydrate data 
- live maps 
- find out what the heck a repl is 