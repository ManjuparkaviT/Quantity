package utility;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QuantityTest {

    @Test
    public void testTrueIfOneCentimeterIsEqualToOneCentimeter(){
        Quantity quantity = new Quantity(1,QuantityType.CENTIMETER);
        Quantity otherQuantity = new Quantity(1, QuantityType.CENTIMETER);

        boolean actual = quantity.equals(otherQuantity);

        assertTrue(actual);
    }

    @Test
    void testFalseIfOneCentimeterIsNotEqualToTwoCentimeter() {
        Quantity quantity = new Quantity(1, QuantityType.CENTIMETER);
        Quantity otherQuantity = new Quantity(2, QuantityType.CENTIMETER);

        boolean actual = quantity.equals(otherQuantity);

        assertFalse(actual);
    }

    @Test
    void testThrowsExceptionIfQuantityValueInCentimeterIsZero(){
        Quantity quantity = new Quantity(0,QuantityType.CENTIMETER);
        Quantity otherQuantity = new Quantity(4,QuantityType.CENTIMETER);

        Exception exception = assertThrows(IllegalArgumentException.class,() ->{
            quantity.equals(otherQuantity);
        });

        assertEquals("Not allowed", exception.getMessage());
    }

    @Test
    void testThrowsExceptionIfQuantityValueInCentimeterIsLessThanZero(){
        Quantity quantity = new Quantity(-4,QuantityType.CENTIMETER);
        Quantity otherQuantity = new Quantity(4,QuantityType.CENTIMETER);

        Exception exception = assertThrows(IllegalArgumentException.class,() ->{
            quantity.equals(otherQuantity);
        });

        assertEquals("Not allowed", exception.getMessage());
    }

    @Test
    void testTrueIf1MeterIsEqualTo100Centimeter(){
        Quantity quantity = new Quantity(1,QuantityType.METER);
        Quantity otherQuantity = new Quantity(100,QuantityType.CENTIMETER);

        boolean actual = quantity.equals(otherQuantity);

        assertTrue(actual);
    }

    @Test
    void testExceptionIsThrownIfOneOfTheQuantityValuesIsZero(){
        Quantity quantity = new Quantity(0,QuantityType.METER);
        Quantity otherQuantity = new Quantity(100,QuantityType.CENTIMETER);

        Exception exception = assertThrows(IllegalArgumentException.class,() ->{
            quantity.equals(otherQuantity);
        });

        assertEquals("Not allowed", exception.getMessage());
    }

    @Test
    void testTrueIf10000CentimeterIsEqualToOneTenthOfKm(){
        Quantity quantity = new Quantity(10000,QuantityType.CENTIMETER);
        Quantity otherQuantity = new Quantity(0.1,QuantityType.KILOMETER);

        boolean actual = quantity.equals(otherQuantity);

        assertTrue(actual);
    }

    @Test
    public void testIfSumOfOneMeterAnd100CentimeterIsEqualTwoMeter() {
        Quantity firstQuantity = new Quantity(1,QuantityType.METER);
        Quantity secondQuantity = new Quantity(100, QuantityType.CENTIMETER);
        Quantity thirdQuantity = new Quantity(2,QuantityType.METER);

        double sumOfFirstAndSecondQuantityValues=
                Quantity.sumOfValuesInMeterAndCentimeterInCm(firstQuantity.value, secondQuantity.value);
        Quantity resultantQuantity = new Quantity(sumOfFirstAndSecondQuantityValues,QuantityType.CENTIMETER);

        assertTrue(thirdQuantity.equals(resultantQuantity));
    }

    @Test
    public void testIfSumOfOneKmAnd200CentimeterIsEqual100200Meter() {
        Quantity firstQuantity = new Quantity(200, QuantityType.CENTIMETER);
        Quantity secondQuantity =  new Quantity(1, QuantityType.KILOMETER);
        Quantity thirdQuantity = new Quantity(100200,QuantityType.CENTIMETER);

        double sumOfKilometerAndCentimeter=
                Quantity.sumOfValuesInKilometerAndCentimeterInCentimeter(firstQuantity.value,secondQuantity.value);
        Quantity resultantQuantity = new Quantity(sumOfKilometerAndCentimeter,QuantityType.CENTIMETER);

        assertTrue(thirdQuantity.equals(resultantQuantity));
    }

    @Test
    public void testIfDifferenceOf1MeterAnd50CentimeterIsEqualToHalfMeter() {
        Quantity firstQuantity = new Quantity(1, QuantityType.METER);
        Quantity secondQuantity =  new Quantity(50, QuantityType.CENTIMETER);
        Quantity thirdQuantity = new Quantity(0.5,QuantityType.METER);

        double sumOfKilometerAndCentimeter=
                Quantity.differenceOfValuesInMeterAndCentimeterInMeter(firstQuantity.value,secondQuantity.value);
        Quantity resultantQuantity = new Quantity(sumOfKilometerAndCentimeter,QuantityType.METER);

        assertTrue(thirdQuantity.equals(resultantQuantity));
    }

    @Test
    public void testIfDifferenceOf2000CentimeterAnd1MeterIsEqualTo1900Centimeter() {
        Quantity firstQuantity = new Quantity(2000, QuantityType.CENTIMETER);
        Quantity secondQuantity =  new Quantity(1, QuantityType.METER);
        Quantity thirdQuantity = new Quantity(1900,QuantityType.CENTIMETER);

        double sumOfKilometerAndCentimeter=
                Quantity.differenceOfValuesInCentimeterAndMeterInCentimeter(firstQuantity.value,secondQuantity.value);
        Quantity resultantQuantity = new Quantity(sumOfKilometerAndCentimeter,QuantityType.CENTIMETER);

        assertTrue(thirdQuantity.equals(resultantQuantity));
    }

}





