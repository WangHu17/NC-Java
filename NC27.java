import java.util.*;

// NC27 集合的所有子集(一)
/*
现在有一个没有重复元素的整数集合S，求S的所有子集
注意：
你给出的子集中的元素必须按升序排列
给出的解集中不能出现重复的元素
*/
public class Solution {
    
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();
    
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        helper(S, 0);
        return res;
    }
    
    public void helper(int[] S, int index){
        res.add(new ArrayList(list));
        for(int i=index; i<S.length; i++){
            list.add(S[i]);
            helper(S, i+1);
            list.remove(list.size() - 1);
        }
    }
    
}