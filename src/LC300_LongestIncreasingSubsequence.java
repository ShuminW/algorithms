public class LC300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        // N^2
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < nums.length; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    // NlogN
    public int biSearch(int[] n, int size, int upper) {
        int left = 0, right = size + 1;
        while (left != right) {
            int mid = left + (right - left) / 2;
            if (n[mid] < upper) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left - 1;
    }

    public int lengthOfLIS_plus(int[] nums) {
        if (nums.length == 0) return 0;
        int[] tails = new int[nums.length + 1];
        tails[1] = nums[0];
        int size = 1;
        for (int i = 1; i < nums.length; ++i) {
            int l = biSearch(tails, size, nums[i]);
            if (size == l) {
                tails[l + 1] = nums[i];
                size += 1;
            }
            else if (tails[l + 1] > nums[i]) tails[l + 1] = nums[i];
        }
        int ans = 0;
        return size;
    }
}
