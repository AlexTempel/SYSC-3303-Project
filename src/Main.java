import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scheduler skedge = new Scheduler();
        skedge.run();
        Elevator elev = new Elevator();
        elev.run();
    }
}