package models;

public class Table implements Element {
    private String name;

    public Table(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitTable(this);
    }

    public String getName() {
        return name;
    }
}
