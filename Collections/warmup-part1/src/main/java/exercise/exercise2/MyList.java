package exercise.exercise2;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Radu.Hoaghe on 20.04.2015.
 *
 * Exercise 2: Create a class that inherits ArrayList<Integer> (class MyList<Integer>).
 *
 *             This list (MyList) should have the following functionality, besides the functionality
 *             that ArrayList already offers: it should retain in every moment how many different
 *             elements exist in the list.
 *                  
 *                  Examples: 1. If you have a List that contains: 7 5 3 2 4 1, there are 6 different elements.
 *                            2. If you have a List that contains: 5 6 1 2 5 6, there are 4 different elements.
 *
 *             A variable that retains the number of different elements that exist in the list in
 *             every moment was already defined (differentElements).
 *
 *             First of all, you will need to override the add methods so that every time a different
 *             element is added the counter will be updated.
 *                      Hint : check out the List documentation to see the methods signatures.
 *
 *             Secondly, you will also need to override the remove methods (Hint: of course, the List
 *             documentation) because the number of different elements in the list could change if
 *             the last element of its kind in the list is removed and by not overrriding it the
 *             counter will remain unchanged.
 *
 *             Finally, you will need to override the clear method and create a getter method for the
 *             counter (in order to access it outside the class).
 *
 *             In order to add/remove/clear the elements into/from the list you will need to use the
 *             add/remove/clear methods inherited from ArrayList.
 *
 *             To test your implementation run the Exercise2Test class.
 *
 */
public class MyList<Integer> extends ArrayList<Integer> {

    // A counter to hold the number of adds that were made on the list
    private int differentElements;

    public MyList(){
        differentElements = 0;
    }

    // TODO Exercise #2 a) Override add() and addAll() methods so that the list should retain the number of
    // TODO Exercise #2 a) different elements (Hint: check out the methods signatures on the List documentation)

    @Override
    public boolean add(Integer integer) {
        boolean dif = true;
        for (Integer element : this){
            if(element == integer) {dif = false; break;}
        }
        if (dif) this.differentElements++;
        return super.add(integer);
    }

    @Override
    public void add(int index, Integer element) {
        boolean dif = true;
        for (Integer i : this){
            if(i == element) {dif = false; break;}
        }
        if (dif) this.differentElements++;
        super.add(index, element);
    }




    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        for (Integer celement : c){
            boolean dif = true;
            for (Integer element : this){
                if (celement == element) {dif = false; break;}
            }
            if (dif) this.differentElements++;
        }
        return super.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        for (Integer celement : c){
            boolean dif = true;
            for (Integer element : this){
                if (celement == element) {dif = false; break;}
            }
            if (dif) this.differentElements++;
        }
        return super.addAll(index, c);
    }

    // TODO Exercise #2 b) Override the remove methods so that the number of different elements is updated when
    // TODO Exercise #2 b) an element is removed

    @Override
    public Integer remove(int index) {
        boolean dif = true;
        Integer toRemove = this.get(index);
        for (int i = 0; i < this.size(); i++){
            Integer element = this.get(i);
            if(element == toRemove && i != index) {dif = false; break;}
        }
        if (dif) this.differentElements--;

        return super.remove(index);
    }

    @Override
    public boolean remove(Object o) {
        int nrApp = 0;
        for (Object element : this){
            if (element == o) nrApp++;
        }
        if (nrApp == 1) differentElements--;
        return super.remove(o);
    }



    // TODO Exercise #2 b) hint: you need to update the number of different elements only when
    // TODO Exercise #2 b) the element that needs to be removed is the last element of its kind in the list

    // TODO Exercise #2 c) Override the clear method and reset the number of different elements

    @Override
    public void clear() {
        differentElements = 0;
        super.clear();
    }
    // TODO Exercise #2 d) Return the number of different elements that exist into the list
    public int getDifferentElements() {
        return differentElements;
    }
}
