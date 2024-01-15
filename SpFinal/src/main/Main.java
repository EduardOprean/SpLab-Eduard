package main;

import models.*;
import services.BookStatistics;
import services.BookSaveVisitor; 

public class Main {
	 private static Book noapteBuna;
    public static void main(String[] args) throws Exception {
        createTableOfContentAndPrintStatistics();

       
        BookSaveVisitor saveVisitor = new BookSaveVisitor();

   
        noapteBuna.accept(saveVisitor);

        
        saveVisitor.saveToFile("book_data.json");
    }

    public static void createTableOfContentAndPrintStatistics() {
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

        BookStatistics bookStatistics = new BookStatistics();
        noapteBuna.accept(bookStatistics);
        bookStatistics.printStatistics();

        // Print Table of Content
        TableOfContentUpdate tocUpdate = new TableOfContentUpdate();
        noapteBuna.accept(tocUpdate);
        System.out.println("TableOfContent");
        System.out.println(tocUpdate.getTableOfContent());
    }
}
