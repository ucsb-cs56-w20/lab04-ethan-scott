package edu.ucsb.cs56.ratcalc.model;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

public class RationalTest {

    private Rational r_5_15;
    private Rational r_24_6;
    private Rational r_3_7;  
    private Rational r_13_4;
    private Rational r_20_25;
    private Rational r_25_20;
    private Rational r_0_1; 
	     
    @Before public void setUp() {
	r_5_15 = new Rational(5,15);
	r_24_6 = new Rational(24,6);
	r_3_7  = new Rational(3,7);
	r_13_4 = new Rational(13,4);
	r_20_25 = new Rational(20,25);
	r_0_1 = new Rational(0,1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_denom_zero() {
	Rational r = new Rational(1,0);
    }
    
    @Test
    public void test_getNumerator_20_25() {
	assertEquals(4, r_20_25.getNumerator());
    }
    
    @Test
    public void test_getNumerator_13_4() {
	assertEquals(13, r_13_4.getNumerator());
    }
    
    @Test
    public void test_getDenominator_20_25() {
	assertEquals(5, r_20_25.getDenominator());
    }
    
    @Test
    public void test_getDenominator_13_4() {
	assertEquals(4, r_13_4.getDenominator());
    }


    @Test
    public void test_toString_5_15() {
	assertEquals("1/3",r_5_15.toString());
    }

    @Test
    public void test_toString_24_6() {
	assertEquals("4",r_24_6.toString());
    }

    @Test
    public void test_toString_3_7() {
	assertEquals("3/7",r_3_7.toString());
    }
    
    @Test
    public void test_toString_20_25() {
	assertEquals("4/5",r_20_25.toString());
    }

    @Test
    public void test_toString_0_1() {
	assertEquals("0",r_0_1.toString());
    }

    @Test
    public void test_gcd_5_15() {
	assertEquals(5, Rational.gcd(5,15));
    }

    @Test
    public void test_gcd_15_5() {
	assertEquals(5, Rational.gcd(15,5));
    }

    @Test
    public void test_gcd_24_6() {
	assertEquals(6, Rational.gcd(24,6));
    }

    @Test
    public void test_gcd_17_5() {
	assertEquals(1, Rational.gcd(17,5));
    }
    
    @Test
    public void test_gcd_1_1() {
	assertEquals(1, Rational.gcd(1,1));
    }

    @Test
    public void test_gcd_20_25() {
	assertEquals(5, Rational.gcd(20,25));
    }

    @Test
    public void test_rational_m10_m5() {
	Rational r = new Rational(-10,-5);
	assertEquals("2",r.toString());
    }

    @Test
    public void test_rational_m5_6() {
	Rational r = new Rational(-5,6);
	assertEquals("-5/6",r.toString());
    }

    @Test
    public void test_rational_7_m8() {
	Rational r = new Rational(7,-8);
	assertEquals("-7/8",r.toString());
    }

    @Test
    public void test_r_5_15_times_r_3_7() {
	Rational r = r_5_15.times(r_3_7);
	assertEquals("1/7",r.toString());
    }

    @Test
    public void test_r_3_7_times_r_13_4() {
	Rational r = r_3_7.times(r_13_4);
	assertEquals("39/28",r.toString());
    }

    @Test
    public void test_r_m3_1_times_1_m3() {
	Rational r_m3_1 = new Rational(-3,1);
	Rational r_1_m3 = new Rational(1,-3);
	Rational r = r_m3_1.times(r_1_m3);
	assertEquals("1",r.toString());
    }

   @Test
    public void test_product_of_r_5_15_and_r_3_7() {
       Rational r = Rational.product(r_5_15,r_3_7);
       assertEquals("1/7",r.toString());
    }

    @Test
    public void test_product_of_r_3_7_and_r_13_4() {
	Rational r = Rational.product(r_3_7,r_13_4);
	assertEquals("39/28",r.toString());
    }

    @Test
    public void test_product_of_r_m3_1_and_1_m3() {
	Rational r_m3_1 = new Rational(-3,1);
	Rational r_1_m3 = new Rational(1,-3);
	Rational r = Rational.product(r_m3_1,r_1_m3);
	assertEquals("1",r.toString());
    }

    @Test
    public void test_lcm_5_15() {
	assertEquals(15, Rational.lcm(5,15));
    }

    @Test
    public void test_lcm_15_5() {
	assertEquals(15, Rational.lcm(15,5));
    }

    @Test
    public void test_lcm_24_6() {
	assertEquals(24, Rational.lcm(24,6));
    }

    @Test
    public void test_lcm_17_5() {
	assertEquals(85, Rational.lcm(17,5));
    }
    
    @Test
    public void test_lcm_1_1() {
	assertEquals(1, Rational.lcm(1,1));
    }

    @Test
    public void test_lcm_20_25() {
	assertEquals(100, Rational.lcm(20,25));
    }
    
    @Test
    public void test_plus_5_15_and_5_15()
    {
        Rational r = new Rational(5,15);
        Rational x = new Rational(5,15);
        Rational temp = r.plus(x);
        assertEquals("2/3", temp.toString());
    }

    @Test
    public void test_plus_10_15_and_5_15()
    {
        Rational r = new Rational(10,15);
        Rational x = new Rational(5,15);
        Rational temp = r.plus(x);
        assertEquals("1", temp.toString());
    }

    @Test
    public void test_plus_20_25_and_25_20()
    {
        Rational r = new Rational(20,25);
        Rational x = new Rational(25,20);
        Rational temp = r.plus(x);
        assertEquals("41/20", temp.toString());
    }

    @Test
    public void test_plus_m20_25_and_25_20()
    {
        Rational r = new Rational(-20,25);
        Rational x = new Rational(25,20);
        Rational temp = r.plus(x);
        assertEquals("9/20", temp.toString());
    }


@Test
    public void test_sum_5_15_and_5_15()
    {
        Rational r = new Rational(5,15);
        Rational x = new Rational(5,15);
        Rational temp = Rational.sum(r,x);
        assertEquals("2/3", temp.toString()) ;
    }

    @Test
    public void test_sum_10_15_and_5_15()
    {
        Rational r = new Rational(10,15);
        Rational x = new Rational(5,15);
        Rational temp = Rational.sum(r,x);
        assertEquals("1", temp.toString());
    }

    @Test
    public void test_sum_20_25_and_25_20()
    {
        Rational r = new Rational(20,25);
        Rational x = new Rational(25,20);
        Rational temp = Rational.sum(r,x);
        assertEquals("41/20", temp.toString());
    }

    @Test
    public void test_sum_m20_25_and_25_20()
    {
        Rational r = new Rational(-20,25);
        Rational x = new Rational(25,20);
        Rational temp = Rational.sum(r,x);
        assertEquals("9/20", temp.toString());
    }

    @Test
    public void test_minus_4_1_and_3_2()
    {
	Rational r = new Rational(4,1);
	Rational x = new Rational(3,2);
	Rational temp = r.minus(x);
	assertEquals("5/2", temp.toString());
    }

    @Test
    public void test_minus_25_20_and_9_10()
    {
	Rational r = new Rational(25,20);
	Rational x = new Rational(9,10);
	Rational temp = r.minus(x);
	assertEquals("7/20", temp.toString());
    }

    @Test
    public void test_minus_25_20_and_m9_10()
    {
	Rational r = new Rational(25,20);
	Rational x = new Rational(-9,10);
	Rational temp = r.minus(x);
	assertEquals("43/20", temp.toString());
    }
    
    @Test
    public void test_diff_4_1_and_3_2()
    {
        Rational r = new Rational(4,1);
	Rational x = new Rational(3,2);
	Rational temp = Rational.difference(r,x);
	assertEquals("5/2", temp.toString());
    }

    @Test
    public void test_diff_25_20_and_9_10()
    {
	Rational r = new Rational(25,20);
	Rational x = new Rational(9,10);
	Rational temp = Rational.difference(r,x);
	assertEquals("7/20", temp.toString());
    }

    @Test
    public void test_diff_25_20_and_m9_10()
    {
	Rational r = new Rational(25,20);
	Rational x = new Rational(-9,10);
	Rational temp = Rational.difference(r,x);
	assertEquals("43/20", temp.toString());
    }
}

