abstract class ClassroomDevice {
    public abstract String operate();[cite: 5]
}

interface Chargeable {
    String charge();[cite: 5]
    String charge(int minutes);[cite: 5]
}

class Tablet extends ClassroomDevice implements Chargeable {
    private final String assetTag;

    public Tablet(String assetTag) {
        this.assetTag = assetTag;[cite: 5]
    }

    @Override
    public String operate() {
        return "Tablet " + assetTag + " displaying lesson";[cite: 5]
    }

    @Override
    public String charge() {
        return assetTag + " charging";[cite: 5]
    }

    @Override
    public String charge(int minutes) {
        return assetTag + " charging for " + minutes + " minutes";[cite: 5]
    }
}

public class pro4 {
    public static void main(String[] args) {
        Tablet t = new Tablet("TAB-5");[cite: 5]
        System.out.println(t.operate());[cite: 5]
        System.out.println(t.charge());[cite: 5]
        System.out.println(t.charge(30));[cite: 5]
    }
}
