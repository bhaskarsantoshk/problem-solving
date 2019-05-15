1. Rule- an abstract class with apply method, every new rule we create will extend Rule class and implement apply method which will give us the price upon rule applied.

2. Once we checkout the products, we can run Rules[] object on checked out product list and total price is a global variable that get updated after each rule is applied

3. Each rule will validate the product code and required condition before getting applied.
4. We can add new Rules in Store Class's createRules method after we create new Rule class with apply method implemented.
