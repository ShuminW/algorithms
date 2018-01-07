public class LC553 {

    class Solution {
        public String optimalDivision(int[] nums) {
            if (nums.length == 0) return "";
            if (nums.length == 1) return String.valueOf(nums[0]);
            StringBuilder sb = new StringBuilder();
            sb.append(nums[0]);
            if (nums.length == 2) {
                sb.append("/" + nums[1]);
            } else {
                sb.append("/(");
                sb.append(nums[1]);
                for (int i = 2; i < nums.length; ++i) {
                    sb.append("/" + nums[i]);
                }
                sb.append(")");
            }
            return sb.toString();
        }
    }

}
