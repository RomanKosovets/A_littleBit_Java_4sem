package ru.billing.stocklist;

public class GenericItem implements Cloneable{
    private Category category;
    private int ID;
    private String name;
    private float price;
    private Analogue analogue;

    static int currentID;

    public GenericItem() {
        this.ID = GenericItem.currentID++;
    };

    public GenericItem(String name, float price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.ID = GenericItem.currentID++;
    };

    public GenericItem(String name, float price, Analogue analog) {
        this.name = name;
        this.price = price;
        this.analogue = analog;
        this.ID = GenericItem.currentID++;
    }

    public GenericItem(Category category, int id, String name, float price, Analogue analogue){ // конструктор для удобства 2 лабы
        this.category = category;
        this.ID = id;
        this.name = name;
        this.price = price;
        this.analogue = analogue;
    }

    public Category getCategory() {return category;}
    public int getID() {return ID;}
    public String getName() {return name;}
    public float getPrice() {return price;}
    public Analogue getAnalogue() {return analogue;}
    public static int getCurrentID() {return currentID;}

    public void setID(int ID) {this.ID = ID;}
    public void setName(String name) {this.name = name;}
    public void setPrice(float price) {this.price = price;}
    public void setAnalogue(Analogue analogue) {this.analogue = analogue;}
    public static void setCurrentID(int currentID) {GenericItem.currentID = currentID;}

    public void printAll(){
        System.out.printf("ID: %d , ru.billing.stocklist.Category:%s , Name: %-20s , price:%5.2f \n" +
                          "Аnalogue: ID: %-12d, Name:%-20s , price:%5.2f\n",
                ID,category, name,price, analogue.getID(), analogue.getName(), analogue.getPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        GenericItem that = (GenericItem) o;

        return ID == that.ID && Float.compare(that.price, price) == 0 &&
                category == that.category && name.equals(that.name) &&
                analogue.equals(that.analogue);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "ru.billing.stocklist.GenericItem{" +
                "category=" + category +
                ", ID=" + ID +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", analogueName=" + analogue.getName() +
                ", analogueID=" + analogue.getID() +
                ", analoguePrice=" + analogue.getPrice() +
                '}';
    }
}
