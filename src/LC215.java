// quick sort
// th Largest Element in an Array

/*/Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
        For example,
        Given [3,2,1,5,6,4] and k = 2, return 5.
*/
public class LC215 {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return helper(0, nums.length - 1, nums, k);
        }

        int helper(int left, int right, int[] nums, int k) {
            int val = nums[left];
            int l = left;
            int r = right;
            for(int i = left + 1; l < r; i++) {
                if(nums[i] > val) {
                    nums[l] = nums[i];
                    l++;
                }
                else {
                    int t = nums[r];
                    nums[r] = nums[i];
                    nums[i] = t;
                    i--;
                    r--;
                }
            }
            nums[l] = val;
            if(l - left + 1 == k) {
                return val;
            }
            if(l - left + 1 < k) {
                return helper(l + 1, right, nums, k - (l - left + 1));
            }
            else {
                return helper(left, l - 1, nums, k);
            }

        }
    }
}
