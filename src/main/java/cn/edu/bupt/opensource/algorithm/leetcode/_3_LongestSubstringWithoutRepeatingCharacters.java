package cn.edu.bupt.opensource.algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: _3_LongestSubstringWithoutRepeatingCharacters</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-08-17 11:09</p>
 * @author ChengTengfei
 * @version 1.0
 *
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * 示例：
 *      给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 *      给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 *      给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 * 优化的滑动窗口：
 *      我们可以定义字符到索引的映射，而不是使用集合来判断一个字符是否存在。
 *      当我们找到重复的字符时，我们可以立即跳过该窗口。
 *      也就是说，如果 s[j]s[j] 在 [i, j)[i,j) 范围内有与j'j′重复的字符，我们不需要逐渐增加ii 。
 *      我们可以直接跳过 [i，j′] 范围内的所有元素，并将 ii 变为 j' + 1j​′+1。
 * time:O(n)
 * space:O(n)
 */
public class _3_LongestSubstringWithoutRepeatingCharacters {

    private int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int len = s.length();
        // 滑动窗口策略：j为窗口左侧索引，i为窗口右侧索引
        for(int i = 0, j = 0; i < len; i++) {
            char c = s.charAt(i);
            // 若已存在重复字符，更新j至重复字符之后的索引
            if(map.containsKey(c)) {
                j = Math.max(j, map.get(c) + 1);
            }
            map.put(c, i);
            res = Math.max(res, i-j+1);
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

}
