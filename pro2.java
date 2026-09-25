abstract class ArtPiece {
    private static int counter = 0; // Shared static counter[cite: 5]
    private final String pieceId;   // Assigned internally[cite: 5]

    public ArtPiece() {
        counter++;
        this.pieceId = "ART-" + counter;
    }

    public String getPieceId() {
        return pieceId;[cite: 5]
    }

    public abstract String describe();[cite: 5]
}

class Painting extends ArtPiece {
    private final String title;

    public Painting(String title) {
        super();
        this.title = title;[cite: 5]
    }

    @Override
    public String describe() {
        return "Painting: " + title + ", framed on canvas";[cite: 5]
    }
}

class Sculpture extends ArtPiece {
    private final String title;

    public Sculpture(String title) {
        super();
        this.title = title;[cite: 5]
    }

    @Override
    public String describe() {
        return "Sculpture: " + title + ", carved from stone";[cite: 5]
    }
}

public class pro2 {
    public static void main(String[] args) {
        Painting p = new Painting("Sunset Fields");[cite: 5]
        System.out.println(p.describe());[cite: 5]

        Sculpture s = new Sculpture("The Thinker II");[cite: 5]
        System.out.println(s.describe());[cite: 5]

        System.out.println("Painting Piece ID: " + p.getPieceId());
        System.out.println("Sculpture Piece ID: " + s.getPieceId());
    }
}
