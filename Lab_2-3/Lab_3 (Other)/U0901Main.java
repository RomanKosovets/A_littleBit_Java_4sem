package Lab_3;

public class U0901Main {
    public static void main(String[] args) {
        Integer[] intArr = {10, 20, 15};
        Double[] floatArr = new Double[5];

        for (int i = 0; i < floatArr.length; i++) {
            floatArr[i] = (Double) Math.random() * 100;
        }

        U0901WorkArray<Integer> insWorkArrayInt = new U0901WorkArray<Integer>(intArr);
        U0901WorkArray<Double> insWorkArrayDouble = new U0901WorkArray<Double>(floatArr);

        System.out.println("Sum of integers: " + insWorkArrayInt.sum());
        System.out.println("Sum of doubles: " + insWorkArrayDouble.sum());
    }
}
