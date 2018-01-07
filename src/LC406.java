import java.util.Arrays;
import java.util.LinkedList;

// Analysis & Hypothesis
public class LC406 {
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            LinkedList<int[]> list = new LinkedList<>();
            Arrays.sort(people, (a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return -(a[0] - b[0]);
            });
            for (int[] p : people) {
                list.add(p[1], new int[] { p[0], p[1] });
            }
            return list.toArray(new int[0][0]);
        }
    }
}
