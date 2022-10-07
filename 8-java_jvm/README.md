# 자바 / JVM

<details>
  <summary>Java에서 자료구조가 내부적으로 어떻게 동작하는지 한 가지 사례를 정하여 작성해주세요.</summary>
  </br>
  <p>ArrayList는 내부적으로 Object[]\(elementData)을 이용하여 데이터를 저장하고 있습니다. 동적인 길이 증가를 위하여 size가 elementData의 길이값보다 커지려고 한다면 grow()를 이용하여 길이를 증가 시키고 Arrays의 Copy관련 함수를 통해서 확장된 크기의 배열에 기존 데이터를 복사합니다.</p>
</details>