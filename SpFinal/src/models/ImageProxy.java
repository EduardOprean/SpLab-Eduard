package models;

public class ImageProxy implements Element {
    private String name;

    public ImageProxy(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitImageProxy(this);
    }

    public String getName() {
        return name;
    }
}
