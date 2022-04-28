import java.util.*;

// NC46 加起来和为目标值的组合(二)
public class Solution {
    
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        dfs(num,new ArrayList<Integer>(),target,0);
        return res;
    }
    
    public void dfs(int[] num, ArrayList<Integer> list, int target, int i){
        if(target == 0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if(i >= num.length)return;
        for(int j=i; j<num.length; j++){
            if(j>i && num[j-1] == num[j])continue;
            if(num[j] <= target){
                list.add(num[j]);
                dfs(num,list,target-num[j],j+1);
                list.remove(list.size()-1);
            }
        }
    }
    
}