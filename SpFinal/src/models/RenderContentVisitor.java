package models;

public class RenderContentVisitor implements Visitor {
    @Override
    public void visitBook(Book book) {
        System.out.println("Book: " + book.getTitle());
        System.out.println("Authors:");
        for (Author author : book.getAuthors()) {
            System.out.println("Author: " + author.getName());
        }
    }

    @Override
    public void visitSection(Section section) {
        System.out.println(section.getTitle());
        for (Element element : section.getElements()) {
            element.accept(this);
        }
    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        System.out.println("Paragraph: " + paragraph.getText());
    }

    @Override
    public void visitImage(Image image) {
        System.out.println("Image with name: " + image.getName());
    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {
        System.out.println("Image Proxy with name: " + imageProxy.getName());
    }

    @Override
    public void visitTable(Table table) {
        System.out.println("Table with name: " + table.getName());
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
