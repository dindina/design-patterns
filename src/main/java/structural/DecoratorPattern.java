package structural;

interface Coffee {
    String getDescription();
    double cost();
}

class SimpleCoffee implements Coffee {
    public String getDescription() {
        return "Simple coffee";
    }
    public double cost() {
        return 1.0;
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
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
    public MilkDecorator(Coffee decoratedCoffee) {
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
    public CollagenDecorator(Coffee decoratedCoffee) {
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
        SimpleCoffee simpleCoffee = new SimpleCoffee();

        CoffeeDecorator milkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println("cost of milk coffee "+ milkCoffee.cost());

        CollagenDecorator collagenCoffee = new CollagenDecorator(simpleCoffee);
        System.out.println("cost of collagen coffee "+ collagenCoffee.cost());

        MilkDecorator milkCollagenCoffee = new MilkDecorator(collagenCoffee);
        System.out.println("cost of collagen , milk coffee "+ milkCollagenCoffee.cost());




    }
}
