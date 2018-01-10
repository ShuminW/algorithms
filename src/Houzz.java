// 0，1，1，0，给出一个range，1是工厂，0是空地，问最小工厂数可以cover所有的index。
public class Houzz {
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

    /*public static void main(String[] args) {
        int[] fac = {1, 1, 0, 1, 1, 0, 1};
        int[] ans = getFactory(fac, 2);
        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }*/
}
