import java.util.ArrayList;

public class Pipe {
    // Create data structure to maintain items passed into the pipe
    ArrayList<Double[]> buffer = new ArrayList<Double[]>();

    // Add an item to the pipe
    public void put(Double[] input) {
        this.buffer.add(input);
    }

    // Remove the first item (if exists) from the pipe
    // This is done in a first-in-first-out fashion
    public Double[] next() {
        if (this.buffer.size() > 0) {
            return this.buffer.remove(0);
        } else
            return null;
    }
}