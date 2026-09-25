abstract class GardenTool {
    public abstract String use();[cite: 5]
}

class CuttingTool extends GardenTool {
    public CuttingTool() {
        super();
    }

    @Override
    public String use() {
        return "Using the tool in the garden, blade sharpened first";[cite: 5]
    }
}

class Pruner extends CuttingTool {
    public Pruner() {
        super();
    }

    @Override
    public String use() {
        return super.use() + ", then trimming branches precisely";[cite: 5]
    }
}

public class pro3 {
    public static void main(String[] args) {
        CuttingTool c = new CuttingTool();[cite: 5]
        System.out.println(c.use());[cite: 5]

        Pruner p = new Pruner();[cite: 5]
        System.out.println(p.use());[cite: 5]
    }
}
