public class Main {
    public static void main(String args[]) {

        // Create array of values
        Double[] values = { 4.5, 12.7, 11.0, 18.9, 7.90, 5.32 };

        // Create pipes to connect filters
        Pipe p1 = new Pipe();
        Pipe p2 = new Pipe();
        Pipe p3 = new Pipe();
        Pipe p4 = new Pipe();

        // Add array of values into first pipe
        p1.put(values);

        // Read values from pipe 1
        // Eliminate the largest value from the array
        // Pass the result into pipe 2
        new EliminateMaxFilter(p1, p2).transform();

        // Read values from pipe 2
        // Eliminate the smallest value from the array
        // Pass the result into pipe 3
        new EliminateMinFilter(p2, p3).transform();

        // Read values from pipe 3
        // Convert values to fahrenheit
        // Pass the result into pipe 4
        new ToFahrenheit(p3, p4).transform();

        // Read values from pipe 4
        // Print the values
        // Do not specify an output pipe as this is the last filter
        new PrintFilter(p4, null).transform();

    }
}