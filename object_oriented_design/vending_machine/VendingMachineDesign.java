package object_oriented_design.vending_machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VendingMachineDesign {
    public enum BillsType {
        ONE, TWO, FIVE, TEN, TWENTY, FIFTY;
    }
    public class Product{
        int quantity, dateImported, expirationDate, price;
        String name, seller;
    }
    public class VendingMachine{
        int shelves, rows, cols, totalSales;
        Product products[][][] = new Product[shelves][rows][cols];
        List<Product> productList = new ArrayList<Product>();
        int currentBalance;
        HashMap<BillsType, Integer> coins = new HashMap<>();
        HashMap<BillsType, Integer> billsList = new HashMap<BillsType, Integer>();
        public void vend (Product product ){
            if ( product.quantity <= 0 ){
                displayMessage("SOLD OUT.");
            }
            else{
                displayMessage("Insert Money");
                int amount = getAmount();
                acceptPayment(product, amount);
            }
        }
    }

    private int getAmount() {
        int amount = 0;
        // update amount
        return amount;
    }

    private void acceptPayment(Product product, int amount) {
        while ( amount < product.price ){
            displayMessage("Not enough, Insert more");
            amount+= getAmount();
        }
        if ( !canMakeChange(amount- product.price)){
            displayMessage("OUT OF CHANGE");
            refund();
        }
        else{
            int change = amount- product.price;
            returnChange(change);
            updateCurrentBalance(product.price);
        }
    }

    private void updateCurrentBalance(int price) {
    }

    private void returnChange(int change) {
    }

    private void refund() {
    }

    private boolean canMakeChange(int change) {
        return true;
    }

    private void displayMessage(String s) {
        // Display a Message.
    }
    public class NotFullPaidException extends Exception {}
    public class SoldOutException extends Exception {}
    public class NotEnoughChangeException extends Exception {}
}

