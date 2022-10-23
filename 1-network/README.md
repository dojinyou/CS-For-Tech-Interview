# 네트워크

<details>
  <summary>웹 브라우저에 `네이버` 를 검색하고 화면에 네이버 화면이 출력이 될 때 까지 내부적으로 어떤 동작들이 수행이 되는지 설명해주세요.</summary>
  </br>
  <p>먼저 입력된 값이 검색어인지 Domain Name인지 판단합니다.
  네이버는 도메인 네임으로 판단하여 URL(URI)를 ip address로 변환
    1. 웹 브라우저는 우선 컴퓨터 내에 존재하는 hosts 파일을 확인한다.
    2. (1번과정에서 해결이 안된다면) OS의 DNS Cache 기록을 확인한다.
    3. (2번과정에서 해결이 안된다면) 공유기 혹은 DNS에 직접 질의한다.
2. 해당 IP 주소로 tcp 연결(가상 회선 설정)을 진행(http 3버전 미만일 경우)
3. 해당 주소로 HTTP GET Method를 포함하는 HTTP Request를 생성 및 송신
4. HTTP Response 응답을 받음.
5. 브라우저는 렌더링 엔진을 통해 응답으로 받은 문서를 파싱
6. DOM과 CSSOM을 생성 후 결합하여 렌더 트리를 생성.
7. 브라우저의 JS의 엔진은 js 파일을 파싱하여 Abstact Syntax tree를 생성하고 바이트 코드로 변환하여 실행
  이 과정에서 위에 생성된 DOM, CSSOM이 변경되면 다시 렌더 트리로 결합
8. 렌더 트리 기반으로 html 요소의 레이아웃을 계산하고 화면에 페인팅

위 과정에서 네이버 같은 큰 회사는 CDN을 이용하여 전세계에 안정적으로 컨텐츠를 공급할 수 있음. 
이에 따라 TCP 연결을 Origin 웹서버가 아닌 CDN 서버로 연결할 수도 있음.</p>
</details>


<details>
  <summary>TCP 와 UDP의 공통점과 차이점을 작성해주세요.</summary>
  </br>
  <p>먼저 공통점으로는 주소 표현에 있어서 포트번호를 이용합니다. 오류 제어를 위해 체크섬 기능을 포함하고 있다는 점입니다.</p>
  <p>첫번 째 차이점은 신뢰성의 차이입니다. TCP는 신뢰성을 보장하지만 UDP는 신뢰성을 보장하지 않습니다. 이때 신뢰성이란 
  </p>
1. 흐름제어 :  송신측과 수신측의 데이터처리 속도 차이를 해결
    - tcp : sliding window 방식(연결 설정 시 윈도우 크기 교환), 수신 신호에 맞취 윈도우를 이동하며 데이터 전송
    - udp : 지원하지 않음.
2. 혼잡 제어 : 송신 측과 네트워크의 데이터 송신 속도 차이를 해결
    - tcp : ECN(explicit Congestion Notification) 방식을 통해 라우터가 네트워크 혼잡 시 이를 수신 측에 전달하고 수신 측은 이것을 다시 송신 측에 전달하여 송신측의 트래픽을 완화. ECN을 사용하기 위해서는 연결 설정 단계에서 협상을 해야함. 헤더의 ECE 비트를 통해 혼잡을 알리고 CWR 비트를 통해 윈도우의 크기를 줄였음을 전달한다.
    - udp : 지원하지 않음
3. 오류 제어 : 데이터 전송 중 발생되는 에러를 검출, 보정
    - tcp : 체크섬, 확인응답(응답 기준과 응답 방식), 타임아웃
    - udp : 헤더와 전송 데이터의 체크섬 기능 제공
4. 분할과 병합 : 데이터의 크기가 처리할 수 있는 크기보다 클 때, 이를 분할하고 병합
    - tcp : Maximum Segment Size 기준으로 데이터를 분할하고 순서번호(Sequence Number)를 부여하여 수신측에서 재조립할 수 있도록 함.
    - udp : Maximum Transfer Unit 에 맞춰서 패킷을 쪼개어 Fragmentation을 시행함. 수신 측에서 fragment offset을 통해 재조립
