import java.util.HashSet;

public class Houzz {

    // 0，1，1，0，给出一个range，1是工厂，0是空地，问最小工厂数可以cover所有的index。
    static int[] getFactory(int[] factory, int k) {
        int pos = 0;
        int[] ans = new int[factory.length];
        while(pos < factory.length) {
            pos = Math.min(pos + k, factory.length - 1);
            while(factory[pos] != 1) {
                pos--;
            }
            ans[pos] = 1;
            pos = pos + k + 1;
        }
        return ans;
    }
    //1. Given a n*m size 2D array with integers from 1 to n*m - 1 in it. Integers are not sorted.
    // The last position of the matrix stays a movable block. For each time, you can swap the movable block with any adjacent number.
    // And eventually you will have the integers sorted and the movable block returned to its starting position.
    // Think about an approach to print the path. (You can assume it always have at least a solution)
    static String getPath(int[][] blocks, HashSet<String> visited, String current, String target, int position, String path) {
        int m = blocks.length;
        if(m == 0) {
            return "";
        }
        int n = blocks[0].length;
        if(current.equals(target)) {
            return path;
        }
        visited.add(current);
        String[] pos = current.split("\\s");
        int posx = position / n;
        int posy = position % n;
        int x[] = {0, 0, 1, -1};
        int y[] = {1, -1, 0, 0};
        for(int i = 0; i < 4; i++) {
            int newx = posx + x[i];
            int newy = posy + y[i];
            if(newx >= 0 && newx < m && newy >= 0 && newy < n) {
                int changepos = newx * n + newy;
                swap(pos, position, changepos);
                StringBuffer sb = new StringBuffer();
                for(int j = 0; j < pos.length; j++) {
                    sb.append(pos[j] + " ");
                }
                String newcurrent = sb.toString();
                if(!visited.contains(newcurrent)) {
                    String ans = getPath(blocks, visited, newcurrent, target, changepos, path + " " + i);
                    if(!ans.equals("")) {
                        return ans;
                    }
                }
                swap(pos, position, changepos);

            }
        }

        return "";
    }

    static void swap(String[] pos, int x, int y) {
        String t = pos[x];
        pos[x] = pos[y];
        pos[y] = t;
    }


    public static void main(String[] args) {
        /*int[] fac = {1, 1, 0, 1, 1, 0, 1};
        int[] ans = getFactory(fac, 2);
        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }*/

        int[][] input= {{5, 8, 4, 2}, {11, 3, 7, 15}, {14, 10, 1, 6}, {9, 13, 12, 0}};
        HashSet<String> set = new HashSet<>();
        StringBuffer sb = new StringBuffer();
        StringBuffer currentsb = new StringBuffer();
        for(int i = 0; i < input.length; i++) {
            for(int j = 0; j < input[i].length; j++) {
                currentsb.append(input[i][j] + " ");
            }
        }
        for(int i = 1; i <= 15; i++) {
            sb.append(i + " ");
        }
        sb.append("0 ");
        System.out.println(getPath(input, set, currentsb.toString(),  sb.toString(), 15, ""));
    }
}
