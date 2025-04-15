package stream;

import global.DishList;
import java.util.stream.Stream;


/**
 * Reduce = 모든 스트림 요소를 처리(소비)하여 값으로 도출 [ 함수형 인터페이스에서는 폴드라고도 부름 ]
 */

public class Reduce {

    public static void main(String[] args) {

        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);

        int sum = numbers.reduce(32, Integer::sum); // 초기값이 존재할 때와 존재하지 않을 때 반환값 다름

//        int sum2 = numbers.reduce(32, Integer::sum); <- 한번 더 하려고 하면 이미 스트림이 소비되어 불가능

        System.out.println("sum : " + sum);

        // Map, reduce 메서드를 활용하여 메뉴의 개수를 구하는 방법
        int dishCount = DishList.menu.stream()
            .map(dish -> 1)
            .reduce(0, Integer::sum);

        System.out.println("dishCount : " + dishCount);
    }

    /**
     *  기존의 단계적 반복으로 합계를 구하는 것과 Reduce 메서드를 사용하는 것은 어떤 차이가 있을까?
     *  기존의 방법은 sum 변수를 공유해야하므로 쉽게 병렬화하기 어렵다.
     *  강제적으로 동기화 하려고해도 그 시점에서 이미 리소스가 든다.
     *  하지만 Reduce 같은 경우 내부 반복이 추상화되어있다.
     *  병렬화를 신경 쓸 리소스가 사라진 것이다.
     */
    
}
