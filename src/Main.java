import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Request floorBuffer = null;
        Request elevatorBuffer = null;
        Scheduler sched = new Scheduler(elevatorBuffer, floorBuffer);
        FloorSubsystem flo = new FloorSubsystem(12, floorBuffer);

        floorBuffer = new Request(LocalTime.now(), 5, "up", 7);
    }
}