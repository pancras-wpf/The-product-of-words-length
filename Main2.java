package 单词长度的最大乘积;

public class Main2 {
    public static void main(String[] args) {
        String[]  words = new String[] {"abcw","baz","foo","bar","xtfn","abcdef"};
        Solution1 solution1 = new Solution1();
        int a = solution1.maxProduct(words);
        System.out.println(a);
    }
}
class Solution1 {

    public int maxProduct(String[] words) {
        int len = words.length;
        int [] nums = new int [len];
        // 用一个 int 数字统计每个字符串里面 abcd26  个字符出现的位置 a 用 0代替 b 用 1
        // 则 abc 可以表示为 111 def 可以表示为 111000 如果不包含重复字符的字符串转换二进制后做与运算肯定为 0
        for(int i=0;i<len;i++){
            for(int j=0;j<words[i].length();j++){
                // |= 判断两个值是否相等，不相等返回真
                // << 按位左移
                nums[i]|=(1 << (words[i].charAt(j)-'a'));
            }
        }
        int res = 0;
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                // 如果两个字符串不包含相同元素 那么与运算肯定为 0
                if((nums[i] & nums[j]) == 0){
                    res = Math.max(res,words[i].length()*words[j].length());
                }
            }
        }
        return res;

    }
}