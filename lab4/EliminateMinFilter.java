public class EliminateMinFilter extends Filter {

    public EliminateMinFilter(Pipe input, Pipe output) {
        // Call Filter constructor and pass both input and output pipes
        super(input, output);
    }

    @Override
    public void transform() {
        // Get the first item in the pipe
        Double[] next = this.input.next();

        while (next != null) {
            // Find min element
            Double minSoFar = next[0];
            for (int i = 1; i < next.length; i++) {
                if (next[i] < minSoFar) {
                    minSoFar = next[i];
                }
            }

            // Create new array
            Double[] result = new Double[next.length - 1];

            // add all values except the smallest one
            for (int i = 0, j = 0; i < next.length; i++) {
                if (next[i] != minSoFar) {
                    result[j++] = next[i];
                }
            }

            // If there exists an outuput pipe, pass the new array to the output pipe
            if (this.output != null) {
                this.output.put(result);
            }

            // Process the next element in the pipe
            next = this.input.next();
        }
    }
}
