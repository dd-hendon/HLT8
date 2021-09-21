package com.HLT8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileLockInterruptionException;
import java.util.Scanner;


public class Potatoes extends Food {
    private int potatoCount;

    public int getPotatoCount() {
        return potatoCount;
    }

    public void setPotatoCount(int potatoCount) {
        this.potatoCount = potatoCount;
    }

    public void taste() {
        System.out.println("Potatoes taste starchy");
    }

    public void addPotato() {
        this.potatoCount++;
    }

    public void removePotato(){
        this.potatoCount--;
    }

    public void modifyStock(){

        System.out.println("Press + to increment or - to decrement stock");
        System.out.println("Press return when finished, or d to delete stockpile\n");

        Scanner scanner = new Scanner(System.in);
        String readString = "default";

        while (!readString.equals(""))
        {
                readString = scanner.nextLine();
            if (readString.equals("+")){
                addPotato();
            }
            if (readString.equals("-")){
                removePotato();
            }
            if (readString.equals("d")){
                DeleteStockpile();
                break;
            }

            System.out.println("Potato count: " + getPotatoCount());
        }
    }

    public void CreateStockpile(){
        try{
            File stockpile = new File("stockpile.txt");
            if (stockpile.createNewFile()) {
                System.out.println("File created: " + stockpile.getName());
                FileWriter writer = new FileWriter("stockpile.txt");
                System.out.println("Initialising stock to 0");
                writer.write('0');
                writer.close();
                System.out.println();
            }
            else {
                System.out.println("Stockpile already exists");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public int ReadStockpile(){
        try{
            File stockpile = new File("stockpile.txt");
            Scanner stockpileSensor = new Scanner(stockpile);
            int quantity = stockpileSensor.nextInt();
            stockpileSensor.close();
            return quantity;

        } catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
            return 0;
        }
    }

    public void UpdateStockpile(){
        try{
            FileWriter updater = new FileWriter("stockpile.txt");
            updater.write(String.valueOf(getPotatoCount()));
            updater.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void DeleteStockpile(){

            File stockpile = new File("stockpile.txt");
            if (stockpile.delete()) {
                System.out.println("Potatoes eradicated");
            }
            else{
                System.out.println("Failed to eradicate potatoes");
            }
    }


}
