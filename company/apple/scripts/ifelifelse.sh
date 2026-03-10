#!/bin/bash
if [ {$1,,} = batman ]; then
  echo "Bat of Gotham is here";
elif [ {$1,,} = help ]; then
  echo "I'm Batman"
else
  echo "i'M bruce wayne"
fi
    