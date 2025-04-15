package stream;

import global.Dish;
import global.Dish.Type;
import global.DishList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SearchAndMatch {

    public static void main(String[] args) {

        /**
         *  요소 일치 검사
         *  anyMatch, allMatch, noneMatch [ 쇼트 서킷 ]
         */

        // 적어도 한 요소가 일치하는가?
        if (DishList.menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("Vegetarian");
        }

        // 모든 요소가 일치하는가?
        if (DishList.menu.stream().allMatch(dish -> dish.getCalories() < 1000)) {
            System.out.println("Only Low Calories food");
        }

        // 모든 요소가 일치하지 않는가?
        if (DishList.menu.stream().noneMatch(dish -> dish.getCalories() >= 1000)) {
            System.out.println("High Calories food is not exist");
        }

        /**
         *  요소 검색
         *  findAny, findFirst [ 쇼트서킷 ]
         *  ( 위 2개의 메서드는 동일하게 처음의 요소를 반환하는데 왜 2개나 있을까? )
         *  ( findAny -> 순서가 정해지지 않았을 때 | findFirst -> 순서가 정해졌을 때 )
         *  ( 병렬 실행에서는 첫 번째 요소를 찾기 어렵기 때문에 findAny 메서드를 주로 사용 )
         */

        // 현재 스트림에서 임의의 요소를 반환 [ 가장 첫번째 ]
        Optional<Dish> dish = DishList.menu.stream()
            .filter(food -> food.getType() == Type.FISH)
            .findAny();

        dish.ifPresent(value -> System.out.println("dish : " + value));

        // 현재 스트림에서 첫번째의 요소를 반환
        List<Integer> someNumber = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree = someNumber.stream().map(n -> n * n)
            .filter(n -> n % 3 == 0).findFirst();

        firstSquareDivisibleByThree.ifPresent(System.out::println);
    }
}
