package practice.Recursion.foundational;


/*  Recurrence Relation

f(n){ 0 || 1 give 1
      >1 f(n)=n*f(n-1) or n*(n-1)!
    }
 *
 *
 *
 */

public class Factorial {


    public int calFactorial(int n){
        if(n==0||n==1){
            return 1;
        }
        return n*calFactorial(n-1);
    }
    public static void main(String[] args){

        Factorial factorial=new Factorial();
        System.out.println("So the answer for the factorial will be : " + factorial.calFactorial(7));

    }
}
