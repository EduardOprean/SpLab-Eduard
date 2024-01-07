package models;

public class TableOfContentUpdate implements Visitor {
    private StringBuilder tableOfContent = new StringBuilder();
    private int currentPage = 0;

    @Override
    public void visitBook(Book book) {
      
    }

    @Override
    public void visitSection(Section section) {
        tableOfContent.append(section.getTitle()).append(" ........................ ").append(currentPage).append("\n");
        currentPage++;

        for (Element element : section.getElements()) {
            element.accept(this);
        }
    }

    @Override
    public void visitParagraph(Paragraph paragraph) {

        currentPage++;
    }

    @Override
    public void visitImage(Image image) {
       
        currentPage++;
    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {
        
        currentPage++;
    }

    @Override
    public void visitTable(Table table) {
       
        currentPage++;
    }

    public String getTableOfContent() {
        return tableOfContent.toString();
    }
}
