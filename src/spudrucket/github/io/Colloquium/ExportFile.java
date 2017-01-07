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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author spudrucket
 */
public class ExportFile {
    
    public ExportFile() {
    }
    
    // export tags to a tab dilineated file
    public static void exportTags(File file) throws IOException {
        try {
            FileWriter fw = new FileWriter(file);
            LinkedList<Tags> tagsList = getTags();
            for (Tags t : tagsList) {
                String tagName = t.getTagname();
                String tagDefinition = t.getTagdefinition();
                String tagExplanation = t.getTagexplanation();
                fw.write(tagName + "\t" + tagDefinition + "\t" + tagExplanation + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {            
        }
    }    
    
    private static LinkedList getInformants() {
        LinkedList<Informants> informantsList = new LinkedList();
        EntityManager entityManager = Persistence.createEntityManagerFactory("ColloquiumPU").createEntityManager();
        Query query = entityManager.createNamedQuery("Informants.findAll");
        informantsList.addAll(query.getResultList());
        return informantsList;
    }
    
    private static LinkedList getInterviews() {
        LinkedList<Interviews> interviewsList = new LinkedList();
        EntityManager entityManager = Persistence.createEntityManagerFactory("ColloquiumPU").createEntityManager();
        Query query = entityManager.createNamedQuery("Interviews.findAll");
        interviewsList.addAll(query.getResultList());
        return interviewsList;        
    }
    
    private static LinkedList getParagraphs() {
        LinkedList<Paragraphs> paragraphsList = new LinkedList();
        EntityManager entityManager = Persistence.createEntityManagerFactory("ColloquiumPU").createEntityManager();
        Query query = entityManager.createNamedQuery("Paragraphs.findAll");
        paragraphsList.addAll(query.getResultList());
        return paragraphsList;
    }
    
    private static LinkedList getTags() {
        LinkedList<Tags> tagsList = new LinkedList();
        EntityManager entityManager = Persistence.createEntityManagerFactory("ColloquiumPU").createEntityManager();
        Query query = entityManager.createNamedQuery("Tags.findAll");
        tagsList.addAll(query.getResultList());
        return tagsList;
    }
    
    private static LinkedList getTerms() {
        LinkedList<Terms> termsList = new LinkedList();
        EntityManager entityManager = Persistence.createEntityManagerFactory("ColloquiumPU").createEntityManager();
        Query query = entityManager.createNamedQuery("Terms.findAll");
        termsList.addAll(query.getResultList());
        return termsList;
    }
    
    private static LinkedList getUsages() {
        LinkedList<Usages> usagesList = new LinkedList();
        EntityManager entityManager = Persistence.createEntityManagerFactory("ColloquiumPU").createEntityManager();
        Query query = entityManager.createNamedQuery("Usages.findAll");
        usagesList.addAll(query.getResultList());
        return usagesList;
    }
    
    // export whole database to a tab dilineated file
    public static void exportDatabase(File file) throws IOException {
        LinkedList<Informants> informantsList = getInformants();
        LinkedList<Interviews> interviewsList = getInterviews();
        LinkedList<Paragraphs> paragraphsList = getParagraphs();
        LinkedList<Tags> tagsList = getTags();
        LinkedList<Terms> termsList = getTerms();
        LinkedList<Usages> usagesList = getUsages();
        
        try {
            FileWriter fw = new FileWriter(file);
            
            fw.write("INFORMANTS" + System.lineSeparator());

            for (Informants i : informantsList) {
                String infoId = i.getId().toString();
                String infoFirstname = i.getFirstname();
                String infoSurname = i.getSurname();
                String infoNickname = i.getNickname();
                String infoGender = i.getGender();
                String infoAge = i.getAge().toString();
                String infoBirthplace = i.getBirthplace();
                String infoResidence = i.getResidence();
                String infoPrimarylang = i.getPrimarylang();
                String infoSecondlang = i.getSecondarylang();
                String infoTribe = i.getTribe();
                String infoClan = i.getClan();
                String infoMarriage = i.getMarriage();
                String infoNumofchildren = i.getNumberofchildren().toString();
                String infoEconomic = i.getEconomic();
                String infoProfession = i.getProfession();
                String infoEducation = i.getEducation();
                String infoReligion = i.getReligion();
                String infoOther1 = i.getOther1();
                String infoOther2 = i.getOther2();
                String infoOther3 = i.getOther3();
                String infoOther4 = i.getOther4();
                String infoOther5 = i.getOther5();
                String infoOther6 = i.getOther6();
                String infoOther7 = i.getOther7();
                String infoOther8 = i.getOther8();
                String infoOther9 = i.getOther9();
                fw.write(infoId + "\t" + infoFirstname + "\t" + infoSurname + "\t" +
                        infoNickname + "\t" + infoGender + "\t" + infoAge + "\t" +
                        infoBirthplace + "\t" + infoResidence + "\t" + infoPrimarylang + "\t" +
                        infoSecondlang + "\t" + infoTribe + "\t" + infoClan + "\t" + infoMarriage + "\t" +
                        infoNumofchildren + "\t" + infoEconomic + "\t" + infoProfession + "\t" +
                        infoEducation + "\t" + infoReligion + "\t" + infoOther1 + "\t" +
                        infoOther2 + "\t" + infoOther3 + "\t" + infoOther4 + "\t" +
                        infoOther5 + "\t" + infoOther6 + "\t" + infoOther7 + "\t" +
                        infoOther8 + "\t" + infoOther9 + System.lineSeparator());
            }
            
            fw.write("INTERVIEWS" + System.lineSeparator());
            
            for (Interviews i : interviewsList) {
                String intId = i.getId().toString();
                String intInformant = i.getInformant().getId().toString();
                String intTitle = i.getTitle();
                String intInterviewer = i.getInterviewer();
                String intLocation = i.getLocation();
                String intDate = null;
                try {
                    intDate = i.getInterviewdate().toString();
                } catch (NullPointerException npe){
                }                                    
                String intSummary = i.getSummary();
                String intTheme1 = i.getTheme1();
                String intTheme2 = i.getTheme2();
                String intTheme3 = i.getTheme3();
                String intTheme4 = i.getTheme4();
                String intTheme5 = i.getTheme5();
                String intTheme6 = i.getTheme6();
                String intTheme7 = i.getTheme7();
                String intTheme8 = i.getTheme8();
                String intTheme9 = i.getTheme9();
                fw.write(intId + "\t" + intInformant + "\t" + intTitle + "\t" + intInterviewer + "\t" +
                        intLocation + "\t" + intDate + "\t" + intSummary + "\t" +
                        intTheme1 + "\t" + intTheme2 + "\t" + intTheme3 + "\t" +
                        intTheme4 + "\t" + intTheme5 + "\t" + intTheme6 + "\t" +
                        intTheme7 + "\t" + intTheme8 + "\t" + intTheme9 + "\t" + 
                        System.lineSeparator());
            } 
            
            fw.write("PARAGRAPHS" + System.lineSeparator());
            
            for (Paragraphs p : paragraphsList) {
                String parId = p.getId().toString();
                String parInformant = p.getInformant().getId().toString();
                String parInterview = p.getInterviewnumber().getId().toString();
                String parText = p.getText();
                String parTrans = p.getTrans();
                String parNotes = p.getNotes();
                String parTags = p.getTags();
                fw.write(parId + "\t" + parInformant + "\t" + parInterview + "\t" +
                        parText + "\t" + parTrans + "\t" + parNotes + "\t" + parTags +
                        System.lineSeparator());
            }
            
            fw.write("TAGS" + System.lineSeparator());
            
            for (Tags t : tagsList) {
                String tagId = t.getId().toString();
                String tagName = t.getTagname();
                String tagDefinition = t.getTagdefinition();
                String tagExplanation = t.getTagexplanation();
                fw.write(tagId + "\t" + tagName + "\t" + tagDefinition + "\t" + tagExplanation + System.lineSeparator());
            }   
            
            fw.write("TERMS" + System.lineSeparator());
            
            for (Terms t : termsList) {
                String termId = t.getId().toString();
                String rootWord = t.getRootword();
                String forms = t.getForms();
                String occurances = t.getOccurances().toString();
                String notes = t.getNotes();
                fw.write(termId + "\t" + rootWord + "\t" + forms + "\t" + occurances + "\t" + notes + System.lineSeparator());
            }
            
            fw.write("USAGES" + System.lineSeparator());
            
            for (Usages u : usagesList) {
                String usagesId = u.getId().toString();
                String term = u.getTerm().toString();
                String informant = u.getParagraph().getInformant().toString();
                String interview = u.getParagraph().getInterviewnumber().toString();
                String form = u.getForm();
                String sentence = u.getSentence();
                fw.write(usagesId + "\t" + informant + "\t" + interview + "\t" + term + "\t" + form + "\t" + sentence + System.lineSeparator());
            }
            
            fw.close();
        } catch (IOException ioe) {            
        }
    }
    
    // back up databse to a folder
    public static void backupDb(File file) throws SQLException{
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:derby:colloquiumdb;create=true");
        } catch (SQLException ex) {
            Logger.getLogger(ExportFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        String backupdirectory = file.getPath();
        CallableStatement cs = con.prepareCall("CALL SYSCS_UTIL.SYSCS_BACKUP_DATABASE(?)"); 
        cs.setString(1, backupdirectory);
        cs.execute(); 
        cs.close();
        
        String timeStamp = new SimpleDateFormat("yyyyMddmmss").format(new Date());
        String newName = "ColloquiumdbBackup_" + timeStamp;
        File newFile = new File(file.getPath() + File.separator + newName + File.separator);
        File oldFile = new File(file.getPath() + File.separator + "colloquiumdb" + File.separator);
        oldFile.renameTo(newFile);        
    }
        
        //creates etc folder and blank db for createnewdb function (new project)
        public static void backupBlankDb(File file) throws SQLException{
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:derby:colloquiumdb;create=true");
        } catch (SQLException ex) {
            Logger.getLogger(ExportFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        String backupdirectory = file.getPath();
        CallableStatement cs = con.prepareCall("CALL SYSCS_UTIL.SYSCS_BACKUP_DATABASE(?)"); 
        cs.setString(1, backupdirectory);
        cs.execute(); 
        cs.close();       
    }
        
    public static void exportTable(JTable tableModel, File file) throws IOException {
        FileWriter fw = new FileWriter(file);
        int numColumns = tableModel.getColumnCount();
        int numRows = tableModel.getRowCount();
        
        for (int row = 0; row < numRows; row++) {
            for (int column = 0; column < numColumns; column++) {
                if (tableModel.getValueAt(row, column) != null) {
                    fw.write(tableModel.getValueAt(row, column).toString());
                    fw.write("\t");
                }
                else {
                    fw.write("\t");
                }
            }
            fw.write(System.lineSeparator());
        }
        fw.close();
    }
    
}
