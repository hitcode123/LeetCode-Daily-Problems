package leetcodeQuestions;

import java.util.*;

class SolutionForPrime {


    long NumberCalculate(String s){

        long prime=0;
        for(int i=0;i<s.length();i++){
            prime=prime*10+(s.charAt(i)-'0');
        }
        return prime;

    }

    boolean isPrime(long can){

        if(can==1) {
            return false;
        }
        if(can==2){
            return true;
        }
        for(int i=2;i*i<can;i++){
            if(can%i==0){
                return false;
            }
        }

        return true;
    }
    public long sumOfLargestPrimes(String s) {

        List<Long> setMap=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                long primeCandidate=NumberCalculate(s.substring(i,j));

                if(isPrime(primeCandidate)&&!setMap.contains(primeCandidate)){
                    setMap.add(primeCandidate);
                }


            }
        }

        long ans=0;
        long count=0;
        Collections.sort(setMap, Collections.reverseOrder());
        for(Long value:setMap){
            if(count<3){
                ans+=value;
                count++;
            }else{
                break;
            }
        }


        return ans;

    }

    public static void main(String[] args){

        SolutionForPrime solutionForPrime=new SolutionForPrime();
        System.out.println(solutionForPrime.sumOfLargestPrimes("837"));
    }
}