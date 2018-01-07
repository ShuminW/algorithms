// segment tree
public class LC307 {

    class NumArray {

        class SegmentTreeNode {
            int sum;
            int start;
            int end;
            SegmentTreeNode left;
            SegmentTreeNode right;

            public SegmentTreeNode(int[] nums, int i, int j) {
                this.sum = 0;
                this.start = i;
                this.end = j;
                left = null;
                right = null;

                if (i > j) return;

                if (i == j) {
                    this.sum = nums[i];
                    return;
                }

                int mid = i + (j - i) / 2;
                left = new SegmentTreeNode(nums, i, mid);
                right = new SegmentTreeNode(nums, mid + 1, j);

                sum = left.sum + right.sum;
            }

            public void update(int i, int val) {
                if (i < start || i > end) {
                    return;
                }
                if (start == end && i == start) {
                    this.sum = val;
                    return;
                }
                int mid = start + (end - start) / 2;
                if (i <= mid) {
                    this.left.update(i, val);
                } else {
                    this.right.update(i, val);
                }
                this.sum = left.sum + right.sum;
            }

            public int range(int i, int j) {
                if (i == start && end == j) {
                    return sum;
                }
                if (!(i >= start && j <= end)) {
                    return 0;
                }
                int mid = start + (end - start) / 2;
                if (i > mid) {
                    return this.right.range(i, j);
                } else if (j <= mid) {
                    return this.left.range(i, j);
                } else {
                    return this.left.range(i, mid) + this.right.range(mid + 1, j);
                }
            }
        }

        SegmentTreeNode buildTree(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            return new SegmentTreeNode(nums, 0, nums.length - 1);
        }

        SegmentTreeNode root;

        public NumArray(int[] nums) {
            root = buildTree(nums);
        }

        public void update(int i, int val) {
            root.update(i, val);
        }

        public int sumRange(int i, int j) {
            return root.range(i, j);
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
}
