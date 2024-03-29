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

2. Difference between \"\=\=\" and "===" ?

* They both are comparison operators.
* \"\==" compares the value, not the type, "===" compares value and type. 

```javascript
'1' == 1
true

'1' === 1
false
```

3. Difference between "let" and "const" ?

* once you assign a value with const, you can't change the value or type anymore. let would allow change of type and value. 

```javascript
const c;
VM118:1 Uncaught SyntaxError: Missing initializer in const declaration

const c; c= 5; c =10
VM152:1 Uncaught SyntaxError: Missing initializer in const declaration

const c = 10; console.log(c);
10


let l=1; console.log(l); l=2; console.log(l);
VM456:1 1
VM456:1 2
```

const would allow modification to an object, but you can't re assign.
```javascript
const c = [1,2]; c.push(3); console.log(c);
VM569:1 (3) [1, 2, 3]

const c = [1,2]; c=[1,2,3]
VM605:1 Uncaught TypeError: Assignment to constant variable.
    at <anonymous>:1:19

```

4. Difference between null and undefined ?

* they both represent an empty value, if you define a variable and not assign a value - it will be set to undefined by javascript. null - you are doing it to yourself. 

* type of undefined is undefined, type of null is object

5. Use of Arrow function ?

```javascript
const profile = {
  firstName: '',
  lastName: '',
  
  setName : function(name){
    let splitName = function(n){
      let nameArray = n.split(' ');
      this.firstName = nameArray[0];
      this.lastName = nameArray[1];
    }
    splitName(name);
  }
  
}

profile.setName("Bruce Wayne");
console.log(firstName);

Output:

Bruce

console.log(profile.firstName);

Output:

profile.setName("Bruce Wayne");
console.log(window.firstName);

Output:

Bruce

```
Arrow function will set the value to objec's this. 

```javascript
```javascript
const profile = {
  firstName: '',
  lastName: '',
  
  setName : function(name){
    let splitName = (n) =>{
      let nameArray = n.split(' ');
      this.firstName = nameArray[0];
      this.lastName = nameArray[1];
    }
    splitName(name);
  }
  
}

profile.setName("Bruce Wayne");
console.log(profile.firstName);

Output:

Bruce
```
