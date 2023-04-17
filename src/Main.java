import java.util.*;

public class Main {

    public static void main(String[] args) {

        String[] inputArray = {"mama","bbbbbbp", "caabb", "abccbas", "xyz", "laslas"};
        String[] result = (findEvenCharacterStrings(inputArray));
        char[] chars = uniqueCharacters(result);

        System.out.print("Found unique characters are: ");
        for(Character c : chars){
            System.out.print(c+" ");
        }
    }

    public static String[] findEvenCharacterStrings(String[] inputArray) {
        String[] result = new String[2];
        int resultCount = 0;

        for (String s : inputArray) {
            if (hasEvenCharacters(s)) {
                result[resultCount++] = s;
                if (resultCount == 2) {
                    break;
                }
            }
        }

        if (resultCount < 2) {
            String[] resizedResult = new String[resultCount];
            System.arraycopy(result, 0, resizedResult, 0, resultCount);
            return resizedResult;
        }

        return result;
    }

    public static boolean hasEvenCharacters(String s) {
        Map<Character, Integer> charFrequency = new HashMap<>();

        for (char c : s.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        for (int frequency : charFrequency.values()) {
            if (frequency % 2 != 0) {
                return false;
            }
        }

        return true;
    }

    public static char[] uniqueCharacters(String[] words){
        Set<Character> uniqueChars = new HashSet<>();
        for(String s : words){
            for (char c :s.toCharArray()){
                uniqueChars.add(c);
            }
        }
        char[] result = new char[uniqueChars.size()];
        int index = 0;

        for (Character c : uniqueChars){
            result[index++]=c;
        }
        return result;
    }
}