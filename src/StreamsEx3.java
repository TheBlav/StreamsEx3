import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsEx3 {

    public static void main(String[] args) throws IOException {
        final String fileName = "/Users/mdziuba/IdeaProjects/StreamsEx3/src/loremimpsum.txt";
        var reader = new BufferedReader(new FileReader(fileName));
        String tmp = null;
        List<String> words = new ArrayList<>();
        while ((tmp = reader.readLine()) != null){
            words.addAll(Arrays.asList(tmp.split(" ")));
        }
        System.out.println(words);

        List<String> wordCollection = words.stream()
                .map(word -> word.replaceAll(",", "").replaceAll("\\.", "").trim())
                .collect(Collectors.toList());

        System.out.println(wordCollection.stream()
                .filter(word -> word.length()==5)
                .count() + " / " + wordCollection.size());


    }
}
