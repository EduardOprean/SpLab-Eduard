package ex.book;

import java.util.ArrayList;
import java.util.List;



class Author {
    private String name;

    public Author(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("Author: " + name);
    }
}

class TableOfContents {
    public void print() {
        System.out.println("Table of Contents");
    }
}

class Chapter {
    private String title;
    private List<SubChapter> subChapters;

    public Chapter(String title) {
        this.title = title;
        this.subChapters = new ArrayList<>();
    }

    public void addSubChapter(SubChapter subChapter) {
        subChapters.add(subChapter);
    }

    public void print() {
        System.out.println("Chapter: " + title);
        for (SubChapter subChapter : subChapters) {
            subChapter.print();
        }
    }
}

class SubChapter {
    private String title;
    private List<Printable> content;

    public SubChapter(String title) {
        this.title = title;
        this.content = new ArrayList<>();
    }

    public void addContent(Printable item) {
        content.add(item);
    }

    public void print() {
        System.out.println("SubChapter: " + title);
        for (Printable item : content) {
            item.print();
        }
    }
}

interface Printable {
    void print();
}

class Image implements Printable {
    public void print() {
        System.out.println("Image: SChema");
    }
}

class Paragraph implements Printable {
    public void print() {
        System.out.println("Paragraph: 1.1");
        System.out.println("Paragraph: 1.2");
        System.out.println("Paragraph: 1.3");
        System.out.println("Paragraph: 1.4");
    }
}

class Table implements Printable {
    public void print() {
        System.out.println("Table: Table 1");
    }
}



