package stream;

import java.util.Arrays;
import java.util.List;
import stream.Dish.Type;

public class filter {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Type.MEAT),
            new Dish("beef", false, 700, Type.MEAT),
            new Dish("chicken", false, 400, Type.MEAT),
            new Dish("french fries", true, 530, Type.OTHER),
            new Dish("rice", true, 350, Type.OTHER),
            new Dish("season fruit", true, 120, Type.OTHER),
            new Dish("pizza", true, 550, Type.OTHER),
            new Dish("prawns", false, 300, Type.FISH),
            new Dish("salmon", false, 450, Type.FISH)
        );

        List<Dish> vegetablesMenu = menu.stream()
            .filter(Dish::isVegetarian)
            .toList();

        // collect(toList()) -> ArrayList 반환 ( add 등 같이 수정 가능 )
        // toList() -> 불변 리스트 반환 ( 수정 불가능 )

        System.out.println("vegetablesMenu : " + vegetablesMenu);

        // takeWhile -> 해당 조건이 참일 때까지만 filter, 그 후 버림
        List<Dish> typeIsMeatMenu = menu.stream()
            .takeWhile(meat -> meat.getType() == Type.MEAT)
            .toList();

        System.out.println("typeIsMeatMenu : " + typeIsMeatMenu);

        // dropWhile -> 해당 조건 거짓으로 시작하기 전을 버림
        List<Dish> typeIsNotMeatMenu = menu.stream()
            .dropWhile(notMeat -> notMeat.getType() == Type.MEAT)
            .toList();

        System.out.println("typeIsNotMeatMenu : " + typeIsNotMeatMenu);

        // skip -> 지정된 숫자만큼 앞에서 부터 스트림 스킵
        List<Dish> typeIsNotMeatMenuSkipTwo = menu.stream()
            .dropWhile(notMeat -> notMeat.getType() == Type.MEAT)
            .skip(2)            // 2개 스킵
            .toList();

        System.out.println("typeIsNotMeatMenuSkipTwo : " + typeIsNotMeatMenuSkipTwo);

        // distinct -> 중복되는 요소를 제거함, limit -> 지정된 숫자만큼 스트림 축소
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
            .filter(n -> n % 2 == 0)  // 짝수만
            .distinct()               // 중복 제거
            .limit(1)        // 1개로 축소
            .forEach(System.out::println);

    }
}
