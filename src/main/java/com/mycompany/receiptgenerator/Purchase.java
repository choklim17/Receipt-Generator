package com.mycompany.receiptgenerator;

public class Purchase {
    
    private String itemName;
    private double itemPrice;
    
    public Purchase(String itemName, double itemPrice) {
        this.itemName = itemName;
        
        if (itemPrice < 0) {
            throw new IllegalArgumentException("NEGATIVE PRICE IS NOT VALID!");
        }
        else {
            this.itemPrice = itemPrice;
        }
    }
    
    public String getItemName() {
        return itemName;
    }
    
    public double getItemPrice() {
        return itemPrice;
    }
    
    @Override
    public String toString() {
        return "ITEM NAME: \t-----------\t" + itemName + "\n" +
                "ITEM PRICE: \t-----------\t$" + itemPrice;
    }
}
