package leetCodeToughQuestions;

import java.util.ArrayList;
import java.util.List;

public class findSuperSequenceFromString {
   static List<List<String>> mpString;
    public static String   findDistanceString(String s1,String s2,int n1,int n2,List<List<String>> mpString){

        if(n2==s2.length()){
            return s1;
        }
        if(n1==s1.length()){
          return s1+s2.substring(n2);
        }

        if(!("".equalsIgnoreCase(mpString.get(n1).get(n2)))){
           return  mpString.get(n1).get(n2);
        }


        if(s1.charAt(n1)==s2.charAt(n2)){
            return findDistanceString(s1,s2,n1+1,n2+1,mpString);
        }

        String s11= findDistanceString(s1,s2,n1 +1,n2,mpString);
        String result = s1.substring(0, n1) + s2.charAt(n2) + s1.substring(n1);
        String s22 =findDistanceString(result,s2,n1+1,n2+1,mpString);


        if(s11.length()<s22.length()){
             mpString.get(n1).set(n2,s11);
             return s11;
        }else{
            mpString.get(n1).set(n2,s22);
            return s22;
        }

    }
    public static String shortestCommonSupersequence(String str1, String str2) {
        mpString=new ArrayList<>();
        int n1=str1.length();
        int n2=str2.length();

        if(str1.length()>str2.length()){
            for(int i=0;i<n1+n2;i++){
                mpString.add(new ArrayList<>());
                for(int j=0;j<n2;j++){
                    mpString.get(i).add("");
                }

            }
            return findDistanceString(str1,str2,0,0,mpString);
        }else{
            for(int i=0;i<n1+n2;i++){
                mpString.add(new ArrayList<>());
                for(int j=0;j<n1;j++){
                    mpString.get(i).add("");
                }

            }
            return findDistanceString(str2,str1,0,0,mpString);
        }

    }

    public static  void main(String [] args){

       System.out.println(shortestCommonSupersequence("ababaabbbb","cbcbacaab"));

    }
}
