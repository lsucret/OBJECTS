package Object.Ch4;

public class Rectangle {
    private int left;
    private int top;
    private int right;
    private int bottom;

    public Rectangle(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    // AnyClass의 AnyMethod에서 하던 Rectangle 변경 책임을 내부로 이동한 코드
    public void enLarge(int multiple) {
        right *= multiple;
        bottom *= multiple;
    }
}

class AnyClass {
    void anyMethod(Rectangle rectangle, int multiple) {
        rectangle.setRight(rectangle.getRight() * multiple);
        rectangle.setBottom(rectangle.getBottom() * multiple);
        // ...
    }
}