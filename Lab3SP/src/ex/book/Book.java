package ex.book;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private List<Author> authors;
    private TableOfContents tableOfContents;
    private List<Chapter> chapters;

    public Book(String title) {
        this.title = title;
        this.authors = new ArrayList<>();
        this.tableOfContents = new TableOfContents();
        this.chapters = new ArrayList<>();
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addChapter(Chapter chapter) {
        chapters.add(chapter);
    }

    public void print() {
        System.out.println("Book: " + title);
        System.out.println("Authors:");
        for (Author author : authors) {
            author.print();
        }
        tableOfContents.print();
        for (Chapter chapter : chapters) {
            chapter.print();
        }
    }
}
