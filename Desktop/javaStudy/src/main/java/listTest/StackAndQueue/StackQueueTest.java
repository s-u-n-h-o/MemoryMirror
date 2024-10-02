package listTest.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTest {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Queue queue = new LinkedList();

        stack.push("0");
        stack.push("1");
        stack.push("2");

        //offer() : Queue에 객체 저장 성공시 true 실패시 false 반환
        queue.offer("0");
        queue.offer("1");
        queue.offer("2");

        while (!stack.empty()) {
            System.out.println("stack값 : " + stack.pop());
        }
        while (!queue.isEmpty()) {
            System.out.println("queue값 : "  + queue.poll());
        }
    }
}