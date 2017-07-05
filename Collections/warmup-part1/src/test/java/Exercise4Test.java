import exercise.exercise4.MyImplementedList;
import exercise.exercise4.exceptions.InvalidIndexException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * //TODO Uncomment those lines after developing the {@link MyImplementedList} methods.
 * //TODO You should start checking your code by running the specific tests, after developing the add(Object o_O) method.
 *
 * @author Cristian.Dumitru
 * @since 7/3/2017.
 */
public class Exercise4Test {

    private MyImplementedList<String> testingStringValues;
    private MyImplementedList<Integer> testingIntegerValues;

    @Before
    public void beforeMethod() {
        testingStringValues = new MyImplementedList<String>();
        testingIntegerValues = new MyImplementedList<Integer>();

        populateLists();
    }

    /**
     * The add(Object o_O) method should work before executing a test!
     */
    private void populateLists() {
        testingStringValues.add("Testing ");
        testingStringValues.add("the ");
        testingStringValues.add("current ");
        testingStringValues.add("list!");
        testingStringValues.add("Testing ");
        testingStringValues.add("huh?!");

        testingIntegerValues.add(0);
        testingIntegerValues.add(1);
        testingIntegerValues.add(2);
        testingIntegerValues.add(3);

    }

    @Test
    public void testAddAndSizeMethodsOverStringList() {
        Assert.assertTrue(testingStringValues.size() == 6);
    }

    @Test
    public void testAddAndSizeMethodsOverIntegerList() {
        Assert.assertTrue(testingIntegerValues.size() == 4);
    }

    @Test
    public void testRemoveMethodOverStringList() throws InvalidIndexException{
        testingStringValues.remove(1);
        System.out.println(testingIntegerValues.size());
        Assert.assertTrue(testingStringValues.size() == 5);

    }

    @Test
    public void testIsEmptyMethodOverIntegerList() throws InvalidIndexException{
        //TODO use iterator

        //ListIterator<Integer> = testingIntegerValues
        Iterator<Integer> it = testingIntegerValues.iterator();
        System.out.println("TURA 1");
        for (int i = 0; i < testingIntegerValues.size(); i++) {
            System.out.println(testingIntegerValues.get(i));
        }

        while(it.hasNext()){
            it.remove();
            it.next();
        }
        it.remove();

        System.out.println("TURA 2");
        for (int i = 0; i < testingIntegerValues.size(); i++) {
            System.out.println(testingIntegerValues.get(i));
        }

        Assert.assertTrue(testingIntegerValues.isEmpty());
    }

    @Test
    public void testIndexOfMethodOverStringList() {
        Assert.assertTrue(testingStringValues.indexOf("Testing ") == 0);
    }

    @Test
    public void testLastIndexOfMethodOverStringList() {
        Assert.assertTrue(testingStringValues.lastIndexOf("Testing ") == 4);
    }

    @Test
    public void testGetMethodOverIntegerList() {
        try {
            Assert.assertTrue(testingIntegerValues.get(1).compareTo(1) == 0);
        }
        catch(Exception e){
            System.out.println("La GET " + e);
        }
    }

    @Test
    public void testSetMethodOverStringList() {
        try {
            testingStringValues.set(1, "this ");
            Assert.assertTrue(testingStringValues.get(1).equals("this "));
        }
        catch(Exception e){
            System.out.println("La SET METHOD OVER STRING LIST  " + e);
        }
    }

    @Test
    public void testListForOneExtension() {
        for (int i = 4; i < 12; i++) {
            testingIntegerValues.add(i);
        }
        Assert.assertTrue(testingIntegerValues.size() == 12);
    }

    @Test
    public void testListForTwoExtensions() {
        for (int i = 4; i < 32; i++) {
            testingIntegerValues.add(i);
        }
        Assert.assertTrue(testingIntegerValues.size() == 32);
    }

    @Test
    public void testForeachMethodsOverStringList() {
        for (Object obj : testingStringValues) {
            System.out.println(obj);
        }
    }

    @Test
    public void testSortMethodOverStringList() {
//        testingStringValues.sort(//TODO add comparator);
    }
}