5. 서비스 프리미티브 : 계층 간 인터페이스 제공
    - tcp : 연결형 서비스 프리미티브 제공
    - udp : 비연결형 서비스 프리미티브 제공
    
설계 시 고려사항
1. 주소 표현
    - tcp : 포트 번호
    - udp : 포트 번호
2. 멀티 플렉싱
    - tcp : 전이중(full duplex) 방식의 양방향 가상 회선 제공, 1대1 연결
    - udp : 
3. 연결 설정
    - tcp : 3단계 연결 설정(syn / ack,syn / ack)
    - udp : 없음
4. 연결 해제
    - tcp : 4단계 연결 해제
    - udp : 없음</p>
</details>


<details>
  <summary>TCP 3, 4 way handshake에 대해서 설명해보세요.</summary>
  </br>
  <p>
  </p>
</details>

<details>
  <summary>HTTP와 HTTPS의 차이점에 대해서 설명해보세요.</summary>
  </br>
  <p>
  </p>
</details>

<details>
  <summary>HTTPS에 대해서 설명하고 SSL Handshake에 대해서 설명해보세요.</summary>
  </br>
  <p>
  </p>
</details>

<details>
  <summary>GET과 POST의 차이점에 대해서 설명해보세요.</summary>
  </br>
  <p>
  </p>
</details>

<details>
  <summary>HTTP 메서드와 이것이 하는 역할에 대해서 설명해보세요.</summary>
  </br>
  <p>
  </p>
</details>

<details>
  <summary>RESTful이란 무엇이며, 이것에 대해서 아는대로 설명해보세요.</summary>
  </br>
  <p>
  </p>
</details>

<details>
  <summary>CORS란 무엇이며 이것에 대해서 설명해보세요.</summary>
  </br>
  <p>
  </p>
</details>

<details>
  <summary>OSI7계층과 그 존재 이유, TCP/IP 4계층에 대해 설명해보세요.</summary>
  </br>
  <p>
  </p>
</details>

<details>
  <summary>웹 서버 소프트웨어(Apache, Nginx)는 OSI 7계층 중 어디서 작동하는지 설명해보세요.</summary>
  </br>
  <p>
  </p>
</details>

<details>
  <summary>Socket 으로 바로 통신하는 것 대비 HTTP 는 비효율적인데도 왜 많은 앱들은 HTTP 를 쓰는 걸까요?</summary>
  </br>
  <p>
  </p>
</details>

<details>
  <summary>차세대 프로토콜로 논의중인 HTTP/3 은 UDP 기반의 QUIC 이라는 기술로 구현되어 있습니다. UDP 는 TCP 대비 안정성이 떨어지는 프로토콜이라고 하는데, 그럼에도 왜 UDP 를 채택한 걸까요?</summary>
  </br>
  <p>
  </p>
</details>

<details>
  <summary>SSL (또는 TLS) 가 어떻게 동작하는지 말씀해주세요.</summary>
  </br>
  <p>
  </p>
</details>

<details>
  <summary>HTTP 는 Stateless (상태가 없는) 통신 프로토콜이라고 합니다. 따라서, 상태가 없다면 가령 HTTP 를 쓰는 서비스는 매번 로그인을 해 줘야 하거나 사용자 정보를 저장하는 일이 불가능합니다. 그런데 실제론 그렇지 않죠. 어떻게 이런 불편함을 해소했을까요?</summary>
  </br>
  <p>
  </p>
</details>

<details>
  <summary>DNS의 동작 방식에 종류와 장단점을 설명해주세요</summary>
  </br>
  <p>
  </p>
</details>

<details>
  <summary>Load Balancer에 대해 설명해주세요.</summary>
  </br>
  <p>
  </p>
</details>

<details>
  <summary>Load Balancer의 load balancing algorithm에 대해서 설명해주세요.</summary>
  </br>
  <p>
  </p>
</details>
