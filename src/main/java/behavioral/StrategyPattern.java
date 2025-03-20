package behavioral;


interface IDiscount{
     double applyDiscount(double price);

}

class FixedDiscount implements IDiscount{
    double discountValue;

    public FixedDiscount(double discountValue){
        this.discountValue = discountValue;
    }

    @Override
    public double applyDiscount(double price) {
        return price - discountValue;
    }
}

class PercentageDiscount implements IDiscount
{
    double discountPercentage;

    public PercentageDiscount(double discountPercentage){
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double applyDiscount(double price) {
        return price - (discountPercentage*price/100);
    }
}

public class StrategyPattern {

    public static void main(String[] args) {

        IDiscount fixedDiscount = new FixedDiscount(11);
        System.out.println("new price " + fixedDiscount.applyDiscount(100));

        IDiscount percentage = new PercentageDiscount(20);
        System.out.println("new price " + percentage.applyDiscount(200));


    }

}
