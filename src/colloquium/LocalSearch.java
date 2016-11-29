/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colloquium;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;


        
 /*
 * @author Mark_K
 */
public class LocalSearch {
//    List<Paragraphs> paragraphsList;
//    String searchString;
    static int MAX_RESULTS = 100;
     
    
    public LocalSearch() { 
    }
    
    public static LinkedList search(List<Paragraphs> paragraphsList, String searchString) throws IOException, ParseException {
        Boolean hasTranslation = true;
        if (paragraphsList.get(0).getTrans() == null) {
            hasTranslation = false;
        }
        if (hasTranslation) {
            Directory index = new RAMDirectory();
            SimpleAnalyzer analyzer = new SimpleAnalyzer();
            IndexWriterConfig writerConfig = new IndexWriterConfig(analyzer);
            IndexWriter writer = new IndexWriter(index, writerConfig);
            for (Paragraphs p : paragraphsList) {
                indexDb(writer, Integer.toString(p.getId()), p.getText(), p.getTrans());
            }
            writer.close();
            MultiFieldQueryParser mfqp = new MultiFieldQueryParser(new String[] {"text", "trans"}, analyzer);
            Query q = mfqp.parse(searchString);
            IndexReader reader = DirectoryReader.open(index);
            IndexSearcher searcher = new IndexSearcher(reader);
            TopDocs docs = searcher.search(q, MAX_RESULTS);
            ScoreDoc[] hits = docs.scoreDocs;
            LinkedList<String> idArray = new LinkedList();
            for (int i = 0; i < hits.length; ++i) {
                int docId = hits[i].doc;
                Document d = searcher.doc(docId);
                idArray.add(d.get("id"));
            }
            return idArray;
        }
        else {
            Directory index = new RAMDirectory();
            SimpleAnalyzer analyzer = new SimpleAnalyzer();
            IndexWriterConfig writerConfig = new IndexWriterConfig(analyzer);
            IndexWriter writer = new IndexWriter(index, writerConfig);
            for (Paragraphs p : paragraphsList) {
                indexDb(writer, Integer.toString(p.getId()), p.getText());
            }
            writer.close();
            Query q = new QueryParser("text", analyzer).parse(searchString);
            IndexReader reader = DirectoryReader.open(index);
            IndexSearcher searcher = new IndexSearcher(reader);
            TopDocs docs = searcher.search(q, MAX_RESULTS);
            ScoreDoc[] hits = docs.scoreDocs;
            LinkedList<String> idArray = new LinkedList();
            for (int i = 0; i < hits.length; ++i) {
                int docId = hits[i].doc;
                Document d = searcher.doc(docId);
                idArray.add(d.get("id"));
            }
            return idArray;
            }        
    }
    
    private static void indexDb(IndexWriter writer, String id, String text, String trans) throws IOException {
        Document d = new Document();      
        d.add(new StringField("id", id, Field.Store.YES));
        d.add(new TextField("text", text, Field.Store.NO));
        d.add(new TextField("trans", trans, Field.Store.NO));
        try {        
            writer.addDocument(d);
        } catch (IOException ex) {
            Logger.getLogger(LocalSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void indexDb(IndexWriter writer, String id, String text) throws IOException {
        Document d = new Document();      
        d.add(new StringField("id", id, Field.Store.YES));
        d.add(new TextField("text", text, Field.Store.NO));
        try {        
            writer.addDocument(d);
        } catch (IOException ex) {
            Logger.getLogger(LocalSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
