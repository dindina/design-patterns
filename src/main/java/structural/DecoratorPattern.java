package structural;

interface ICoffee {
    String getDescription();
    double cost();
}

class SimpleICoffee implements ICoffee {
    public String getDescription() {
        return "Simple coffee";
    }
    public double cost() {
        return 1.0;
    }
}

abstract class CoffeeDecorator implements ICoffee {
    protected ICoffee decoratedCoffee;

    public CoffeeDecorator(ICoffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    public double cost() {
        return decoratedCoffee.cost();
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(ICoffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    public String getDescription() {
        return super.getDescription() + ", milk";
    }

    public double cost() {
        return super.cost() + 0.5;
    }
}

class CollagenDecorator extends CoffeeDecorator {
    public CollagenDecorator(ICoffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    public String getDescription() {
        return super.getDescription() + ", collagen";
    }

    public double cost() {
        return super.cost() + 3;
    }
}




public class DecoratorPattern {
    public static void main(String[] args) {
        SimpleICoffee simpleCoffee = new SimpleICoffee();

        CoffeeDecorator milkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println("cost of milk coffee "+ milkCoffee.cost());

        CollagenDecorator collagenCoffee = new CollagenDecorator(simpleCoffee);
        System.out.println("cost of collagen coffee "+ collagenCoffee.cost());

        MilkDecorator milkCollagenCoffee = new MilkDecorator(collagenCoffee);
        System.out.println("cost of collagen , milk coffee "+ milkCollagenCoffee.cost());

    }
}
