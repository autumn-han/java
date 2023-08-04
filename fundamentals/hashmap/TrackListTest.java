import java.util.HashMap;
import java.util.Set;

public class TrackListTest {
    public static void main(String[] args) {
        // initiating HashMap called trackList
        HashMap<String, String> trackList = new HashMap<String, String>();
        // loading trackList with song title - song lyrics key-value pairings
        trackList.put("Love Me Do", "Love, love me do / You know I love you");
        trackList.put("Roll Over Beethoven", "Well gonna write a little letter / Gonna mail it to my local DJ");
        trackList.put("Can't Buy Me Love", "Can't buy me love, love / Can't buy me love");
        trackList.put("I've Just Seen A Face", "I've just seen a face / I can't forget the time or place");
        // pull out one of the songs from trackList using song title
        System.out.println(trackList.get("Roll Over Beethoven"));
        // iterate through trackList and print all song titles and corresponding lyrics
        Set<String> keys = trackList.keySet();
        for (String key : keys) {
            String titleAndLyrics = String.format("%s: %s", key, trackList.get(key));
            System.out.println(titleAndLyrics);
        }
    }
}