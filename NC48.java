import java.util.*;

//NC48 在旋转过的有序数组中寻找目标值
public class Solution {
    public int search (int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] >= nums[left]){// 左边有序
                if(target > nums[mid] || (target < nums[mid] && target < nums[left])){
                    left = mid + 1;
                }else
                    right = mid;
            }else if(nums[mid] < nums[right]){// 右边有序
                if(target < nums[mid] || (target > nums[mid] && target > nums[right]))
                    right = mid;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }
}