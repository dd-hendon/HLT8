package com.HLT8;
import java.util.Scanner;

public class Fruit extends Food {

    public void taste() {
        System.out.println("Fruit tastes sweet");
    }

    public String fruitVariety; //changed access modifier to public. Best to make everything public if in doubt for now!

    public void setFruitVariety(){
        System.out.print("Enter variety of fruit: "); //prompt to the user
        Scanner sc = new Scanner(System.in); //create in built Scanner object to read user input
        String FruitVar = sc.nextLine();     //assign user input to a string
        this.fruitVariety = FruitVar;        //assign string to the Fruit object fruitVariety variable
    };

    public String getFruitVariety() {
        return fruitVariety;
    }

}
