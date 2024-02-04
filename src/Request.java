import java.time.LocalTime;

public class Request {
    //private Date time;
    private LocalTime time; //changed all type Data to LocalTime
    //private int time; //hh:mm:ss.mmm
    private final int floor;
    private final int car_button;
    private final String floor_button;

    private Boolean complete = false;

    public Request(LocalTime time, int floor, String floor_button, int car_button) {
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
        System.out.println("Request to go from floor: " + floor + " to floor: " + car_button + " going " + floor_button + "wards");
    }

    public LocalTime getTime() {
        return time;
    }

    public int getStarting_floor() {
        return floor;
    }

    public int getEnding_floor() {
        return car_button;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String toString() {
        return ("Complete: " + time.toString() + " " + floor + " " + floor_button + " " + car_button);
    }
}
