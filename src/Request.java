public class Request {
    private int time; //hh:mm:ss.mmm
    private final int starting_floor;
    private final int ending_floor;

    private Boolean complete = false;

    public Request(int time, int starting_floor, int ending_floor) {
        this.time = time;
        this.starting_floor = starting_floor;
        this.ending_floor = ending_floor;
    }

    public boolean getComplete() {
        return complete;
    }
    public void finish() {
        complete = true;
    }
    public int getTime() {
        return time;
    }

    public int getStarting_floor() {
        return starting_floor;
    }

    public int getEnding_floor() {
        return ending_floor;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
