package leetcodeQuestions;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class countListTiles {


        public static void countPossibility(Set<String> setString,String tiles,String ans,int[] check){

            setString.add(ans);
            for(int i=0;i<tiles.length();i++)
            {

                if(check[i]!=1){
                    check[i]=1;
                    countPossibility(setString,tiles,ans+tiles.charAt(i),check);
                    check[i]=-1;
                }

            }
        }
        public static int numTilePossibilities(String tiles) {

            int[] check= new int[tiles.length()];
            for(int i=0;i<tiles.length();i++)
            {
                check[i]=-1;
            }
            Set<String> setString= new HashSet<>();
            countPossibility(setString,tiles,"",check);
            return setString.size()-1;

        }


    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s=sc.nextLine();
        int val=numTilePossibilities(s);
        System.out.println("Current Output of the countListtiles is"+val);


    }
}
