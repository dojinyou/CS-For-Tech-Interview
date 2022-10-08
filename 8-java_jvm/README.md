# 자바 / JVM

<details>
  <summary>Java에서 자료구조가 내부적으로 어떻게 동작하는지 한 가지 사례를 정하여 작성해주세요.</summary>
  </br>
  <p>ArrayList는 내부적으로 Object[]\(elementData)을 이용하여 데이터를 저장하고 있습니다. 동적인 길이 증가를 위하여 size가 elementData의 길이값보다 커지려고 한다면 grow()를 이용하여 길이를 증가 시키고 Arrays의 Copy관련 함수를 통해서 확장된 크기의 배열에 기존 데이터를 복사합니다.</p>
</details>

<details>
  <summary>자바 언어에서 설계적 결함 한 가지를 작성해주세요.</summary>
  </br>
  <p>자바 언어의 설계적 결함은 Nullable하다는 점입니다. 최근 코틀린과 가장 많이 비교되는 부분으로 태생적으로 null이라는 값을 Default로 포함하고 있습니다. 이것은 많은 RuntimeException을 발생 시키는 원인이자 불필요한 검증 코드가 발생하는 부분이라고 생각합니다.</p>
  <p>또 다른 자바의 설계적 결함은 기본 자료구조 중 하나인 Stack의 Vector 상속입니다. Stack은 LIFO이라고 불리는 대표적인 자료구조입니다. Stack은 Vector를 상속 받고 있기 때문에 중간에 데이터가 삽입될 수 있어 LIFO라는 특성을 꺠질 수 있습니다. synchronized 키워드가 붙어 있어서 Thread-safe 하지만 Lock이 걸리기 때문에 성능이 떨어질 수 있습니다. 자바는 이에 대한 대안으로 ArrayDeque를 제안하지만 Deque 역시 LIFO를 깰 수 있기 때문에 사용 시에는 유의해서 사용해야 합니다.</p>
</details>

