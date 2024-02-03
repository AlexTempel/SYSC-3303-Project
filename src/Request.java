import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.util.Date;

public class Request {
    private Date time;
    //private int time; //hh:mm:ss.mmm
    private final int floor;
    private final int car_button;
    private final String floor_button;

    private Boolean complete = false;

    public Request(Date time, int floor, String floor_button, int car_button) {
        this.time = time;
        this.floor = floor;
        this.floor_button = floor_button;
        this.car_button = car_button;
    }

    public boolean getComplete() {
        return complete;
    }

    public void finish() {
        complete = true;
    }

    public Date getTime() {
        return time;
    }

    public int getStarting_floor() {
        return floor;
    }

    public int getEnding_floor() {
        return car_button;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
