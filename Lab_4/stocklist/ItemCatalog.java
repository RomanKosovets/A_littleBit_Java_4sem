package ru.billing.stocklist;
import ru.billing.exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemCatalog {
    private final HashMap<Integer, GenericItem> catalog =
            new HashMap<Integer,GenericItem>();           // коллекция для поиска следующих товаров
    private final ArrayList<GenericItem> ALCatalog =
            new ArrayList<GenericItem>();                 // коллекция для сравнения

    public void addItem(GenericItem item) throws ItemAlreadyExistsException {
        if(catalog.containsKey(item.getID())) {
            throw new ItemAlreadyExistsException("Item with ID" + item.getID() + "already exists in catalog");
        }
        catalog.put(item.getID(), item);
        ALCatalog.add(item);
    }

    public void printItems(){
        for(GenericItem i : ALCatalog){
            System.out.println(i);
        }
    }

    public GenericItem findItemByID(int id) throws CatalogLoadException {
        if (catalog.isEmpty()) {
            throw new CatalogLoadException("Catalog is empty");
        }
        GenericItem item = catalog.get(id);
        if (item == null) {
            throw new CatalogLoadException("Item with ID " + id + " not found in catalog");
        }
        return item;
    }

    public GenericItem findItemByIDAL(int id){
        for(GenericItem i : ALCatalog){
            if(i.getID()==id) {
                return i;
            }
        }
        return null;
    }

    public int KolItemInCatalog( ){
        int result = 0;
        for (GenericItem i  : ALCatalog){
            result += 1;
        }
        return result;
    }
}
