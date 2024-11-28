class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr = new int[26];
        int[] window = new int[26];
        int m = s1.length();
        int n = s2.length();
        for(int i=0;i<m;i++){
            arr[s1.charAt(i) - 'a']++;
        }
        for(int i=0;i<n;i++){
            window[s2.charAt(i) - 'a']++;

            if(i >= m){
                window[s2.charAt(i - m) - 'a']--;
            }

            if(matches(arr, window)){
                return true;
            }
        }
        return false;
    }
    public boolean matches(int[] arr, int[] window){
        for(int i=0;i<26;i++){
            if(arr[i] != window[i]){
                return false;
            }
        }
        return true;
    }
}