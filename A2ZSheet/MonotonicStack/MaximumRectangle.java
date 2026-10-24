package A2ZSheet.MonotonicStack;

import java.util.Stack;

public class MaximumRectangle {

    // Next Smaller in Row (Right Boundary)
    int[] returnHorRectangleLine(char[][] mat, int i){
        int n = mat[i].length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for(int j = n - 1; j >= 0; j--){
            int current = mat[i][j] - '0';

            while(!st.isEmpty() && (mat[i][st.peek()] - '0') >= current){
                st.pop();
            }

            ans[j] = (st.isEmpty()) ? n : st.peek();
            st.push(j);
        }
        return ans;
    }

    // Next Smaller in Column (Down)
    int[] returnVerNext(char[][] mat, int col){
        int m = mat.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[m];

        for(int i = m - 1; i >= 0; i--){
            int current = mat[i][col] - '0';

            while(!st.isEmpty() && (mat[st.peek()][col] - '0') >= current){
                st.pop();
            }

            ans[i] = (st.isEmpty()) ? m : st.peek();
            st.push(i);
        }
        return ans;
    }

    // Previous Smaller in Column (Up)
    int[] returnVerPrev(char[][] mat, int col){
        int m = mat.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[m];

        for(int i = 0; i < m; i++){
            int current = mat[i][col] - '0';

            while(!st.isEmpty() && (mat[st.peek()][col] - '0') >= current){
                st.pop();
            }

            ans[i] = (st.isEmpty()) ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    public int maximalRectangle(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] hor = new int[m][n];
        int[][] verNext = new int[m][n];
        int[][] verPrev = new int[m][n];

        // Horizontal NSE
        for(int i = 0; i < m; i++){
            int[] right = returnHorRectangleLine(matrix, i);
            for(int j = 0; j < n; j++){
                hor[i][j] = right[j];
            }
        }

        // Vertical NSE + PSE
        for(int col = 0; col < n; col++){
            int[] next = returnVerNext(matrix, col);
            int[] prev = returnVerPrev(matrix, col);

            for(int row = 0; row < m; row++){
                verNext[row][col] = next[row];
                verPrev[row][col] = prev[row];
            }
        }

        int maxi = 0;

        // Main logic (your idea)
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(matrix[i][j] == '1'){

                    int k = hor[i][j]; // right boundary
                    int minHeight = Integer.MAX_VALUE;

                    for(int x = j; x < k; x++){
                        int height = verNext[i][x] - verPrev[i][x] - 1;
                        minHeight = Math.min(minHeight, height);
                    }

                    int width = k - j;
                    int area = width * minHeight;
                    maxi = Math.max(maxi, area);
                }
            }
        }

        return maxi;
    }
    public static void main(String[] args){
            char[][] arr = {
                    {'1','0','1','0','0'},
                    {'1','0','1','1','1'},
                    {'1','1','1','1','1'},
                    {'1','0','0','1','0'}
            };
            MaximumRectangle maximumRectangle=new MaximumRectangle();
            System.out.println(maximumRectangle.maximalRectangle(arr));

        }



}
