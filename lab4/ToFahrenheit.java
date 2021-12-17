public class ToFahrenheit extends Filter {

    public ToFahrenheit(Pipe input, Pipe output) {
        // Call Filter constructor and pass both input and output pipes
        super(input, output);
    }

    @Override
    public void transform() {
        Double[] next = this.input.next();

        while (next != null) {
            Double[] result = new Double[next.length];
            for (int i = 0; i < next.length; i++) {
                result[i] = next[i] * ((double) 9 / 5) + 32;
            }

            // If there exists an output pipe, pass on the values
            if (this.output != null) {
                this.output.put(result);
            }

            // Process the next element in the pipe
            next = this.input.next();
        }

    }
}
