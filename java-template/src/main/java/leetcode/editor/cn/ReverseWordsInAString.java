package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ReverseWordsInAString {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            //解决思路就是先将字符串整体进行反转,然后再逐个单词进行反转
            StringBuilder sb = new StringBuilder();
            //先清洗一下数据,将源字符串中的前导空格,尾随空格,多余空格等清洗掉
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c != ' ') {
                    //单词中的字母
                    sb.append(c);
                }else if(!sb.isEmpty() && sb.charAt(sb.length() - 1) != ' ') {
                    //单词之间保留一个空格
                    sb.append(' ');
                }
            }

            if (sb.isEmpty()) {
                return "";
            }

            //如果末尾有空格,清除一下
            if (sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }

            //清洗之后的字符串
            char[] chars = sb.toString().toCharArray();
            int n = chars.length;
            //先整体反转
            reverse(chars,0,n-1);
            //再把每个单词进行翻转
            for (int i = 0; i < n;) {
                for (int j = i; j < n; j++) {
                    if (j+1 == n || chars[j+1] == ' ') {
                        //char[i,j]是一个单词,翻转他
                        reverse(chars,i,j);
                        //把i置为下一个单词的首字母
                        i = j + 2;
                        break;
                    }
                }
            }

            //最后得到了想要的结果
            return new String(chars);
        }

        public void reverse(char[] arr, int left, int right) {
            while (left <= right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAString().new Solution();
        // put your test code here
        
    }
}