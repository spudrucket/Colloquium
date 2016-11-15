/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colloquium;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mark_K
 */
@Entity
@Table(name = "TAGS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tags.findAll", query = "SELECT t FROM Tags t")
    , @NamedQuery(name = "Tags.findById", query = "SELECT t FROM Tags t WHERE t.id = :id")
    , @NamedQuery(name = "Tags.findByTagname", query = "SELECT t FROM Tags t WHERE t.tagname = :tagname")
    , @NamedQuery(name = "Tags.findByTagdefinition", query = "SELECT t FROM Tags t WHERE t.tagdefinition = :tagdefinition")
    , @NamedQuery(name = "Tags.findByTagexplanation", query = "SELECT t FROM Tags t WHERE t.tagexplanation = :tagexplanation")})
public class Tags implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "TAGNAME", length = 50)
    private String tagname;
    @Column(name = "TAGDEFINITION", length = 512)
    private String tagdefinition;
    @Column(name = "TAGEXPLANATION", length = 2048)
    private String tagexplanation;

    public Tags() {
    }

    public Tags(Integer id) {
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

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        String oldTagname = this.tagname;
        this.tagname = tagname;
        changeSupport.firePropertyChange("tagname", oldTagname, tagname);
    }

    public String getTagdefinition() {
        return tagdefinition;
    }

    public void setTagdefinition(String tagdefinition) {
        String oldTagdefinition = this.tagdefinition;
        this.tagdefinition = tagdefinition;
        changeSupport.firePropertyChange("tagdefinition", oldTagdefinition, tagdefinition);
    }

    public String getTagexplanation() {
        return tagexplanation;
    }

    public void setTagexplanation(String tagexplanation) {
        String oldTagexplanation = this.tagexplanation;
        this.tagexplanation = tagexplanation;
        changeSupport.firePropertyChange("tagexplanation", oldTagexplanation, tagexplanation);
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
        if (!(object instanceof Tags)) {
            return false;
        }
        Tags other = (Tags) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tagname;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
