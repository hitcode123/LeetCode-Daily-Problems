package OracleQuestions;

public class ModifyTheString {

    public String findAns(String str){
        int[] first = new int[26];
        int[] last = new int[26];

        // Fill first[] with -1 (means "not yet seen")
        for (int i = 0; i < 26; i++) {
            first[i] = -1;
        }

        // Traverse the string
        int countAlp=0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int index = ch - 'a'; // Map 'a' to 0, 'b' to 1, ..., 'z' to 25

            if (first[index] == -1) {
                first[index] = i;
                countAlp++;
            }
            last[index] = i;
        }
        int[] ans=new int[countAlp];
        for(int i=0;i<26;i++){
            int count_level=0;
            if(first[i]!=-1){
                for(int j=0;j<26;j++){
                    if(first[j]!=-1&&last[i]>first[j]&&i!=j){
                        count_level++;
                    }
                }
                ans[count_level]=i;
            }
        }
         StringBuilder ansForThis= new StringBuilder();
        for(int i=0;i<countAlp;i++){
            ansForThis.append((char)(ans[i] + 'a'));
        }
        return ansForThis.reverse().toString();

    }
    public static void main(String[] args) {
        ModifyTheString modifyTheString=new ModifyTheString();
        System.out.print("answer for the modify string is:" +" "+modifyTheString.findAns("aabcb"));
    }
    }
