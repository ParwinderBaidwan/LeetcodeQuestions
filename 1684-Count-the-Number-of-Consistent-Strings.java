class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<allowed.length(); i++){
            set.add(allowed.charAt(i));
        }

        int count = 0;
        for(String s : words){
            for(int i=0; i<s.length(); i++){
                if(!set.contains(s.charAt(i))){
                    break;
                }
                else if(i == s.length() - 1){
                    count++;
                }
            }
        }

        return count;
    }
}