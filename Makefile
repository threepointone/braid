setup:
	npm install

dev: 
	DEBUG=braid node index.js

watch:
	watchify out/ribbon/index.js -o public/ribbon.js -v

PHONY: setup dev watch

