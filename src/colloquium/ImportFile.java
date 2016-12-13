/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colloquium;

import colloquium.exceptions.NonexistentEntityException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Mark_K
 */
public class ImportFile {
    
    
    public ImportFile() {   
    }
    
    //Import from tab dilineated file tags only
    public void importTags(File file) throws FileNotFoundException, IOException {
        EntityManager entityManager = Persistence.createEntityManagerFactory("ColloquiumPU").createEntityManager();
        Query deletequery = entityManager.createQuery("SELECT t.id FROM Tags t");        
        List<Integer> tagId = deletequery.getResultList();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColloquiumPU");
        for (int i : tagId) {
                TagsJpaController tjc = new TagsJpaController(emf);
            try {
                tjc.destroy(i);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(ShowTags.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            BufferedReader buf = new BufferedReader(new FileReader(file));
            String[] tags;
            String line = null;
            
            while (true) {
                line = buf.readLine();
                if (line == null) {
                    break;
                }
                else {
                    tags = line.split("\\t", -1);
                    addTag(tags);                    
                }
            }
            buf.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Import failed.");
        }                                        
    }
    
    // NOT IMPLEMENTED import from tab dilineated file whole database
    public void importBackup (File file) throws FileNotFoundException, IOException {
        
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:derby:colloquiumdb;create=true");
        } catch (SQLException ex) {
            Logger.getLogger(ImportFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (con != null) {
            Statement stmt;
            String querydeletetags = "DELETE FROM TAGS WHERE 1=1";
            String querydeleteparagraphs = "DELETE FROM PARAGRAPHS WHERE 1=1";
            String querydeleteinterviews = "DELETE FROM INTERVIEWS WHERE 1=1";
            String querydeleteinformants = "DELETE FROM INFORMANTS WHERE 1=1";
            try {
                stmt = con.createStatement();                
                stmt.execute(querydeletetags);
                stmt.execute(querydeleteparagraphs);
                stmt.execute(querydeleteinterviews);
                stmt.execute(querydeleteinformants);
            } catch (SQLException ex) {
                Logger.getLogger(ImportFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ImportFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            BufferedReader buf = new BufferedReader(new FileReader(file));
            String[] informants;
            String[] interviews;
            String[] paragraphs;
            String[] tags;
            String tableName = "";
            String line = null;
            
            while (true) {                
                line = buf.readLine();
                if (line != null) {                                    
                    switch (line) {
                        case "INFORMANTS" :
                            tableName = "INFORMANTS";
                            break;
                        case "INTERVIEWS" :
                            tableName = "INTERVIEWS";
                            break;
                        case "PARAGRAPHS" :
                            tableName = "PARAGRAPHS";
                            break;
                        case "TAGS" :
                            tableName = "TAGS";
                            break;
                        default :
                            if (tableName == "INFORMANTS") {
                                informants = line.split("\\t", -1);
                                addInformant(informants);
                            }
                            else if (tableName == "INTERVIEWS") {
                                 interviews = line.split("\\t", -1);
                                 addInterview(interviews);
                            }
                            else if (tableName == "PARAGRAPHS") {
                                paragraphs = line.split("\\t", -1);
                                addParagraph(paragraphs);
                            }
                            else if (tableName == "TAGS") {
                                tags = line.split("\\t", -1);
                                addTag(tags);
                            }
                    }
                }
                else {
                    break;
                }                                                        
            }
            buf.close();
        } catch (Exception e) {  
            JOptionPane.showMessageDialog(null,"Error importing database backup.");
        }          
    }
    
    private void addInformant(String[] informant) {
        
        String infoId = null;
        String infoFirstname = null;
        String infoSurname = null;
        String infoNickname = null;
        String infoGender = null;
        String infoAge = null;
        String infoBirthplace = null;
        String infoResidence = null;
        String infoPrimarylang = null;
        String infoSecondlang = null;
        String infoTribe = null;
        String infoClan = null;
        String infoMarriage = null;
        String infoNumofchildren = null;
        String infoEconomic = null;
        String infoProfession = null;
        String infoEducation = null;
        String infoReligion = null;
        String infoOther1 = null;
        String infoOther2 = null;
        String infoOther3 = null;
        String infoOther4 = null;
        String infoOther5 = null;
        String infoOther6 = null;
        String infoOther7 = null;
        String infoOther8 = null;
        String infoOther9 = null;
        
        infoId = informant[0];
        infoFirstname = informant[1];
        infoSurname = informant[2];
        infoNickname = informant[3];
        infoGender = informant[4];
        infoAge = informant[5];
        infoBirthplace = informant[6];
        infoResidence = informant[7];
        infoPrimarylang = informant[8];
        infoSecondlang = informant[9];
        infoTribe = informant[10];
        infoClan = informant[11];
        infoMarriage = informant[12];
        infoNumofchildren = informant[13];
        infoEconomic = informant[14];
        infoProfession = informant[15];
        infoEducation = informant[16];
        infoReligion = informant[17];
        infoOther1 = informant[18];
        infoOther2 = informant[19];
        infoOther3 = informant[20];
        infoOther4 = informant[21];
        infoOther5 = informant[22];
        infoOther6 = informant[23];
        infoOther7 = informant[24];
        infoOther8 = informant[25];
        infoOther9 = informant[26];
         
        Informants newInformant = new Informants();
        int trueInfoId = Integer.parseInt(infoId);
        newInformant.setFirstname(infoFirstname);
        newInformant.setSurname(infoSurname);
        newInformant.setNickname(infoNickname);
        newInformant.setGender(infoGender);
        newInformant.setAge(Integer.parseInt(infoAge));
        newInformant.setBirthplace(infoBirthplace);
        newInformant.setResidence(infoResidence);
        newInformant.setPrimarylang(infoPrimarylang);
        newInformant.setSecondarylang(infoSecondlang);
        newInformant.setTribe(infoTribe);
        newInformant.setClan(infoClan);
        newInformant.setMarriage(infoMarriage);
        newInformant.setNumberofchildren(Integer.parseInt(infoNumofchildren));
        newInformant.setEconomic(infoEconomic);
        newInformant.setProfession(infoProfession);
        newInformant.setEducation(infoEducation);
        newInformant.setReligion(infoReligion);
        newInformant.setOther1(infoOther1);
        newInformant.setOther2(infoOther2);
        newInformant.setOther3(infoOther3);
        newInformant.setOther4(infoOther4);
        newInformant.setOther5(infoOther5);
        newInformant.setOther6(infoOther6);
        newInformant.setOther7(infoOther7);
        newInformant.setOther8(infoOther8);
        newInformant.setOther9(infoOther9);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColloquiumPU");
        InformantsJpaController ijc = new InformantsJpaController(emf);
        ijc.create(newInformant);        
        int newInformantId = newInformant.getId();
        
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:derby:colloquiumdb;create=true");
        } catch (SQLException ex) {
            Logger.getLogger(ImportFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (con != null) {
            Statement stmt;
            String queryinf = "UPDATE INFORMANTS SET ID = " + trueInfoId + " WHERE id = " + newInformantId;
            try {
                stmt = con.createStatement();                
                stmt.execute(queryinf);
            } catch (SQLException ex) {
                Logger.getLogger(ImportFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ImportFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void addInterview(String[] interview) {
        
        String intId = null;
        String intInformant = null;
        String intTitle = null;
        String intInterviewer = null;
        String intLocation = null;
        String intDate = null;
        String intSummary = null;
        String intTheme1 = null;
        String intTheme2 = null;
        String intTheme3 = null;
        String intTheme4 = null;
        String intTheme5 = null;
        String intTheme6 = null;
        String intTheme7 = null;
        String intTheme8 = null;
        String intTheme9 = null;
        
        intId = interview[0];
        intInformant = interview[1];
        intTitle = interview[2];
        intInterviewer = interview[3];
        intLocation = interview[4];
        intDate = interview[5];
        intSummary = interview[6];
        intTheme1 = interview[7];
        intTheme2 = interview[8];
        intTheme3 = interview[9];
        intTheme4 = interview[10];
        intTheme5 = interview[11];
        intTheme6 = interview[12];
        intTheme7 = interview[13];
        intTheme8 = interview[14];
        intTheme9 = interview[15];

        Interviews newInterview = new Interviews();
        int trueInterviewId = Integer.parseInt(intId);
        newInterview.setTitle(intTitle);
        EntityManager entityManager = Persistence.createEntityManagerFactory("ColloquiumPU").createEntityManager();
        Query query = entityManager.createNamedQuery("Informants.findById").setParameter("id", Integer.parseInt(intInformant));
        Informants informant = (Informants)query.getSingleResult();
        newInterview.setInformant(informant);
        newInterview.setInterviewer(intInterviewer);
        newInterview.setLocation(intLocation);
        if (intDate != null && !intDate.isEmpty()) {
            java.sql.Date sqlStartDate = null;
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
            java.util.Date date;
            try {
                date = sdf.parse(intDate);
                sqlStartDate = new Date(date.getTime());
                newInterview.setInterviewdate(sqlStartDate);
            } catch (ParseException ex) {
                Logger.getLogger(ImportFile.class.getName()).log(Level.SEVERE, null, ex);
            }          
        }
        newInterview.setSummary(intSummary);
        newInterview.setTheme1(intTheme1);
        newInterview.setTheme2(intTheme2);
        newInterview.setTheme3(intTheme3);
        newInterview.setTheme4(intTheme4);
        newInterview.setTheme5(intTheme5);
        newInterview.setTheme6(intTheme6);
        newInterview.setTheme7(intTheme7);
        newInterview.setTheme8(intTheme8);
        newInterview.setTheme9(intTheme9);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColloquiumPU");
        InterviewsJpaController ijc = new InterviewsJpaController(emf);
        ijc.create(newInterview);
        int newInterviewId = newInterview.getId();
        
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:derby:colloquiumdb;create=true");
        } catch (SQLException ex) {
            Logger.getLogger(ImportFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (con != null) {
            Statement stmt;
            String queryint = "UPDATE INTERVIEWS SET ID = " + trueInterviewId + " WHERE id = " + newInterviewId;
            try {
                stmt = con.createStatement();                
                stmt.execute(queryint);
            } catch (SQLException ex) {
                Logger.getLogger(ImportFile.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }
    
    private void addParagraph(String[] paragraph) {
        
        String parId = null;
        String parInformant = null;
        String parInterview = null;
        String parText = null;
        String parTrans = null;
        String parNotes = null;
        String parTags = null;
       
        parId = paragraph[0];
        parInformant = paragraph[1];
        parInterview = paragraph[2];
        parText = paragraph[3];
        parTrans = paragraph[4];
        parNotes = paragraph[5];
        parTags = paragraph[6];

        Paragraphs newParagraph = new Paragraphs();
        newParagraph.setId(Integer.parseInt(parId));
        EntityManager entityManager = Persistence.createEntityManagerFactory("ColloquiumPU").createEntityManager();
        Query query = entityManager.createNamedQuery("Informants.findById").setParameter("id", Integer.parseInt(parInformant));
        Informants informant = (Informants)query.getSingleResult();
        newParagraph.setInformant(informant);
        Query query2 = entityManager.createNamedQuery("Interviews.findById").setParameter("id", Integer.parseInt(parInterview));
        Interviews interview = (Interviews)query2.getSingleResult();
        newParagraph.setInterviewnumber(interview);
        newParagraph.setText(parText);
        newParagraph.setTrans(parTrans);
        newParagraph.setNotes(parNotes);
        newParagraph.setTags(parTags);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColloquiumPU");
        ParagraphsJpaController pjc = new ParagraphsJpaController(emf);
        pjc.create(newParagraph);
    }
    
    private void addTag(String[] tag) {
        
        String tagName = "";
        String tagDefinition = "";
        String tagExplanation = "";               
        
        tagName = tag[0];
        if (tag.length == 2)
            tagDefinition = tag[1];
        if (tag.length == 3)
            tagExplanation = tag[2];
        
        Tags newTag = new Tags();
        newTag.setTagname(tagName);
        newTag.setTagdefinition(tagDefinition);
        newTag.setTagexplanation(tagExplanation);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColloquiumPU");
        TagsJpaController tjc = new TagsJpaController(emf);
        tjc.create(newTag);
    }  
    
    // restore from a db backup folder
    public void restoreDb(File file) {
        Connection con = null;        
        try {
            DriverManager.getConnection("jdbc:derby:colloquiumdb;shutdown=true");
        } catch (SQLException ex) {
            Logger.getLogger(ImportFile.class.getName()).log(Level.SEVERE, null, ex);
        }  
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ImportFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:derby:colloquiumdb;restoreFrom="+file.getAbsolutePath());
        } catch (SQLException ex) {
            Logger.getLogger(ImportFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ImportFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createNewDb() {
        File file = new File("etc" + File.separator + "colloquiumdb");
        Connection con = null;        
        try {
            DriverManager.getConnection("jdbc:derby:colloquiumdb;shutdown=true");
        } catch (SQLException ex) {
            Logger.getLogger(ImportFile.class.getName()).log(Level.SEVERE, null, ex);
        }  
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ImportFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:derby:colloquiumdb;restoreFrom="+file.getAbsolutePath());
        } catch (SQLException ex) {
            Logger.getLogger(ImportFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ImportFile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private boolean deleteFolder(File file) throws IOException {
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                deleteFolder(f);
            }
        }
        if (!file.delete()) {
            return false;
        }
        else {
            return true;
        }
    }
}