package leetCodeToughQuestions;


class SolutionInterLeaving {

    public boolean findSolution(int i,int j,int k,String s1, String s2, String s3){


        if(i==s1.length()&&j==s2.length()&&k==s3.length()){
            return true;
        }
        boolean val1=false;
        boolean val2=false;
        boolean val3=false;
        boolean val4=false;

        if(i<s1.length()&&j<s2.length()&&s1.charAt(i)==s3.charAt(k)&&s2.charAt(j)==s3.charAt(k)){
            val3=findSolution(i,j+1,k+1,s1,s2,s3);
            val4=findSolution(i+1,j,k+1,s1,s2,s3);
        }else if(i<s1.length()&&s1.charAt(i)==s3.charAt(k)){
            val2=findSolution(i+1,j,k+1,s1,s2,s3);
        }else if(j<s2.length()&&s2.charAt(j)==s3.charAt(k)){
            val1=findSolution(i,j+1,k+1,s1,s2,s3);

        }
        return val1||val2||val3||val4;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
       return  findSolution(0,0,0,s1,s2,s3);


    }
}
public class InterLeavingStrings {

    public static void main(String [] args){
        SolutionInterLeaving solutionInterLeavin=new SolutionInterLeaving();
//       System.out.println(solutionInterLeavin.isInterleave("aabcc","dbbca","aadbbcbcac"));
       System.out.println(solutionInterLeavin.isInterleave("aabcc","dbbca","aadbbbaccc"));

    }
}



