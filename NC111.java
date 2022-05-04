import java.util.*;

// NC111 最大数
/* 给定一个长度为n的数组nums，数组由一些非负整数组成，现需要将他们进行排列并拼接，
每个数不可拆分，使得最后的结果最大，返回值需要是string类型，否则可能会溢出。*/
public class Solution {
    
    public String solve (int[] nums) {
        ArrayList<String> list = new ArrayList<>();
        for(int num:nums){
            list.add(String.valueOf(num));
        }
        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                return (b + a).compareTo(a + b);
            }
        });
        if(list.get(0).equals("0"))return "0";
        StringBuilder res = new StringBuilder();
        for(String s:list){
            res.append(s);
        }
        return res.toString();
    }
    
}