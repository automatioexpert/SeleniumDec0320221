/*Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
*/

class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if(len == k) return "0";
        List<Character> li  = new LinkedList<Character>();
        StringBuilder sb = new StringBuilder();
        
        int count = 0;
        while (count < len){
            while(k > 0 && !(li.size() == 0) && li.get(li.size() - 1) > num.charAt(count)){
                li.remove(li.size() - 1);
                k--;
            }
            
            li.add(num.charAt(count));
            count++;
        }
        
        while(k > 0){
            li.remove(li.size() - 1);
            k--;
        }
        for(char c: li){
            sb.append(c);
        }
        
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        
        
        return sb.toString();
    }
       
}
