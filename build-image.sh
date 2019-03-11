#!/usr/bin/env bash

echo 'Building docker image course-service'
docker build -t eu.gcr.io/stdstack/course-service:0.1 .
echo 'Image course-service built'