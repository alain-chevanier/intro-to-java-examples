package unam.ciencias.icc.list;

import java.util.Optional;

public class LinkedList implements List {

  ListNode head;

  public LinkedList() {
    this.head = null;
  }

  @Override
  public int size() {
    int count = 0;
    ListNode tmp = this.head;
    while (tmp != null) {
      count++;
      tmp = tmp.next;
    }
    return count;
  }

  @Override
  public boolean isEmpty() {
    throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
  }

  @Override
  public Optional<Integer> get(int position) {
    throw new UnsupportedOperationException("Unimplemented method 'get'");
  }

  @Override
  public int contains() {
    throw new UnsupportedOperationException("Unimplemented method 'contains'");
  }

  @Override
  public void add(int elem) {
    ListNode newHead = new ListNode();
    newHead.elem = elem;
    newHead.next = this.head;
    this.head = newHead;
  }

  @Override
  public void add(int... elems) {
    // for (int i = 0; i < elems.length; i++) {
    //   this.addBeginning(elems[i]);
    // }
    for (int elem : elems) {
      this.add(elem);
    }
  }

  @Override
  public Optional<Integer> getHead() {
    if (this.head == null) {
      return Optional.empty();
    }
    return Optional.of(this.head.elem);
  }

  class ListNode {
    int elem;
    ListNode next;
  }
}
