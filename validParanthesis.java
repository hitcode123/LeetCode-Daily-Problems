import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void  generateParanthesisSolution(List<String> ans, Integer count, String ansString,  Integer cl, Integer cr ,Integer n) {

        if(count<0){
            return;
        }

        if(count==0&&ansString.length()==2*n){
            ans.add(ansString);
        }
        if(cl<n){
            generateParanthesisSolution(ans,count+1,ansString+'(',cl+1,cr,n);
        }
        if(cr<n) {
            generateParanthesisSolution(ans,count-1,ansString+')',cl,cr+1,n);
        }
    }
    public static List<String> generateParenthesis(int n) {

        List<String> ans= new ArrayList<>();
        generateParanthesisSolution(ans,0,"",0,0,n);
        return ans;


    }
    public static void main(String[] args){
        List<String> value=generateParenthesis(3);
        for(String s:value)
        {
            System.out.println(s);
        }
    }

}


