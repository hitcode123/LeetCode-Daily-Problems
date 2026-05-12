package A2ZSheet;

public class L29_Div2Num {



    public int SolutionForProblem(int dividend,int div){
        int number=dividend;
        int ans=0;
        while(number>=div){
            int count=0;
            int dividing=div;
            while(dividing<number){
                count++;
                dividing=dividing<<1;
            }
            count--;
            dividing=dividing>>1;
            ans+=1<<count;
            number=number-dividing;
        }

        return ans;
    }
    public static void main(String[] args){
        L29_Div2Num obj=new L29_Div2Num();
        int ans=obj.SolutionForProblem(7,3);
        System.out.println("Hence the answer is "+ans);
    }
}
