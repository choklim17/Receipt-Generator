package com.mycompany.receiptgenerator;

import java.util.ArrayDeque;
import java.util.Queue;

public class ReceiptQueue {
    
    private Queue<Purchase> purchaseQueue;
    private double totalBill;
    
    public ReceiptQueue() {
        purchaseQueue = new ArrayDeque<>();
        totalBill = 0;
    }
    
    public void addPurchase(Purchase purchase) {
        purchaseQueue.offer(purchase); //Adds the pruchase object to the queue
        totalBill += purchase.getItemPrice();
    }
    
    public void generateReceipt() {
        System.out.println("\n================ RECEIPT =========================");
        
        while(!purchaseQueue.isEmpty()) {
            Purchase itemPurchased = purchaseQueue.poll(); //Removes the object to the queue
            
            System.out.println(itemPurchased.toString());
            System.out.println("==================================================");
        }
        
        System.out.println("TOTAL BILL: $" + totalBill);
    }
    
    public boolean isEmpty() {
        return purchaseQueue.isEmpty();
    }
}
