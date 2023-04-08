package ru.billing.client;
import ru.billing.exceptions.CatalogLoadException;
import ru.billing.exceptions.ItemAlreadyExistsException;
import ru.billing.stocklist.*;

public interface CatalogLoader {
    public void load(ItemCatalog cat) throws ItemAlreadyExistsException, CatalogLoadException;
}
