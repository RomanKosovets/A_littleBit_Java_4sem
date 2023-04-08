package ru.billing.stocklist;

import ru.billing.stocklist.GenericItem;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemCatalog {
    private final HashMap<Integer, GenericItem> catalog =
            new HashMap<Integer,GenericItem>();           // коллекция для поиска следующих товаров
    private final ArrayList<GenericItem> ALCatalog =
            new ArrayList<GenericItem>();                 // коллекция для сравнения

    public void addItem(GenericItem item) {
        catalog.put(item.getID(), item);
        ALCatalog.add(item);
    }

    public void printItems(){
        for(GenericItem i : ALCatalog){
            System.out.println(i);
        }
    }

    public GenericItem findItemByID(int id){
        return catalog.getOrDefault(id, null);
    }

    public GenericItem findItemByIDAL(int id){
        for(GenericItem i : ALCatalog){
            if(i.getID()==id) {
                return i;
            }
        }
        return null;
    }

    public int KolItemInCot( ){
        int result = 0;
        for (GenericItem i  : ALCatalog){
            result += 1;
        }
        return result;
    }

}
