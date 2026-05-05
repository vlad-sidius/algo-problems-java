package com.samples.algo.yandex.easy;

public class PalindromeLinkedList {

  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    slow = reverse(slow);

    while (slow != null) {
      if (head.val != slow.val) {
        return false;
      }

      head = head.next;
      slow = slow.next;
    }

    return true;
  }

  public ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
      ListNode nxt = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nxt;
    }

    return prev;
  }
}
