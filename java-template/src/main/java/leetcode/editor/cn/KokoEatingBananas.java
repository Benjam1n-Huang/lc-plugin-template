package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class KokoEatingBananas {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            //珂珂每小时最多只能吃一堆香蕉，如果吃不完的话留到下一小时再吃
            //如果吃完了这一堆还有胃口，也只会等到下一小时才会吃下一堆。
            //想在警卫回来之前吃掉所有的香蕉，确定吃香蕉的最小速度

            //确定x,f(x),target分别是什么
            //x是自变量，也就是吃香蕉的速度
            //显然，吃香蕉的速度越快，所花费的时间越少，所以速度和时间是一个单调递减的关系。所以函数关系f(x)可以定义为：若吃香蕉的速度为 x 根/小时，则需要 f(x) 小时吃完所有香蕉。
            //吃香蕉的时间限制h就是target，也就是说target是f(x)返回值的最大约束

            //定义自变量x的左右边界. 左边界就是0，右边界就是piles 数组中元素的最大值（因为最多一个小时吃一堆香蕉，胃口再大也没用）
            int left = 1;
            int right = Arrays.stream(piles).max().getAsInt();

            while(left <= right ) {
                int mid = left + (right - left) / 2;
                if(f(piles,mid) < h) {
                    //消耗的时间小于等于h，说明吃香蕉的速度能够在警卫回来之前将所有香蕉吃完,尝试降低速度(缩小右边界)
                    right = mid - 1;
                } else if (f(piles,mid) > h) {
                    //消耗的时间大于h,说明吃香蕉的速度太慢了，不能在警卫回来之前吃完，尝试增加速度（扩大左边界）
                    left = mid + 1;
                } else if (f(piles,mid) == h) {
                    //说明吃香蕉的速度正好，但是本题目的是探索左边界，因此尝试降低速度
                    right = mid - 1;
                }
            }

            return left;
        }

        //函数定义为：若吃香蕉的速度为 x 根/小时，则需要 f(x) 小时吃完所有香蕉。
        //因为吃香蕉的速度越快，消耗的时间越少，所以f(x)是一个单调递减函数
        private long f(int[] piles, int x) {
            long hours = 0;
            for (int i = 0; i < piles.length; i++) {
                hours += piles[i] / x;
                if(piles[i] % x > 0) {
                    hours++;
                }
            }

            return hours;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new KokoEatingBananas().new Solution();
        // put your test code here
        
    }
}