/*
 * Copyright (C) 2016 Mark_K
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

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author spudrucket
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paragraph")
    private Collection<Usages> usagesCollection;

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

    @XmlTransient
    public Collection<Usages> getUsagesCollection() {
        return usagesCollection;
    }

    public void setUsagesCollection(Collection<Usages> usagesCollection) {
        this.usagesCollection = usagesCollection;
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
        return "spudrucket.github.io.Colloquium.Paragraphs[ id=" + id + " ]";
    }
    
}
