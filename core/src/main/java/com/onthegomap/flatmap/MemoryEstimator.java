package com.onthegomap.flatmap;

import com.carrotsearch.hppc.IntObjectHashMap;
import com.carrotsearch.hppc.LongArrayList;
import com.carrotsearch.hppc.LongHashSet;
import com.carrotsearch.hppc.LongIntHashMap;
import com.carrotsearch.hppc.LongLongHashMap;
import com.carrotsearch.hppc.LongObjectHashMap;
import com.carrotsearch.hppc.ObjectIntHashMap;

public class MemoryEstimator {

  public static long size(HasEstimate object) {
    return object == null ? 0 : object.estimateMemoryUsageBytes();
  }

  public static long size(LongHashSet object) {
    return object == null ? 0 : 24L + 8L * object.keys.length;
  }

  public static long size(LongLongHashMap object) {
    return object == null ? 0 : (24L + 8L * object.keys.length +
      24L + 8L * object.values.length);
  }

  public static <T> long sizeWithoutValues(LongObjectHashMap<T> object) {
    return object == null ? 0 : (24L + 8L * object.keys.length +
      24L + 8L * object.values.length);
  }

  public static long size(LongIntHashMap object) {
    return object == null ? 0 : (24L + 8L * object.keys.length +
      24L + 4L * object.values.length);
  }

  public static long size(LongArrayList object) {
    return object == null ? 0 : (24L + 8L * object.buffer.length);
  }

  public static long size(String string) {
    return string == null ? 0 : 54 + string.getBytes().length;
  }

  public static long sizeWithoutValues(IntObjectHashMap<?> object) {
    return object == null ? 0 : (24L + 4L * object.keys.length + 24L + 8L * object.values.length);
  }

  public static long sizeWithoutKeys(ObjectIntHashMap<?> object) {
    return object == null ? 0 : (24L + 8L * object.keys.length + 24L + 4L * object.values.length);
  }

  public interface HasEstimate {

    long estimateMemoryUsageBytes();
  }
}