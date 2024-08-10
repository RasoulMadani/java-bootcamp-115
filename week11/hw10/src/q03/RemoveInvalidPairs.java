package q03;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveInvalidPairs {

    public static void removeInvalidPairs(ArrayList<Integer> list) {

        if (list.size() % 2 != 0) {
            list.remove(list.size() - 1);
        }


        ArrayList<Integer> validList = new ArrayList<>();


        for (int i = 0; i < list.size(); i += 2) {
            int left = list.get(i);
            int right = list.get(i + 1);
            if (left <= right) {
                validList.add(left);
                validList.add(right);
            }
        }


        list.clear();
        list.addAll(validList);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 7, 4, 3, 6, 5, 8, 5, 5, 2, 9, 7, 3));
        System.out.println("Original List: " + list);
        removeInvalidPairs(list);
        System.out.println("Modified List: " + list);
    }
}

