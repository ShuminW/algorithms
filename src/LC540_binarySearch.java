// Binary search ( [start, end) )
public class LC540_binarySearch {
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            int start = 0, end = nums.length;

            while (start < end - 1) {
                int mid = start + (end - start) / 2;

                if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                    return nums[mid];
                }

                if ((mid - start) % 2 == 0) {
                    if (nums[mid] == nums[mid - 1]) {
                        end = mid - 1;
                    } else {
                        start = mid + 2;
                    }
                } else {
                    if (nums[mid] == nums[mid - 1]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
            return nums[start];
        }
    }
}
