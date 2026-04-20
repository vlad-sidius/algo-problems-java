package com.samples.algo.yandex.easy;

/*

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 */

public class MergeTwoSortedLists {

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode result = new ListNode();
    ListNode resultNode = result;

    while (list1 != null && list2 != null) {
      ListNode current;

      if (list1.val < list2.val) {
        current = list1;
        list1 = list1.next;
      } else {
        current = list2;
        list2 = list2.next;
      }


      resultNode.next = current;
      resultNode = resultNode.next;
    }

    while (list1 != null) {
      ListNode current = list1;
      list1 = list1.next;
      current.next = null;
      resultNode.next = current;
      resultNode = resultNode.next;
    }

    while (list2 != null) {
      ListNode current = list2;
      list2 = list2.next;
      current.next = null;
      resultNode.next = current;
      resultNode = resultNode.next;
    }

    return result.next;
  }
}
