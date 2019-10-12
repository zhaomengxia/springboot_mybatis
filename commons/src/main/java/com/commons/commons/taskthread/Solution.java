package com.commons.commons.taskthread;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @Author zhaomengxia
 * @create 2019/9/26 17:06
 */
public class Solution {


    public static void main(String[] args) {

        int[] nums1 = {1, 3};
        int[] nums2 = {2,4};
        double d = findMedianSortedArrays(nums1, nums2);

        System.out.println("double=" + d);

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {


//        int length1=nums1.length;
//        int length2=nums2.length;
//        int s=length1+length2;
//        int[] nums3=new int[length1+length2];
//
//        for (int i = 0; i <length1 ; i++) {
//            nums3[i]=nums1[i];
//        }
//
//        for (int i = length1; i <s ; i++) {
//            nums3[i]=nums2[i-length1];
//        }
//
//        Arrays.sort(nums3);
//
//        double d=0.0;
//        for (int i = 0; i < s; i++) {
//            if (s%2==0){
//                int t=s/2;
//                int sum=nums3[t-1]+nums3[t];
//
//               d= sum*1.0/2;
//            }
//            else {
//                int t=s-1;
//                d=nums3[t/2];
//            }
//        }
//        return d;

        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;

    }
}


