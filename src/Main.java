import java.util.*;
import static java.util.Collections.emptySet;

public class Main {

    public static void main(String[] args) {

        String[] inputArray = {"mamda", "bbbbbb2", "кукуeкуку", "caabb", "abccbas", "xyz", "laslasr"};
        System.out.print("Found unique characters are: " + findEvenCharacterStrings(inputArray));
    }
    public static Set findEvenCharacterStrings(String[] inputArray) {
        int resultCount = 0;
        Set finalSetOfCharacters = new HashSet();            //створюється сет для унікальних симолів

        for (String s : inputArray) {
            Set uniqueCharsForWord = hasEvenCharacters(s);
            if (!uniqueCharsForWord.isEmpty()) {
                finalSetOfCharacters.addAll(uniqueCharsForWord);   //всі унікальні символи слова додаються до фінального
                resultCount++;
                if (resultCount == 2) {
                    break;
                }
            }
        }
        return finalSetOfCharacters;
    }
    public static Set hasEvenCharacters(String s) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        Set uniqueCharacters = new HashSet();
        for (char c : s.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
            uniqueCharacters.add(c);                 // додаються унікальні символи для слова.
        }

        for (int frequency : charFrequency.values()) {
            if (frequency % 2 != 0) {
                return emptySet();                       // якщо умова не виконана - тоді ми повертаємо пустий сет
            }
        }

        return uniqueCharacters;
    }

}