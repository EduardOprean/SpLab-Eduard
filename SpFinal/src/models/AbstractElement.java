package models;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractElement implements Element {
    protected AlignStrategy alignStrategy;
    protected List<Element> elements = new ArrayList<>();

    public void setAlignStrategy(AlignStrategy alignStrategy) {
        this.alignStrategy = alignStrategy;
    }

    public abstract void add(Element element);

    public abstract void remove(Element element);

    public abstract Element get(int index);

    public abstract void print();

    public List<Element> getElements() {
        return elements;
    }

    @Override
    public abstract void accept(Visitor visitor);
}
