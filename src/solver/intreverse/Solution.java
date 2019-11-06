package solver.intreverse;

/**
 * @author long
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int reverse(int x) {
        if(x == 0 || x /10 == 0) {
            return x;
        }
        int divide = 10;

        int val = x;
        int index = 0;
        long sum = 0;

        while (val != 0)
        {
            int posNum = val%divide;
            sum = sum*10+posNum;
            if(sum < Integer.MIN_VALUE) {
                   return 0;
               }
            else if(sum > Integer.MAX_VALUE) {
                return 0;
            }
            val = val/10;
        }
        return (int) sum;
    }
}
