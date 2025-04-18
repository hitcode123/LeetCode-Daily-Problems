package leetCodeToughQuestions;


class SolutionForII {

    long calFac(int[] nums){
        int count=0;
        for(int i=0;i<26;i++){
            count+=nums[i];
        }
        long numeratorCount=factorial(count);
        long denominatorCount=1;
        for(int i=0;i<26;i++){
            if(nums[i]>1){
                denominatorCount*=factorial(nums[i]);
            }
        }
        return (numeratorCount/denominatorCount)>1000000?  1000000: (numeratorCount/denominatorCount) ;
    }

    public long factorial(int freq){
        long ans=1;
        while(freq>0){
            ans*=freq;
            freq-=1;
        }
        return ans;
    }
    public String smallestPalindrome(String s, int k) {

        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }

        int[] half=new int[26];
        String mid="";
        for(int i=0;i<26;i++){
            if(freq[i]%2==1){
                mid=mid+(char)(freq[i]+'a');
            }
            half[i]=freq[i]/2;
        }
        if(calFac(half)<k){
            return "";
        }
        StringBuilder halfR=new StringBuilder();
        for(int i=0;i<26;i++){

            while(half[i]>0){
                half[i]--;
                long fac=calFac(half);
                if(fac>=k){
                    halfR.append((char)(i+'a'));
                    i=0;
                }else{
                    k-=fac;
                    half[i]++;
                    break;
                }
            }
        }
        String secondHalf=new StringBuilder(halfR).reverse().toString();
        return halfR+mid+secondHalf;




    }
}
public class PalindromicSubStringII {

    public static  void main(String[] args){
        SolutionForII solution=new SolutionForII();
        solution.smallestPalindrome("ycnypoidimbrvasctjkkwwkkjtcsavrbmidiopyncy",32993);

    }
}
