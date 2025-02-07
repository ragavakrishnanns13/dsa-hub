class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 10000000000;
        // for(int pile : piles){
        //     right = Math.max(right, pile);
        // }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private int f(int[] piles, int speed) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += piles[i] / speed;
            if (piles[i] % speed > 0) hours++;
        }
        return hours;
    }
}