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

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author spudrucket
 */
@Entity
@Table(name = "TERMS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Terms.findAll", query = "SELECT t FROM Terms t")
    , @NamedQuery(name = "Terms.findById", query = "SELECT t FROM Terms t WHERE t.id = :id")
    , @NamedQuery(name = "Terms.findByRootword", query = "SELECT t FROM Terms t WHERE t.rootword = :rootword")
    , @NamedQuery(name = "Terms.findByForms", query = "SELECT t FROM Terms t WHERE t.forms = :forms")
    , @NamedQuery(name = "Terms.findByOccurances", query = "SELECT t FROM Terms t WHERE t.occurances = :occurances")
    , @NamedQuery(name = "Terms.findByNotes", query = "SELECT t FROM Terms t WHERE t.notes = :notes")})
public class Terms implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "ROOTWORD", length = 50)
    private String rootword;
    @Column(name = "FORMS", length = 2048)
    private String forms;
    @Column(name = "OCCURANCES")
    private Integer occurances;
    @Column(name = "NOTES", length = 2048)
    private String notes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "term")
    private Collection<Usages> usagesCollection;

    public Terms() {
    }

    public Terms(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getRootword() {
        return rootword;
    }

    public void setRootword(String rootword) {
        String oldRootword = this.rootword;
        this.rootword = rootword;
        changeSupport.firePropertyChange("rootword", oldRootword, rootword);
    }

    public String getForms() {
        return forms;
    }

    public void setForms(String forms) {
        String oldForms = this.forms;
        this.forms = forms;
        changeSupport.firePropertyChange("forms", oldForms, forms);
    }

    public Integer getOccurances() {
        return occurances;
    }

    public void setOccurances(Integer occurances) {
        Integer oldOccurances = this.occurances;
        this.occurances = occurances;
        changeSupport.firePropertyChange("occurances", oldOccurances, occurances);
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        String oldNotes = this.notes;
        this.notes = notes;
        changeSupport.firePropertyChange("notes", oldNotes, notes);
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
        if (!(object instanceof Terms)) {
            return false;
        }
        Terms other = (Terms) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return rootword;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
