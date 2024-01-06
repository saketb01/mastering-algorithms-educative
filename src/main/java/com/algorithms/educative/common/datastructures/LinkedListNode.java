package com.algorithms.educative.common.datastructures;

import java.util.Objects;

public class LinkedListNode {
    public int data;
    public LinkedListNode next;

    // Constructor will be used to make a LinkedListNode type object
    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        LinkedListNode node = this;
        StringBuilder builder = new StringBuilder("{ ");
        while (Objects.nonNull(node)) {
            builder.append(node.data);
            if (Objects.nonNull(node.next)) {
                builder.append(" -> ");
            }
            node = node.next;
        }
        builder.append("}");

        return builder.toString();
    }


}