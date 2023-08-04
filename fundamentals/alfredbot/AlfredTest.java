public class AlfredTest {
    public static void main(String[] args) {
        // creating an instance of the AlfredQuotes
        AlfredQuotes alfredBot = new AlfredQuotes();
        // creating strings to test the quotes
        String testGreeting = alfredBot.basicGreeting();
        String testGuestGreeting = alfredBot.guestGreeting("Beth Kane");
        String testGuestOverload = alfredBot.guestGreeting("Beth Kane", "morning");
        String testDateAnnouncement = alfredBot.dateAnnouncement();
        String alexisTest = alfredBot.respondBeforeAlexis("Alexis! Play some lo-fi beats");
        String alfredTest = alfredBot.respondBeforeAlexis("I can't find my yo-yo. Maybe Alfred will know where it is");
        String notRelevantTest = alfredBot.respondBeforeAlexis("Maybe that's not what Batman is about. Not winning. But failing...");
        String whatMoodTest = alfredBot.whatMood();
        // printing strings to console
        System.out.println(testGreeting);
        System.out.println(testGuestGreeting);
        System.out.println(testGuestOverload);
        System.out.println(testDateAnnouncement);
        System.out.println(alexisTest);
        System.out.println(alfredTest);
        System.out.println(notRelevantTest);
        System.out.println(whatMoodTest);
    }
}