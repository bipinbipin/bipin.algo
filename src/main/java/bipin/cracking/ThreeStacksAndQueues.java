package bipin.cracking;

import java.util.*;

public class ThreeStacksAndQueues {

    public static class StackWithMin extends Stack<NodeWithMin> {
        public void push(int value) {
            int newMin = Math.min(value, min());
            super.push(new NodeWithMin(value, newMin));
        }

        public int min() {
            if (this.isEmpty()) {
                return Integer.MAX_VALUE;
            } else {
                return peek().min;
            }
        }
    }

    static class NodeWithMin {
        public int value;
        public int min;
        public NodeWithMin(int v, int min) {
            value = v;
            this.min = min;
        }
    }

    public static void main(String[] args) {
        threeDotTwo_StackMin();
    }

    static void threeDotTwo_StackMin() {
        /*
        Stack Min: How would you design a stack which, in addition to push and pop, has a function m i n
        which returns the minimum element? Push, pop and min should all operate in 0(1) time.
        Hints: #27, #59, #78
         */
        StackWithMin intStack = new StackWithMin();
        intStack.push(3);
        intStack.push(21);
        intStack.push(9);
        intStack.push(38);
        intStack.push(17);
        intStack.push(7);
        System.out.println(intStack.min());

    }


    static class StackNode<T> {
        private T data;
        private StackNode<T> next;
        private StackNode<T> top;
        public StackNode(T data) {
            this.data = data;
        }

        public T pop() {
            if (top == null) throw new EmptyStackException();
            T item = top.data;
            top = top.next;
            return item;
        }

        public void push(T item) {
            StackNode<T> t = new StackNode<>(item);
            t.next = top;
            top = t;
        }

        public T peek() {
            if (top == null) throw new EmptyStackException();
            return top.data;
        }
    }
}
