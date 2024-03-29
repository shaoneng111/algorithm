package offer;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 *
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 *
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead","deleteHead"]
 * [[],[3],[],[],[]]
 * 输出：[null,null,3,-1,-1]
 *
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 */

public class Offer09 {

    Stack<Integer> a;
    Stack<Integer> b;

    public Offer09() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void appendTail(int val) {
        a.push(val);
    }

    public int deleteHead() {
        if (!b.isEmpty()) {
            return b.pop();
        }
        if (a.isEmpty()) {
            return -1;
        }
        while (!a.isEmpty()) {
            b.push(a.pop());
        }
        return b.pop();
    }

}
