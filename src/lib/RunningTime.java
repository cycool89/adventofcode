package src.lib;

public class RunningTime {

    static long startTime = 0;

    public static void start() {
        startTime = System.currentTimeMillis();
    }

    public static long measure() {
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static void check() {
        System.out.println();
        System.out.println("Program running time: " + measure() + "ms");

    }
}
