import java.util.*;

//NC36 在两个长度相等的排序数组中找到上中位数(上中位数：假设递增序列长度为n，为第n/2个数)
public class Solution {
    
    // 方法二：二分
    public int findMedianinTwoSortedAray (int[] arr1, int[] arr2) {
        int left1 = 0, right1 = arr1.length - 1, left2 = 0, right2 = arr2.length - 1, mid1, mid2, even;
        while(left1 < right1){
            mid1 = (left1 + right1)/2;
            mid2 = (left2 + right2)/2;
            even = (right1 - left1)%2;
            if(arr1[mid1] == arr2[mid2]){
                return arr1[mid1];
            }else if(arr1[mid1] < arr2[mid2]){
                right2 = mid2;
                left1 = mid1 + even;
            }else{
                right1 = mid1;
                left2 = mid2 + even;       
            }
        }
        return Math.min(arr1[left1], arr2[left2]);
    }
    
    // 方法一：双指针
    public int findMedianinTwoSortedAray1 (int[] arr1, int[] arr2) {
        int len = arr1.length, p1 = 0, p2 = 0, res = 0;
        while(len-- > 0){
            if(arr1[p1] <= arr2[p2]){
                res = arr1[p1];
                p1++;
            }else{
                res = arr2[p2];
                p2++;
            }
        }
        return res;
    }
    
}