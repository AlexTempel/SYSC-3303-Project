import java.lang.Math;

public class Elevator implements Runnable{
    private int current_floor;
    private Request[] requestBuffer;
    private final int elevator_id;

    /**
     * Contruct the Elevator Object
     * @param id integer identifier of the elevator
     * @param requestBuffer shared requestBuffer for coordinating with Scheduler
     */
    public Elevator(int id, Request[] requestBuffer) {
        this.elevator_id = id;
        this.requestBuffer = requestBuffer;
        current_floor = 1; //start the Elevator at the ground floor
    }

    

    /**
     * Attempt to complete the request when the buffer is full
     */
    public void run() {
        System.out.println("Starting Elevator");
        while(true){
            synchronized(requestBuffer) {
                if (requestBuffer[0] != null) {
                    System.out.println("Elevator has received the Request!");
                    handleRequest();
                }
            }
        }
    }

    /**
     * Move the elevator from its current floor to the destination floor
     * @param destination ending floor
     */
    private void moveElevator(int destination){
        // Check how many floors elevator needs to travel
        int floorDifference = Math.abs(current_floor - destination);
        for(int i = floorDifference; i > 0; i--){
            System.out.printf("Elevator %d needs to travel %d floors to reach destination\n", elevator_id, i);
            try {
                Thread.sleep(1000); // Simulate travel time
            }catch(InterruptedException e) {}
        }
        // Complete the trip
        current_floor = destination;
    }

    /**
     * Moves the elevator to the starting floor, then to the destination floor
     */
    private synchronized void handleRequest(){
        int startingFloor = requestBuffer[0].getStarting_floor();
        int endingFloor = requestBuffer[0].getEnding_floor();

        // Move from the current floor to the starting floor
        if (startingFloor != current_floor){
            moveElevator(startingFloor);
        }
        // Move to destination floor
        moveElevator(endingFloor);
        requestBuffer[0].finish();
        requestBuffer[0] = null;
        System.out.println("The Elevator buffer is set to completed");
        notifyAll();
    }
}
