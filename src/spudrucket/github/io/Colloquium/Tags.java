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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author spudrucket
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
        this.id = id;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public String getTagdefinition() {
        return tagdefinition;
    }

    public void setTagdefinition(String tagdefinition) {
        this.tagdefinition = tagdefinition;
    }

    public String getTagexplanation() {
        return tagexplanation;
    }

    public void setTagexplanation(String tagexplanation) {
        this.tagexplanation = tagexplanation;
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
    
}
