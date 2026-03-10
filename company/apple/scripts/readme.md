
# wc
> wc -w prefix1.txt
3 prefix1.txt
> wc -w < hello.txt
3
> 
>  % cat <<EOF
heredoc> I'm Batman
heredoc> I'm also Bruce Wayne
heredoc> EOF
I'm Batman
I'm also Bruce Wayne
> wc -w <<< "I am Batman"
3
>  % [ hello = hello ]
% echo $?
0
>  [ 1 = 0 ]
% echo $?
1
> 
>  [ 1 -eq 1 ]
% echo $?    
0

bash-3.2$  my_arr=(one two three)
bash-3.2$  echo "$my_arr"  
one
bash-3.2$ echo {$my_arr[@]}
{one[@]}
bash-3.2$ echo ${my_arr[@]}
one two three



