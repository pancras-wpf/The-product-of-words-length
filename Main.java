package 单词长度的最大乘积;
/*
* 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，
* 它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
*/
/*成功，但是用时和内存都不好
* */
public class Main {
    public static void main(String[] args) {
        String[]  words = new String[] {"abcw","baz","foo","bar","xtfn","abcdef"};
        Solution solution = new Solution();
        int a = solution.maxProduct(words);
        System.out.println(a);
    }
}

class Solution {
    public int maxProduct(String[] words) {
        int product = 0;
        boolean flag = true;
        for (int i = 0; i < words.length; i++) {
            char[] chars1 = words[i].toCharArray();
            for (int j = i + 1; j < words.length; j++) {

                for (int k = 0; k < chars1.length; k++) {
                    // 所有字符都要判断 不重复才输出
                    if (words[j].contains(""+chars1[k])){
                        flag = false;
                        break;
                    }
                }

                if (flag){
                    int a = chars1.length * words[j].length();
                    product = product > a ? product:a;
                }else flag = true;

            }
        }
        return product;
    }
}
