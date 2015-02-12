// Compiled by ClojureScript 0.0-2695 {}
goog.provide('cljs.repl');
goog.require('cljs.core');
cljs.repl.print_doc = (function print_doc(m){
cljs.core.println.call(null,"-------------------------");

cljs.core.println.call(null,[cljs.core.str((function (){var temp__4126__auto__ = new cljs.core.Keyword(null,"ns","ns",441598760).cljs$core$IFn$_invoke$arity$1(m);
if(cljs.core.truth_(temp__4126__auto__)){
var ns = temp__4126__auto__;
return [cljs.core.str(ns),cljs.core.str("/")].join('');
} else {
return null;
}
})()),cljs.core.str(new cljs.core.Keyword(null,"name","name",1843675177).cljs$core$IFn$_invoke$arity$1(m))].join(''));

if(cljs.core.truth_(new cljs.core.Keyword(null,"forms","forms",2045992350).cljs$core$IFn$_invoke$arity$1(m))){
var seq__6169_6173 = cljs.core.seq.call(null,new cljs.core.Keyword(null,"forms","forms",2045992350).cljs$core$IFn$_invoke$arity$1(m));
var chunk__6170_6174 = null;
var count__6171_6175 = (0);
var i__6172_6176 = (0);
while(true){
if((i__6172_6176 < count__6171_6175)){
var f_6177 = cljs.core._nth.call(null,chunk__6170_6174,i__6172_6176);
cljs.core.print.call(null,"  ");

cljs.core.prn.call(null,f_6177);

var G__6178 = seq__6169_6173;
var G__6179 = chunk__6170_6174;
var G__6180 = count__6171_6175;
var G__6181 = (i__6172_6176 + (1));
seq__6169_6173 = G__6178;
chunk__6170_6174 = G__6179;
count__6171_6175 = G__6180;
i__6172_6176 = G__6181;
continue;
} else {
var temp__4126__auto___6182 = cljs.core.seq.call(null,seq__6169_6173);
if(temp__4126__auto___6182){
var seq__6169_6183__$1 = temp__4126__auto___6182;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__6169_6183__$1)){
var c__3622__auto___6184 = cljs.core.chunk_first.call(null,seq__6169_6183__$1);
var G__6185 = cljs.core.chunk_rest.call(null,seq__6169_6183__$1);
var G__6186 = c__3622__auto___6184;
var G__6187 = cljs.core.count.call(null,c__3622__auto___6184);
var G__6188 = (0);
seq__6169_6173 = G__6185;
chunk__6170_6174 = G__6186;
count__6171_6175 = G__6187;
i__6172_6176 = G__6188;
continue;
} else {
var f_6189 = cljs.core.first.call(null,seq__6169_6183__$1);
cljs.core.print.call(null,"  ");

cljs.core.prn.call(null,f_6189);

var G__6190 = cljs.core.next.call(null,seq__6169_6183__$1);
var G__6191 = null;
var G__6192 = (0);
var G__6193 = (0);
seq__6169_6173 = G__6190;
chunk__6170_6174 = G__6191;
count__6171_6175 = G__6192;
i__6172_6176 = G__6193;
continue;
}
} else {
}
}
break;
}
} else {
if(cljs.core.truth_(new cljs.core.Keyword(null,"arglists","arglists",1661989754).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.prn.call(null,new cljs.core.Keyword(null,"arglists","arglists",1661989754).cljs$core$IFn$_invoke$arity$1(m));
} else {
}
}

if(cljs.core.truth_(new cljs.core.Keyword(null,"special-form","special-form",-1326536374).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"Special Form");

cljs.core.println.call(null," ",new cljs.core.Keyword(null,"doc","doc",1913296891).cljs$core$IFn$_invoke$arity$1(m));

if(cljs.core.contains_QMARK_.call(null,m,new cljs.core.Keyword(null,"url","url",276297046))){
if(cljs.core.truth_(new cljs.core.Keyword(null,"url","url",276297046).cljs$core$IFn$_invoke$arity$1(m))){
return cljs.core.println.call(null,[cljs.core.str("\n  Please see http://clojure.org/"),cljs.core.str(new cljs.core.Keyword(null,"url","url",276297046).cljs$core$IFn$_invoke$arity$1(m))].join(''));
} else {
return null;
}
} else {
return cljs.core.println.call(null,[cljs.core.str("\n  Please see http://clojure.org/special_forms#"),cljs.core.str(new cljs.core.Keyword(null,"name","name",1843675177).cljs$core$IFn$_invoke$arity$1(m))].join(''));
}
} else {
if(cljs.core.truth_(new cljs.core.Keyword(null,"macro","macro",-867863404).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"Macro");
} else {
}

return cljs.core.println.call(null," ",new cljs.core.Keyword(null,"doc","doc",1913296891).cljs$core$IFn$_invoke$arity$1(m));
}
});
