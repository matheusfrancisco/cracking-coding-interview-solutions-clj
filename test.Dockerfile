FROM clojure:openjdk-11-lein-slim-buster AS BUILD

COPY . /code
WORKDIR /code
