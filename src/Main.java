import java.time.LocalTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Request> requests = FloorSubsystem.readCSV("Input.csv");
        for (Request r : requests) {
            System.out.println(r.getTime());
            System.out.println(r.getEnding_floor());
            System.out.println("CUrrent time: " + LocalTime.now());

        }

    }
}