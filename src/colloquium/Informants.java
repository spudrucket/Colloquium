/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colloquium;

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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mark_K
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

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

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
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        String oldFirstname = this.firstname;
        this.firstname = firstname;
        changeSupport.firePropertyChange("firstname", oldFirstname, firstname);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        String oldSurname = this.surname;
        this.surname = surname;
        changeSupport.firePropertyChange("surname", oldSurname, surname);
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        String oldNickname = this.nickname;
        this.nickname = nickname;
        changeSupport.firePropertyChange("nickname", oldNickname, nickname);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        String oldGender = this.gender;
        this.gender = gender;
        changeSupport.firePropertyChange("gender", oldGender, gender);
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        Integer oldAge = this.age;
        this.age = age;
        changeSupport.firePropertyChange("age", oldAge, age);
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        String oldBirthplace = this.birthplace;
        this.birthplace = birthplace;
        changeSupport.firePropertyChange("birthplace", oldBirthplace, birthplace);
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        String oldResidence = this.residence;
        this.residence = residence;
        changeSupport.firePropertyChange("residence", oldResidence, residence);
    }

    public String getPrimarylang() {
        return primarylang;
    }

    public void setPrimarylang(String primarylang) {
        String oldPrimarylang = this.primarylang;
        this.primarylang = primarylang;
        changeSupport.firePropertyChange("primarylang", oldPrimarylang, primarylang);
    }

    public String getSecondarylang() {
        return secondarylang;
    }

    public void setSecondarylang(String secondarylang) {
        String oldSecondarylang = this.secondarylang;
        this.secondarylang = secondarylang;
        changeSupport.firePropertyChange("secondarylang", oldSecondarylang, secondarylang);
    }

    public String getTribe() {
        return tribe;
    }

    public void setTribe(String tribe) {
        String oldTribe = this.tribe;
        this.tribe = tribe;
        changeSupport.firePropertyChange("tribe", oldTribe, tribe);
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        String oldClan = this.clan;
        this.clan = clan;
        changeSupport.firePropertyChange("clan", oldClan, clan);
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        String oldMarriage = this.marriage;
        this.marriage = marriage;
        changeSupport.firePropertyChange("marriage", oldMarriage, marriage);
    }

    public Integer getNumberofchildren() {
        return numberofchildren;
    }

    public void setNumberofchildren(Integer numberofchildren) {
        Integer oldNumberofchildren = this.numberofchildren;
        this.numberofchildren = numberofchildren;
        changeSupport.firePropertyChange("numberofchildren", oldNumberofchildren, numberofchildren);
    }

    public String getEconomic() {
        return economic;
    }

    public void setEconomic(String economic) {
        String oldEconomic = this.economic;
        this.economic = economic;
        changeSupport.firePropertyChange("economic", oldEconomic, economic);
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        String oldProfession = this.profession;
        this.profession = profession;
        changeSupport.firePropertyChange("profession", oldProfession, profession);
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        String oldEducation = this.education;
        this.education = education;
        changeSupport.firePropertyChange("education", oldEducation, education);
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        String oldReligion = this.religion;
        this.religion = religion;
        changeSupport.firePropertyChange("religion", oldReligion, religion);
    }

    public String getOther1() {
        return other1;
    }

    public void setOther1(String other1) {
        String oldOther1 = this.other1;
        this.other1 = other1;
        changeSupport.firePropertyChange("other1", oldOther1, other1);
    }

    public String getOther2() {
        return other2;
    }

    public void setOther2(String other2) {
        String oldOther2 = this.other2;
        this.other2 = other2;
        changeSupport.firePropertyChange("other2", oldOther2, other2);
    }

    public String getOther3() {
        return other3;
    }

    public void setOther3(String other3) {
        String oldOther3 = this.other3;
        this.other3 = other3;
        changeSupport.firePropertyChange("other3", oldOther3, other3);
    }

    public String getOther4() {
        return other4;
    }

    public void setOther4(String other4) {
        String oldOther4 = this.other4;
        this.other4 = other4;
        changeSupport.firePropertyChange("other4", oldOther4, other4);
    }

    public String getOther5() {
        return other5;
    }

    public void setOther5(String other5) {
        String oldOther5 = this.other5;
        this.other5 = other5;
        changeSupport.firePropertyChange("other5", oldOther5, other5);
    }

    public String getOther6() {
        return other6;
    }

    public void setOther6(String other6) {
        String oldOther6 = this.other6;
        this.other6 = other6;
        changeSupport.firePropertyChange("other6", oldOther6, other6);
    }

    public String getOther7() {
        return other7;
    }

    public void setOther7(String other7) {
        String oldOther7 = this.other7;
        this.other7 = other7;
        changeSupport.firePropertyChange("other7", oldOther7, other7);
    }

    public String getOther8() {
        return other8;
    }

    public void setOther8(String other8) {
        String oldOther8 = this.other8;
        this.other8 = other8;
        changeSupport.firePropertyChange("other8", oldOther8, other8);
    }

    public String getOther9() {
        return other9;
    }

    public void setOther9(String other9) {
        String oldOther9 = this.other9;
        this.other9 = other9;
        changeSupport.firePropertyChange("other9", oldOther9, other9);
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

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
