package pojo;

public class Apple implements Fruit {

    private static final float QUOTIETY = 12.3f;

    public String color;

    @Override
    public float price(float weight) {
        return weight * QUOTIETY;
    }

    protected String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
