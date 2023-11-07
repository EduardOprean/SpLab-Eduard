package ex.book;
public class Main {
    public static void main(String[] args) {
        Book myBook = new Book("Sample Book");

        Author author1 = new Author("John Doe");
        Author author2 = new Author("Jane Smith");

        TableOfContents toc = new TableOfContents();

        Chapter chapter1 = new Chapter("Chapter 1");
        SubChapter subChapter1 = new SubChapter("Introduction");

        Paragraph paragraph1 = new Paragraph();
        Image image1 = new Image();
        Table table1 = new Table();

        subChapter1.addContent(paragraph1);
        subChapter1.addContent(image1);
        subChapter1.addContent(table1);

        chapter1.addSubChapter(subChapter1);

        myBook.addAuthor(author1);
        myBook.addAuthor(author2);
        myBook.addChapter(chapter1);

        myBook.print();
    }
}