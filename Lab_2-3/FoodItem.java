import java.util.Date;
import java.util.Objects;

public class FoodItem extends GenericItem implements Cloneable{

    private Date dateOfIncome; // дата производства
    private short expires; // срок годности, дней

    public Date getDateOfIncome() {return dateOfIncome;}
    public short getExpires() {return expires;}

    public void setDateOfIncome(Date dateOfIncome) {this.dateOfIncome = dateOfIncome;}
    public void setExpires(short expires) {this.expires = expires;}

    public FoodItem(String name, float price, Analogue analog, Date date, short expires){
        this(name, price, expires);
        this.dateOfIncome = date;
        this.expires = expires;
    }

    public FoodItem(String name, float price, short expires){
        this(name);
        setPrice(price);
        this.expires = expires;
    }

    public FoodItem(String name) {
        setName(name);
    }

    public FoodItem() { };

    public FoodItem(Category category, int id, String name, float price,
                    Analogue analogue, Date dateOfIncome, short expires) {
        super(category, id, name, price, analogue);
        this.expires = expires;
        this.dateOfIncome = dateOfIncome;
    }

    void printAll(){
        super.printAll();
        System.out.printf("DateOfIncome: %tT , Expires: %d \n\n", dateOfIncome, expires);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        if (!super.equals(o))
            return false;

        FoodItem foodItem = (FoodItem) o;

        return expires == foodItem.expires &&
                Objects.equals(dateOfIncome, foodItem.dateOfIncome);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {;
        return "FoodItem{" +
                "dateOfIncome=" + dateOfIncome +
                ", expires=" + expires +
                '}';
    }
}
