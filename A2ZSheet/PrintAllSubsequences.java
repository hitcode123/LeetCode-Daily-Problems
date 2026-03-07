package A2ZSheet;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequences {
    public static void printAllSubs(List<String> ap, int n, int i, String current, String real) {
        if (i == n) {
            ap.add(current);
            return;
        }

        printAllSubs(ap, n, i + 1, current + real.charAt(i), real);
        printAllSubs(ap, n, i + 1, current, real);
    }

    public static void main(String[] args) {
        String sample="abc";
        List<String> ans = new ArrayList<>();
        printAllSubs(ans,sample.length(),0,"",sample);
        for(String ech:ans){
            System.out.println(ech);
        }

    }
}