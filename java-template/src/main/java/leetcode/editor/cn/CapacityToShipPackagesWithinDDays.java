package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class CapacityToShipPackagesWithinDDays {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            //首先确定x,f(x),target
            //x是最低运载能力，左边界是weights数组中的最大值,右边界是weights数组的和（因为超过这个值,1天之内肯定能运完，装载能力再多也没有意义）
            //函数定义：若装载能力为x，则需要f(x)天将所有包裹送达，f(x)是单调递减函数
            //target就是days(需要在days天之内送完)
            int left = Arrays.stream(weights).max().getAsInt();
            int right = Arrays.stream(weights).sum();

            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(f(weights,mid) > days) {
                    //说明最小装载能力不够，导致不能在days天只能送达所有货物，需要增加左边界（提升最小装载能力）
                    left = mid + 1;
                } else if (f(weights,mid) < days) {
                    //说明最小装载能力足够，能在days天只能送达所有货物，尝试缩减右边界（尝试降低最小装载能力）
                    right = mid - 1;
                } else if (f(weights,mid) == days) {
                    //说明最小装载能力足够，能在days天只能送达所有货物，尝试缩减右边界（尝试降低最小装载能力）
                    right = mid - 1;
                }
            }

            return left;


        }

        /**
         * 定义：当运载能力为 x 时，需要 f(x) 天运完所有货物
         * f(x) 随着 x 的增加单调递减
         * @param weights
         * @param x
         * @return
         */
        private long f(int[] weights, int x) {
            long days = 0;
            for (int i = 0; i < weights.length;) {
                //尽可能地多装货物
                int cap = x;
                while (i < weights.length) {
                    if(cap < weights[i]) break;
                    else cap -= weights[i];
                    i++;
                }
                days++;
            }

            return days;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new CapacityToShipPackagesWithinDDays().new Solution();
        // put your test code here
        
    }
}