package com.algorithms.educative.fastslowpointers;

public class BrentCycleDetectionAlgorithm {

    public static boolean hasCycle(Node head) {
        if (head == null) {
            return false; // Empty list has no cycle
        }

        Node slow = head, fast = head;
        int power = 1;  // Initialize power of two for jumps

        while (true) {
            slow = slow.next;  // Slow pointer moves one step

            if (fast.next == null) {
                return false;  // No cycle if fast reaches the end
            }

            fast = fast.next.next;  // Fast pointer moves two steps

            if (slow == fast) {
                return true;  // Cycle detected
            }

            // Power of two jump for fast pointer
            if (power == 1) {
                power *= 2;
                fast = head;  // Reset fast to head for the jump
            } else {
                power /= 2;
            }
        }
    }

    // Node class for the LinkedList
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // Example usage
    public static void main(String[] args) {
        // Create a LinkedList with a cycle
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head;  // Create the cycle

        boolean checkCycle = hasCycle(head);
        System.out.println("Cycle detected: " + checkCycle);

        Node headOne = new Node(1);
        headOne.next = new Node(2);
        headOne.next.next = new Node(3);
        headOne.next.next.next = null;  // Create the cycle

        checkCycle = hasCycle(headOne);
        System.out.println("Cycle detected: " + checkCycle);

    }
}