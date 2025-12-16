package practice.Recursion.foundational;


/*
Recurrence Relation
f(n) where f(n) gives the reverse string for n string
         {
f(s,n) ---> n== length  ""
           n>=0   f(s,n+1)+s.charAt(n);
         }

 */
public class ReverseString {

    String reverseString(String s,int n){
        if(n==s.length()){
            return "";
        }
        return reverseString(s,n+1)+s.charAt(n);
    }
    public static void main(String[] args){
        ReverseString reverseString=new ReverseString();
        String result=reverseString.reverseString("mohit",0);
        System.out.println("hence the result for the given input is "+result);

    }
}
