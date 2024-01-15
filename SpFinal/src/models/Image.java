package models;

public class Image implements Element {
    private String name;

    public Image(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitImage(this);
    }

    public String getName() {
        return name;
    }
}
