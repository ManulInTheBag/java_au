# Design

+ [Min Stack](#min-stack)
+ [Implement Stack using Queues](#implement-stack-using-queues)
+ [Implement Queue using Stacks](#implement-queue-using-stacks)

## Min Stack

https://leetcode.com/problems/min-stack/

<details><summary>Test Cases</summary><blockquote>

``` java 

```

</blockquote></details>


``` java
class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack = new ArrayDeque<>();

    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }

    public void pop() {
        int val = stack.pop();
        if (minStack.peek() == val) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
```


## Implement Stack using Queues

https://leetcode.com/problems/implement-stack-using-queues/

<details><summary>Test Cases</summary><blockquote>

```java

```

</blockquote></details>

```java
class MyStack {

    private final Queue<Integer> master = new LinkedList<>();
    private Integer lastElement;

    public void push(final int x) {
        master.add(x);
        lastElement = x;
    }

    public int pop() {
        final Queue<Integer> slave = new LinkedList<>();
        while (master.size() > 1) {
            lastElement = master.remove();
            slave.add(lastElement);
        }
        final int result = master.remove();
        for (final int element:  slave) {
            master.add(element);
        }
        return result;
    }

    public int top() {
        return lastElement;
    }

    public boolean empty() {
        return master.isEmpty();
    }
}
 ```

## Implement Queue using Stacks

https://leetcode.com/problems/implement-queue-using-stacks/

<details><summary>Test Cases</summary><blockquote>

``` java 

```

</blockquote></details>


``` java
class MyQueue {
    Deque<Integer> queue;

    public MyQueue() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.addLast(x);
    }

    public int pop() {
        return queue.pop();
    }

    public int peek() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
```