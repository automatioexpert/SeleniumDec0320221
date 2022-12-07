/*Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

 

Example 1:



Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 

Note:

0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9

*/


class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int a = A.length;
        int b = B.length;
        int aptr = 0, bptr =0;
        List<int[]> li = new ArrayList();
        
        while (aptr < a && bptr < b){
            if (A[aptr][0] <= B[bptr][1] && B[bptr][0] <= A[aptr][1]){
                li.add(new int[]{(Math.max(A[aptr][0], B[bptr][0])), (Math.min(A[aptr][1], B[bptr][1]))});
            }
            if(A[aptr][1] > B[bptr][1]){
                bptr++;
            } else
                aptr++;
        }
        
        return li.toArray(new int[li.size()][2]);
    }
}
