package pachet;
import java.util.ArrayList;
import java.util.List;

// Element interface
interface Element {
    void print();
    void add(Element element);
    void remove(Element element);
    Element get(int index);
}

// AbstractElement class providing common behavior for Section, Paragraph, Image, and Table
abstract class AbstractElement implements Element {
    protected List<Element> elements = new ArrayList<>();

    @Override
    public void add(Element element) {
        elements.add(element);
    }

    @Override
    public void remove(Element element) {
        elements.remove(element);
    }

    @Override
    public Element get(int index) {
        if (index >= 0 && index < elements.size()) {
            return elements.get(index);
        }
        return null;
    }
}

// Section class extending AbstractElement
class Section extends AbstractElement {
    private String title;

    public Section(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println("Section: " + title);
        for (Element element : elements) {
            element.print();
        }
    }
}

// Paragraph class extending AbstractElement
class Paragraph extends AbstractElement {
    private String text;

    public Paragraph(String text) {
        this.text = text;
    }

    @Override
    public void print() {
        System.out.println("Paragraph: " + text);
    }
}

// Image class extending AbstractElement
class Image extends AbstractElement {
    private String name;

    public Image(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("Image with name: " + name);
    }
}

// Book class with generalization to Section
class Book extends Section {
    private String title;
    private List<Author> authors = new ArrayList<>();

    public Book(String title) {
        super(title);
        this.title = title;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    @Override
    public void print() {
        System.out.println("Book: " + title);
        System.out.println("Authors:");
        for (Author author : authors) {
            System.out.println("Author: " + author.getName());
        }
        super.print();
    }

    // Additional method to add content to the book
    public void addContent(Element element) {
        super.add(element);
    }
}

// Author class with aggregation to Book (1 author can have multiple books)
class Author {
    private String name;
    private List<Book> books = new ArrayList<>();

    public Author(String name) {
        this.name = name;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public String getName() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        Book noapteBuna = new Book("Noapte buna, copii!");
        Author rpGheo = new Author("Radu Pavel Gheo");
        noapteBuna.addAuthor(rpGheo);
        Section cap1 = new Section("Capitolul 1");
        Section cap11 = new Section("Capitolul 1.1");
        Section cap111 = new Section("Capitolul 1.1.1");
        Section cap1111 = new Section("Subchapter 1.1.1.1");
        noapteBuna.addContent(new Paragraph("Multumesc celor care ..."));
        noapteBuna.addContent(cap1);
        cap1.add(new Paragraph("Moto capitol"));
        cap1.add(cap11);
        cap11.add(new Paragraph("Text from subchapter 1.1"));

        cap11.add(cap111);
        cap111.add(new Paragraph("Text from subchapter 1.1.1"));
        cap111.add(cap1111);
        cap1111.add(new Image("Image subchapter 1.1.1.1"));

        noapteBuna.print();
    }
}
