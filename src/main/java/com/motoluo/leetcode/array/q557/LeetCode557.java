package com.motoluo.leetcode.array.q557;

public class LeetCode557 {

    /**
     * 557. 反转字符串中的单词 III
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     * <p>
     * 输入："Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     * <p>
     * 提示：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-insert-position
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(force(s));
        System.out.println(reverseWords(s));
    }

    /**
     * 暴力法
     *
     * @param s
     * @return
     */
    public static String force(String s) {
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = swap(arr[i]);
        }
        return String.join(" ", arr);
    }

    public static String swap(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left <= right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
        return String.valueOf(chars);
    }

    /**
     * 遍历过程不做类型转换，提搞效率
     *
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        // 最后增加空格，便于遍历
        s = s.concat(" ");
        char[] as = s.toCharArray();
        int l = 0;
        int r = 0;
        while (l < as.length) {
            while (as[l] != ' ') {
                l++;
            }
            res(as, r, l - 1);
            r = l + 1;
            l = r;
        }
        String rx = new String(as);
        return rx.substring(0, as.length - 1);
    }

    public static void res(char[] a, int m, int n) {
        while (m < n) {
            char t = a[m];
            a[m] = a[n];
            a[n] = t;
            m++;
            n--;
        }
    }

}
