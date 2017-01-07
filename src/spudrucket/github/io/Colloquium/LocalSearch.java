/*
 * Copyright (C) 2016 spudrucket
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package spudrucket.github.io.Colloquium;

import java.io.IOException;
import java.text.BreakIterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
 * @author spudrucket
 */
public class LocalSearch {

    static int MAX_RESULTS = Integer.MAX_VALUE;
     
    
    public LocalSearch() { 
    }
    
    public static LinkedList searchText(List<Paragraphs> paragraphsList, String searchString) throws IOException, ParseException {
            Directory index = new RAMDirectory();
            SimpleAnalyzer analyzer = new SimpleAnalyzer();
            IndexWriterConfig writerConfig = new IndexWriterConfig(analyzer);
            IndexWriter writer = new IndexWriter(index, writerConfig);
            for (Paragraphs p : paragraphsList) {
                String trans;
                if (p.getTrans() == null) {
                    trans = "";
                }
                else {
                    trans = p.getTrans();
                }
                String text;
                if (p.getText() == null) {
                    text = "";
                }
                else {
                    text = p.getText();
                }
                indexText(writer, Integer.toString(p.getId()), text, trans);
            }
            writer.close();
            MultiFieldQueryParser mfqp = new MultiFieldQueryParser(new String[] {"text", "trans"}, analyzer);
            Query q = mfqp.parse(searchString);
            IndexReader reader = DirectoryReader.open(index);
            IndexSearcher searcher = new IndexSearcher(reader);
            TopDocs docs = searcher.search(q, MAX_RESULTS);
            ScoreDoc[] hits = docs.scoreDocs;
            LinkedList<String> idList = new LinkedList();
            for (int i = 0; i < hits.length; ++i) {
                int docId = hits[i].doc;
                Document d = searcher.doc(docId);
                idList.add(d.get("id"));
            }
            return idList;
    }
    
    private static void indexText(IndexWriter writer, String id, String text, String trans) throws IOException {
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
    
    public static LinkedList searchTags(List<Paragraphs> paragraphsList, String searchString) throws IOException, ParseException {
        Directory index = new RAMDirectory();
        SimpleAnalyzer analyzer = new SimpleAnalyzer();
        IndexWriterConfig writerConfig = new IndexWriterConfig(analyzer);
        IndexWriter writer = new IndexWriter(index, writerConfig);
        for (Paragraphs p : paragraphsList) {
            String tag;
            if (p.getTags() == null) {
                tag = "";
            }
            else {
                tag = p.getTags();
            }
            indexTags(writer, Integer.toString(p.getId()), tag);
        }
        writer.close();
        Query q = new QueryParser("tags", analyzer).parse(searchString);
        IndexReader reader = DirectoryReader.open(index);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopDocs docs = searcher.search(q, MAX_RESULTS);
        ScoreDoc[] hits = docs.scoreDocs;
        LinkedList<Integer> idList = new LinkedList();
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            idList.add(Integer.parseInt(d.get("id")));
        }
        return idList;                   
    }
    
