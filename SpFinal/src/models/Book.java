package models;

import java.util.ArrayList;
import java.util.List;

public class Book extends Section {
    private String title;
    private List<Author> authors;

    public Book(String title) {
        super(title);
        this.title = title;
        this.authors = new ArrayList<>();
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public String getName() {
        return title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

  
    public void addContent(Element element) {
        if (element instanceof Paragraph || element instanceof Section) {
            super.add(element);
        } else {
        
            System.out.println("Unsupported content type: " + element.getClass().getSimpleName());
        }
    }
}
