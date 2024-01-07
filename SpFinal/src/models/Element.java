package models;

public interface Element {
    void accept(Visitor visitor);
}
