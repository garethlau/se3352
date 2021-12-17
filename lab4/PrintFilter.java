
public class PrintFilter extends Filter {

    public PrintFilter(Pipe input, Pipe output) {
        // Call Filter constructor and pass both input and output pipes
        super(input, output);
    }

    @Override
    public void transform() {
        // Get the first item in the pipe
        Double[] next = this.input.next();

        while (next != null) {
            // Print each element in the array
            for (int i = 0; i < next.length; i++) {
                System.out.println(next[i]);
            }

            // If there exists an output pipe, pass on the values
            if (this.output != null) {
                this.output.put(next);
            }

            // Process the next element in the pipe
            next = this.input.next();
        }

    }
}
