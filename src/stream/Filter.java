package stream;

import global.Dish;
import global.Dish.Type;
import global.DishList;
import java.util.Arrays;
import java.util.List;

/**
 * Filter = 필터링
 */
public class Filter {

    public static void main(String[] args) {

        List<Dish> vegetablesMenu = DishList.menu.stream()
            .filter(Dish::isVegetarian)
            .toList();

        // collect(toList()) -> ArrayList 반환 ( add 등 같이 수정 가능 )
        // toList() -> 불변 리스트 반환 ( 수정 불가능 )

        System.out.println("vegetablesMenu : " + vegetablesMenu);

        // takeWhile -> 해당 조건이 참일 때까지만 filter, 그 후 멈춤 [ 쇼트서킷 ]
        List<Dish> typeIsMeatMenu = DishList.menu.stream()
            .takeWhile(meat -> meat.getType() == Type.MEAT)
            .toList();

        System.out.println("typeIsMeatMenu : " + typeIsMeatMenu);

        // dropWhile -> 해당 조건 거짓으로 시작하기 전을 버림
        List<Dish> typeIsNotMeatMenu = DishList.menu.stream()
            .dropWhile(notMeat -> notMeat.getType() == Type.MEAT)
            .toList();

        System.out.println("typeIsNotMeatMenu : " + typeIsNotMeatMenu);

        // skip -> 지정된 숫자만큼 앞에서 부터 스트림 스킵
        List<Dish> typeIsNotMeatMenuSkipTwo = DishList.menu.stream()
            .dropWhile(notMeat -> notMeat.getType() == Type.MEAT)
            .skip(2)            // 2개 스킵
            .toList();

        System.out.println("typeIsNotMeatMenuSkipTwo : " + typeIsNotMeatMenuSkipTwo);

        // distinct -> 중복되는 요소를 제거함, limit -> 지정된 숫자만큼 스트림 축소 [ 쇼트서킷 ]
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
            .filter(n -> n % 2 == 0)  // 짝수만
            .distinct()               // 중복 제거
            .limit(1)        // 1개로 축소
            .forEach(System.out::println);

    }
}
