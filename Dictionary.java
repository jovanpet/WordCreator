import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dictionary {
    /**
     * Get the words stored in words.txt Generally you should put the words.txt file in the proejct folder, but NOT in the src folder.
     * @return
     */
    public static String[] getWords() {
        // making a scanner from a file. Some new syntax but NBD
        Scanner scan = null;
        try {
            scan = new Scanner(new FileInputStream("words.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
            // If you are getting this error the words file isn't where it's expected to be.
        }

        // OK, so I'm using a list here. So sue me. You shouldn't use one.
        List<String> words = new ArrayList<>();
        while(scan.hasNext()) {
            words.add(scan.next());
        }

        // yeah this one is a bit confusing to me too. But that's how java says to call the function, and who am I to argue
        return words.toArray(new String[0]);

    }

    
}
