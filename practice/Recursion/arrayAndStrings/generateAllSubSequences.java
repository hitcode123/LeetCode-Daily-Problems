package practice.Recursion.arrayAndStrings;

import java.util.ArrayList;
import java.util.List;


/*

Recurrence Relation
                    {
                      i==n add string
f([[]],s1,i,s3) --->  pick f(i+1,s+charAt(i);
                      not pick f(i+1,s)
                    }
 */
public class generateAllSubSequences {

    public void findAllSubSequences(List<String> countedStrings,String sample, int i,String tempString){
        if(i==sample.length()){
            if(!tempString.isEmpty()){
                countedStrings.add(tempString);
            }
            return ;
        }

        findAllSubSequences(countedStrings,sample,i+1,tempString+sample.charAt(i));
        findAllSubSequences(countedStrings,sample,i+1,tempString);
    }
    public static void main(String[] args){
        generateAllSubSequences allSubSequences=new generateAllSubSequences();
        List<String> ans=new ArrayList<>();
        allSubSequences.findAllSubSequences(ans,"Mohit",0,"");
        System.out.println("Hence the provided String  Subsequences is");
        System.out.print("[ ");
        for(String s:ans){
            System.out.print(s+", ");

        }
        System.out.print("]");
    }
}
