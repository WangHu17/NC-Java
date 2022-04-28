import java.util.*;
//NC82 滑动窗口的最大值
public class Solution {
    
    // 方法：双端队列：使队列元素保持为单调递减，向后移动窗口时，加入元素并依次弹出队尾比自己小的元素，
    //      同时如果队首元素不在窗口内了，就弹出，然后队首元素就是该窗口的最大值
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        // 加入第一个窗口的元素
        for(int i=0; i<size; i++){
            while(!deque.isEmpty() && num[deque.peekLast()] <= num[i])
                deque.pollLast();
            deque.add(i);
        }
        res.add(num[deque.peekFirst()]);
        // 遍历后面的元素
        for(int i=size; i<num.length; i++){
            // 弹出不在该窗口的下标
            if(!deque.isEmpty() && deque.peekFirst() <= i-size)
                deque.pollFirst();
            // 加入新下标到窗口
            while(!deque.isEmpty() && num[deque.peekLast()] <= num[i])
                deque.pollLast();
            deque.add(i);
            // 将队首放入结果
            res.add(num[deque.peekFirst()]);
        }
        return res;
    }
    
}