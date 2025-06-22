// Define an interface for documents
interface Document {
    void open();
    void save();
    void close();
}
 
// Create abstract classes for different document types
abstract class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word document...");
    }
 
    @Override
    public void save() {
        System.out.println("Saving Word document...");
    }
 
    @Override
    public void close() {
        System.out.println("Closing Word document...");
    }
}
 
abstract class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document...");
    }
 
    @Override
    public void save() {
        System.out.println("Saving PDF document...");
    }
 
    @Override
    public void close() {
        System.out.println("Closing PDF document...");
    }
}
 
abstract class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel document...");
    }
 
    @Override
    public void save() {
        System.out.println("Saving Excel document...");
    }
 
    @Override
    public void close() {
        System.out.println("Closing Excel document...");
    }
}
 
// Create concrete classes for each document type
class WordDocumentImpl extends WordDocument {
    @Override
    public void open() {
        super.open();
        System.out.println("Word document opened.");
    }
 
    @Override
    public void save() {
        super.save();
        System.out.println("Word document saved.");
    }
 
    @Override
    public void close() {
        super.close();
        System.out.println("Word document closed.");
    }
}
 
class PdfDocumentImpl extends PdfDocument {
    @Override
    public void open() {
        super.open();
        System.out.println("PDF document opened.");
    }
 
    @Override
    public void save() {
        super.save();
        System.out.println("PDF document saved.");
    }
 
    @Override
    public void close() {
        super.close();
        System.out.println("PDF document closed.");
    }
}
 
class ExcelDocumentImpl extends ExcelDocument {
    @Override
    public void open() {
        super.open();
        System.out.println("Excel document opened.");
    }
 
    @Override
    public void save() {
        super.save();
        System.out.println("Excel document saved.");
    }
 
    @Override
    public void close() {
        super.close();
        System.out.println("Excel document closed.");
    }
}
 
// Create an abstract class DocumentFactory with a method createDocument()
abstract class DocumentFactory {
    public abstract Document createDocument();
}
 
// Create concrete factory classes for each document type
class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocumentImpl();
    }
}
 
class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocumentImpl();
    }
}
 
class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocumentImpl();
    }
}
 
public class FactoryMethod {
    public static void main(String[] args) {
        // Create a Word document using the factory method
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDocument = wordFactory.createDocument();
        wordDocument.open();
        wordDocument.save();
        wordDocument.close();
 
        // Create a PDF document using the factory method
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDocument = pdfFactory.createDocument();
        pdfDocument.open();
        pdfDocument.save();
        pdfDocument.close();
 
        // Create an Excel document using the factory method
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDocument = excelFactory.createDocument();
        excelDocument.open();
        excelDocument.save();
        excelDocument.close();
    }
}
 