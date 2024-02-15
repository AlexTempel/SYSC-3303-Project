public class Main {
    public static void main(String[] args) {
        Request[] floorbuffer = new Request[1]; //Buffer
        Request[] elevatorbuffer = new Request[1];

        FloorSubsystem floorSubsystem = new FloorSubsystem(22, floorbuffer);
        Scheduler scheduler = new Scheduler(floorbuffer, elevatorbuffer);
        Elevator elevator = new Elevator(1, elevatorbuffer);

        Thread floorThread = new Thread(floorSubsystem);
        Thread schedulerThread = new Thread(scheduler);
        Thread elevatorThread = new Thread(elevator);

        floorThread.start();
        schedulerThread.start();
        elevatorThread.start();
    }
}