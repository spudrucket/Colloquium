/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spudrucket.github.io.Colloquium;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mark_K
 */
@Entity
@Table(name = "INTERVIEWS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Interviews.findAll", query = "SELECT i FROM Interviews i")
    , @NamedQuery(name = "Interviews.findByInformant", query = "SELECT i FROM Interviews i WHERE i.informant = :informant")
    , @NamedQuery(name = "Interviews.findById", query = "SELECT i FROM Interviews i WHERE i.id = :id")
    , @NamedQuery(name = "Interviews.findByTitle", query = "SELECT i FROM Interviews i WHERE i.title = :title")
    , @NamedQuery(name = "Interviews.findByInterviewer", query = "SELECT i FROM Interviews i WHERE i.interviewer = :interviewer")
    , @NamedQuery(name = "Interviews.findByLocation", query = "SELECT i FROM Interviews i WHERE i.location = :location")
    , @NamedQuery(name = "Interviews.findByInterviewdate", query = "SELECT i FROM Interviews i WHERE i.interviewdate = :interviewdate")
    , @NamedQuery(name = "Interviews.findBySummary", query = "SELECT i FROM Interviews i WHERE i.summary = :summary")
    , @NamedQuery(name = "Interviews.findByTheme1", query = "SELECT i FROM Interviews i WHERE i.theme1 = :theme1")
    , @NamedQuery(name = "Interviews.findByTheme2", query = "SELECT i FROM Interviews i WHERE i.theme2 = :theme2")
    , @NamedQuery(name = "Interviews.findByTheme3", query = "SELECT i FROM Interviews i WHERE i.theme3 = :theme3")
    , @NamedQuery(name = "Interviews.findByTheme4", query = "SELECT i FROM Interviews i WHERE i.theme4 = :theme4")
    , @NamedQuery(name = "Interviews.findByTheme5", query = "SELECT i FROM Interviews i WHERE i.theme5 = :theme5")
    , @NamedQuery(name = "Interviews.findByTheme6", query = "SELECT i FROM Interviews i WHERE i.theme6 = :theme6")
    , @NamedQuery(name = "Interviews.findByTheme7", query = "SELECT i FROM Interviews i WHERE i.theme7 = :theme7")
    , @NamedQuery(name = "Interviews.findByTheme8", query = "SELECT i FROM Interviews i WHERE i.theme8 = :theme8")
    , @NamedQuery(name = "Interviews.findByTheme9", query = "SELECT i FROM Interviews i WHERE i.theme9 = :theme9")})
public class Interviews implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "TITLE", nullable = false, length = 50)
    private String title;
    @Column(name = "INTERVIEWER", length = 50)
    private String interviewer;
    @Column(name = "LOCATION", length = 50)
    private String location;
    @Column(name = "INTERVIEWDATE")
    @Temporal(TemporalType.DATE)
    private Date interviewdate;
    @Column(name = "SUMMARY", length = 2048)
    private String summary;
    @Column(name = "THEME1", length = 50)
    private String theme1;
    @Column(name = "THEME2", length = 50)
    private String theme2;
    @Column(name = "THEME3", length = 50)
    private String theme3;
    @Column(name = "THEME4", length = 50)
    private String theme4;
    @Column(name = "THEME5", length = 50)
    private String theme5;
    @Column(name = "THEME6", length = 50)
    private String theme6;
    @Column(name = "THEME7", length = 50)
    private String theme7;
    @Column(name = "THEME8", length = 50)
    private String theme8;
    @Column(name = "THEME9", length = 50)
    private String theme9;
    @JoinColumn(name = "INFORMANT", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Informants informant;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "interviewnumber")
    private Collection<Paragraphs> paragraphsCollection;

    public Interviews() {
    }

    public Interviews(Integer id) {
        this.id = id;
    }

    public Interviews(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getInterviewdate() {
        return interviewdate;
    }

    public void setInterviewdate(Date interviewdate) {
        this.interviewdate = interviewdate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTheme1() {
        return theme1;
    }

    public void setTheme1(String theme1) {
        this.theme1 = theme1;
    }

    public String getTheme2() {
        return theme2;
    }

    public void setTheme2(String theme2) {
        this.theme2 = theme2;
    }

    public String getTheme3() {
        return theme3;
    }

    public void setTheme3(String theme3) {
        this.theme3 = theme3;
    }

    public String getTheme4() {
        return theme4;
    }

    public void setTheme4(String theme4) {
        this.theme4 = theme4;
    }

    public String getTheme5() {
        return theme5;
    }

    public void setTheme5(String theme5) {
        this.theme5 = theme5;
    }

    public String getTheme6() {
        return theme6;
    }

    public void setTheme6(String theme6) {
        this.theme6 = theme6;
    }

    public String getTheme7() {
        return theme7;
    }

    public void setTheme7(String theme7) {
        this.theme7 = theme7;
    }

    public String getTheme8() {
        return theme8;
    }

    public void setTheme8(String theme8) {
        this.theme8 = theme8;
    }

    public String getTheme9() {
        return theme9;
    }

    public void setTheme9(String theme9) {
        this.theme9 = theme9;
    }

    public Informants getInformant() {
        return informant;
    }

    public void setInformant(Informants informant) {
        this.informant = informant;
    }

    @XmlTransient
    public Collection<Paragraphs> getParagraphsCollection() {
        return paragraphsCollection;
    }

    public void setParagraphsCollection(Collection<Paragraphs> paragraphsCollection) {
        this.paragraphsCollection = paragraphsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Interviews)) {
            return false;
        }
        Interviews other = (Interviews) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return title;
    }
    
}
