* e^3n cannot be categorized as O(e^n) since we cannot find a c such that e^3n <= c * e^n ( because e^3n will be expressed as e^n * e^2n)
* Time Comlexity of below snippet is O(N)
```java
for (int i=0; i<n; i++){
    i*=2;
    for (int j=0; j<i; j++){
        // C
    }
}
```

* Time Complexity of below snippet is O(N)
```JAVA
int i = 0;
do {
    while (i < N ) {
      i++;
    }
} while (i < N);
```
* Counting Sort and Radix Sort  algorithms have the same best, worst and average case complexities.

* 3 way merge vs 2 way merge sort : Though the number of recursion calls are less in 3-way merge sort ( O (log<sub>3</sub><sup>N</sup>) < O (log<sub>2</sub><sup>N</sup>)), the number of comparisons during merge are more. So, Subdeviding into more parts won't necessarily improve the run time on an algorithm.


