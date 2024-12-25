package company.confluent;

import java.util.*;

public class RestaurantOrderOptimizer {

    // Backtracking function to find the minimum price
    public static int findBestPrice(List<MenuItem> menu, Set<String> userWants) {
        // This is the minimum price we want to calculate, we start with infinity.
        return backtrack(menu, userWants, 0);
    }

    // Backtrack to find the minimum price for the remaining items
    private static int backtrack(List<MenuItem> menu, Set<String> remainingItems, int currentPrice) {
        // If all items are covered, return the current price.
        if (remainingItems.isEmpty()) {
            return currentPrice;
        }

        int minPrice = Integer.MAX_VALUE;

        // Try all possible menu items
        for (MenuItem menuItem : menu) {
            Set<String> newRemainingItems = new HashSet<>(remainingItems);
            newRemainingItems.removeAll(menuItem.items);

            if (newRemainingItems.size() < remainingItems.size()) {
                // If this menuItem reduces the number of remaining items, explore further.
                minPrice = Math.min(minPrice, backtrack(menu, newRemainingItems, currentPrice + menuItem.price));
            }
        }

        return minPrice;
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Input menu
        List<MenuItem> menu = Arrays.asList(
                new MenuItem(5, "pizza"),
                new MenuItem(8, "sandwich, coke"),
                new MenuItem(4, "pasta"),
                new MenuItem(2, "coke"),
                new MenuItem(6, "pasta, coke, pizza"),
                new MenuItem(8, "burger, coke, pizza"),
                new MenuItem(5, "sandwich")
        );

        // User wants these items
        Set<String> userWants = new HashSet<>(Arrays.asList("burger", "pasta"));

        // Find the best price
        int bestPrice = findBestPrice(menu, userWants);
        System.out.println("Best price: " + bestPrice);
    }

    // Helper class to represent a menu item
    static class MenuItem {
        int price;
        Set<String> items;

        MenuItem(int price, String itemList) {
            this.price = price;
            this.items = new HashSet<>(Arrays.asList(itemList.split(", ")));
        }
    }
}

/*
can somebody help how to solve this problem?

// You are building an App that lets the users determine the most cost-effective order that they can place in a restaurant for the food items that they want to have. You have the menu of the restaurant that contains item name, and it's price. The restaurant can also offer Value Meals, which are groups of several items, at a discounted price. Write a program that accepts a list of menu items, and a list of items that the user wants to eat, and outputs the best price at which they can get all of their desired items.
// [Constraint: The user can order a maximum of 3 unique items.]

input
[5.00, "pizza"],
[8.00, "sandwich, coke"],
[4.00, "pasta"],
[2.00, "coke"],
[6.00, "pasta, coke, pizza"],
[8.00, "burger, coke, pizza"],
[5.00, "sandwich"]

user_wants: ["burger", "pasta"]

output
12
 */