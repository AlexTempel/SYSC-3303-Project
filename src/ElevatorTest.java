import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class ElevatorTest {
    @Test
    void test(){

        Request testRequest = new Request(1,3,5);
        Elevator testElevator = new Elevator(1,testRequest);

    }



}
