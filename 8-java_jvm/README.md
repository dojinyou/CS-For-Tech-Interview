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

<details>
    <summary>JVM 구조에 대해서 설명해주세요.</summary>
    </br>
    <p>JVM 구조는 다음과 같이 4가지로 나눌 수 있습니다. Class Loader, Run-Time Memory Area, Execution Engine, Java Native Interface/Library입니다.</p>
    <p>먼저 클래스 로더는 컴파일 된 .class파일을 읽어 JVM의 메모리 영역에 클래스의 정보를 적재하는 역할을 합니다. Run-Time Memory Area는 실행 중인 코드에 대한 데이터를 저장합니다. Execution Engine은 garbage collection, JIT Compiler, Interpreter로 이루어져 있어 메모리 관리(GC)와 바이트 코드를 OS에서 실행 가능한 형태로 변환하는 역할을 수행한다. 마지막으로 Java Native Interface와 Library는 C 기반의 언어로 작성된 코드를 Java에서 실행할 수 있도록 인터페이스를 제공하고 라이브러리를 읽고 실행ㅎ나다.</p>
</details>

<details>
    <summary>Java 코드가 실행되는 과정을 설명해주세요.</summary>
    </br>
    <p>
    .java 파일을 컴파일러를 통해 JVM에서 실행 가능한 .class 파일로 변환합니다.(변환 과정 추가 필요) 
    </p>
  
    <p> 변환된 .class 파일을 실행하게 되면 jvm의 class loader가 동작하여 클래스들을 JVM 내 런타임 메모리 영역으로 적재하게 됩니다. 적재된 데이터를 이용하여 Execution Engine의 Interpreter 혹은 JIT Compiler에 의해서 OS가 실행가능한 형태로 변환하여 실행되게 됩니다.
    </p>
</details>

<details>
    <summary>어노테이션에 대해서 설명해주세요</summary>
    </br>
    <p>
    어노테이션은 타겟에 어떤 정보를 원하는 시점까지 유지하도록 하는 기법입니다. 이를 통해 특정 로직이 적용되어야할 타겟을 식별하고 정보를 얻어 로직을 적용할 수 있습니다.
    </p>

    <p>
    어노테이션은 크게 표준 어노테이션과 커스텀 어노테이션으로 나눌 수 있습니다. 표준 어노테이션에는 `@Override`와 같은 일반 목적의 어노테이션과 `@Target`과 같은 어노테이션을 위한 메타 어노테이션이 있습니다.
    </p>

    <p>
    어노테이션은 크게 표준 어노테이션과 커스텀 어노테이션으로 나눌 수 있습니다. 표준 어노테이션에는 `@Override`와 같은 일반 목적의 어노테이션과 `@Target`과 같은 어노테이션을 위한 메타 어노테이션이 있습니다.
    </p>
</details>