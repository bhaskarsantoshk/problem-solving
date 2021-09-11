# Interview questions

1. Difference between "var" vs "let" key words ?
*  var has been in JS since beginning, let was introduced in ES2015/ES6.

* "let" has block scope. "var" has  function scope.
* "var" gets hoisted while variables with "let" won't. 
example: 
```javascript
let x = function() {
  if ( true){
    console.log(v);
    var v = 1;
  }
}
x();
```

output:
```text
undefined
```

```javascript
let x = function() {
  if ( true){
    console.log(v);
    let v = 1;
  }
}
x();
```

output:
```text
ReferenceError: Cannot access 'v' before initialization
    at x (HelloWorld.js:3:17)
```




