package leetcode.editor.cn;

import java.util.*;

import com.sun.jdi.Value;
import leetcode.editor.common.*;

public class SingleNumber {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            HashMap<String, List<Integer>> map = new HashMap<>();
            for (Integer num : nums) {
                String key = String.valueOf(num);
                //首先判断该key对应的value是否为空，若为空则新建一个ArrayList
                if (map.get(key) == null) {
                    map.put(key,new ArrayList<>());
                }
                List<Integer> list = map.get(key);
                list.add(num);
            }

            //便利Map，查看哪个key对应的List的size为1，然后调用Integer的parse将key解析回来
            Set<Map.Entry<String, List<Integer>>> entries = map.entrySet();
            Iterator<Map.Entry<String, List<Integer>>> iterator = entries.iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, List<Integer>> entry = iterator.next();
                String key = entry.getKey();
                List<Integer> value = entry.getValue();
                if (value.size() == 1) {
                    return Integer.parseInt(key);
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
        // put your test code here
        
    }
}