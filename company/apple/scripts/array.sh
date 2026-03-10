my_arr=(one tow three four five)
for item in ${my_arr[@]}; do echo -n $item | wc -c; done