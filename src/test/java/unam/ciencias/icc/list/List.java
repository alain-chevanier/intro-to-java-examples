package unam.ciencias.icc.list;

import java.util.Optional;

public interface List {
  int size();
  boolean isEmpty();
  Optional<Integer> get(int position);
  int contains(); // -1
  void add(int elem);
  void add(int... elems);
  Optional<Integer> getHead();
}
