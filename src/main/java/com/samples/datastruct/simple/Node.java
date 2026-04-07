package com.samples.datastruct.simple;

public class Node<T> {

  private T item;
  private Node<T> next;

  public Node(final T item) {
    this(item, null);
  }

  public Node(final T item, Node<T> next) {
    this.item = item;
    this.next = next;
  }

  public T getItem() {
    return item;
  }

  public void setItem(final T item) {
    this.item = item;
  }

  public Node<T> getNext() {
    return next;
  }

  public void setNext(final Node<T> next) {
    this.next = next;
  }
}
