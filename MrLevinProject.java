import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class MrLevinProject {
    public static final String WORD = "word";
    public static final String END_WORD = "turd";

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("C:\\Users\\joarlab20\\IdeaProjects\\IBCS\\src\\dictionary words.txt");
        boolean brudda = false;
        boolean firstdone = false;
        boolean bro = false;
        int counter = 1;
        int gen = 0;
        Scanner sc = new Scanner(f);
        ArrayList<String> words = new ArrayList<>();
        ArrayList<ArrayList<String>> length = new ArrayList<>();
        Set<String> dict = new HashSet<>();
        Set<String> used = new HashSet<>();
        while (sc.hasNext()) {
            String word = sc.next();
            dict.add(word);
        }
        Iterator<String> iterator = dict.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().length() == WORD.length()) {
//                words.add(iterator.next());
            }
        }
//        int index = words.indexOf(WORD);
        for (int j = 0; j < WORD.length(); j++) {
            for (int i = 97; i < 122; i++) {
                char[] ch = WORD.toCharArray();
                ch[j] = (char) i;

                String newValue = String.valueOf(ch);

                if (dict.contains(newValue) && !used.contains(newValue)) {
                    words.add(newValue);
                    used.add(newValue);
                }

            }
        }
        if (words.contains(END_WORD)) {
            firstdone = true;
            System.out.println("Generation: " + 1);
        }
        length.add(words);
        System.out.println(words.toString());
        if (firstdone == false) {
//            while (brudda == false) {
//                brudda = true;
            while (brudda == false) {
                brudda = true;
                if (words.contains(END_WORD)) {
                    System.out.println("Generation: " + counter);
                } else {
                    counter++;
                    int smol = words.size();
                    for (int k = 0; k < smol; k++) {
                        for (int j = 0; j < words.get(k).length(); j++) {
                            for (int i = 97; i < 122; i++) {
                                String word = words.get(k);
                                char[] ch = word.toCharArray();
                                ch[j] = (char) i;

                                String newValue = String.valueOf(ch);

                                if (dict.contains(newValue) && !used.contains(newValue)) {
                                    brudda = false;
                                    words.add(newValue);
                                    used.add(newValue);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
