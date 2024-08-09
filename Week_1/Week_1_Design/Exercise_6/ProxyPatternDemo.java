import java.util.Map;
import java.util.HashMap;

interface Document {
    void show();
}

class RealDocument implements Document {
    private String docName;

    public RealDocument(String docName) {
        this.docName = docName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading document: " + docName);
    }

    @Override
    public void show() {
        System.out.println("Displaying " + docName);
    }
}

class CachedDocumentProxy implements Document {
    private RealDocument realDocument;
    private String docName;
    private static Map<String, RealDocument> docCache = new HashMap<>();

    public CachedDocumentProxy(String docName) {
        this.docName = docName;
    }

    @Override
    public void show() {
        if (docCache.containsKey(docName)) {
            realDocument = docCache.get(docName);
        } else {
            realDocument = new RealDocument(docName);
            docCache.put(docName, realDocument);
        }
        realDocument.show();
    }
}

public class ProxyPatternDemo {
    public static void main(String[] args) {
        Document document1 = new CachedDocumentProxy("document1.txt");
        Document document2 = new CachedDocumentProxy("document2.txt");

        document1.show();
        System.out.println("");

        document1.show();
        System.out.println("");

        document2.show();
        System.out.println("");

        document2.show();
    }
}
