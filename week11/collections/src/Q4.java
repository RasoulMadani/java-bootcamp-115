// Java program to demonstrate shuffling of arraylist
// elements Using Random class

import java.util.*;
class Q4 {
    public static void main(String args[])
    {
        // creating
        // ArrayList
        ArrayList<Integer> al = new ArrayList<Integer>();

        // adding object in ArrayList
        al.add(10);
        al.add(20);
        al.add(30);
        al.add(40);
        al.add(50);
        al.add(60);
        al.add(70);
        al.add(80);

        System.out.println("Before shuffling Arraylist:");

        // getting Iterator
        // from arraylist to
        // traverse elements
        Iterator itr = al.iterator();

        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println("");

        Random r1 = new Random();

//        for (int i = al.size() - 1; i >= 1; i--) {
//            // swapping current index value
//            // with random index value
//            Collections.swap(al, i, r1.nextInt(i + 1));
//        }
        Collections.shuffle(al);
        System.out.println("After shuffling Arraylist:");

        itr = al.iterator();

        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }
}

