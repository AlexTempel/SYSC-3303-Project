import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Request> requests = FloorSubsystem.readCSV("Input.csv");
        for (Request r : requests) {
            LocalTime time = r.getTime();
            LocalTime currTime = LocalTime.now();
            System.out.println(time);
            System.out.println(r.getEnding_floor());
            System.out.println("CUrrent time: " + currTime);

            if (currTime.compareTo(time) == 0 || currTime.compareTo(time) > 0 ){
                System.out.println("It works");
            }
            else {
                System.out.println("It don't work");
            }
        }

    }
}