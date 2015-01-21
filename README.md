### braid

some notes - 
- buzzwords - clojurescript express superagent browserify react reagent
- did this to learn about clojurescript, and get a familiar stack on node 
- needed this [patch](https://gist.github.com/threepointone/67c73c9089838004afac) for clojurescript to work on io.js
- the isomorphic dream is alive! pass either :simple or :advanced to the compiler, and send the resulting blob through browserify. that's it!
- here, ui.core is shared between browser and server; containing reagent components and a superagent http client
- this way, you get BOTH - closure compiler's advanced stuff, and uglify or whatever for the rest
- further, you bypass the whole externs mess. sweet!

add to .bash_profile 
```
export LEIN_FAST_TRAMPOLINE=y
alias cljsbuild="lein trampoline cljsbuild $@"
```

run once 
```
npm install watchify browserify -g
make install
./script/compile_cljsc
```

in 3 terminals 
```
cljsbuild auto
make watch
make dev
```

visit `http://localhost:3693`

todo

- react-router
- hydrate data 
- live maps 
- find out what the heck a repl is 