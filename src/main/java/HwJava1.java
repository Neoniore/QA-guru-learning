public class HwJava1 {
    public static void main(String[] args) {
        task01();
        task2();
        task4();
    }

    public static void task01() {
        int a = 2;
        int b = 3;
        int c = (a + b) * 4 / 2;
        System.out.println(c);

        double d = c / 2.0 - 1 * 0.2;
        System.out.println(d);
    }

    public static void task2() {
        int a = 2;
        int b = 3;
        boolean c1 = (a > b);
        boolean c2 = (a <= b);
        boolean c3 = (a == b);

        System.out.printf("%b %b %b \n", c1, c2, c3);
    }

    public static void task4() {
        int i = Integer.MAX_VALUE + 1;
        System.out.printf("%d", i);
    }


}
