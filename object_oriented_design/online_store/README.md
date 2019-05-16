1. Rule- an abstract class with apply method. Every new rule will extend Rule class and implement apply method. This apply method will return price upon a rule applied.
2. We create Rules[] array by instantiating multiple child classes that are designed.
3. Once we checkout the products, we can run Rules[] object on checked out product list and total price is a global variable that get updated after each rule is applied
4. Each rule will validate the product code and required condition before getting applied.
