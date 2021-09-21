package com.HLT8;
import java.util.Scanner;

public class Food {
    public String crop; // How about this becomes a blank string,
                        // whose value can be hardcoded in the Main method
                        // which will call the setCrop() method defined below

    public void setCrop(String crop){
        this.crop = crop;
    }

    public void taste() {
        System.out.println("Food tastes good");
    }

    public int quantity; // This will be a good opportunity for a try catch in the main method,
                         // as a string being sent to it will cause an error

    //Let's make our own setter for quantity, like we did in the Fruit class, that takes user input
    public void setQuantity() {
        System.out.print("Enter quantity of food: ");
        Scanner sc = new Scanner(System.in);
        int quantity = sc.nextInt();
        this.quantity = quantity;
    }

    //this is an auto generated getter
    public int getQuantity() {
        return quantity;
    }
}
