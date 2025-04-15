package stream;

import global.Dish;
import global.DishList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Map = 변환
 */
public class Map {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> wordLengths = words.stream()
            .map(String::length)
            .toList();

        System.out.println("wordLengths : " + wordLengths);

        List<Integer> dishNameLengths = DishList.menu.stream()
            .map(Dish::getName)
            .map(String::length)
            .toList();

        System.out.println("dishNameLengths" + dishNameLengths);

        /**
         * 고유문자로 된 list 반환 방법 1
         */
        List<String> helloWorldList = Arrays.asList("Hello", "World");

        // String[]이 반환되며 실패
        List<String[]> distinctHelloWorld = helloWorldList.stream()
            .map(word -> word.split("")) // String[]을 반환 -> distinct 로는 각각 배열안에 있는 요소들 비교 불가
            .distinct()
            .toList();

        System.out.println("distinctHelloWorld : " + distinctHelloWorld);

        /**
         * 고유문자로 된 list 반환 방법 2
         */

        // Stream 메서드를 통해 해결하려 했지만 결국 스트림이 반환되며 실패
        List<Stream<String>> distinctHelloWorldTwo = helloWorldList.stream()
            .map(word -> word.split(""))
            .map(Arrays::stream)
            .distinct()
            .toList();

        System.out.println("distinctHelloWorld : " + distinctHelloWorldTwo);

        /**
         * 고유문자로 된 list 반환 방법 3
         */
        // flatMap 이용으로 성공
        List<String> uniqueCharacters = helloWorldList.stream()
            .map(word -> word.split(""))
            .flatMap(Arrays::stream)
            .distinct()
            .toList();

        System.out.println("uniqueCharacters : " + uniqueCharacters);

    }
}
