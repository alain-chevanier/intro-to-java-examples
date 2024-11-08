package unam.ciencias.icc.list;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;

public class ListTest {
  @Test
  public void test_CreateEmptyList() {
    List list = new LinkedList();
    assertThat(list.size(), is(equalTo(0)));
  }

  @Test
  public void test_CreateSingleElementList() {
    List list = new LinkedList();
    list.add(5);
    assertThat(list.size(), is(equalTo(1)));
    assertThat(list.getHead(), is(equalTo(Optional.of(5))));
  }

  @Test
  public void test_CreateMultipleElementsList() {
    List list = new LinkedList();
    list.add(5);
    list.add(8);
    list.add(3);
    list.add(20);
    // 20 -> 3 -> 8 -> 5
    assertThat(list.size(), is(equalTo(4)));
    assertThat(list.getHead(), is(equalTo(Optional.of(20))));
  }

  @Test
  public void test_CreateMultipleElementsList_2() {
    List list = new LinkedList();
    list.add(5, 8, 3, 20);
    // 20 -> 3 -> 8 -> 5
    assertThat(list.size(), is(equalTo(4)));
    assertThat(list.getHead(), is(equalTo(Optional.of(20))));
  }
}
