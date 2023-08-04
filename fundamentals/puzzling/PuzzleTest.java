import java.util.StringJoiner;
import java.util.ArrayList;

class PuzzleTest {
    public static void main(String[] args) {
        Puzzle puzzleTest = new Puzzle();
        // invoking methods from Puzzle.java
        ArrayList<Integer> tenRollsTest = puzzleTest.getTenRolls();
        String randLetterTest = puzzleTest.getRandomLetter();
        StringJoiner passwordTest = puzzleTest.generatePassword();
        ArrayList<StringJoiner> passwordSetTest = puzzleTest.getNewPasswordSet(5);
        // printing return statements to console
        System.out.println(tenRollsTest);
        System.out.println(randLetterTest);
        System.out.println(passwordTest);
        System.out.println(passwordSetTest);
    }
}