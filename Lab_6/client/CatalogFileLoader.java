package ru.billing.client;
import ru.billing.exceptions.*;
import ru.billing.stocklist.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

import static java.sql.Types.NULL;

public class CatalogFileLoader implements CatalogLoader{

    private final String fileName;
    public CatalogFileLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void load(ItemCatalog catalog) throws CatalogLoadException {
        File f = new File(fileName);
        FileInputStream fis;
        String line;
        try {
            fis = new FileInputStream(f);
            Scanner s = new Scanner(fis);

            while (s.hasNextLine()) {
                line = s.nextLine();
                if (line.length()==0)
                    break;
                if (line.startsWith("INSERT INTO Item VALUES")) {
                    String[] item_fld = line.split(",");
                    int ID = Integer.parseInt(item_fld[1]);
                    String name = item_fld[2];
                    String NameAnalog = item_fld[3];
                    float price = Float.parseFloat(item_fld[5]);
                    float priceAnalog = Float.parseFloat(item_fld[6]);

                    Analogue analogue = new Analogue(NULL, NameAnalog, priceAnalog);
                    TechnicalItem item = new TechnicalItem(Category.GENERAL, ID, name, price, analogue, (short) NULL);
                    catalog.addItem(item);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new CatalogLoadException(String.valueOf(e));
        } catch (ItemAlreadyExistsException e) {
            e.printStackTrace();
            throw new CatalogLoadException(e);
        }
    }
}
