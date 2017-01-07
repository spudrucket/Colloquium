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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author spudrucket
 */
@Entity
@Table(name = "INFORMANTS", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"NICKNAME"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Informants.findAll", query = "SELECT i FROM Informants i")
    , @NamedQuery(name = "Informants.findById", query = "SELECT i FROM Informants i WHERE i.id = :id")
    , @NamedQuery(name = "Informants.findByFirstname", query = "SELECT i FROM Informants i WHERE i.firstname = :firstname")
    , @NamedQuery(name = "Informants.findBySurname", query = "SELECT i FROM Informants i WHERE i.surname = :surname")
    , @NamedQuery(name = "Informants.findByNickname", query = "SELECT i FROM Informants i WHERE i.nickname = :nickname")
    , @NamedQuery(name = "Informants.findByGender", query = "SELECT i FROM Informants i WHERE i.gender = :gender")
    , @NamedQuery(name = "Informants.findByAge", query = "SELECT i FROM Informants i WHERE i.age = :age")
    , @NamedQuery(name = "Informants.findByBirthplace", query = "SELECT i FROM Informants i WHERE i.birthplace = :birthplace")
    , @NamedQuery(name = "Informants.findByResidence", query = "SELECT i FROM Informants i WHERE i.residence = :residence")
    , @NamedQuery(name = "Informants.findByPrimarylang", query = "SELECT i FROM Informants i WHERE i.primarylang = :primarylang")
    , @NamedQuery(name = "Informants.findBySecondarylang", query = "SELECT i FROM Informants i WHERE i.secondarylang = :secondarylang")
    , @NamedQuery(name = "Informants.findByTribe", query = "SELECT i FROM Informants i WHERE i.tribe = :tribe")
    , @NamedQuery(name = "Informants.findByClan", query = "SELECT i FROM Informants i WHERE i.clan = :clan")
    , @NamedQuery(name = "Informants.findByMarriage", query = "SELECT i FROM Informants i WHERE i.marriage = :marriage")
    , @NamedQuery(name = "Informants.findByNumberofchildren", query = "SELECT i FROM Informants i WHERE i.numberofchildren = :numberofchildren")
    , @NamedQuery(name = "Informants.findByEconomic", query = "SELECT i FROM Informants i WHERE i.economic = :economic")
    , @NamedQuery(name = "Informants.findByProfession", query = "SELECT i FROM Informants i WHERE i.profession = :profession")
    , @NamedQuery(name = "Informants.findByEducation", query = "SELECT i FROM Informants i WHERE i.education = :education")
    , @NamedQuery(name = "Informants.findByReligion", query = "SELECT i FROM Informants i WHERE i.religion = :religion")
    , @NamedQuery(name = "Informants.findByOther1", query = "SELECT i FROM Informants i WHERE i.other1 = :other1")
    , @NamedQuery(name = "Informants.findByOther2", query = "SELECT i FROM Informants i WHERE i.other2 = :other2")
    , @NamedQuery(name = "Informants.findByOther3", query = "SELECT i FROM Informants i WHERE i.other3 = :other3")
    , @NamedQuery(name = "Informants.findByOther4", query = "SELECT i FROM Informants i WHERE i.other4 = :other4")
    , @NamedQuery(name = "Informants.findByOther5", query = "SELECT i FROM Informants i WHERE i.other5 = :other5")
    , @NamedQuery(name = "Informants.findByOther6", query = "SELECT i FROM Informants i WHERE i.other6 = :other6")
    , @NamedQuery(name = "Informants.findByOther7", query = "SELECT i FROM Informants i WHERE i.other7 = :other7")
    , @NamedQuery(name = "Informants.findByOther8", query = "SELECT i FROM Informants i WHERE i.other8 = :other8")
    , @NamedQuery(name = "Informants.findByOther9", query = "SELECT i FROM Informants i WHERE i.other9 = :other9")})
