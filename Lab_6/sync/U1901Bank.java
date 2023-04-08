package sync;

public class U1901Bank {
    private int intTo;
    private int intFrom = 220;

    public int getIntTo() {return intTo;}
    public int getIntFrom() {return intFrom;}

    public void setIntTo(int a) {
        this.intTo = a;
    }

    public synchronized void calc(int intTransaction, long lngTimeout){
        System.out.println("Before: intFrom = " + intFrom + ", intTo = " + intTo +
                ", Thread = " + Thread.currentThread().getName());
        intFrom -= intTransaction;

        try {
            Thread.sleep(lngTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        intTo += intTransaction;
        System.out.println("After: intFrom = " + intFrom + ", intTo = " + intTo +
                ", Thread = " + Thread.currentThread().getName());
    }
}
