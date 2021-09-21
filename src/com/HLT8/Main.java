package com.HLT8;

public class Main {

    public static void main(String[] args) {
        Food myFood = new Food(); //changed Fruit type to Food at beginning of line
        Fruit myFruit = new Fruit();
        Potatoes myPotatoes = new Potatoes();

        myFood.taste();      //let's call the Food taste() method here
        myFruit.taste();     //this is polymorphism
        myPotatoes.taste();  //aka the same method creates different behaviour for each of these objects

        System.out.println(); //this is just to make a newline for style


        myFruit.setCrop("Apple"); // here we are hardcoding the value of a variable of this instance of a Fruit object
                                    //note that myFruit inherited the ability to setCrop from it's parent class (Food)
        System.out.println("Crop: " + myFruit.crop );

        myFruit.setFruitVariety(); // here by contrast we can get user to type in a value for a different variable of the same Fruit object
        System.out.print("Fruit variety: ");
        System.out.println(myFruit.getFruitVariety()); // here we can feed one method to another.
        // The return value (in other words the output) from getFruitVariety gets passed to the System.out.println, which prints it to the console

        System.out.println();


        try {
            myFood.setQuantity(); //because quantity needs an integer to be entered there is the chance for the user to create an error. Let's try and catch it
            System.out.println(myFood.getQuantity() + " food added to storage");
        }
        catch (Exception e) {
            System.out.println("Please enter a number next time"); // Let's make the error message specific
        }
        finally {
            System.out.println("\nThank you for using central food database\n\n"); //a goodbye message whether there
            // was an error or not
        }


        // Finally, let's do something with files
        // How about we simulate adding or removing a potato from a stockpile

        //Create text file in project root if not already existing
        myPotatoes.CreateStockpile();

        //Read any existing value in file and set it as current object count
        myPotatoes.setPotatoCount(myPotatoes.ReadStockpile());

        //Display current count
        System.out.println(myPotatoes.getPotatoCount()+ " Potatoes in stockpile");

        //Use scanner and a while loop to manually increment/decrement count
        //This will internally and optionally call DeleteStockpile()
        myPotatoes.modifyStock();

        //Write updated count back to txt file (persistent potatoes!)
        myPotatoes.UpdateStockpile();


    }
}



