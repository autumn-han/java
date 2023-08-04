import java.util.Date;
import java.util.Random;

public class AlfredQuotes {
    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }
    public String guestGreeting(String name) {
        String helloGuest = String.format("Welcome to the Wayne Family Mansion. How may I assist you, %s?", name);
        return helloGuest;
    }
    // ninja bonus: overload guestGreeting method
    public String guestGreeting(String name, String dayPeriod) {
        String helloGuest = String.format("Good %s, %s. Lovely to see you", dayPeriod, name);
        return helloGuest;
    }
    public String dateAnnouncement() {
        Date date = new Date();
        String giveDate = String.format("It is currently %tc", date);
        return giveDate;
    }
    public String respondBeforeAlexis(String conversation) {
        int nameNotPresent = -1;
        if(conversation.indexOf("Alexis") != nameNotPresent) {
            return "Right away sir. She certainly isn't sophisticated enough for that";
        }
        else if(conversation.indexOf("Alfred") != nameNotPresent) {
            return "At your service. As you wish, naturally";
        }
        else {
            return "Right. And with that I shall retire";
        }
    }
    // ninja bonus: create your own method
    public String whatMood() {
        Random randInt = new Random();
        int randPick = randInt.nextInt(7);
        String[] sassyAlfred = new String[7];
        sassyAlfred[0] = "Why you're the very model of sanity. Oh by the way, I pressed your tights and put away your exploding gas balls";
        sassyAlfred[1] = "What is the point of all those push-ups if you can't even lift a bloody log?";
        sassyAlfred[2] = "I'll prepare your usual breakfast: toast, coffee, bandages";
        sassyAlfred[3] = "You really scared me Master Bruce. If you had died...who employs butlers any more?";
        sassyAlfred[4] = "You start pretending to have fun, you might even have a little by accident";
        sassyAlfred[5] = "Only vampires loathe daylight more than Batman";
        sassyAlfred[6] = "Sir, may I suggest you try to avoid landing on your head?";
        String randQuip = sassyAlfred[randPick];
        return randQuip;
    }
}