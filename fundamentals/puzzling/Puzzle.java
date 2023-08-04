import java.util.Random;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Puzzle {
    Random randMachine = new Random();
    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> intArray = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            int randNum = randMachine.nextInt(21);
            intArray.add(randNum);
        }
        return intArray;
    }
    public String getRandomLetter() {
        String[] abcArr = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        int randIndex = randMachine.nextInt(26);
        String randLetter = abcArr[randIndex];
        return randLetter;
    }
    public StringJoiner generatePassword() {
        String[] passwordArr = new String[8];
        StringJoiner password = new StringJoiner("");
        for (int i = 0; i < 8; i++) {
            passwordArr[i] = getRandomLetter();
            password.add(passwordArr[i]);
        }
        return password;
    }
    public ArrayList<StringJoiner> getNewPasswordSet(int arrLength) {
        ArrayList<StringJoiner> randWords = new ArrayList<StringJoiner>();
        for (int i = 0; i < arrLength; i++) {
            randWords.add(generatePassword());
        }
        return randWords;
    }
}
