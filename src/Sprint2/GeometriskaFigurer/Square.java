package Sprint2.GeometriskaFigurer;

public class Square implements Figure {

    protected int length, width;

    Square(int length, int width) {
        this.length = length;
        this.width = width;
    }
    public double getArea() {
        return length * width;
    }
    public double getCircumference() {
        return 2 * (length + width);
    }
}
