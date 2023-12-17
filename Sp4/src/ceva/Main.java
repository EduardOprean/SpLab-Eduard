package ceva;

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

// Section class extending AbstractElement and implementing Element interface
class Section extends AbstractElement {
    protected String title;

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

// Image interface
interface Image extends Element {
    void display();
}

// RealImage class implementing Image interface
class RealImage implements Image {
    private String imageName;

    public RealImage(String imageName) {
        this.imageName = imageName;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        // Simulate loading the image from disk
        System.out.println("Loading image: " + imageName);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + imageName);
    }

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Element element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Element element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Element get(int index) {
		// TODO Auto-generated method stub
		return null;
	}
}

// ImageProxy class implementing Image interface
class ImageProxy implements Image {
    private RealImage realImage;
    private String imageName;

    public ImageProxy(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(imageName);
        }
        realImage.display();
    }

    @Override
    public void print() {
        display();
    }

	@Override
	public void add(Element element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Element element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Element get(int index) {
		// TODO Auto-generated method stub
		return null;
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
        long startTime = System.currentTimeMillis();

        Image img1 = new ImageProxy("Pamela Anderson");
        Image img2 = new ImageProxy("Kim Kardashian");
        Image img3 = new ImageProxy("Kirby Griffin");

        Section playboyS1 = new Section("Front Cover");
        playboyS1.add(img1);
        Section playboyS2 = new Section("Summer Girls");
        playboyS2.add(img2);
        playboyS2.add(img3);

        Book playboy = new Book("Playboy");
        playboy.addContent(playboyS1);
        playboy.addContent(playboyS2);

        long endTime = System.currentTimeMillis();
        System.out.println("Creation of the content took " + (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        playboyS2.print(); // Print only the second chapter
        endTime = System.currentTimeMillis();
        System.out.println("Printing of the section 2 took " + (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        playboyS2.print(); // Print again the second chapter
        endTime = System.currentTimeMillis();
        System.out.println("Printing again the section 2 took " + (endTime - startTime) + " milliseconds");
    }
}
