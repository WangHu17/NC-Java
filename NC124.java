import java.util.*;

// NC124 字典树的实现
/*
假设组成所有单词的字符仅是‘a’～‘z’，请实现字典树的结构，并包含以下四个主要的功能。

1. void insert(String word)：添加word，可重复添加；
2. void delete(String word)：删除word，如果word添加过多次，仅删除一次；
3. boolean search(String word)：查询word是否在字典树中出现过(完整的出现过，前缀式不算)；
4. int prefixNumber(String pre)：返回以字符串pre作为前缀的单词数量。
*/
public class Solution {
    
    private TrieTree root;
    
    public Solution(){
        root = new TrieTree();
    }
    
    public String[] trieU (String[][] operators) {
        List<String> res = new ArrayList<>();
        for(int i=0; i<operators.length; i++){
            String s = operators[i][1];
            if(operators[i][0].equals("1")){
                insert(s);
            }else if(operators[i][0].equals("2")){
                delete(s);
            }else if(operators[i][0].equals("3")){
                boolean b = search(s);
                if(b){
                    res.add("YES");
                }else
                    res.add("NO");
            }else if(operators[i][0].equals("4")){
                int num = prefixNumber(s);
                res.add(String.valueOf(num));
            }
        }
        String[] result = new String[res.size()];
        res.toArray(result);
        return result;
    }
    
    public void insert(String word){
        if(word == null)return;
        char[] chars = word.toCharArray();
        TrieTree node = root;
        int index = 0;
        for(int i=0; i<word.length(); i++){
            index = chars[i] - 'a';
            if(node.map[index] == null){
                node.map[index] = new TrieTree();
            }
            node = node.map[index];
            node.path++;
        }
        node.end++; // 最后记得加end
    }
    
    public void delete(String word){
        if(search(word)){
            char[] chars = word.toCharArray();
            TrieTree node = root;
            int index = 0;
            for(int i=0; i<word.length(); i++){
                index = chars[i] - 'a';
                if(node.map[index].path-- == 1){
                    node.map[index] = null;
                    return;
                }
                node = node.map[index];
            }
            node.end--;
        }
    }
    
    public boolean search(String word){
        if(word == null)return false;
        char[] chars = word.toCharArray();
        TrieTree node = root;
        int index = 0;
        for(int i=0; i<word.length(); i++){
            index = chars[i] - 'a';
            if(node.map[index] == null){
                return false;
            }
            node = node.map[index];
        }
        return node.end != 0;
    }
    
    public int prefixNumber(String pre){
        if(pre == null)return 0;
        char[] chars = pre.toCharArray();
        TrieTree node = root;
        int index = 0;
        for(int i=0; i<pre.length(); i++){
            index = chars[i] - 'a';
            if(node.map[index] == null){
                return 0;
            }
            node = node.map[index];
        }
        return node.path;
    }
    
}
class TrieTree{
    public int path;
    public int end;
    public TrieTree[] map;
    
    public TrieTree(){
        path = 0;
        end = 0;
        map = new TrieTree[26];
    }
}