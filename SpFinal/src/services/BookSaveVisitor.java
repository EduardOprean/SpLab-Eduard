package services;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import models.*;

public class BookSaveVisitor implements Visitor {
    private JSONArray elementsArray;

    public BookSaveVisitor() {
        this.elementsArray = new JSONArray();
    }

    public void saveToFile(String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(elementsArray.toJSONString());
            System.out.println("Successfully saved to file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JSONObject createElementJsonObject(String type, Map<String, Object> data) {
        JSONObject elementObject = new JSONObject();
        elementObject.put("type", type);
        elementObject.put("data", data);
        return elementObject;
    }

    @Override
    public void visitBook(Book book) {
        Map<String, Object> bookData = new HashMap<>();
        bookData.put("title", book.getName());
        JSONArray authorsArray = new JSONArray();
        for (Author author : book.getAuthors()) {
            JSONObject authorObject = new JSONObject();
            authorObject.put("name", author.getName());
            authorsArray.add(authorObject);
        }
        bookData.put("authors", authorsArray);

        elementsArray.add(createElementJsonObject("Book", bookData));

        // Visit the book's sections and elements
        for (Element element : book.getElements()) {
            element.accept(this);
        }
    }

    @Override
    public void visitSection(Section section) {
        Map<String, Object> sectionData = new HashMap<>();
        sectionData.put("title", section.getTitle());

        elementsArray.add(createElementJsonObject("Section", sectionData));

        // Visit the section's elements
        for (Element element : section.getElements()) {
            element.accept(this);
        }
    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        Map<String, Object> paragraphData = new HashMap<>();
        paragraphData.put("text", paragraph.getText());

        elementsArray.add(createElementJsonObject("Paragraph", paragraphData));
    }

    @Override
    public void visitImage(Image image) {
        Map<String, Object> imageData = new HashMap<>();
        imageData.put("name", image.getName());

        elementsArray.add(createElementJsonObject("Image", imageData));
    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {
        Map<String, Object> imageProxyData = new HashMap<>();
        imageProxyData.put("name", imageProxy.getName());

        elementsArray.add(createElementJsonObject("ImageProxy", imageProxyData));
    }

    @Override
    public void visitTable(Table table) {
        Map<String, Object> tableData = new HashMap<>();
        tableData.put("name", table.getName());

        elementsArray.add(createElementJsonObject("Table", tableData));
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
