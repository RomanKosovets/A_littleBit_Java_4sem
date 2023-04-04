import java.awt.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

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
        TechnicalItem LaptopWarrantyTime = new TechnicalItem(Category.GENERAL, 30, "Asus", 45000, LaptopAnalog, (short) 365);
        GenericItem[] mas = new GenericItem[]{Apple, LaptopWarrantyTime};

        for(GenericItem i : mas){
            i.printAll();
        }
        /** Task_2.2-2.3 */
        FoodItem Pear = new FoodItem(Category.FOOD, 10, "Pear", 30, FruitAnalog, new Date(), (short) 2);
        FoodItem Pear2 = new FoodItem(Category.FOOD, 10, "Pear", 30, FruitAnalog, new Date(), (short) 2);

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

    }
}
