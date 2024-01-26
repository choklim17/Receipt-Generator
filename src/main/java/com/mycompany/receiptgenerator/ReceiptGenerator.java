package com.mycompany.receiptgenerator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReceiptGenerator {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        ReceiptQueue receiptQueue = new ReceiptQueue();
        
        do {
            try {
                System.out.print("ENTER ITEM NAME (or ENTER 'exit' TO GENERATE RECEIPT: ");
                String itemName = scanner.nextLine();
                
                if (itemName.equalsIgnoreCase("exit")) {

                    if (receiptQueue.isEmpty()) {
                        System.out.println("\nNO ITEM PRUCHASED. CANNOT GENERATE RECEIPT");
                    }
                    else {
                        receiptQueue.generateReceipt();
                    }
                    scanner.close();
                    break;
                }
                
                System.out.print("ENTER ITEM PRICE: $");
                double itemPrice = scanner.nextDouble();
                scanner.nextLine();
                
                Purchase purchase = new Purchase(itemName, itemPrice);
                receiptQueue.addPurchase(purchase);
                
                System.out.println("\nPURCHASE ADDED:");
                System.out.println(purchase.toString() + "\n");
   
            } 
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\n");
            } 
            catch (InputMismatchException e) {
                System.out.println("INPUT MISMATCH. PLEASE ENTER THE CORRECT PRICE!\n");
                scanner.close();
                break;
            }
            
        } while (true);
        
    }
}
