package Sprint2.GeometriskaFigurer;

public class Triangle implements Figure{

    protected int length, width;

    public Triangle(int length, int width) {
        this.length = length;
        this.width = width;
    }
    public double getArea() {
        return (length * width)/2;
    }
    public double getCircumference() {
        return width*3;
    }
}
