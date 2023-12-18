package pachet;


import java.util.ArrayList;
import java.util.List;

// Element interface
interface Element {
    void print();
}

// AlignStrategy interface
interface AlignStrategy {
    void align();
}

// Concrete AlignLeft class implementing AlignStrategy
class AlignLeft implements AlignStrategy {
    @Override
    public void align() {
        System.out.println("Align Left");
    }
}

// Concrete AlignRight class implementing AlignStrategy
class AlignRight implements AlignStrategy {
    @Override
    public void align() {
        System.out.println("Align Right");
    }
}

// AlignCenter class implementing AlignStrategy
class AlignCenter implements AlignStrategy {
    @Override
    public void align() {
        System.out.println("Align Center");
    }
}

// AbstractElement class providing common behavior for Section, Paragraph, ImageProxy, and Table
abstract class AbstractElement implements Element {
    protected AlignStrategy alignStrategy;

    public void setAlignStrategy(AlignStrategy alignStrategy) {
        this.alignStrategy = alignStrategy;
    }

    public Element get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(Element element) {
		// TODO Auto-generated method stub
		
	}

	public void remove(Element element) {
		// TODO Auto-generated method stub
		
	}

	@Override
    public abstract void print();
}

// Section class extending AbstractElement and implementing Element interface
class Section extends AbstractElement {
    protected String title;
    private List<Element> elements = new ArrayList<>();

    public Section(String title) {
        this.title = title;
    }

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

    @Override
    public void print() {
        if (alignStrategy != null) {
            alignStrategy.align();
        }
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
        if (alignStrategy != null) {
            alignStrategy.align();
        }
        System.out.println("Paragraph: " + text);
    }
}

// ImageProxy class implementing Element interface
class ImageProxy implements Element {
    private RealImage realImage;
    private String imageName;

    public ImageProxy(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public void print() {
        if (realImage == null) {
            realImage = new RealImage(imageName);
        }
        realImage.print();
    }
}

// RealImage class implementing Element interface
class RealImage implements Element {
    private String imageName;

    public RealImage(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public void print() {
        System.out.println("Image: " + imageName);
    }
}

// Table class implementing Element interface
class Table implements Element {
    private String content;

    public Table(String content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println("Table: " + content);
    }
}

// Book class with generalization to Section
class Book extends Section {
    private List<Author> authors = new ArrayList<>();

    public Book(String title) {
        super(title);
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
    public static void main(String[] args) throws Exception {
        Section cap1 = new Section("Capitolul 1");
        Paragraph p1 = new Paragraph("Paragraph 1");
        cap1.add(p1);
        Paragraph p2 = new Paragraph("Paragraph 2");
        cap1.add(p2);
        Paragraph p3 = new Paragraph("Paragraph 3");
        cap1.add(p3);
        Paragraph p4 = new Paragraph("Paragraph 4");
        cap1.add(p4);

        System.out.println("Printing without Alignment");
        System.out.println();
        cap1.print();

        p1.setAlignStrategy(new AlignCenter());
        p2.setAlignStrategy(new AlignRight());
        p3.setAlignStrategy(new AlignLeft());

        System.out.println();
        System.out.println("Printing with Alignment");
        System.out.println();
        cap1.print();
    }
}
