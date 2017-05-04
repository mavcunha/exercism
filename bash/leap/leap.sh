#!/usr/bin/env bash

function usage() {
  echo "Usage: leap.sh <year>"
  exit 1
}

year="${*}"

[[ "${year}" =~ ^[0-9]+$ ]] || usage

if [[ $((${year} % 400)) -eq 0 ]] || \
  ([[ $((${year} % 4))   -eq 0 ]] && \
   [[ $((${year} % 100)) -ne 0 ]]); then
  echo "This is a leap year."
else
  echo "This is not a leap year."
fi
