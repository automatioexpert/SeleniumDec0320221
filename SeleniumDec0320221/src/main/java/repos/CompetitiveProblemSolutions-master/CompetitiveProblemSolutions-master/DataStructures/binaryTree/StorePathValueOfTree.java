/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root == null) return 0;
        if (root.left == null & root.right == null) return 1;
        List<List<Integer>> res = new ArrayList();
        rootToLeafPaths(root, res, "");
        System.out.println(res);
        int max = 0;
        for (List<Integer> path: res){
            if(isPallindrome(path))
                max++;
        }
        
        return max;
        
    }
    
    //To store all value of tree path in list
    private void rootToLeafPaths(TreeNode root, List<List<Integer>> res, String curr) {
        if (root.left == null && root.right == null) {
            String[] vals = curr.split(",");
            List<Integer> temp = new ArrayList<>();
            for (String val : vals) temp.add(Integer.parseInt(val));
            temp.add(root.val);
            res.add(new ArrayList<>(temp));
        }
        if (root.left != null) rootToLeafPaths(root.left, res, curr + root.val + ",");
        if (root.right != null) rootToLeafPaths(root.right, res, curr + root.val + ",");
    }
    
    //To check whether given path can make pallindrome or not
    private boolean isPallindrome(List<Integer> path){
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < path.size(); i++){
            map.put(path.get(i), map.getOrDefault(path.get(i), 0) + 1);
        }
        Set<Integer> set = map.keySet();
        Iterator<Integer> it = set.iterator();
        Boolean isEven = false;
        while (it.hasNext()){
            int no = map.get(it.next());
            if(no%2 == 1 && !isEven){
                isEven = true;
            } else if (no % 2 == 1 && isEven){
                return false;
            }
        }
        return true;
    }
}
