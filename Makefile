PHONY: \
	__build_test_image \
	test

__build_test_image:
	docker build -f test.Dockerfile -t clojure-test .

test: __build_test_image
	docker run \
		-v $(shell pwd):/code \
		-u $$(stat -c "%u:%g" $(shell pwd)) \
		clojure-test \
    lein test
