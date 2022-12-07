/*Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

 

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
Example 2:

Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.
*/

//In same solution we can keep count of maximum of matrix to return maximal 1 square

class Solution {
    public int countSquares(int[][] matrix) {
        int ans = matrix[0][0];
        int row = matrix.length;
        int col = matrix[0].length;
        
        for (int i = 1; i < row; i++){
            ans += matrix[i][0];
        }          
        
        for (int j = 1; j < col; j++){
            ans += matrix[0][j];
        }
        
        for (int i = 1; i < row ; i++){
            for (int j = 1; j < col; j++){
                if (matrix[i][j] > 0){
                    matrix[i][j] = Math.min(Math.min(matrix[i-1][j-1], matrix[i - 1][j]), matrix[i][j - 1]) + 1;
                    ans += matrix[i][j];
                }
            }
        }
 
        return ans;
    }
}
