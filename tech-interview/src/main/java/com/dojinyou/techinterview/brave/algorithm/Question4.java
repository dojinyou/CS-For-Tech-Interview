package com.dojinyou.techinterview.brave.algorithm;

/**
 * Q) 배열 A의 최대값을 구하시오.
 * Q+) 배열 A의 최대값과 최소값을 구하시오.
 * <p>
 * // 원소의 범위?
 */

public class Question4 {

  public int Solution(int[] nums) {
    int max = Integer.MIN_VALUE;

    for (int num : nums) {
      max = Math.max(num, max);
    }

    return max;
  }

  public int[] Solution2(int[] nums) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for (int num : nums) {
      max = Math.max(num, max);
      min = Math.min(num, min);
    }

    return new int[]{max, min};
  }

}
