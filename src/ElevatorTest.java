import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;


class ElevatorTest {
    @Test
    void test(){

        //Request testRequest = new Request(1,3,5);
        Request testRequest = new Request(LocalTime.now(),3,5);

        Elevator testElevator = new Elevator(1,testRequest);

    }



}
