import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Dec03 {

    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("Data.txt");
            BufferedReader br = new BufferedReader(fr);

            char c;
            String rucksack, firstHalf, secondHalf;
            String[] groupOfSacks = new String[3];
            int sum = 0;
            int i = 0;
            while ( (rucksack = br.readLine()) != null) {
                groupOfSacks[i] = rucksack;
                i++;
                // Reset i
                if (i == 3) {
                    i = 0;
                    c = getBadge(groupOfSacks);
                    sum += getScore(c);
                }

            }
            System.out.println("Sum is:  " + sum);
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static char getBadge(String[] group) {
        char c = '\0';
        for (int i = 0 ; i < group[0].length() ; i++) {
            for (int j = 0 ; j < group[1].length() ; j++) {

                // If you find a match b/w the 1st & 2nd, then go in to check the 3rd string.
                if (group[0].charAt(i) == group[1].charAt(j)) {
                    for (int k = 0 ; k < group[2].length() ; k++) {
                        // If we find a match here, we've found the one that matches all 3
                        if (group[0].charAt(i) == group[2].charAt(k)) {
                            return group[0].charAt(i);
                        }
                    }


                }
            }
        }
        return c;
    }

    public static int getScore(char c) {
        int score = 0;
        if (Character.isLowerCase(c)) {
            score = ( (int) c ) - 96;
        } else {
            score = ( (int) c ) - 38;
        }
        return score;
    }
}
