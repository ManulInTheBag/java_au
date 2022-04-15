import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;


public class topk {
    public static void main(String[] args) {
        String[] LEETCODE_TEST_1 = {"i", "love", "leetcode", "i", "love", "coding"};
        String[] LEETCODE_TEST_2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};

        System.out.println(Arrays.toString(LEETCODE_TEST_1));
        System.out.println(topKFrequent(LEETCODE_TEST_1, 2));

        System.out.println(Arrays.toString(LEETCODE_TEST_2));
        System.out.println(topKFrequent(LEETCODE_TEST_2, 4));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        return Arrays.stream(words)
                .collect(Collectors.groupingBy(t -> t, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String,Long>comparingByValue().reversed().thenComparing(Map.Entry.<String,Long>comparingByKey()))
                .map(Map.Entry::<String,Long>getKey)
                .limit(k)
                .collect(Collectors.toList());
    }
}