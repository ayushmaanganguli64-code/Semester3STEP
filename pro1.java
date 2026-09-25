// Interface contract for ringable devices[cite: 5]
interface Ringable {
    String ring();[cite: 5]
}

class AlarmClock implements Ringable {
    private final String time;

    public AlarmClock(String time) {
        this.time = time;[cite: 5]
    }

    @Override
    public String ring() {
        return "Alarm ringing for " + time;[cite: 5]
    }
}

class Doorbell implements Ringable {
    private final String location;

    public Doorbell(String location) {
        this.location = location;[cite: 5]
    }

    @Override
    public String ring() {
        return "Doorbell ringing at " + location;[cite: 5]
    }
}

public class pro1 {
    public static void ringAll(Ringable[] devices) {
        if (devices != null) {
            for (Ringable device : devices) {
                if (device != null) {
                    System.out.println(device.ring());[cite: 5]
                }
            }
        }
    }

    public static void main(String[] args) {
        AlarmClock a = new AlarmClock("7:00 AM");[cite: 5]
        System.out.println(a.ring());[cite: 5]

        Doorbell d = new Doorbell("Front Door");[cite: 5]
        System.out.println(d.ring());[cite: 5]

        System.out.println("--- Batch Ringing ---");
        ringAll(new Ringable[] { a, d });[cite: 5]
    }
}
