import java.util.ArrayList;

public class Scheduler implements Runnable {
    private Request[] requestBufferFloor;
    private Request[] requestBufferElevator;

    Scheduler(Request[] floorBuffer, Request[] elevatorBuffer) {
        requestBufferFloor = floorBuffer;
        requestBufferElevator = elevatorBuffer;
    }

    /**
     * Provides the functionality of the scheduler
     * If there is a request in the floor buffer and no request in the elevator buffer
     * Put the floor buffer's request in the elevator buffer
     */
    private synchronized void communicate() {
        if (requestBufferFloor[0] != null && requestBufferElevator[0] == null) {
            requestBufferElevator[0] = requestBufferFloor[0];
            requestBufferFloor[0] = null;
            System.out.println("Sent to Elevator");
        }
        notifyAll();
    }

    public void run() {
        System.out.println("Starting Scheduler");
        while (true) {
            communicate();
        }
    }
}
