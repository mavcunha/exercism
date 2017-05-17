#!/usr/bin/env bash

project="${1}"

[[ -z ${project} ]] && echo "Missing [project]" && exit 1

cd ${HOME}/Projects/exercism/java

cp -R hello-world/gradle "${project}"
