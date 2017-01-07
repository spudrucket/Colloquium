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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author spudrucket
 */
@Entity
@Table(name = "USAGES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usages.findAll", query = "SELECT u FROM Usages u")
    , @NamedQuery(name = "Usages.findById", query = "SELECT u FROM Usages u WHERE u.id = :id")
    , @NamedQuery(name = "Usages.findByTerm", query = "SELECT U FROM Usages u WHERE u.term = :term")
    , @NamedQuery(name = "Usages.findByForm", query = "SELECT u FROM Usages u WHERE u.form = :form")
    , @NamedQuery(name = "Usages.findBySentence", query = "SELECT u FROM Usages u WHERE u.sentence = :sentence")})
public class Usages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "FORM", length = 50)
    private String form;
    @Column(name = "SENTENCE", length = 2048)
    private String sentence;
    @JoinColumn(name = "PARAGRAPH", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Paragraphs paragraph;
    @JoinColumn(name = "TERM", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Terms term;

    public Usages() {
    }

    public Usages(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public Paragraphs getParagraph() {
        return paragraph;
    }

    public void setParagraph(Paragraphs paragraph) {
        this.paragraph = paragraph;
    }

    public Terms getTerm() {
        return term;
    }

    public void setTerm(Terms term) {
        this.term = term;
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
        if (!(object instanceof Usages)) {
            return false;
        }
        Usages other = (Usages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "spudrucket.github.io.Colloquium.Usages[ id=" + id + " ]";
    }
    
}
