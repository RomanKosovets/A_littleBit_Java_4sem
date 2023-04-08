package ru.billing.stocklist;

public class Analogue {
    private int ID;
    private String Name;
    private float Price;

    public String getName() { return Name;}
    public int getID() {return ID;}
    public float getPrice() {return Price; }

    public void setName(String name) {Name = name;}
    public void setPrice(float price) {this.Price = price;}
    public void setID(int ID) {this.ID = ID;}

    public Analogue (int id, String name, float price){
        this.ID = id;
        this.Name = name;
        this.Price = price;
    }
}
