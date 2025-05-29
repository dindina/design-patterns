package soliddesign;

class Rectanglee {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

class Square extends Rectanglee {
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width); // Square's width and height must be equal
    }

    @Override
    public void setHeight(int height) {
        super.setWidth(height);
        super.setHeight(height); // Square's width and height must be equal
    }
}
/*
 * Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.
 */

public class LiskovSubstitutionViolated {
    public static void main(String[] args) {
        Rectanglee rectangle = new Rectanglee();
        rectangle.setWidth(5);
        rectangle.setHeight(10);
        System.out.println("Rectangle Area: " + rectangle.getArea()); // Output: 50

        Rectanglee square = new Square();
        square.setWidth(5);
        square.setHeight(10); // Problem!
        System.out.println("Square Area (as Rectangle): " + square.getArea()); // Output: 100, not 25!
    }

    public static void processRectangle(Rectanglee rect){
        rect.setWidth(5);
        rect.setHeight(10);

        if(rect.getArea() != 50){
            System.out.println("Error, the rectangle area is not 50");
        }
    }
}
