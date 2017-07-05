package exercise.exercise0;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Create a List (ArrayList or LinkedList), add elements to it and print all of them using ListIterator
 *             for loop and foreach loop.
 *
 */
public class Exercise0 {

    public Exercise0(){

    }

    public void iterateThroughList(){

        // TODO Exercise #0 a) Create a list (ArrayList or LinkedList) and add elements to it
        // TODO Exercise #0 a) Don't forget to specify the type of the list (Integer, String etc.)


        List<Integer> myList = new ArrayList<Integer>();
        myList.add(10);
        myList.add(20);
        myList.add(30);
        myList.add(40);
        myList.add(50);

        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements

        System.out.println("LIST ITERATOR");
        ListIterator<Integer> myListIterator = myList.listIterator();
        while(myListIterator.hasNext()) {
            System.out.println("Element: " + myListIterator.next() +", Index: " + myListIterator.nextIndex() +
            ", Previous index" + myListIterator.previousIndex());
        }

        // TODO Exercise #0 c) Iterate through the list using classic for loop and print all its elements

        System.out.println("FOR:");
        for (int i = 0; i < myList.size(); i++)
            System.out.println("Element: " + myList.get(i) +", Index: " + i +
                    ", Previous index" + (i-1));

        System.out.println("FOREACH:");
        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements
        for(Integer i : myList)
            System.out.println("Element: " + i);
    }

    public static void main(String[] args) {
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method
        Exercise0 exercise0 = new Exercise0();

        exercise0.iterateThroughList();
    }
}
