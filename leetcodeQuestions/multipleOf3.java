package leetcodeQuestions;

class SolutionmultipleOf3 {
    public boolean checkPowersOfThree(int n) {

        while(n>=3){
            int count=3;
            while(count<=n){
                count*=3;
            }
            count/=3;
            n=n-count;
        }

        if(n==2){
            return false;
        }
        return true;

    }
}

public class multipleOf3 {
    public static void main(String[] args){
        SolutionmultipleOf3 solutionmultipleOf3=new SolutionmultipleOf3();
        System.out.println(solutionmultipleOf3.checkPowersOfThree(21));

    }
}
