package com.samples.algo.yandex.easy;

/*

Given the head of a singly linked list, reverse the list, and return the reversed list.

*/

public class ReverseLinkedList {

  public ListNode reverseList(ListNode head) {
    ListNode result = null;

    while (head != null) {
      ListNode current = head;
      head = head.next;
      current.next = result;
      result = current;
    }

    return result;
  }

}
