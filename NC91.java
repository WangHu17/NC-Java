import java.util.*;

// NC91 最长上升子序列(三)
/*给定数组 arr ，设长度为 n ，输出 arr 的最长上升子序列。（如果有多个答案，请输出其中 
按数值(注：区别于按单个字符的ASCII码值)进行比较的 字典序最小的那个）*/
public class Solution {
    
    public int[] LIS (int[] arr) {
        int n = arr.length;
        int[] ele = new int[n+1];
        int[] l = new int[n];
        int len = 1;
        ele[len] = arr[0];
        l[0] = 1;
        for(int i=1; i<n; i++){
            if(arr[i] > ele[len]){
                ele[++len] = arr[i];
                l[i] = len;
            }else{
                // 二分查找第一个比arr[i]大的元素并替换
                int left = 0, right = len, pos = 0;
                while(left <= right){
                    int mid = (left+right)/2;
                    if(ele[mid] < arr[i]){
                        pos = mid + 1;
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }
                ele[pos] = arr[i];
                l[i] = pos;
            }
        }
        int[] res = new int[len];
        // 因为是最小字典序，所以从后往前找上升序列
        for(int i=n-1; i>=0; i--){
            if(l[i] == len){
                res[--len] = arr[i];
            }
        }
        return res;
    }
    
}