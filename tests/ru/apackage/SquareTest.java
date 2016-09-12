package ru.apackage;

import org.junit.Assert;
import org.junit.Test;
import ru.socialquantum.testtasks.Square;
import ru.socialquantum.testtasks.SquareFactory;

/**
 *
 * @author Vladimir Bogodukhov
 **/
public class SquareTest {


    @Test
    public void test() {
        Square square = SquareFactory.newSquare(100.10);
        /* here are some actions with square instance to check it */
    }

}
