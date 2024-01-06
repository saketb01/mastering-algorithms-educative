package com.algorithms.educative.fastslowpointers;

import com.algorithms.educative.common.datastructures.LinkedList;
import com.algorithms.educative.common.datastructures.LinkedListNode;
import com.algorithms.educative.common.utils.PrintList;

import java.util.Objects;


public class MiddleNode {

    public static LinkedListNode middleNode(LinkedListNode head) {

        if (Objects.isNull(head) || head.next == null) {
            return head;
        }

        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while (Objects.nonNull(fast) && Objects.nonNull(fast.next)) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String args[]) {
        int[][] input = {
                {2, 4, 6, 8, 10, 12},
                {1},
                {0, 1, 2},
                {3, 4},
                {5, 1, 4, 9, 2, 3, 12, 15}
        };

        for (int i = 0; i < input.length; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            list.createLinkedList(input[i]);
            System.out.print(i + 1 + ".\tInput:");
            System.out.print("\t");

            PrintList.printListWithForwardArrowLoop(list.head);

            System.out.println("\n\t Middle Node =  " + middleNode(list.head));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }


}
