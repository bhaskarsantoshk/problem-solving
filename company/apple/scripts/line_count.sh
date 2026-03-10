#!/bin/bash

prefix=$1;
for file in "$prefix"*; do
  if [ -f $file ]; then
    lines=$(wc -l < "$file")
    echo "$file $lines"
  fi
done