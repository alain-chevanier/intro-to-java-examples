package unam.ciencias.icc;

import org.junit.jupiter.api.Test;

import static unam.ciencias.icc.BidimensionalArrays.buildPascalTriangle;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

public class BidimensionalArraysTest {
  @Test
  public void test_OneLevel() {
    var actual = buildPascalTriangle(1);
    var expected = new int[][] {new int[] {1}};
    assertThat(actual, is(equalTo(expected)));
  }

  @Test
  public void test_TwoLevels() {
    var actual = buildPascalTriangle(2);
    var expected = new int[][] {new int[] {1},
                                new int[] {1, 1}};
    assertThat(actual, is(equalTo(expected)));
  }

  @Test
  public void test_SixLevels() {
    var actual = buildPascalTriangle(6);
    var expected = new int[][] {new int[] {1},
                                new int[] {1, 1},
                                new int[] {1, 2, 1},
                                new int[] {1, 3, 3, 1},
                                new int[] {1, 4, 6, 4, 1},
                                new int[] {1, 5, 10, 10, 5, 1}};
    assertThat(actual, is(equalTo(expected)));
  }
}
