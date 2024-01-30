import java.util.ArrayList;

public class FloorSubsystem implements Runnable {

    ArrayList<Floor> listOfFloors;
    ArrayList<Request> listOfRequests;

    FloorSubsystem(int numberOfFloors) {
        listOfFloors = new ArrayList<>();
        for (int i = 0; i < numberOfFloors; i++) {
            listOfFloors.add(new Floor(i+1));
        }
        listOfRequests = readCSV("Input.csv");
    }

    private static ArrayList<Request> readCSV(String csvName) {
        return new ArrayList<>(); //Temp return, put actual implementation in later
    }
    public void run() {

    }
}
