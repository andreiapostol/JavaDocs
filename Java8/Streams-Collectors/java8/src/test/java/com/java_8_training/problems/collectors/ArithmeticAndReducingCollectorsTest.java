
package com.java_8_training.problems.collectors;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Comparator;
import java.util.IntSummaryStatistics;

import static com.java_8_training.problems.collectors.Dish.menu;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summarizingInt;
import static junit.framework.Assert.assertEquals;

class MyComparator implements Comparator<Dish> {
    public int compare(Dish dish1, Dish dish2) {
        return (dish1.getCalories() < dish2.getCalories()) ? -1 : 1;
    }
}
@Ignore
public class ArithmeticAndReducingCollectorsTest {

    // See: Dish.menu.stream()
    @Test
    public void leastCaloricDishMEAT() {
        //TODO #C5
        Dish leastCaloricMEAT = Dish.menu.stream().filter(dish->dish.getType() == Dish.Type.MEAT)
                .min(comparing(Dish::getCalories)).get();

        //leastCaloricMEAT = menu.stream().reduce(Integer.MAX_VALUE, (acc, a)->Integer.min(acc, a.getCalories()));
        //leastCaloricMEAT = menu.stream().collect(maxBy(MyComparator));
        assertEquals("chicken", leastCaloricMEAT.getName());
    }

    @Test
    public void statisticsForVegetarianDishes() {
        //TODO #C6
        IntSummaryStatistics vegetarianStats = Dish.menu.stream().filter(Dish::isVegetarian)
                .collect(summarizingInt(Dish::getCalories));



        assertEquals(4, vegetarianStats.getCount());
        assertEquals(1550, vegetarianStats.getSum());
        assertEquals(120, vegetarianStats.getMin());
        assertEquals(387.5, vegetarianStats.getAverage());
        assertEquals(550, vegetarianStats.getMax());

    }
}
