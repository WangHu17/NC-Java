import java.util.*;

//NC140 排序
public class Solution {
    
    // 堆排序
    public int[] MySort (int[] arr) {
        for(int i=arr.length/2-1; i>=0; i--)
            adjustHeap(arr,i,arr.length);
        for(int j=arr.length-1; j>=1; j--){
            int t = arr[j];
            arr[j] = arr[0];
            arr[0] = t;
            adjustHeap(arr,0,j);
        }
        return arr;
    }
    public void adjustHeap(int[] arr, int i, int length){
        int temp=arr[i];
        for(int k=2*i+1; k<length; k=k*2+1){
            if(k+1<length && arr[k] < arr[k+1]){
                k++;
            }
            if(arr[k] > temp){
                arr[i] = arr[k];
                i=k;
            }else break;
        }
        arr[i] = temp;
    }
    
    // 归并排序
    public int[] MySort7 (int[] arr) {
        mergeSort(arr,0,arr.length-1,new int[arr.length]);
        return arr;
    }
    public void mergeSort(int[] arr, int left, int right, int[] temp){
        if(left < right){
            int mid = left + (right - left)/2;
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }
    public void merge(int[] arr, int left, int mid, int right, int[] temp){
        int l=left, tL=mid+1, t=0;
        while(l<=mid && tL<=right){
            if(arr[l] <= arr[tL]){
                temp[t++] = arr[l++];
            }else{
                temp[t++] = arr[tL++];
            }
        }
        while(l<=mid)temp[t++] = arr[l++];
        while(tL<=right)temp[t++] = arr[tL++];
        int index=left;
        t=0;
        while(index <= right)arr[index++]=temp[t++];
    }
    
    // 基数排序
    public int[] MySort6 (int[] arr) {
        int max=0;
        for(int n:arr){
            if(max<n)max=n;
        }
        int len = (max+"").length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[10];
        for(int i=0, n=1; i<len; i++, n*=10){
            for(int j=0; j<arr.length; j++){
                int num = arr[j] / n % 10;
                bucket[num][bucketCount[num]] = arr[j];
                bucketCount[num]++;
            }
            int index = 0;
            for(int k=0; k<10; k++){
                if(bucketCount[k]!=0){
                    int m=0, count = bucketCount[k];
                    while(m<count){
                        arr[index++] = bucket[k][m++];
                    }
                }
                bucketCount[k]=0;
            }
        }
        return arr;
    }
    
    // 快速排序
    public int[] MySort5 (int[] arr) {
        quickSort(arr,0,arr.length-1);
        return arr;
    }
    public void quickSort(int[] arr, int left, int right){
        int l=left, r=right, t=0;
        int pivot = arr[(left+right)/2];
        while(l<right){
            while(arr[l] < pivot)l++;
            while(arr[r] > pivot)r--;
            if(l>=r)break;
            t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            
            if(arr[l] == pivot)r--;
            if(arr[r] == pivot)l++;
        }
        if(l == r){
            l++;
            r--;
        }
        if(left < r)quickSort(arr,left,r);
        if(l < right)quickSort(arr,l,right);
    }
    
    // 希尔排序
    public int[] MySort4 (int[] arr) {
        for(int gap = arr.length/2; gap>=1; gap--){
            for(int i=gap; i<arr.length; i++){
                int insertIndex = i-gap, insertVal = arr[i];
                while(insertIndex>=0 && insertVal < arr[insertIndex]){
                    arr[insertIndex + gap] = arr[insertIndex];
                    insertIndex -= gap;
                }
                arr[insertIndex + gap] = insertVal;
            }
        }
        return arr;
    }
    
    // 插入排序
    public int[] MySort3 (int[] arr) {
        for(int i=1; i<arr.length; i++){
            int insertIndex = i-1, insertVal = arr[i];
            while(insertIndex>=0 && insertVal < arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1] = insertVal;
        }
        return arr;
    }
    
    // 选择排序
    public int[] MySort2 (int[] arr) {
        int min, minIndex, t;
        for(int i=0; i<arr.length-1; i++){
            min = arr[i];
            minIndex=i;
            for(int j=i+1; j<arr.length; j++){
                if(min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex != i){
                t = arr[i];
                arr[i] = min;
                arr[minIndex] = t;
            }
        }
        return arr;
    }

    // 冒泡排序
    public int[] MySort1 (int[] arr) {
        int t, flag;
        for(int i=0; i<arr.length-1; i++){
            flag = 0;
            for(int j=0; j<arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    flag = 1;
                    t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
            if(flag == 0)break;
        }
        return arr;
    }
    
}