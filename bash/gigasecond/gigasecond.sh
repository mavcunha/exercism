#!/usr/bin/env bash

GIGASECOND=1000000000

function sec_to_date() {
  local s="${1}"
  date -u -r ${s} "+%a %b %-e %T %Z %Y"
}

function date_to_sec() {
  local d="${1}"
  [[ ${d} =~ :[0-9] ]] || d="${d%%Z} 00:00:00Z"
  date -u -j -f "%Y-%m-%d %H:%M:%SZ" "${d}" "+%s"
}

function add_gigaseconds() {
  local date="${1}"
  input_secs=$(date_to_sec "${date}")
  sec_to_date $((${input_secs} + ${GIGASECOND}))
}

add_gigaseconds "${1}"

