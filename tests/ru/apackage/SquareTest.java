package ru.apackage;
//import org.apache.log4j.Level;
import org.junit.Assert;
import org.junit.Test;
import ru.socialquantum.testtasks.Square;
import ru.socialquantum.testtasks.SquareFactory;
import java.math.BigDecimal;
import java.math.RoundingMode;
import main.java.RandomNumeric;

/**
 *
 * @author Vladimir Bogodukhov
 **/
public class SquareTest {

    @Test
    public void testMethod_sideLength_withRandomSideValue() {
        //random range from 0.0 until 100.0 including min/max
        double side = (double)RandomNumeric.getRandomInt(0,1000)/10;
        System.out.println("side random "+ side);

        Square sq = SquareFactory.newSquare(side);
        System.out.println("Square side "+ sq.sideLength());
        Assert.assertEquals(side, sq.sideLength(),0);
    }

    @Test
    public void testMethod_square_withRandomSideValue() {
        //random range from 0.0 until 100.0 including min/max
        double side = (double)RandomNumeric.getRandomInt(0,1000)/10;
        System.out.println("side random "+ side);

        Square sq = SquareFactory.newSquare(side);  //get square by Square Interface method;
        double sq_byMath = Math.pow(side, 2);  //get square by math function;
        System.out.println("Square by Interface method "+ sq.square()+" | by Math.sqrt: "+ sq_byMath);

        Assert.assertEquals(sq.square(),sq_byMath,0);
    }

    @Test
    public void testMethod_equalsSquare_pos() {
        double side = (double)RandomNumeric.getRandomInt(0,1000)/10;
        Square sq1 = SquareFactory.newSquare(side);
        Square sq2 = SquareFactory.newSquare(side);
        Assert.assertTrue(sq2.equalsSquare(sq1));
    }

    @Test
    public void testMethod_equalsSquare_neg() {
        Square sq1 = SquareFactory.newSquare(9);
        Square sq2 = SquareFactory.newSquare(9.01);
        Assert.assertFalse(sq2.equalsSquare(sq1));
    }


    @Test
    public void testObjectMethodsByIteration() {

        double side;
        //specify range (0; undefined)
        for(int i = 0; i < 4000; i++) {
            side = (double)i/10;
            //System.out.print("x: " + x );
            System.out.print("set side: " + side);

            Square sq = SquareFactory.newSquare(side);
            System.out.println(" | "+ sq.sideLength()+" getSideByMethod");

            double sq_byMath = Math.pow(side,2);
            //double newDouble = new BigDecimal(y).setScale(1, RoundingMode.FLOOR).doubleValue();
            System.out.println("Square by math: " + sq_byMath);
            if (!(side == sq.sideLength()))
                System.out.println("Side set is not equal to return result of sideLength() method");
            System.out.println(" | "+ sq.square()+" squareByMethod");
            boolean sqEquals = sq_byMath == sq.square();
            if (!sqEquals)
                System.out.println("square by math is not equal to return result of square() method");
            System.out.println(" |  equals: " + sqEquals);
            System.out.print("\n"+"\n");


        }
    }
}

/*
          sideLength > 0.0D && sideLength < 10.0D?sideLength + 0.9D
        :(sideLength > 10.0D && sideLength < 20.0D?sideLength - 0.1D
        :(sideLength > 20.0D && sideLength < 30.0D?-sideLength
        : sideLength));*/
