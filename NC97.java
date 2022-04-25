import java.util.*;

//NC97 字符串出现次数的TopK问题
public class Solution {
    
    // 方法：使用最小堆 - PriorityQueue
    public String[][] topKstrings (String[] strings, int k) {
        if(k==0)return new String[][]{};
        HashMap<String, Integer> map = new HashMap<>();
        for(String s:strings){
            map.put(s, map.getOrDefault(s,0)+1);
        }
        MyComparator compara = new MyComparator();
        String[][] res = new String[k][2];
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(k, compara);
        for(Map.Entry<String, Integer> entry:map.entrySet()){
            if(queue.size() < k){
                queue.offer(entry);
            }else if(compara.compare(queue.peek(), entry) < 0){
                queue.poll();
                queue.offer(entry);
            }
        }
        for(int i=k-1; i>=0; i--){
            Map.Entry<String, Integer> entry = queue.poll();
            res[i][0] = entry.getKey();
            res[i][1] = String.valueOf(entry.getValue());
        }
        return res;
    }
    
    // 自定义比较器
    class MyComparator implements Comparator<Map.Entry<String,Integer>>{
        @Override
        public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2){
            if(o1.getValue().equals(o2.getValue())){
                return o2.getKey().compareTo(o1.getKey());
            }else{
                return o1.getValue() - o2.getValue();
            }
        }
    }
    
}