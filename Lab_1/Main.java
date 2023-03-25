import java.util.Random;
public class Main{
/** Hi, it's my first programm */
    public static void main(String[] args){

        // Task_1
        System.out.println("Starting project");

        // task_2
        byte v_byte = 120;
        short v_short = 30000;
        char v_char = 'a';
        int v_int = 65000;
        long v_long = 1000000;
        float v_float = 0.134F;
        double v_double = 0.12131323232;
        boolean v_boolean = true;

        System.out.println("This is a byte: "+ v_byte);
        System.out.println("This is a short: "+ v_short);
        System.out.println("This is a char: "+ v_char);
        System.out.println("This is a int: "+ v_int);
        System.out.println("This is a long: "+ v_long);
        System.out.println("This is a float: "+ v_float);
        System.out.println("This is a double: "+ v_double);
        System.out.println("This is a boolean: "+ v_boolean + "\n");

        // Task_3
        for (int i = 97; i < 123; i++){
            char symbol = (char) i;
            System.out.println(symbol);
        }

        // Task_4
        long begin = new java.util.Date().getTime();
        for (int i = 0; i < 100000001; i++){
            if (i == 100000000 ){
                System.out.println("Done");
            }
        }
        long end = new java.util.Date().getTime();
        System.out.println("Time: " + (end-begin));

        // Task_5.1
        int[] mas = {12,43,12,-65,778,123,32,76};
        int max = 0;
        for (int NumberInMas : mas) {
            if (NumberInMas > max) {
                max = NumberInMas;
            }
        }
        System.out.println("Max number in mas: " + max);

        // Task_5.2
        int n = 3;
        int[][] matrix = new int[n][n];
        Random random = new Random();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                matrix[i][j]= random.nextInt(10);
            }
        }

        System.out.println();
        System.out.println("Начальная матрица:\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d", matrix[i][j]);
            }
            System.out.println();
        }

        // транспонирование матрицы
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // вывод на экран транспонированной матрицы
        System.out.println();
        System.out.println("Новая матрица:\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
