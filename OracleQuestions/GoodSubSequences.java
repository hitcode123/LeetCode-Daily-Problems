package OracleQuestions;

import static sun.nio.cs.Surrogate.MAX;

public class GoodSubSequences {

    int MOD = 1_000_000_007;
    int[] fact = new int[MAX];
    int[] invFact = new int[MAX];

    void preprocess(int max) {
        fact[0] = invFact[0] = 1;
        for (int i = 1; i < max; i++) {
            fact[i] = (int)((long)fact[i - 1] * i % MOD);
        }
        invFact[max - 1] = powMod(fact[max - 1], MOD - 2);
        for (int i = max - 2; i >= 1; i--) {
            invFact[i] = (int)((long)invFact[i + 1] * (i + 1) % MOD);
        }
    }

    // Modular exponentiation
    int powMod(int x, int y) {
        long res = 1;
        long base = x;
        while (y > 0) {
            if ((y & 1) != 0) res = (res * base) % MOD;
            base = (base * base) % MOD;
            y >>= 1;
        }
        return (int) res;
    }

    // O(1) nCr
    public static long nCr(int n, int r) {
        if (r > n) return 0;
        if (r == 0 || r == n) return 1;

        // Since C(n, r) = C(n, n-r)
        r = Math.min(r, n - r);

        long result = 1;
        for (int i = 1; i <= r; i++) {
            result *= (n - i + 1);
            result /= i; // divide at each step to avoid overflow
        }
        return result;
    }

    int findAns(String ans){
        int n=ans.length();
        int[] freqAlp= new int[26];
        int maxFreq=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            freqAlp[ans.charAt(i)-'a']++;
            maxFreq=Math.max(maxFreq,freqAlp[ans.charAt(i)-'a']);
        }
        int finalAns=0;
        for(int i=1;i<=maxFreq;i++){
            int tempCount=1;
            for(int j=0;j<26;j++){
                if(freqAlp[j]>=i){
                    tempCount*=(nCr(freqAlp[j],i)+1);
                }

            }
            finalAns+=tempCount-1;
        }
        System.out.println(finalAns);
        return  finalAns;

    }

    public static void main(String[] args){

        GoodSubSequences goodSubSequences=new GoodSubSequences();
        System.out.print("Following is the ans:"+goodSubSequences.findAns("aabbcc"));
    }
}
