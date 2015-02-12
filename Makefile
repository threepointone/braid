setup:
	npm install

dev: 
	DEBUG=braid node index.js

require:
	./scripts/require out/ribbon/index.js -o ./public/require.js

PHONY: setup dev require

