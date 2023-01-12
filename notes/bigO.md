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


