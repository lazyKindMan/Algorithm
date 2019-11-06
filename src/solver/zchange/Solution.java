package solver.zchange;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author long
 * 思路：找规律呗
 * 设层数为numRows,当前层数为r
 * 第一行和最后一行下标步长为 2*numRows - 2，中间的步长为 2*numRows - 2 - 2*(r-1),和2*(r-1)
 */
public class Solution {
    public String convert(String s, int numRows) {
        if(s.length() <= numRows)
            return s;
        if(numRows <= 1)
            return s;
        StringBuilder builder = new StringBuilder(s.length());
        for(int r =1 ;r <= numRows;r++)
        {
            int index = r-1;
            int stepLength = 2*numRows - 2 - 2*(r-1);
            if(r == numRows)
            {
                stepLength = 2*numRows - 2;
            }
            while (index < s.length())
            {
                builder.append(s.charAt(index));
                index += stepLength;
                stepLength = 2*numRows - 2 - stepLength;
                //这里很机智的避免了尴尬的多次无用重复
                if(stepLength == 0)
                {
                    stepLength = 2*numRows - 2;
                }
            }
        }
        return builder.toString();
    }
}
