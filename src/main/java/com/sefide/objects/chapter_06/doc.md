<aside>
💡클래스보다는 객체들이 주고 받는 메시지가 중요하다.

</aside>

- 협력과 메시지

    ```java
    	// 수신자.오퍼레이션명(인자)
    	condition.isSatisfiedBy(screening);
    ```

    - 메서드 : 메시지를 수신했을 때 실제로 실행되는 함수 또는 프로시저
        - 메시지 전송 vs 메서드 호출
            - 메시지 전송은 컴파일 시점과 실행 시점의 의미가 달라질 수 있다.
            - 메시지 전송자는 자신이 어떤 메시지를 전송해야 하는지만 알면 되고 수신자는 누가 전송했는지를 알 필요가 없다.
    - 퍼블릭 인터페이스 : 객체가 의사소통을 위해 외부에 공개하는 메시지의 집합
    - 오퍼레이션
        - 하나의 오퍼레이션에 다양한 메서드가 존재한다.

    ```java
    1. 메시지 전송 → 2. 오퍼레이션 호출 → 3. 메서드 실행
    ```


---

- 인터페이스와 설계 품질
    - 최소한의 인터페이스 x 추상적인 인터페이스
    - **디미터의 법칙(Law of Demeter)** : 객체의 내부 구조에 강하게 결합되지 않도록 협력 경로를 제한하라
        - shy code

        ```
        - this 객체
        - 메서드의 매개변수
        - this의 속성
        - this의 속성인 컬렉션의 요소
        - 메서드 내에서 생성된 지역 객체
        ```

      💬 보통.. 매개변수를 이용해서 새로운 객체를 조회.. 활용하는데..

    - train wreck (기차 충돌) : 메시지 전송자가 수신자의 내부 구조와 반환받은 요소를 연쇄적으로 사용 전송한다.

        ```java
        screening.getMovie().getDiscountConditions();
        // screening.calculateFee(audienceCount);
        ```

    - **묻지 말고 시켜라(Tell, Don’t Ask)**
    - **의도를 드러내는 인터페이스 ⇒ 어떻게가 아닌 무엇을 하는지 드러낸다.**
        - 어떻게를 드러내면..

            ```java
            public class PeriodCondition {
            	public boolean isSatisfiedByPeriod(Screening screening) { ... }
            }
            
            public class SequenceCondition {
            	public boolean isSatisfiedBySequence(Screening screening) { ... }
            }
            ```

            - 클라이언트 관점에서 두 메서드가 동일한 (할인 조건을 판단한다는) 작업을 수행한다는 사실을 알 수 없음
            - 캡슐화 위반
        - 무엇을 하는지 드러내면
            - 의도를 드러내는 선택자(Intention Revealing Selector)
            - 의도를 드러내는 인터페이스(Intention Revealing Interface)
    - **함께 모으기**
        - 티켓 판매 시스템을 예시로..
            - 💬 setTicket method 명이 모호하다는 생각이 든다. ⇒ 이 내용이 실제 책에도 언급됨 `p196` 예시를 잘 든 것 같다.
                - Theater ( TicketSeller to Audience ) ⇒ sellTo
                - TicketSeller ( Audience ) ⇒ Buy
                - Audience ( Bag to Ticket ) ⇒ hold

---

> 설계는 트레이드오프의 산물
>
- 원칙의 함정
    - 디미터 법칙은 하나의 도트(.)를 강제하는 규칙이 아니다.

        ```java
        IntStream.of(1, 15, 20, 3, 9).filter( x -> x > 10).distinct().count()
        ```

        - 디미터의 법칙은 결합도와 관련되어 있다.
        - IntStream의 내부 구조가 외부로 노출된 거 아님..
    - 결합도와 응집도 충돌
        - Screening 과 PeriodCondition 간의 할인조건 판단하는 부분

            ```java
            public class Screening {
            	public boolean isDiscountable(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
            		return whenScreened.getDayOfWeek().equals(dayOfWeek) &&
            			startTime.compareTo(whenScreened.toLocalTime()) <= 0 &&
            			endTime.compareTo(whenScreened.toLocalTime()) >= 0;
            		}
            }
            
            public class PeriodCondition implements DiscountCondition {
            	public boolean isSatisfiedBy(Screening screening) {
            		return screening.isDicountable(dayOfWeek, startTime, endTime);
            	}
            }
            ```

        - 자료 구조를 활용해야 하는 경우

            ```java
            for(Movie each : movies) {
            	total += each.getFee();
            }
            ```


---

- 명령-쿼리 분리 원칙 (Command-Query-Separation)
    - 퍼블릭 인터페이스에 오퍼레이션을 정의할 때 참고할 수 있는 지침을 제공한다.
    - 루틴 : 어떤 절차를 묶어 호출 가능하도록 이름을 부여한 기능 모듈
        - 함수 : 값을 반환할 수 있지만 부수효과를 발생시킬 수 없다.
        - 프로시저 : 부수효과를 발생시킬 수 있지만 값을 반환할 수 없다.
    - 명령과 쿼리
        - 명령 → 오퍼레이션 → 프로시저
        - 쿼리 → 객체와 관련된 정보를 반환하는 오퍼레이션 → 함수
            - 값이 변경되지 않기 때문에 결과를 예측하기 쉬움

      > 💬  `p204`
      >
        - 이벤트와 반복 일정 (💬 아하!)
            - Event.isSatisfied 위험해..
        - 참조 투명성 (referential transparency)
            - 어떤 표현시 e가 있을 때 e의 값으로 e가 나타나는 모든 위치를 교체하더라도 결과가 달라지지 않는 특성
            - 불변성
            - 수학.. 하지만 객체에서는 부수효과를 기반으로 하기 때문에 참조 투명성은 예외에 가깝다.
            - 명령형 프로그래밍(상태를 변경시키는 연산들을 적절한 순서대로 나열)과 [함수형 프로그래밍](https://namu.wiki/w/%ED%95%A8%EC%88%98%ED%98%95%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D)(부수효과가 존재하지 않는 수학적인 함수에 기반)

