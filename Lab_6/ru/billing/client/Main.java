package ru.billing.client;
import ru.billing.exceptions.*;
import ru.billing.stocklist.*;

import java.awt.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException, ItemAlreadyExistsException, CatalogLoadException {

        /** Task_1.1-1.2 */
        Analogue FruitAnalog = new Analogue(11,"Pear", 35);
        Analogue CarAnalog = new Analogue(21,"BMW M5",140000);
        Analogue LaptopAnalog = new Analogue(32, "MSI", 48000);

        GenericItem Fruit = new GenericItem(Category.FOOD, 10, "Apple", 30, FruitAnalog);
        GenericItem Car = new GenericItem(Category.GENERAL, 20, "Porsche 911", 130000, CarAnalog);
        GenericItem Laptop = new GenericItem(Category.GENERAL, 30, "Asus", 45000, LaptopAnalog);

        Fruit.printAll();
        Car.printAll();
        Laptop.printAll();
        System.out.println();


        /** Task_2.1-2.2 */
        FoodItem Apple = new FoodItem(Category.FOOD, 10, "Apple", 30, FruitAnalog, new Date(), (short) 2);
        TechnicalItem Laptop2 = new TechnicalItem(Category.GENERAL, 30, "Asus", 45000, LaptopAnalog, (short) 365);
        GenericItem[] mas = new GenericItem[]{Apple, Laptop2};

        for(GenericItem i : mas){
            i.printAll();
        }
        /** Task_2.2-2.3 */
        FoodItem Pear = new FoodItem(Category.FOOD, 20, "Pear", 35, FruitAnalog, new Date(), (short) 2);
        FoodItem Pear2 = new FoodItem(Category.FOOD, 20, "Pear", 35, FruitAnalog, new Date(), (short) 2);

        System.out.println("\n");
        System.out.println("Result of compare Pear and Pear2: " + Pear.equals(Pear2));

        FoodItem ClonePear = (FoodItem) Pear.clone();
        System.out.println("Result of compare ClonePear and Pear: " + ClonePear.equals(Pear));
        System.out.println();
        System.out.println(Fruit);

        /** task_3.1 Работа со строками */
        System.out.println();
        String line = "Конфеты 'Маска'; 45;120";
        String[] item_fld = line.split(";");

        String name = item_fld[0];
        float price = Float.parseFloat(item_fld[1]);
        short expires = Short.parseShort(item_fld[2]);

        FoodItem foodItem = new FoodItem(name, price, expires);
        System.out.println(foodItem.getName());
        System.out.println(foodItem.getPrice());
        System.out.println(foodItem.getExpires());

        /** task_4.1 */

        ItemCatalog Catalog = new ItemCatalog();

        FoodItem Orange = new FoodItem(Category.FOOD, 17, "Orange", 30, FruitAnalog, new Date(), (short) 2);
        FoodItem Blackberry = new FoodItem(Category.FOOD, 12, "Blackberry", 140, FruitAnalog, new Date(), (short) 2);
        FoodItem Pineapple = new FoodItem(Category.FOOD, 14, "Pineapple", 50, FruitAnalog, new Date(), (short) 2);
        TechnicalItem iPhone = new TechnicalItem(Category.GENERAL, 34, "iPhone", 95000, LaptopAnalog, (short) 365);
        TechnicalItem Samsung = new TechnicalItem(Category.GENERAL, 38, "Samsung", 25000, LaptopAnalog, (short) 365);
        TechnicalItem Huawei = new TechnicalItem(Category.GENERAL, 39, "Huawei", 15000, LaptopAnalog, (short) 365);
        TechnicalItem Asus = new TechnicalItem(Category.GENERAL, 40, "Asus", 105000, LaptopAnalog, (short) 365);

        Catalog.addItem(Apple);
        Catalog.addItem(Pear);
        Catalog.addItem(Pineapple);
        Catalog.addItem(Orange);
        Catalog.addItem(Blackberry);
        Catalog.addItem(Laptop2);
        Catalog.addItem(iPhone);
        Catalog.addItem(Samsung);
        Catalog.addItem(Huawei);
        Catalog.addItem(Asus);

        System.out.println();
        long begin = new Date().getTime();

        for(int i=0; i<100000;i++)
            Catalog.findItemByID(10);
        long end = new Date().getTime();
        System.out.println("In HashMap: "+(end-begin)); begin = new Date().getTime();
        for(int i=0; i<100000;i++)
            Catalog.findItemByIDAL(10);
        end = new Date().getTime();
        System.out.println("In ArrayList: "+(end-begin));

        /** task_4.2 */

        System.out.println();
        System.out.println("Количество елементов массива до добавления: " + Catalog.KolItemInCatalog());
        CatalogLoader loader = new CatalogStubLoader();
        loader.load(Catalog);
        System.out.println("Количество елементов массива после добавления: " + Catalog.KolItemInCatalog());

        /** task_6.3.1 */

        System.out.println();
        CatalogFileLoader CatalogFile = new CatalogFileLoader("C:\\Users\\roman\\IdeaProjects\\Project2\\src\\ru\\items.sql");
        CatalogFile.load(Catalog);
        System.out.println("Количество елементов массива после добавления файла: " + Catalog.KolItemInCatalog());



    }
}
