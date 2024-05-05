import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain1 {
    public static void main(String[] args) {
        // Q)Create a List and Filter all even numbers from List

        // List<Integer> list1 = List.of(2, 4, 50, 21, 22, 67);not suppoted

        List<Integer> list2 = new ArrayList<>();
        list2.add(12);
        list2.add(34);
        list2.add(23);
        list2.add(78);

        List<Integer> list3 = Arrays.asList(23, 567, 12, 677, 24);

        // List1
        // without stream
        List<Integer> listEven = new ArrayList<>();

        for (Integer i : list2) {
            if (i % 2 == 0) {
                listEven.add(i);

            }

        }
        System.out.println(list2);
        System.out.println(listEven);

        // woth stream
        List<Integer> newList = list2.stream()
                .filter(i -> i % 2 == 0) // Filter even numbers
                .collect(Collectors.toList()); // Collect them into a new list

        System.out.println("Original List: " + list2);
        System.out.println("New List with Even Numbers: " + newList);

        Stream<Integer> stream2 = list2.stream();
        stream2.forEach(e -> {
            System.out.println(e);

        });


        List<Integer> dble =  list2.stream().map(i->i*2).collect(Collectors.toList()); // Collect them into a new list
        System.out.println(dble+"dvl");


        int arr[]={5,7,8,8,6,5,3,2};
        // arr.st//not exist
    }
}