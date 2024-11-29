class Solution {
    public String minWindow(String s, String t) {
        int[] res = {-1, -1};

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        int resLen = Integer.MAX_VALUE;

        int have = 0, need = 0;
        int l = 0;

        for(char c: t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
        need = countT.size();
        for(int r = 0; r < s.length(); r++){
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0)+1);

            if(countT.containsKey(c) && window.get(c).equals(countT.get(c))){
                have++;
            }

            while(have == need){
                if((r - l + 1) < resLen){
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r; 
                }
                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar)-1);
                if(countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)){
                    have--;
                }
                l++;
            }

        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);

    }
}