/*
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

 

Example 1:

Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: [3,3,7,7,10,11,11]
Output: 10
*/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        if (end < 1) return nums[0];
        else if (nums[start] != nums[start + 1]) return nums[start];
        else if (nums[end] != nums[end - 1]) return nums[end];
        
        while(start<= end){
            int mid = start + (end - start) / 2;
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]){
                return nums[mid];
            } else if (((mid % 2) == 0 && nums[mid] == nums[mid + 1]) 
                       || ( (mid % 2) == 1 && nums[mid] == nums[mid - 1])){
                start = mid + 1;
            } else
                end = mid - 1;
        }
        return -1;
    }
}
