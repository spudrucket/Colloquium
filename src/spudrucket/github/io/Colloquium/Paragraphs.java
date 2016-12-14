/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spudrucket.github.io.Colloquium;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mark_K
 */
@Entity
@Table(name = "PARAGRAPHS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paragraphs.findAll", query = "SELECT p FROM Paragraphs p")
    , @NamedQuery(name = "Paragraphs.findById", query = "SELECT p FROM Paragraphs p WHERE p.id = :id")
    , @NamedQuery(name = "Paragraphs.findByInformant", query = "SELECT p FROM Paragraphs p WHERE p.informant = :informant")
    , @NamedQuery(name = "Paragraphs.findByInterviewnumber", query = "SELECT p FROM Paragraphs p WHERE p.interviewnumber = :interviewnumber")
    , @NamedQuery(name = "Paragraphs.findByNotes", query = "SELECT p FROM Paragraphs p WHERE p.notes = :notes")
    , @NamedQuery(name = "Paragraphs.findByTags", query = "SELECT p FROM Paragraphs p WHERE p.tags = :tags")})
public class Paragraphs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "TEXT", nullable = false, length = 32700)
    private String text;
    @Lob
    @Column(name = "TRANS", length = 32700)
    private String trans;
    @Column(name = "NOTES", length = 2048)
    private String notes;
    @Column(name = "TAGS", length = 2048)
    private String tags;
    @JoinColumn(name = "INFORMANT", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Informants informant;
    @JoinColumn(name = "INTERVIEWNUMBER", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Interviews interviewnumber;

    public Paragraphs() {
    }

    public Paragraphs(Integer id) {
        this.id = id;
    }

    public Paragraphs(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Informants getInformant() {
        return informant;
    }

    public void setInformant(Informants informant) {
        this.informant = informant;
    }

    public Interviews getInterviewnumber() {
        return interviewnumber;
    }

    public void setInterviewnumber(Interviews interviewnumber) {
        this.interviewnumber = interviewnumber;
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
        if (!(object instanceof Paragraphs)) {
            return false;
        }
        Paragraphs other = (Paragraphs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "colloquium.Paragraphs[ id=" + id + " ]";
    }
    
}
