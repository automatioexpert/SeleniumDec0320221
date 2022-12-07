class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1 > l2) return false;
        
        int[] s1hash = new int[26];
        int[] s2hash = new int[26];
        
        for(int i=0 ; i< l1; i++){
            s1hash[s1.charAt(i)- 'a']++;
            s2hash[s2.charAt(i)- 'a']++;
        }
        if(Arrays.equals(s1hash, s2hash))
            return true;
        
        int front=0,back=l1;
        while(back<l2){
            s2hash[s2.charAt(front)-'a']--;
            s2hash[s2.charAt(back)-'a']++;
            if(Arrays.equals(s1hash,s2hash)){
                return true;
            }
            front++;
            back++;
        }
        return false;
    }
}
  
