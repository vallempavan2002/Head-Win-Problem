import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Toss {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String player1 = "Player1";
        String player2 = "Player2";
        ArrayList<ArrayList<String>> pl1 = new ArrayList<>();
        ArrayList<ArrayList<String>> pl2 = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            ArrayList<String> ar1 = new ArrayList<>();
            ArrayList<String> ar2 = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                if (i % 2 == 0) {
                    if (Math.random() < 0.5) {
                        ar1.add("Head");
                    } else
                        ar1.add("Tail");
                } else {
                    if (Math.random() < 0.5) {
                        ar2.add("Head");
                    } else
                        ar2.add("Tail");
                }
            }
            pl1.add(ar1);
            pl2.add(ar2);
            // System.out.println(ar1);
            // System.out.println(ar2);
            int c1 = ar1.stream().filter(ele -> ele.equals("Head")).collect(Collectors.toList()).size();
            int c2 = ar2.stream().filter(ele -> ele.equals("Head")).collect(Collectors.toList()).size();
            if (c1 > c2) {
                System.out.println("Winner is " + player1);
            } else
                System.out.println("Winner is " + player2);
        }
        try {
            PrintWriter pw = new PrintWriter("toss.csv");
            StringBuffer csvHeader = new StringBuffer("");
            StringBuffer csvData = new StringBuffer("");
            csvHeader.append("Round,Player1,Player2\n");
            pw.write(csvHeader.toString());

            for (int i = 0; i < 3; i++) {
                csvData.append("Cycle" + (i + 1) + "\n");
                for (int j = 0; j < 10; j++) {
                    csvData.append("Round" + (j + 1));
                    csvData.append(",");
                    csvData.append(pl1.get(i).get(j));
                    csvData.append(",");
                    csvData.append(pl2.get(i).get(j));
                    csvData.append("\n");
                }
            }
            pw.write(csvData.toString());
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
