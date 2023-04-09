import java.util.*;

public class RecursionQuestion17 {

    char [] arr = "AEIOU".toCharArray();

    public List<String> words (String word) {
        List<String> result = new ArrayList<>();
        result.add(word);

        if (word.length() == 5) return result;

        for (char c : arr) {
            result.addAll(words(word + c));
        }

        return result;
    }

    public int solution(String word) {
        return words("").indexOf(word);
    }

}