    private static void indexTags(IndexWriter writer, String id, String tags) throws IOException {
        Document d = new Document();      
        d.add(new StringField("id", id, Field.Store.YES));
        d.add(new TextField("tags", tags, Field.Store.NO));
        try {        
            writer.addDocument(d);
        } catch (IOException ex) {
            Logger.getLogger(LocalSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int termSearch(Terms term) throws IOException, ParseException {
        Directory paragraphIndex = new RAMDirectory();
        SimpleAnalyzer paragraphAnalyzer = new SimpleAnalyzer();
        IndexWriterConfig paragraphWriterConfig = new IndexWriterConfig(paragraphAnalyzer);
        IndexWriter paragraphWriter = new IndexWriter(paragraphIndex, paragraphWriterConfig);
        
        EntityManager entityManager = Persistence.createEntityManagerFactory("ColloquiumPU").createEntityManager();
        javax.persistence.Query query = entityManager.createNamedQuery("Paragraphs.findAll");
        List<Paragraphs> paragraphsList = query.getResultList();
        
        for (Paragraphs p : paragraphsList) {
            String text;
            if (p.getText() == null) {
                text = "";
            }
            else {
                text = p.getText();
            }
            indexTerms(paragraphWriter, Integer.toString(p.getId()), text);
        }
        paragraphWriter.close();
        String[] searchString = term.getForms().split(" *, *");
        for (String s : searchString) {
            Query paragraphQuery = new QueryParser("text", paragraphAnalyzer).parse(s);
            IndexReader paragraphReader = DirectoryReader.open(paragraphIndex);
            IndexSearcher paragraphSearcher = new IndexSearcher(paragraphReader);
            TopDocs paragraphDocs = paragraphSearcher.search(paragraphQuery, MAX_RESULTS);
            ScoreDoc[] paragraphHits = paragraphDocs.scoreDocs;
            LinkedList<Integer> paragraphIdList = new LinkedList();
            for (int i = 0; i < paragraphHits.length; ++i) {
                int paragraphDocId = paragraphHits[i].doc;
                Document paragraphDocument = paragraphSearcher.doc(paragraphDocId);
                paragraphIdList.add(Integer.parseInt(paragraphDocument.get("id")));
            }
            for (int i : paragraphIdList) {
                Directory sentenceIndex = new RAMDirectory();
                SimpleAnalyzer sentenceAnalyzer = new SimpleAnalyzer();
                IndexWriterConfig sentenceWriterConfig = new IndexWriterConfig(sentenceAnalyzer);
                IndexWriter sentenceWriter = new IndexWriter(sentenceIndex, sentenceWriterConfig);
                
                javax.persistence.Query dbQuery = entityManager.createQuery("SELECT p FROM Paragraphs p WHERE p.id = " + Integer.toString(i));
                Paragraphs paragraph = (Paragraphs) dbQuery.getSingleResult();
                LinkedList<String> sentences = new LinkedList();
                // get locale when importing text
                BreakIterator bi = BreakIterator.getSentenceInstance(Locale.US); 
                String source = paragraph.getText();
                bi.setText(source);
                int start = bi.first();
                for (int end = bi.next(); end != BreakIterator.DONE; start = end, end = bi.next()) {
                    sentences.add(source.substring(start,end));
                }
                for (String ss : sentences) {
                    indexSentences(sentenceWriter, ss);
                }
                sentenceWriter.close();
                Query sentenceQuery = new QueryParser("sentence", sentenceAnalyzer).parse(s);
                IndexReader sentenceReader = DirectoryReader.open(sentenceIndex);
                IndexSearcher sentenceSearcher = new IndexSearcher(sentenceReader);
                TopDocs sentenceDocs = sentenceSearcher.search(sentenceQuery, MAX_RESULTS);
                ScoreDoc[] sentenceHits = sentenceDocs.scoreDocs;
                LinkedList<String> sentenceList = new LinkedList();
                for (int ii = 0; ii < sentenceHits.length; ++ii) {
                    int sentenceDocId = sentenceHits[ii].doc;
                    Document sentenceDocument = sentenceSearcher.doc(sentenceDocId);
                    sentenceList.add(sentenceDocument.get("sentence"));
                }
                for (String sss : sentenceList) {
                    Usages newUsage = new Usages();
                    newUsage.setTerm(term);
                    newUsage.setParagraph(paragraph);
                    newUsage.setForm(s);
                    newUsage.setSentence(sss);
                    
                    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColloquiumPU");
                    UsagesJpaController ujc = new UsagesJpaController(emf);
                    ujc.create(newUsage);
                }                
            }
        }
        javax.persistence.Query dbQuery2 = entityManager.createNamedQuery("Usages.findByTerm").setParameter("term", term);
        List<Usages> usagesList = dbQuery2.getResultList();
        return usagesList.size();
    }
    
    private static void indexTerms (IndexWriter writer, String id, String text) throws IOException {
        Document d = new Document();
        d.add(new StringField("id", id, Field.Store.YES));
        d.add(new TextField("text", text, Field.Store.NO));
        try {
            writer.addDocument(d);
        } catch (IOException ex) {
            Logger.getLogger(LocalSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void indexSentences (IndexWriter writer, String sentence) throws IOException {
        Document d = new Document();
        d.add(new TextField("sentence", sentence, Field.Store.YES));
        try {
            writer.addDocument(d);
        } catch (IOException ex) {
            Logger.getLogger(LocalSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
