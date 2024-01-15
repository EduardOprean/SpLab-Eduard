package models;

public class Paragraph implements Element {
    private String text;

    public Paragraph(String text) {
        this.text = text;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitParagraph(this);
    }

    public String getText() {
        return text;
    }
}
