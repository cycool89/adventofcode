package src.lib;

public class RunningTime {

    static long startTime = 0;

    public static void start() {
        startTime = System.currentTimeMillis();
    }

    public static void check() {
        long endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("Program running time: " + (endTime - startTime) + "ms");

    }
}
