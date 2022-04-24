import java.util.*;

//NC105 二分查找-II
public class Solution {
    public int search (int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int index = -1;
        while(l <= r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                index = mid;
                break;
            }else if(nums[mid] < target)
                l = mid + 1;
            else 
                r = mid - 1;
        }
        while(index-1 >=0 && nums[index-1] == target)index--;
        return index;
    }
}