public class Floor implements Runnable{
    private final int floorNumber;

    Floor(int floor) {
        floorNumber = floor;
    }

    public void run() {
        System.out.println("I am a Floor");
    }
}
