#!/bin/bash
awk '{print $1}' nums

bash-3.2$ echo "I am Batman" | awk '{print $3}'
Batman

bash-3.2$ awk -F, '{print $2}' nums.csv
two

echo "Just get this word: Hello" | awk -F: '{print $2}' | cut -c2-