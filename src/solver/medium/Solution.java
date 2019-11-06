package solver.medium;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author long
 * 思路:
 * 这里用到了二分查找的思路，但是查的不是值，而是位置
 * 这里思考在普通情况下为啥不直接找第K个位置而是去找第k/2的val，因为两个数组很有可能存在没有0+k下标的值，在第一次进入函数的时候
 * 所以去判断k/2一定会有一个数组是存在这样的0+k/2下标
 * 然后判断了k/2一定不会再某一个数组的前k/2之中，继续递归查找
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mediumPos1 = (nums1.length+nums2.length+1)/2;
        int mediumPos2 = (nums1.length+nums2.length+2)/2;
        return ((double) findKNum(nums1,0,nums2,0,mediumPos1)+ (double) findKNum(nums1,0,nums2,0,mediumPos2))/2.0;
    }
    int findKNum(int[] nums1,int start1,int[] nums2,int start2,int k)
    {
        //如果nums1数组已经找完了，说明需要找的中位数不在nums1中，直接到nums2找即可，同理nums2也是一样
        if(start1 >= nums1.length) return nums2[start2+k-1];
        if(start2 >= nums2.length) return nums1[start1+k-1];

        if(k == 1)
        {
            return nums1[start1]>nums2[start2]?nums2[start2]:nums1[start1];
        }

        //二分法查找中位数位置
        int medianVal1 = (start1 + k/2 -1 <nums1.length)?nums1[start1+k/2-1]:Integer.MAX_VALUE;
        int medianVal2 = (start2 + k/2 -1 <nums2.length)?nums2[start2+k/2-1]:Integer.MAX_VALUE;

        if(medianVal1 < medianVal2)
        {
            return findKNum(nums1,start1+k/2,nums2,start2,k-k/2);
        }
        else {
            return findKNum(nums1,start1,nums2,start2+k/2,k-k/2);
        }
    }
}
