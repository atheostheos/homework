package atheostheos.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("data/test.txt");
        String[] lines = Files.lines(path).filter((line) -> line.length() % 2 == 0).toArray(String[]::new);

        Random rand = new Random();
        long evenDigitsCount = Stream.generate( () -> rand.nextInt(1000000) ).limit(100).filter( num -> Math.ceil(Math.log10(num)) % 2 == 0).count();

        Integer[] sizes = Files.lines(path).map(String::length).toArray(Integer[]::new);

        String[] sorted = Files.lines(path).sorted((a,b) -> a.length() - b.length()).toArray(String[]::new);

        System.out.println(Arrays.toString(lines));
        System.out.println(evenDigitsCount);
        System.out.println(Arrays.toString(sizes));
        System.out.println(Arrays.toString(sorted));


    }
}