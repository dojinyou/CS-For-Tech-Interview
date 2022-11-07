package com.dojinyou.techinterview.brave.algorithm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Q) Map, HashMap, Set에 대해서 설명하세요
 */

public class Question3 {

  public static void main(String[] args) {
    Map<Object, Object> map1 = new HashMap<>();
    /*
       해쉬는 해쉬 함수를 이용해서 특정한 값으로 추출
       이 특정한 값을 키로 활용하여 사용.
       해쉬 계산 결과가 같다면? 해쉬 충돌 발생
       충돌 해결방법
       Open Addressing: 충돌 시 빈 공간을 찾아서 추가하는 방법
       Separate Chaining: 키에 대한 밸류를 리스트로 관리하는 방법(HashMap에서 사용)
       Thread Safe하지 않음
     */
    Map<Object, Object> map2 = new TreeMap<>();
    /*

     */
    Map<Object, Object> map3 = new Hashtable<>();
    Map<Object, Object> map4 = new LinkedHashMap<>();
    Map<Object, Object> map5 = new ConcurrentHashMap<>();
    Map<Object, Object> map6 = Collections.synchronizedMap(map5);
  }

  /*
    내가 인자로 인터페이스를 받는 데 실제로 어떤 구현체를 넣어줄 지?를 아는 친구 필요해 
   */
  
  // Interface <- 구현체
  // IoC / DI 

}
