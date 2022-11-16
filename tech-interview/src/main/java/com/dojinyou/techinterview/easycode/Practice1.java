package com.dojinyou.techinterview.easycode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 배열에 담긴 서로 다른 두 정수의 합이 Target Number와 같은 지 확인하는 함수를 구현하시오.
 * 배열 속 서로 다른 두 정수를 통해 Target Number를 만들 수 있다면 true, 아니라면 false 반환
 */
public class Practice1 {

  public boolean solution(
      int[] arr,
      int targetNumber
  ) {
    return solutionMy(arr, targetNumber);
  }

  // O(NlogN)
  private boolean solutionMy(
      int[] arr,
      int targetNumber
  ) {
    Arrays.sort(arr);

    int lIdx = 0;
    int rIdx = arr.length - 1;

    while (lIdx < rIdx) {
      int lValue = arr[lIdx];
      int rValue = arr[rIdx];
      int sumValue = lValue + rValue;

      if (sumValue == targetNumber) {
        return true;
      }

      if (sumValue < targetNumber) {
        lIdx++;
      } else {
        rIdx--;
      }
    }

    return false;
  }

  // O(N^2)
  private boolean solution1(
      int[] arr,
      int targetNumber
  ) {

    for (int num1 : arr) {
      for (int num2 : arr) {
        if (num1 == num2) {
          continue;
        }

        if (num1 + num2 == targetNumber) {
          return true;
        }
      }
    }

    return false;
  }

  // O(N^2)
  private boolean solution2(
      int[] arr,
      int targetNumber
  ) {

    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] + arr[j] == targetNumber) {
          return true;
        }
      }
    }

    return false;
  }

// O(N)
private boolean solution3(
    int[] arr,
    int targetNumber
) {

  Set<Integer> set = Arrays
      .stream(arr)
      .boxed()
      .collect(Collectors.toSet());

  for (int num : arr) {
    int findNumber = targetNumber - num;
    if (num == findNumber) {
      continue;
    }

    if (set.contains(findNumber)) {
      return true;
    }
  }

  return false;
}

  // O(N)
private boolean solution4(
    int[] arr,
    int targetNumber
) {

  Set<Integer> set = new HashSet<>(arr.length);

  for (int num : arr) {
    int findNumber = targetNumber - num;

    if (set.contains(findNumber)) {
      return true;
    }

    set.add(num);
  }

  return false;
}

  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 15, 6};
    int targetNumber1 = 7;
    int targetNumber2 = 12;
    boolean result1 = true;
    boolean result2 = false;

    var practice1 = new Practice1();

    System.out.println(practice1.solution1(arr, targetNumber1) == result1);
    System.out.println(practice1.solution1(arr, targetNumber2) == result2);
    System.out.println(practice1.solution2(arr, targetNumber1) == result1);
    System.out.println(practice1.solution2(arr, targetNumber2) == result2);
    System.out.println(practice1.solution3(arr, targetNumber1) == result1);
    System.out.println(practice1.solution3(arr, targetNumber2) == result2);
    System.out.println(practice1.solution4(arr, targetNumber1) == result1);
    System.out.println(practice1.solution4(arr, targetNumber2) == result2);
    System.out.println(practice1.solutionMy(arr, targetNumber1) == result1);
    System.out.println(practice1.solutionMy(arr, targetNumber2) == result2);
  }

}
