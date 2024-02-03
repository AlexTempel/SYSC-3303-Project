import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalTime;

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

    public static ArrayList<Request> readCSV(String csvName) {
        //SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.S");
        ArrayList<Request> toReturn = new ArrayList<Request>();
        try {
            FileReader file = new FileReader(csvName);
            BufferedReader input = new BufferedReader(file);
            String line = input.readLine();

            while(line != null){
                line = input.readLine();
                String[] values = line.split(" ");
                Request newRequest = new Request(LocalTime.parse(values[0]),
                        Integer.parseInt(values[1]),
                        values[2],
                        Integer.parseInt(values[3]));
                toReturn.add(newRequest);
            }
            input.close();
        } catch(Exception e) { e.getStackTrace(); }
        return toReturn;
    }

    public boolean checkTime(LocalTime reqTime, LocalTime currTime){
        int result = reqTime.compareTo(currTime);
        return result == 0 || result > 0;

    }
    public void run() {
        while(true){
            for (Request r : listOfRequests) {
                boolean requestNow = checkTime(r.getTime(), LocalTime.now());
                if (requestNow){
                    //send request to scheduler
                }
            }

        }
    }
}
