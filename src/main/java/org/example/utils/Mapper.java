package org.example.utils;

public interface Mapper<F, T> {
  T map(F from);
  F revers(T to);
}
