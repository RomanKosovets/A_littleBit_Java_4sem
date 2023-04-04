import java.util.Objects;

public class TechnicalItem extends GenericItem implements Cloneable{
    private short warrantyTime; // гарантийный срок (суток)

    public short getWarrantyTime() {return warrantyTime;}
    public void setWarrantyTime(short warrantyTime) {this.warrantyTime = warrantyTime;}


    public TechnicalItem(Category category, int id, String name,
                         float price, Analogue analogue, short warrantyTime) {
        super(category, id, name, price, analogue);
        this.warrantyTime = warrantyTime;
    }
    void printAll(){
        super.printAll();
        System.out.printf("WarrantyTime: %d", warrantyTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        if (!super.equals(o))
            return false;

        TechnicalItem that = (TechnicalItem) o;

        return warrantyTime == that.warrantyTime;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "TechnicalItem{" +
                "warrantyTime=" + warrantyTime +
                '}';
    }
}
