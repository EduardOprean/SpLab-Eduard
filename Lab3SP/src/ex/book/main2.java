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



