package com.algorithms.educative.fastslowpointers;

import com.algorithms.educative.common.datastructures.LinkedList;
import com.algorithms.educative.common.datastructures.LinkedListNode;

import java.util.Objects;

public class CycleDetection {

    public static boolean detectCycle(LinkedListNode head) {

        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return false;
        }
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (Objects.nonNull(fast) && Objects.nonNull(fast.next)) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String... args) {

        //[2,4,6,8,10] and 1
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.createLinkedList(new int[]{2, 4, 6, 8, 10});
        detectCycle(linkedList.head);

        //[1,3,5,7,9] and -1

        //[1,2,3,4,5] and 1

        //[0,2,3,5,6] and -1

        //[3,6,9,10,11] and 1


    }


}
