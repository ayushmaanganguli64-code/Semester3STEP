abstract class Drone {
    public abstract String fly();[cite: 5]
}

interface Trackable {
    String getLocation();[cite: 5]
}

class DeliveryDrone extends Drone implements Trackable {
    private final String id;

    public DeliveryDrone(String id) {
        this.id = id;[cite: 5]
    }

    @Override
    public String fly() {
        return "Delivery drone " + id + " flying";
    }

    @Override
    public String getLocation() {
        return id + " at Sector 4";[cite: 5]
    }
}

class ScoutDrone extends Drone {
    private final String id;

    public ScoutDrone(String id) {
        this.id = id;[cite: 5]
    }

    @Override
    public String fly() {
        return "Scout drone " + id + " flying";
    }
}

class GroundRobot implements Trackable {
    private final String id;

    public GroundRobot(String id) {
        this.id = id;[cite: 5]
    }

    @Override
    public String getLocation() {
        return id + " at Sector 4";[cite: 5]
    }
}

public class pro5 {
    public static String getLocationIfTrackable(Object o) {
        if (o instanceof Trackable) {[cite: 5]
            Trackable trackable = (Trackable) o;[cite: 5]
            return trackable.getLocation();
        }
        return "Tracking not available";[cite: 5]
    }

    public static void main(String[] args) {
        DeliveryDrone d = new DeliveryDrone("DR-1");[cite: 5]
        System.out.println(getLocationIfTrackable(d));[cite: 5]

        ScoutDrone s = new ScoutDrone("SC-1");[cite: 5]
        System.out.println(getLocationIfTrackable(s));[cite: 5]

        GroundRobot g = new GroundRobot("GR-1");[cite: 5]
        System.out.println(getLocationIfTrackable(g));[cite: 5]
    }
}
