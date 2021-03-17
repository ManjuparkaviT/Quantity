package utility;

public class Quantity{
    public double value;
    public QuantityType type;

    public Quantity(double value, QuantityType type) {
        this.value = value;
        this.type= type;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)return true;
        if(obj == null || getClass() != obj.getClass())return false;

        Quantity quantity=(Quantity)obj;

        if(quantity.value<=0 || value<=0){
            throw new IllegalArgumentException("Not allowed");
        }

        if(this.type!= quantity.type){

            if(this.type==QuantityType.METER && quantity.type==QuantityType.CENTIMETER){
                return 100*this.value==quantity.value;
            }
            else if(this.type==QuantityType.CENTIMETER && quantity.type==QuantityType.KILOMETER){
                return this.value==100000*quantity.value;
            }

        }

        return quantity.value==this.value;
    }

    public static double sumOfValuesInMeterAndCentimeterInCm(double firstValue, double secondValue){
        return (firstValue*100)+secondValue;
    }


    public static double sumOfValuesInKilometerAndCentimeterInCentimeter(double secondValue, double kilometer){
        return (kilometer*100000)+secondValue;
    }

    public static double differenceOfValuesInMeterAndCentimeterInMeter(double firstValue, double secondValue){
        return (firstValue)-(0.01*secondValue);
    }

    public static double differenceOfValuesInCentimeterAndMeterInCentimeter(double firstValue, double secondValue){
        return (firstValue)-(100*secondValue);
    }

}