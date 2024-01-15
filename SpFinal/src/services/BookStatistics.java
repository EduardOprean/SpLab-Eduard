package services;

import models.*;

public class BookStatistics implements Visitor {
    private int imageCount = 0;
    private int tableCount = 0;
    private int paragraphCount = 0;

    public void printStatistics() {
        System.out.println("Book Statistics:");
        System.out.println("*** Number of images: " + imageCount);
        System.out.println("*** Number of tables: " + tableCount);
        System.out.println("*** Number of paragraphs: " + paragraphCount);
    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        paragraphCount++;
    }

    @Override
    public void visitImage(Image image) {
        imageCount++;
    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {
        imageCount++;
    }

    @Override
    public void visitTable(Table table) {
        tableCount++;
    }

    @Override
    public void visitSection(Section section) {
        for (Element element : section.getElements()) {
            element.accept(this);
        }
    }

	@Override
	public void visitBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitImage(ImageProxy imageProxy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endVisitSection(Section section) {
		// TODO Auto-generated method stub
		
	}
}
