package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 234: Palindrome Linked List")
public class PalindromeLinkedListTest {

  private final PalindromeLinkedList instance = new PalindromeLinkedList();

  static Stream<Arguments> provideCases() {
    return Stream.of(
        Arguments.of(buildList(1, 2, 2, 1), true),
        Arguments.of(buildList(1, 2), false),
        Arguments.of(buildList(1, 2, 3, 2, 1), true),
        Arguments.of(buildList(1, 2, 3), false),
        Arguments.of(buildList(1), true),
        Arguments.of(null, true),
        Arguments.of(buildList(0, 0), true),
        Arguments.of(buildList(1, 2, 1, 2, 1), true),
        Arguments.of(buildList(1, 2, 1, 2), false)
    );
  }

  private static ListNode buildList(int... vals) {
    if (vals.length == 0) {
      return null;
    }

    ListNode head = new ListNode(vals[0]);
    ListNode curr = head;

    for (int i = 1; i < vals.length; i++) {
      curr.next = new ListNode(vals[i]);
      curr = curr.next;
    }

    return head;
  }

  @ParameterizedTest(name = "list={0} → expected={1}")
  @MethodSource("provideCases")
  void testIsPalindrome(ListNode head, boolean expected) {
    assertEquals(expected, instance.isPalindrome(head));
  }
}
