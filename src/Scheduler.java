import java.util.ArrayList;

public class Scheduler implements Runnable {
    private Request requestBufferFloor;
    private Request requestBufferElevator;
    private ArrayList<Request> outstandingRequests;
    Scheduler(Request floorBuffer, Request elevatorBuffer) {
        requestBufferFloor = floorBuffer;
        requestBufferElevator = elevatorBuffer;
        outstandingRequests = new ArrayList<>();
    }

    /**
     * Checks if there is a request from the floor subsystem, if so empty the buffer and return it
     * @return Request that the floor subsystem is making, or null if there is no current request from floor subsystem
     */
    private synchronized boolean floorRequestCheck() {
        if (requestBufferFloor != null) {
            //Request returnRequest = requestBufferFloor;
            //requestBufferFloor = null;
            notifyAll();
            return true;
        }
        notifyAll();
        return false;
    }

    /**
     * Handles the request in the requestBufferFloor
     * Sends the request to the elevator
     * And keeps the request in its list of outstanding requests
     */
    private synchronized void handleFloorRequest() {
        if (requestBufferFloor != null) {
            while(!sendRequestElevator(requestBufferFloor)); //Keep trying to send request to elevator, if it fails (returns false) try again
            outstandingRequests.add(requestBufferFloor);
            requestBufferFloor = null;
        }
        notifyAll();
    }

    /**
     * Sends a request to the elevator
     * @param request the request to be sent
     * @return if sending the request was successful
     */
    private synchronized boolean sendRequestElevator(Request request) {
        if (request != null && requestBufferElevator == null) {
            requestBufferElevator = request;
            notifyAll();
            return true;
        }
        notifyAll();
        return false;
    }

    /**
     * Checks if any of the outstanding requests to the elevator are complete yet
     * If so remove them from the outstanding request arraylist
     */
    private synchronized void checkOutstanding() {
        outstandingRequests.removeIf(Request::getComplete);
    }
    public void run() {
        while (true) {
            checkOutstanding();
            if (floorRequestCheck()) {
                handleFloorRequest();
            }
        }
    }
}
