package com.dojinyou.techinterview.temp;

import java.util.HashMap;
import java.util.Map;

public class Question {

  // O(N^2)
  public boolean Solution(
      String ransomNote,
      String magazine
  ) {

    int ransomNoteLength = ransomNote.length();

    Map<Character, Integer> map = new HashMap<>(ransomNoteLength);
    initMap(map, ransomNote);

    for (int i = 0; i < magazine.length(); i++) {

      char c = magazine.charAt(i);

      if (!map.containsKey(c)) {
        continue;
      }

      int count = map.get(c);
      map.put(c, count - 1);
    }

    for (int value : map.values()) {
      if (0 < value) {
        return false;
      }
    }

    return true;
  }

  private static void initMap(
      Map<Character, Integer> map,
      String ransomNote
  ) {
    for (int i = 0; i < ransomNote.length(); i++) {
      char c = ransomNote.charAt(i);

      int count = map.getOrDefault(c, 0);
      map.put(c, count + 1);
    }
  }

}
