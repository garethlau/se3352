
public class EliminateMaxFilter extends Filter {
    // Constructor
    public EliminateMaxFilter(Pipe input, Pipe output) {
        // Call Filter constructor and pass both input and output pipes
        super(input, output);
    }

    @Override
    public void transform() {
        // Get the first item in the pipe
        Double[] next = this.input.next();

        while (next != null) {
            // Find max element
            Double maxSoFar = next[0];
            for (int i = 1; i < next.length; i++) {
                if (next[i] > maxSoFar) {
                    maxSoFar = next[i];
                }
            }

            // Create new array
            Double[] result = new Double[next.length - 1];

            // Add all values except the max
            for (int i = 0, j = 0; i < next.length; i++) {
                if (next[i] != maxSoFar) {
                    result[j++] = next[i];
                }
            }

            // If there exists an output pipe, pass on the result to the output pipe
            if (this.output != null) {
                this.output.put(result);
            }

            // Process the next element in the pipe
            next = this.input.next();
        }
    }
}