public class Informants implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "FIRSTNAME", length = 50)
    private String firstname;
    @Column(name = "SURNAME", length = 50)
    private String surname;
    @Basic(optional = false)
    @Column(name = "NICKNAME", nullable = false, length = 50)
    private String nickname;
    @Column(name = "GENDER", length = 20)
    private String gender;
    @Column(name = "AGE")
    private Integer age;
    @Column(name = "BIRTHPLACE", length = 50)
    private String birthplace;
    @Column(name = "RESIDENCE", length = 50)
    private String residence;
    @Column(name = "PRIMARYLANG", length = 50)
    private String primarylang;
    @Column(name = "SECONDARYLANG", length = 50)
    private String secondarylang;
    @Column(name = "TRIBE", length = 50)
    private String tribe;
    @Column(name = "CLAN", length = 50)
    private String clan;
    @Column(name = "MARRIAGE", length = 20)
    private String marriage;
    @Column(name = "NUMBEROFCHILDREN")
    private Integer numberofchildren;
    @Column(name = "ECONOMIC", length = 50)
    private String economic;
    @Column(name = "PROFESSION", length = 50)
    private String profession;
    @Column(name = "EDUCATION", length = 50)
    private String education;
    @Column(name = "RELIGION", length = 50)
    private String religion;
    @Column(name = "OTHER1", length = 50)
    private String other1;
    @Column(name = "OTHER2", length = 50)
    private String other2;
    @Column(name = "OTHER3", length = 50)
    private String other3;
    @Column(name = "OTHER4", length = 50)
    private String other4;
    @Column(name = "OTHER5", length = 50)
    private String other5;
    @Column(name = "OTHER6", length = 50)
    private String other6;
    @Column(name = "OTHER7", length = 50)
    private String other7;
    @Column(name = "OTHER8", length = 50)
    private String other8;
    @Column(name = "OTHER9", length = 50)
    private String other9;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "informant")
    private Collection<Interviews> interviewsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "informant")
    private Collection<Paragraphs> paragraphsCollection;

    public Informants() {
    }

    public Informants(Integer id) {
        this.id = id;
    }

    public Informants(Integer id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getPrimarylang() {
        return primarylang;
    }

    public void setPrimarylang(String primarylang) {
        this.primarylang = primarylang;
    }

    public String getSecondarylang() {
        return secondarylang;
    }

    public void setSecondarylang(String secondarylang) {
        this.secondarylang = secondarylang;
    }

    public String getTribe() {
        return tribe;
    }

    public void setTribe(String tribe) {
        this.tribe = tribe;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public Integer getNumberofchildren() {
        return numberofchildren;
    }

    public void setNumberofchildren(Integer numberofchildren) {
        this.numberofchildren = numberofchildren;
    }

    public String getEconomic() {
        return economic;
    }

    public void setEconomic(String economic) {
        this.economic = economic;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getOther1() {
        return other1;
    }

    public void setOther1(String other1) {
        this.other1 = other1;
    }

    public String getOther2() {
        return other2;
    }

    public void setOther2(String other2) {
        this.other2 = other2;
    }

    public String getOther3() {
        return other3;
    }

    public void setOther3(String other3) {
        this.other3 = other3;
    }

    public String getOther4() {
        return other4;
    }

    public void setOther4(String other4) {
        this.other4 = other4;
    }

    public String getOther5() {
        return other5;
    }

    public void setOther5(String other5) {
        this.other5 = other5;
    }

    public String getOther6() {
        return other6;
    }

    public void setOther6(String other6) {
        this.other6 = other6;
    }

    public String getOther7() {
        return other7;
    }

    public void setOther7(String other7) {
        this.other7 = other7;
    }

    public String getOther8() {
        return other8;
    }

    public void setOther8(String other8) {
        this.other8 = other8;
    }

    public String getOther9() {
        return other9;
    }

    public void setOther9(String other9) {
        this.other9 = other9;
    }

    @XmlTransient
    public Collection<Interviews> getInterviewsCollection() {
        return interviewsCollection;
    }

    public void setInterviewsCollection(Collection<Interviews> interviewsCollection) {
        this.interviewsCollection = interviewsCollection;
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
        if (!(object instanceof Informants)) {
            return false;
        }
        Informants other = (Informants) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nickname;
    }
    
}
