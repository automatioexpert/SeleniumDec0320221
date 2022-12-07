#!/bin/bash

# This script allows you run this test on docker engine. Only you have to run with ./run.sh

DOCKER_IMAGE=markhobson/maven-chrome
docker pull $DOCKER_IMAGE
docker run --rm -i -v $PWD:/usr/src/ -v $PWD/target/:/usr/src/target/ -w /usr/src $DOCKER_IMAGE mvn integration-test
