package com.algorithms.educative.fastslowpointers;

import com.algorithms.educative.common.datastructures.LinkedList;
import com.algorithms.educative.common.datastructures.LinkedListNode;
import com.algorithms.educative.common.utils.PrintList;

//https://web.archive.org/web/20200704074331/http://www.siafoo.net/algorithm/11
// Cycle detection: LinkedList, pseudorandom number generator, cryptographic hash collision

class CycleDetectionSolution {
    public static boolean detectCycle(LinkedListNode head) {
        if (head == null) {
            return false;
        }

        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    // Driver code
    public static void main(String args[]) {
        int[][] input = {
                {2, 4, 6, 8, 10, 12},
                {1, 3, 5, 7, 9, 11},
                {0, 1, 2, 3, 4, 6},
                {3, 4, 7, 9, 11, 17},
                {5, 1, 4, 9, 2, 3}};

        int[] pos = {0, -1, 1, -1, 2};

        for (int i = 0; i < input.length; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            list.createLinkedList(input[i]);
            System.out.print(i + 1 + ".\tInput:");
            System.out.print("\t");
            if (pos[i] == -1) {
                PrintList.printListWithForwardArrow(list.head);
            } else {
                PrintList.printListWithForwardArrowLoop(list.head);
            }
            System.out.println("\n\tpos: " + pos[i]);

            if (pos[i] != -1) {
                int length = list.getLength(list.head);
                LinkedListNode lastNode = list.getNode(list.head, length - 1);
                lastNode.next = list.getNode(list.head, pos[i]);
            }
            System.out.println("\n\tDetected Cycle =  " + detectCycle(list.head));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
