import java.util.ArrayList;
import java.util.List;

// If values range from 1 to n (n is the size of array), we can use index!
public class LC442 {
    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> ans = new ArrayList<>();
            if (nums == null) return ans;
            int round = 1;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[Math.abs(nums[i]) - 1] < 0) {
                    ans.add(Math.abs(nums[i]));
                }
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
            return ans;
        }
    }
}
