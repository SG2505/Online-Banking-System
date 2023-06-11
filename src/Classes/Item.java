package Classes;

import java.util.Date;

public class Item {


    static int counter = 220;
    int ID;
    int price;
    String name; // momken yb2a certficate or ay 7aga
    String description; //esm el brand lw lbs aw kda or el description bta3 el certif zy ely mazen tarek 3amlha fel gui

    public Item( String name,String description, int price) {
        this.ID = counter;
        this.name = name;
        this.price = price;
        this.description= description;
        counter++;

    }

    public String getname() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getID() {
        return ID;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "ID=" + ID +
                ", price=" + price +
                ", Item='" + name +
                '}';
    }
}
