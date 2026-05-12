package A2ZSheet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DivisorOfANumber {
    public static Set<Integer> tempList;
    public Set<Integer> countPrimeFactors(int n){
        tempList=new HashSet<>();
        while(n%2==0){
            n/=2;
            tempList.add(2);
        }

        for(int i=3;i*i<n;i+=2){
            while(n%i==0){
                n/=i;
                tempList.add(i);
            }
        }

        if(n>2){
            tempList.add(n);
        }
        return tempList;
    }
    public static void main(String[] args){
        DivisorOfANumber obj=new DivisorOfANumber();
       Set<Integer> tempList= obj.countPrimeFactors(4650);
        for(Integer i: tempList){
            System.out.println(i+ " ");
        }
        System.out.println();
    }
}
