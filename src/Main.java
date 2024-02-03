public class Main {
    public static void main(String[] args) {
        Request floorbuffer = null;
        Request elevatorbuffer = null;

        FloorSubsystem floorSubsystem = new FloorSubsystem(22, floorbuffer);
        Scheduler scheduler = new Scheduler(floorbuffer, elevatorbuffer);
        Elevator elevator = new Elevator(1, elevatorbuffer);

        floorSubsystem.run();
        scheduler.run();
        elevator.run();
    }
}