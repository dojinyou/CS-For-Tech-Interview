# 데이터베이스

<details>
  <summary>Transaction의 Isolation Level에 대해서 설명해주세요.</summary>
  </br>

  <p>트랜잭션의 격리 수준은 총 4개의 단계로 나눌 수 있습니다. 격리 수준이 가장 높은 Serializable부터 Repeatable read, Read commited, Read uncommited순으로 격리 수준이 낮아지게 됩니다.격리 수준이 높다고 하는 것은 트랜잭션을 엄격하게 지켜진다는 것이며 일반적으로 동시 처리 성능에 손해가 발생합니다.</p>

  <p>격리 수준이 가장 낮은 Read uncommited는 commit 여부와 상관없이 변경 내용을 다른 트랜잭션에서 조회가 가능합니다. 트랜잭션 작업이 완료되지 않았는 데도 다른 트랜잭션에서 데이터를 조회할 수 있는 현상인 더티 리드(Dirty Read)가 발생합니다. 일반적인 RDBMS의 격리 수준으로 인정하기 어려울 정도로 정합성의 문제가 많아 잘 사용하지 않습니다. </p>

  <p>다음으로 Read commited가 있습니다. 이름 그대로 커밋되어진 정보만 읽을 수 있기 때문에 앞선 Read uncommited에서 발생했던 더티 리드현상은 발생하지 않습니다. 그러나 트랜잭션 내에서 같은 결과를 반환해야하는 Repeatable read를 만족하지 못합니다. 예를 들어 먼저 시작된 트랜잭션에서 특정 조건에 해당하는 쿼리를 조회했을 때 데이터가 없었지만 뒤에 시작한 다른 트랜잭션에 특정 조건에 맞도록 데이터를 생성, 수정하고 commit한 경우 앞선 트랜잭션의 같은 쿼리에 해당 데이터가 조회됩니다.</p>

  <p>다음으로 Repeatable read가 있습니다. 앞서 발생한 트랜잭션 내 다른 결과가 조회되는 현상을 막아 트랜잭션 내의 조회결과는 항상 같음을 보장합니다. MySQL의 InnoDB 스토리지 엔진에서는 해당 격리 수준을 기본으로 사용합니다. InnoDB 스토리지 엔진의 경우 RollBack될 가능성을 고려하여 Undo tablespace에 log로 백업을 해두고 실제 데이터를 변경합니다. 이러한 방식을 MVCC(Multi Version Concurency Control)이라고 합니다. 이러한 동작 방식에 따르면 Read commited 격리 수준에서도 버저닝된 commit 이전 데이터를 보여줌으로써 Repeatable read를 만족할 수 있습니다. 하지만 InnoDB 스토리지 엔진은 이러한 Undo Log에 대해서 더 이상 사용이 불필요하다고 생각하면 삭제합니다. 이 주기적인 삭제가 격리 수준에 영향을 받아 Repeatable read 격리 수준일 경우 가장 오래된 트랜잭션의 고유 번호보다 큰 값을 삭제되지 않도록 합니다. Repeatable Read의 경우에도 트랜잭션 이후에 추가된 데이터가 조건에 의해 조회되어 나타나는 Phantom read현상이 발생합니다. 하지만 InnoDB 스토리지 엔진의 경우 갭 락과 넥스트 키 락을 통해서 Phantom read 현상도 발생하지 않습니다.</p>

  <p>격리 수준이 가장 높은 Serializable은 모든 트랜잭션을 직렬화하여 처리합니다. 즉, 하나의 Queue를 통해서 요청을 제어하고 순서대로 요청을 처리하는 것입니다. InnoDB 스토리지 엔진의 경우 기본적으로 읽기 잠금이 발생하지 않는 데, Serializable 격리 수준을 사용할 경우 읽기 락이 발생하며 락을 획득해야지만 데이터를 읽을 수 있습니다. 앞서 발생했던 Phantom read현상은 발생하지 않지만 동시 처리 성능이 몹시 떨어지기 때문에 거의 사용하지 않습니다.</p>

</details>

<details>
  <summary>MySQL에서는 Repeatable Read 격리 수준에서 Phantom read 현상이 발생하지 않는 이유를 자세하게 설명해주세요</summary>
  </br>

  <p></p>

</details>