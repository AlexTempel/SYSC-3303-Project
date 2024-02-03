import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Request floorbuffer = null;
        Request elevatorbuffer = null;

        FloorSubsystem floorSubsystem = new FloorSubsystem();
        Scheduler scheduler = new Scheduler();
        Elevator elevator = new Elevator();
    }
}