#!/bin/zsh
case ${1,,} in
    batman | admin )
      echo "welcome batman"
      ;;
    help)
      echo "aren't you the batman?"
      ;;
    *)
      echo " Ok bruce"
esac