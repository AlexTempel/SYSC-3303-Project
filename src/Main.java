public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scheduler sched = new Scheduler();
        sched.run();
        Floor flor = new Floor(1);
        flor.run();
        Elevator elev = new Elevator();
        elev.run();
    }
}