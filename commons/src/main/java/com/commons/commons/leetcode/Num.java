package com.commons.commons.leetcode;

import javax.swing.tree.TreeNode;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author zhaomengxia
 * @create 2019/9/24 9:19
 */
public class Num {


    public static void main(String[] args) {
        int[] nums = {3,2,5,6,0};
        int target = 6;
        int[] s = twoNum(nums, target);
        int count = s.length;
        for (int i = 0; i < count; i++) {
            System.out.println(s[i]);
        }

//        int[] numss = {-1, 0, 1, 2, -1, -4};
//        List<List<Integer>> lists = threeNum(numss);
//        for (int i = 0; i < lists.size(); i++) {
//            for (int j = 0; j < lists.get(i).size(); j++) {
//                System.out.print(lists.get(i).get(j) + " ");
//            }
//            System.out.println();
//        }
    }


    public static int[] twoNum(int[] nums, int target) {

//        int s = nums.length;
//        Map<Integer,Integer>  integerIntegerMap=new HashMap<>();
//        for (int i = 0; i < s; i++) {//第一位与 第二位之后相加；第二位与第三位之后相加
//            int t=target-nums[i];
//            if (integerIntegerMap.containsKey(t)){
//                return new int[] {integerIntegerMap.get(t),i};
//            }
//            integerIntegerMap.put(nums[i],i);
//        }
//        return null;
//
        int max=2047;
        int[] ints=new int[max+1];
        for (int i = 0; i <nums.length ; i++) {
            int d=target-nums[i];
            int index=d & max;
            if (ints[index]!=0){
                return new int[] {ints[index]-1,i};
            }
            ints[nums[i]&max]=i+1;
        }
        throw new IllegalArgumentException("No two sum value");

    }


    public static List<List<Integer>> threeNum(int[] nums) {
        int s = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        if (nums==null||s<3) return lists;
        Arrays.sort(nums);//[-4,-1,-1,0,1,2]
        for (int i = 0; i < s; i++) {
            if (nums[i]>0) break;
            if (i>0&&nums[i]==nums[i-1]) continue;
            int l=i+1;
            int r=s-1;
            while (l<r){
                int sum=nums[i]+nums[l]+nums[r];
                if (sum==0){
                    lists.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while (l<r&&nums[l]==nums[l+1]) l++;
                    while (l<r&&nums[r]==nums[r-1]) r--;
                    l++;
                    r--;
                }
                else if (sum<0){
                    l++;
                }
                else if (sum>0){
                    r--;
                }

            }
        }
        return lists;
    }




}
