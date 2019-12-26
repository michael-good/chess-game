package Game;

public class Coordinate {
    int file;
    int rank;

    public Coordinate(int file, int rank) {
        this.file = file;
        this.rank = rank;
    }

    public int getFile() {
        return file;
    }

    public int getRank() {
        return rank;
    }

    public boolean equals(Coordinate coord) {
        return this.file == coord.getFile() && this.rank == coord.getRank();
    }

    @Override
    public String toString() {
        return "File: " + Integer.toString(file) + " ; " + "Rank: " + Integer.toString(rank);
    }
}
