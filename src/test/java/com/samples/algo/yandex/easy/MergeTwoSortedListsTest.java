package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MergeTwoSortedListsTest {

  private final MergeTwoSortedLists instance = new MergeTwoSortedLists();

  @Test
  void testBaseCase() {
    // list1 = [1,2,4], list2 = [1,3,4]
    ListNode list1 = createList(new int[] { 1,2,4 });
    ListNode list2 = createList(new int[] { 1,3,4 });

    ListNode actual = instance.mergeTwoLists(list1, list2);

    assertThat(actual).isNotNull();
  }

  private ListNode createList(int[] array) {
    ListNode head = new ListNode();
    ListNode node = head;

    for (int value : array) {
      ListNode current = new ListNode(value);
      node.next = current;
      node = node.next;
    }

    return head.next;
  }
}
