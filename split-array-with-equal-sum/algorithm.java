class Solution {
    public boolean splitArray(int[] nums) {
        if(nums.length < 7) return false;
        int[] sum = new int[nums.length];
        int t = 0;
        for(int i = 0; i < nums.length; i++) {
            t += nums[i];
            sum[i] = t;
        }
        
        // separate the array into two parts (left and right)
        for(int i = 3; i < nums.length-3; i++) {
            Set<Integer> set = new HashSet<>();
            // if left part has two parts equal, put them into hash set.
            for(int j = 1; j < i-1; j++) {
                if(sum[j-1] == sum[i-1]-sum[j]) {
                    set.add(sum[j-1]);
                }
            }
            // if right part has two parts equal, check if there are similar sum in hash set, if so, return true
            for(int k = i+2; k < nums.length-1; k++) {
                if(sum[k-1]-sum[i] == sum[nums.length-1]-sum[k] && set.contains(sum[k-1]-sum[i])) return true;
            }
        }
        
        return false;
    }
}
