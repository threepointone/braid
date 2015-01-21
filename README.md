### braid

experiments with clojurescript

add to .bash_profile 
```
export LEIN_FAST_TRAMPOLINE=y
alias cljsbuild="lein trampoline cljsbuild $@"
```

run once 
```
./script/compile_cljsc
```

in 3 terminals 
```
cljsbuild auto
make watch
make dev

```

visit `http://localhost:3693`