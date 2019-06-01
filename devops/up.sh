#!/bin/bash

git clone git@github.com:fabianogoes/api-demo.git
cd api-demo
mvn clean package
docker-compose up