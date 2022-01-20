# LinkedLists

+ [Reverse linked list](#reverse-linked-list)
+ [Middle of the Linked List](#middle-of-the-linked-list)
+ [Palindrome Linked List](#palindrome-linked-list)
+ [Merge Two Sorted Lists](#merge-two-sorted-lists)
+ [Intersection of Two Linked Lists](#intersection-of-two-linked-lists)
+ [Sort list](#sort-list)
<!---->

## Reverse linked list

https://leetcode.com/problems/reverse-linked-list/

<details>
    <summary>Test Cases</summary>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class LeetcodeSolutionTest {
    private LeetcodeSolution solution;

    @BeforeEach
    void setSolution() {
        solution = new LeetcodeSolution();
    }

    @Test
    void testReverseList() {
        ListNode expected = ListNodeHandler.buildLinkedList(List.of(1, 2, 2, 3, 4));
        assertEquals(expected, solution.reverseList(ListNodeHandler.buildLinkedList(List.of(4, 3, 2, 2, 1))));
    }

    @Test
    void testNullHead() {
        assertNull(solution.reverseList(null));
    }
```

```java
class ListNodeHandler{
    static ListNode buildLinkedList(List<Integer> src) {
        ListNode prev = null;
        ListNode node = null;
        int p = src.size() - 1;
        for (int i = p; i >= 0; i--) {
            node = new ListNode(src.get(i), prev);
            prev = node;
        }
        return node;
    }
}
``` 
</details>

```java
public ListNode reverseList(ListNode head) {
    ListNode next = null, curr = head, prev = null;
        
    while(curr != null){
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
        
    return prev;
}
```


## Middle of the Linked List

https://leetcode.com/problems/middle-of-the-linked-list/

<details>
    <summary>Test Cases</summary>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeetcodeSolutionTest {
    private LeetcodeSolution solution;

    @BeforeEach
    void setSolution() {
        solution = new LeetcodeSolution();
    }

    @Test
    void testMiddleNodeInOddList() {
        ListNode list = ListNodeHandler.buildLinkedList(List.of(1, 2, 3, 4, 5));
        ListNode expected = ListNodeHandler.buildLinkedList(List.of(3, 4, 5));
        assertEquals(expected, solution.middleNode(list));
    }

    @Test
    void testMiddleNodeInEvenList() {
        ListNode list = ListNodeHandler.buildLinkedList(List.of(1, 2, 3, 4));
        ListNode expected = ListNodeHandler.buildLinkedList(List.of(3, 4));
        assertEquals(expected, solution.middleNode(list));
    }
}
```

```java
class ListNodeHandler{
    static ListNode buildLinkedList(List<Integer> src) {
        ListNode prev = null;
        ListNode node = null;
        int p = src.size() - 1;
        for (int i = p; i >= 0; i--) {
            node = new ListNode(src.get(i), prev);
            prev = node;
        }
        return node;
    }
}
``` 

</details>


``` java
public ListNode middleNode(ListNode head) {
    ListNode slowPointer = head;
    ListNode fastPointer = head;

    while (fastPointer != null && fastPointer.next != null) {
        slowPointer = slowPointer.next;
        fastPointer = fastPointer.next.next;
    }

    return slowPointer;
}
```


## Palindrome Linked List

https://leetcode.com/problems/palindrome-linked-list/

<details>
    <summary>Test Cases</summary>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class LeetcodeSolutionTest {
    private LeetcodeSolution solution;

    @BeforeEach
    void setSolution() {
        solution = new LeetcodeSolution();
    }

    @Test
    void testIsPalindrome() {
        assertTrue(solution.isPalindrome(ListNodeHandler.buildLinkedList(List.of(1, 2, 3, 4, 3, 2, 1))));
    }

    @Test
    void testIsNotPalindrome(){
        assertFalse(solution.isPalindrome(ListNodeHandler.buildLinkedList(List.of(1, 2, 3, 4, 5, 6))));
    }

    @Test
    void testNullList(){
        assertTrue(solution.isPalindrome(ListNodeHandler.buildLinkedList(List.of())));
    }
    
}
```
```java
class ListNodeHandler{
    static ListNode buildLinkedList(List<Integer> src) {
        ListNode prev = null;
        ListNode node = null;
        int p = src.size() - 1;
        for (int i = p; i >= 0; i--) {
            node = new ListNode(src.get(i), prev);
            prev = node;
        }
        return node;
    }
}
``` 
</details>

```java
public boolean isPalindrome(ListNode head) {
    Stack<Integer>stack = new Stack();
      
    ListNode current  = head;
       
    while(current!=null) {
        stack.push(current.val);
        current = current.next;
    }
        
    while(head!=null) {
        int i = stack.pop();
        if(head.val != i) {
            return false;
        }
            head = head.next;
    }
      
    return true;
}
```


## Merge Two Sorted Lists

https://leetcode.com/problems/merge-two-sorted-lists/

<details>
    <summary>Test Cases</summary>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class LeetcodeSolutionTest {
    private LeetcodeSolution solution;

    @BeforeEach
    void setSolution() {
        solution = new LeetcodeSolution();
    }

    @Test
    void testMergeTwoLists() {
        ListNode l1 = ListNodeHandler.buildLinkedList(List.of(1, 2));
        ListNode l2 = ListNodeHandler.buildLinkedList(List.of(3, 4));
        ListNode res = ListNodeHandler.buildLinkedList(List.of(1, 2, 3, 4));
        assertEquals(res, solution.mergeTwoLists(l1, l2));
    }

    @Test
    void testMergeOneList() {
        ListNode l2 = ListNodeHandler.buildLinkedList(List.of(3, 4));
        ListNode res = ListNodeHandler.buildLinkedList(List.of(3, 4));
        assertEquals(res, solution.mergeTwoLists(null, l2));
    }

    @Test
    void testMergeEqualLists() {
        ListNode l1 = ListNodeHandler.buildLinkedList(List.of(1, 2));
        ListNode res = ListNodeHandler.buildLinkedList(List.of(1, 1, 2, 2));
        assertEquals(res, solution.mergeTwoLists(l1, l1));
    }

}

```
```java
class ListNodeHandler {
    static ListNode buildLinkedList(List<Integer> src) {
        ListNode prev = null;
        ListNode node = null;
        int p = src.size() - 1;
        for (int i = p; i >= 0; i--) {
            node = new ListNode(src.get(i), prev);
            prev = node;
        }
        return node;
    }
}
``` 
</details>

```java
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null) return l2;
    if(l2 == null) return l1;
    ListNode prevl1 = null;
    ListNode head = l1;
    while(l1 != null && l2 != null){
        if(l1.val <= l2.val){
            prevl1 = l1;
            l1 = l1.next;
        }
        else{
            ListNode temp = l2;
            l2 = l2.next;
            temp.next = l1;
            if(prevl1 != null){
                prevl1.next = temp;
            }
            else{
                head = temp;
            }
            prevl1 = temp;
        }
    }
    if(l2 != null){
        prevl1.next = l2;
    }
    return head;
}

```


## Intersection of Two Linked Lists

https://leetcode.com/problems/intersection-of-two-linked-lists/

<details>
    <summary>Test Cases</summary>

``` java 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LeetcodeSolutionTest {
    private LeetcodeSolution solution;

    @BeforeEach
    void setSolution() {
        solution = new LeetcodeSolution();
    }

    @Test
    void testGetIntersectionNode1() {
        ListNode expected = ListNodeHandler.buildLinkedList(List.of(3, 5), null);
        ListNode headA = ListNodeHandler.buildLinkedList(List.of(1, 2), expected);
        ListNode headB = ListNodeHandler.buildLinkedList(List.of(5, 3, 5), expected);
        assertEquals(expected, solution.getIntersectionNode(headA, headB));
    }

    @Test
    void testGetIntersectionNode2() {
        ListNode expected = ListNodeHandler.buildLinkedList(List.of(8), null);
        ListNode headA = ListNodeHandler.buildLinkedList(List.of(1, 2), expected);
        ListNode headB = ListNodeHandler.buildLinkedList(List.of(5, 3, 5), expected);
        assertEquals(expected, solution.getIntersectionNode(headA, headB));
    }
}
```

```java
class ListNodeHandler{
    static ListNode buildLinkedList(List<Integer> src) {
        ListNode prev = null;
        ListNode node = null;
        int p = src.size() - 1;
        for (int i = p; i >= 0; i--) {
            node = new ListNode(src.get(i), prev);
            prev = node;
        }
        return node;
    }
}
``` 

</details>


``` java
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode A = headA;
    ListNode B = headB;
    int lenA = getLength(A);
    int lenB = getLength(B);

    if (lenA < lenB) {
        while (lenA != lenB) {
            headB = headB.next;
            lenB -= 1;
        }
    }

    if (lenB < lenA) {
        while (lenA != lenB) {
            headA = headA.next;
            lenA -= 1;
        }
    }

    while (headA != null || headB != null) {
        if (headA == headB) {
            return headA;
        } else {
            headA = headA.next;
            headB = headB.next;
        }
    }
    return null;
}

private int getLength (ListNode list) {
    int lenList = 0;

    while (list != null) {
        lenList += 1;
        list = list.next;
    }
    return lenList;
}
```


## Sort List

https://leetcode.com/problems/sort-list/

<details>
    <summary>Test Cases</summary>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class LeetcodeSolutionTest {
    private LeetcodeSolution solution;

    @BeforeEach
    void setSolution() {
        solution = new LeetcodeSolution();
    }

    @Test
    void testSortList() {
        ListNode l1 = ListNodeHandler.buildLinkedList(List.of(1, 4, 5, 3, 2));
        ListNode res = ListNodeHandler.buildLinkedList(List.of(1, 2, 3, 4, 5));
        assertEquals(res, solution.sortList(l1));
    }

    @Test
    void testSortNullList() {
        assertNull(solution.sortList(null));
    }

    @Test
    void testSortEqList() {
        ListNode l1 = ListNodeHandler.buildLinkedList(List.of(1, 1, 1));
        ListNode res = ListNodeHandler.buildLinkedList(List.of(1, 1, 1));
        assertEquals(res, solution.sortList(l1));
    }

}
```
```java

class ListNodeHandler {
    static ListNode buildLinkedList(List<Integer> src) {
        ListNode prev = null;
        ListNode node = null;
        int p = src.size() - 1;
        for (int i = p; i >= 0; i--) {
            node = new ListNode(src.get(i), prev);
            prev = node;
        }
        return node;
    }
}
```
</details>

```java
public ListNode sortList(ListNode head) {
    if (head == null || head.next == null)
        return head;
    ListNode middle = getMid(head);
    ListNode left = sortList(head);
    ListNode right = sortList(middle);
    return merge(left, right);
}

ListNode merge(ListNode list1, ListNode list2) {
    ListNode dummyHead = new ListNode();
    ListNode tail = dummyHead;
    while (list1 != null && list2 != null) {
        if (list1.val < list2.val) {
            tail.next = list1;
            list1 = list1.next;
            tail = tail.next;
        } else {
            tail.next = list2;
            list2 = list2.next;
            tail = tail.next;
        }
    }
    tail.next = (list1 != null) ? list1 : list2;
    return dummyHead.next;
}

ListNode getMid(ListNode head) {
    ListNode middlePrev = null;
    while (head != null && head.next != null) {
        middlePrev = (middlePrev == null) ? head : middlePrev.next;
        head = head.next.next;
    }
    ListNode middle = middlePrev.next;
    middlePrev.next = null;
    return middle;
}

```