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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "PARAGRAPHS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paragraphs.findAll", query = "SELECT p FROM Paragraphs p")
    , @NamedQuery(name = "Paragraphs.findById", query = "SELECT p FROM Paragraphs p WHERE p.id = :id")
    , @NamedQuery(name = "Paragraphs.findByTag00", query = "SELECT p FROM Paragraphs p WHERE p.tag00 = :tag00")
    , @NamedQuery(name = "Paragraphs.findByTag01", query = "SELECT p FROM Paragraphs p WHERE p.tag01 = :tag01")
    , @NamedQuery(name = "Paragraphs.findByTag02", query = "SELECT p FROM Paragraphs p WHERE p.tag02 = :tag02")
    , @NamedQuery(name = "Paragraphs.findByTag03", query = "SELECT p FROM Paragraphs p WHERE p.tag03 = :tag03")
    , @NamedQuery(name = "Paragraphs.findByTag04", query = "SELECT p FROM Paragraphs p WHERE p.tag04 = :tag04")
    , @NamedQuery(name = "Paragraphs.findByTag05", query = "SELECT p FROM Paragraphs p WHERE p.tag05 = :tag05")
    , @NamedQuery(name = "Paragraphs.findByTag06", query = "SELECT p FROM Paragraphs p WHERE p.tag06 = :tag06")
    , @NamedQuery(name = "Paragraphs.findByTag07", query = "SELECT p FROM Paragraphs p WHERE p.tag07 = :tag07")
    , @NamedQuery(name = "Paragraphs.findByTag08", query = "SELECT p FROM Paragraphs p WHERE p.tag08 = :tag08")
    , @NamedQuery(name = "Paragraphs.findByTag09", query = "SELECT p FROM Paragraphs p WHERE p.tag09 = :tag09")
    , @NamedQuery(name = "Paragraphs.findByTag10", query = "SELECT p FROM Paragraphs p WHERE p.tag10 = :tag10")
    , @NamedQuery(name = "Paragraphs.findByTag11", query = "SELECT p FROM Paragraphs p WHERE p.tag11 = :tag11")
    , @NamedQuery(name = "Paragraphs.findByTag12", query = "SELECT p FROM Paragraphs p WHERE p.tag12 = :tag12")
    , @NamedQuery(name = "Paragraphs.findByTag13", query = "SELECT p FROM Paragraphs p WHERE p.tag13 = :tag13")
    , @NamedQuery(name = "Paragraphs.findByTag14", query = "SELECT p FROM Paragraphs p WHERE p.tag14 = :tag14")
    , @NamedQuery(name = "Paragraphs.findByTag15", query = "SELECT p FROM Paragraphs p WHERE p.tag15 = :tag15")
    , @NamedQuery(name = "Paragraphs.findByTag16", query = "SELECT p FROM Paragraphs p WHERE p.tag16 = :tag16")
    , @NamedQuery(name = "Paragraphs.findByTag17", query = "SELECT p FROM Paragraphs p WHERE p.tag17 = :tag17")
    , @NamedQuery(name = "Paragraphs.findByTag18", query = "SELECT p FROM Paragraphs p WHERE p.tag18 = :tag18")
    , @NamedQuery(name = "Paragraphs.findByTag19", query = "SELECT p FROM Paragraphs p WHERE p.tag19 = :tag19")
    , @NamedQuery(name = "Paragraphs.findByTag20", query = "SELECT p FROM Paragraphs p WHERE p.tag20 = :tag20")
    , @NamedQuery(name = "Paragraphs.findByTag21", query = "SELECT p FROM Paragraphs p WHERE p.tag21 = :tag21")
    , @NamedQuery(name = "Paragraphs.findByTag22", query = "SELECT p FROM Paragraphs p WHERE p.tag22 = :tag22")
    , @NamedQuery(name = "Paragraphs.findByTag23", query = "SELECT p FROM Paragraphs p WHERE p.tag23 = :tag23")
    , @NamedQuery(name = "Paragraphs.findByTag24", query = "SELECT p FROM Paragraphs p WHERE p.tag24 = :tag24")
    , @NamedQuery(name = "Paragraphs.findByTag25", query = "SELECT p FROM Paragraphs p WHERE p.tag25 = :tag25")
    , @NamedQuery(name = "Paragraphs.findByTag26", query = "SELECT p FROM Paragraphs p WHERE p.tag26 = :tag26")
    , @NamedQuery(name = "Paragraphs.findByTag27", query = "SELECT p FROM Paragraphs p WHERE p.tag27 = :tag27")
    , @NamedQuery(name = "Paragraphs.findByTag28", query = "SELECT p FROM Paragraphs p WHERE p.tag28 = :tag28")
    , @NamedQuery(name = "Paragraphs.findByTag29", query = "SELECT p FROM Paragraphs p WHERE p.tag29 = :tag29")
    , @NamedQuery(name = "Paragraphs.findByTag30", query = "SELECT p FROM Paragraphs p WHERE p.tag30 = :tag30")
    , @NamedQuery(name = "Paragraphs.findByTag31", query = "SELECT p FROM Paragraphs p WHERE p.tag31 = :tag31")
    , @NamedQuery(name = "Paragraphs.findByTag32", query = "SELECT p FROM Paragraphs p WHERE p.tag32 = :tag32")
    , @NamedQuery(name = "Paragraphs.findByTag33", query = "SELECT p FROM Paragraphs p WHERE p.tag33 = :tag33")
    , @NamedQuery(name = "Paragraphs.findByTag34", query = "SELECT p FROM Paragraphs p WHERE p.tag34 = :tag34")
    , @NamedQuery(name = "Paragraphs.findByTag35", query = "SELECT p FROM Paragraphs p WHERE p.tag35 = :tag35")
    , @NamedQuery(name = "Paragraphs.findByTag36", query = "SELECT p FROM Paragraphs p WHERE p.tag36 = :tag36")
    , @NamedQuery(name = "Paragraphs.findByTag37", query = "SELECT p FROM Paragraphs p WHERE p.tag37 = :tag37")
    , @NamedQuery(name = "Paragraphs.findByTag38", query = "SELECT p FROM Paragraphs p WHERE p.tag38 = :tag38")
    , @NamedQuery(name = "Paragraphs.findByTag39", query = "SELECT p FROM Paragraphs p WHERE p.tag39 = :tag39")
    , @NamedQuery(name = "Paragraphs.findByTag40", query = "SELECT p FROM Paragraphs p WHERE p.tag40 = :tag40")
    , @NamedQuery(name = "Paragraphs.findByTag41", query = "SELECT p FROM Paragraphs p WHERE p.tag41 = :tag41")
    , @NamedQuery(name = "Paragraphs.findByTag42", query = "SELECT p FROM Paragraphs p WHERE p.tag42 = :tag42")
    , @NamedQuery(name = "Paragraphs.findByTag43", query = "SELECT p FROM Paragraphs p WHERE p.tag43 = :tag43")
    , @NamedQuery(name = "Paragraphs.findByTag44", query = "SELECT p FROM Paragraphs p WHERE p.tag44 = :tag44")
    , @NamedQuery(name = "Paragraphs.findByTag45", query = "SELECT p FROM Paragraphs p WHERE p.tag45 = :tag45")
    , @NamedQuery(name = "Paragraphs.findByTag46", query = "SELECT p FROM Paragraphs p WHERE p.tag46 = :tag46")
    , @NamedQuery(name = "Paragraphs.findByTag47", query = "SELECT p FROM Paragraphs p WHERE p.tag47 = :tag47")
    , @NamedQuery(name = "Paragraphs.findByTag48", query = "SELECT p FROM Paragraphs p WHERE p.tag48 = :tag48")
    , @NamedQuery(name = "Paragraphs.findByTag49", query = "SELECT p FROM Paragraphs p WHERE p.tag49 = :tag49")
    , @NamedQuery(name = "Paragraphs.findByTag50", query = "SELECT p FROM Paragraphs p WHERE p.tag50 = :tag50")
    , @NamedQuery(name = "Paragraphs.findByTag51", query = "SELECT p FROM Paragraphs p WHERE p.tag51 = :tag51")
    , @NamedQuery(name = "Paragraphs.findByTag52", query = "SELECT p FROM Paragraphs p WHERE p.tag52 = :tag52")
    , @NamedQuery(name = "Paragraphs.findByTag53", query = "SELECT p FROM Paragraphs p WHERE p.tag53 = :tag53")
    , @NamedQuery(name = "Paragraphs.findByTag54", query = "SELECT p FROM Paragraphs p WHERE p.tag54 = :tag54")
    , @NamedQuery(name = "Paragraphs.findByTag55", query = "SELECT p FROM Paragraphs p WHERE p.tag55 = :tag55")
    , @NamedQuery(name = "Paragraphs.findByTag56", query = "SELECT p FROM Paragraphs p WHERE p.tag56 = :tag56")
    , @NamedQuery(name = "Paragraphs.findByTag57", query = "SELECT p FROM Paragraphs p WHERE p.tag57 = :tag57")
    , @NamedQuery(name = "Paragraphs.findByTag58", query = "SELECT p FROM Paragraphs p WHERE p.tag58 = :tag58")
    , @NamedQuery(name = "Paragraphs.findByTag59", query = "SELECT p FROM Paragraphs p WHERE p.tag59 = :tag59")
    , @NamedQuery(name = "Paragraphs.findByTag60", query = "SELECT p FROM Paragraphs p WHERE p.tag60 = :tag60")
    , @NamedQuery(name = "Paragraphs.findByTag61", query = "SELECT p FROM Paragraphs p WHERE p.tag61 = :tag61")
    , @NamedQuery(name = "Paragraphs.findByTag62", query = "SELECT p FROM Paragraphs p WHERE p.tag62 = :tag62")
    , @NamedQuery(name = "Paragraphs.findByTag63", query = "SELECT p FROM Paragraphs p WHERE p.tag63 = :tag63")
    , @NamedQuery(name = "Paragraphs.findByTag64", query = "SELECT p FROM Paragraphs p WHERE p.tag64 = :tag64")
    , @NamedQuery(name = "Paragraphs.findByTag65", query = "SELECT p FROM Paragraphs p WHERE p.tag65 = :tag65")
    , @NamedQuery(name = "Paragraphs.findByTag66", query = "SELECT p FROM Paragraphs p WHERE p.tag66 = :tag66")
    , @NamedQuery(name = "Paragraphs.findByTag67", query = "SELECT p FROM Paragraphs p WHERE p.tag67 = :tag67")
    , @NamedQuery(name = "Paragraphs.findByTag68", query = "SELECT p FROM Paragraphs p WHERE p.tag68 = :tag68")
    , @NamedQuery(name = "Paragraphs.findByTag69", query = "SELECT p FROM Paragraphs p WHERE p.tag69 = :tag69")
    , @NamedQuery(name = "Paragraphs.findByTag70", query = "SELECT p FROM Paragraphs p WHERE p.tag70 = :tag70")
    , @NamedQuery(name = "Paragraphs.findByTag71", query = "SELECT p FROM Paragraphs p WHERE p.tag71 = :tag71")
    , @NamedQuery(name = "Paragraphs.findByTag72", query = "SELECT p FROM Paragraphs p WHERE p.tag72 = :tag72")
    , @NamedQuery(name = "Paragraphs.findByTag73", query = "SELECT p FROM Paragraphs p WHERE p.tag73 = :tag73")
    , @NamedQuery(name = "Paragraphs.findByTag74", query = "SELECT p FROM Paragraphs p WHERE p.tag74 = :tag74")
    , @NamedQuery(name = "Paragraphs.findByTag75", query = "SELECT p FROM Paragraphs p WHERE p.tag75 = :tag75")
    , @NamedQuery(name = "Paragraphs.findByTag76", query = "SELECT p FROM Paragraphs p WHERE p.tag76 = :tag76")
    , @NamedQuery(name = "Paragraphs.findByTag77", query = "SELECT p FROM Paragraphs p WHERE p.tag77 = :tag77")
    , @NamedQuery(name = "Paragraphs.findByTag78", query = "SELECT p FROM Paragraphs p WHERE p.tag78 = :tag78")
    , @NamedQuery(name = "Paragraphs.findByTag79", query = "SELECT p FROM Paragraphs p WHERE p.tag79 = :tag79")
    , @NamedQuery(name = "Paragraphs.findByTag80", query = "SELECT p FROM Paragraphs p WHERE p.tag80 = :tag80")
    , @NamedQuery(name = "Paragraphs.findByTag81", query = "SELECT p FROM Paragraphs p WHERE p.tag81 = :tag81")
    , @NamedQuery(name = "Paragraphs.findByTag82", query = "SELECT p FROM Paragraphs p WHERE p.tag82 = :tag82")
    , @NamedQuery(name = "Paragraphs.findByTag83", query = "SELECT p FROM Paragraphs p WHERE p.tag83 = :tag83")
    , @NamedQuery(name = "Paragraphs.findByTag84", query = "SELECT p FROM Paragraphs p WHERE p.tag84 = :tag84")
    , @NamedQuery(name = "Paragraphs.findByTag85", query = "SELECT p FROM Paragraphs p WHERE p.tag85 = :tag85")
    , @NamedQuery(name = "Paragraphs.findByTag86", query = "SELECT p FROM Paragraphs p WHERE p.tag86 = :tag86")
    , @NamedQuery(name = "Paragraphs.findByTag87", query = "SELECT p FROM Paragraphs p WHERE p.tag87 = :tag87")
    , @NamedQuery(name = "Paragraphs.findByTag88", query = "SELECT p FROM Paragraphs p WHERE p.tag88 = :tag88")
    , @NamedQuery(name = "Paragraphs.findByTag89", query = "SELECT p FROM Paragraphs p WHERE p.tag89 = :tag89")
    , @NamedQuery(name = "Paragraphs.findByTag90", query = "SELECT p FROM Paragraphs p WHERE p.tag90 = :tag90")
    , @NamedQuery(name = "Paragraphs.findByTag91", query = "SELECT p FROM Paragraphs p WHERE p.tag91 = :tag91")
    , @NamedQuery(name = "Paragraphs.findByTag92", query = "SELECT p FROM Paragraphs p WHERE p.tag92 = :tag92")
    , @NamedQuery(name = "Paragraphs.findByTag93", query = "SELECT p FROM Paragraphs p WHERE p.tag93 = :tag93")
    , @NamedQuery(name = "Paragraphs.findByTag94", query = "SELECT p FROM Paragraphs p WHERE p.tag94 = :tag94")
    , @NamedQuery(name = "Paragraphs.findByTag95", query = "SELECT p FROM Paragraphs p WHERE p.tag95 = :tag95")
    , @NamedQuery(name = "Paragraphs.findByTag96", query = "SELECT p FROM Paragraphs p WHERE p.tag96 = :tag96")
    , @NamedQuery(name = "Paragraphs.findByTag97", query = "SELECT p FROM Paragraphs p WHERE p.tag97 = :tag97")
    , @NamedQuery(name = "Paragraphs.findByTag98", query = "SELECT p FROM Paragraphs p WHERE p.tag98 = :tag98")
    , @NamedQuery(name = "Paragraphs.findByTag99", query = "SELECT p FROM Paragraphs p WHERE p.tag99 = :tag99")})
public class Paragraphs implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

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
    @Column(name = "TAG00")
    private Integer tag00;
    @Column(name = "TAG01")
    private Integer tag01;
    @Column(name = "TAG02")
    private Integer tag02;
    @Column(name = "TAG03")
    private Integer tag03;
    @Column(name = "TAG04")
    private Integer tag04;
    @Column(name = "TAG05")
    private Integer tag05;
    @Column(name = "TAG06")
    private Integer tag06;
    @Column(name = "TAG07")
    private Integer tag07;
    @Column(name = "TAG08")
    private Integer tag08;
    @Column(name = "TAG09")
    private Integer tag09;
    @Column(name = "TAG10")
    private Integer tag10;
    @Column(name = "TAG11")
    private Integer tag11;
    @Column(name = "TAG12")
    private Integer tag12;
    @Column(name = "TAG13")
    private Integer tag13;
    @Column(name = "TAG14")
    private Integer tag14;
    @Column(name = "TAG15")
    private Integer tag15;
    @Column(name = "TAG16")
    private Integer tag16;
    @Column(name = "TAG17")
    private Integer tag17;
    @Column(name = "TAG18")
    private Integer tag18;
    @Column(name = "TAG19")
    private Integer tag19;
    @Column(name = "TAG20")
    private Integer tag20;
    @Column(name = "TAG21")
    private Integer tag21;
    @Column(name = "TAG22")
    private Integer tag22;
    @Column(name = "TAG23")
    private Integer tag23;
    @Column(name = "TAG24")
    private Integer tag24;
    @Column(name = "TAG25")
    private Integer tag25;
    @Column(name = "TAG26")
    private Integer tag26;
    @Column(name = "TAG27")
    private Integer tag27;
    @Column(name = "TAG28")
    private Integer tag28;
    @Column(name = "TAG29")
    private Integer tag29;
    @Column(name = "TAG30")
    private Integer tag30;
    @Column(name = "TAG31")
    private Integer tag31;
    @Column(name = "TAG32")
    private Integer tag32;
    @Column(name = "TAG33")
    private Integer tag33;
    @Column(name = "TAG34")
    private Integer tag34;
    @Column(name = "TAG35")
    private Integer tag35;
    @Column(name = "TAG36")
    private Integer tag36;
    @Column(name = "TAG37")
    private Integer tag37;
    @Column(name = "TAG38")
    private Integer tag38;
    @Column(name = "TAG39")
    private Integer tag39;
    @Column(name = "TAG40")
    private Integer tag40;
    @Column(name = "TAG41")
    private Integer tag41;
    @Column(name = "TAG42")
    private Integer tag42;
    @Column(name = "TAG43")
    private Integer tag43;
    @Column(name = "TAG44")
    private Integer tag44;
    @Column(name = "TAG45")
    private Integer tag45;
    @Column(name = "TAG46")
    private Integer tag46;
    @Column(name = "TAG47")
    private Integer tag47;
    @Column(name = "TAG48")
    private Integer tag48;
    @Column(name = "TAG49")
    private Integer tag49;
    @Column(name = "TAG50")
    private Integer tag50;
    @Column(name = "TAG51")
    private Integer tag51;
    @Column(name = "TAG52")
    private Integer tag52;
    @Column(name = "TAG53")
    private Integer tag53;
    @Column(name = "TAG54")
    private Integer tag54;
    @Column(name = "TAG55")
    private Integer tag55;
    @Column(name = "TAG56")
    private Integer tag56;
    @Column(name = "TAG57")
    private Integer tag57;
    @Column(name = "TAG58")
    private Integer tag58;
    @Column(name = "TAG59")
    private Integer tag59;
    @Column(name = "TAG60")
    private Integer tag60;
    @Column(name = "TAG61")
    private Integer tag61;
    @Column(name = "TAG62")
    private Integer tag62;
    @Column(name = "TAG63")
    private Integer tag63;
    @Column(name = "TAG64")
    private Integer tag64;
    @Column(name = "TAG65")
    private Integer tag65;
    @Column(name = "TAG66")
    private Integer tag66;
    @Column(name = "TAG67")
    private Integer tag67;
    @Column(name = "TAG68")
    private Integer tag68;
    @Column(name = "TAG69")
    private Integer tag69;
    @Column(name = "TAG70")
    private Integer tag70;
    @Column(name = "TAG71")
    private Integer tag71;
    @Column(name = "TAG72")
    private Integer tag72;
    @Column(name = "TAG73")
    private Integer tag73;
    @Column(name = "TAG74")
    private Integer tag74;
    @Column(name = "TAG75")
    private Integer tag75;
    @Column(name = "TAG76")
    private Integer tag76;
    @Column(name = "TAG77")
    private Integer tag77;
    @Column(name = "TAG78")
    private Integer tag78;
    @Column(name = "TAG79")
    private Integer tag79;
    @Column(name = "TAG80")
    private Integer tag80;
    @Column(name = "TAG81")
    private Integer tag81;
    @Column(name = "TAG82")
    private Integer tag82;
    @Column(name = "TAG83")
    private Integer tag83;
    @Column(name = "TAG84")
    private Integer tag84;
    @Column(name = "TAG85")
    private Integer tag85;
    @Column(name = "TAG86")
    private Integer tag86;
    @Column(name = "TAG87")
    private Integer tag87;
    @Column(name = "TAG88")
    private Integer tag88;
    @Column(name = "TAG89")
    private Integer tag89;
    @Column(name = "TAG90")
    private Integer tag90;
    @Column(name = "TAG91")
    private Integer tag91;
    @Column(name = "TAG92")
    private Integer tag92;
    @Column(name = "TAG93")
    private Integer tag93;
    @Column(name = "TAG94")
    private Integer tag94;
    @Column(name = "TAG95")
    private Integer tag95;
    @Column(name = "TAG96")
    private Integer tag96;
    @Column(name = "TAG97")
    private Integer tag97;
    @Column(name = "TAG98")
    private Integer tag98;
    @Column(name = "TAG99")
    private Integer tag99;
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
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        String oldText = this.text;
        this.text = text;
        changeSupport.firePropertyChange("text", oldText, text);
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        String oldTrans = this.trans;
        this.trans = trans;
        changeSupport.firePropertyChange("trans", oldTrans, trans);
    }

    public Integer getTag00() {
        return tag00;
    }

    public void setTag00(Integer tag00) {
        Integer oldTag00 = this.tag00;
        this.tag00 = tag00;
        changeSupport.firePropertyChange("tag00", oldTag00, tag00);
    }

    public Integer getTag01() {
        return tag01;
    }

    public void setTag01(Integer tag01) {
        Integer oldTag01 = this.tag01;
        this.tag01 = tag01;
        changeSupport.firePropertyChange("tag01", oldTag01, tag01);
    }

    public Integer getTag02() {
        return tag02;
    }

    public void setTag02(Integer tag02) {
        Integer oldTag02 = this.tag02;
        this.tag02 = tag02;
        changeSupport.firePropertyChange("tag02", oldTag02, tag02);
    }

    public Integer getTag03() {
        return tag03;
    }

    public void setTag03(Integer tag03) {
        Integer oldTag03 = this.tag03;
        this.tag03 = tag03;
        changeSupport.firePropertyChange("tag03", oldTag03, tag03);
    }

    public Integer getTag04() {
        return tag04;
    }

    public void setTag04(Integer tag04) {
        Integer oldTag04 = this.tag04;
        this.tag04 = tag04;
        changeSupport.firePropertyChange("tag04", oldTag04, tag04);
    }

    public Integer getTag05() {
        return tag05;
    }

    public void setTag05(Integer tag05) {
        Integer oldTag05 = this.tag05;
        this.tag05 = tag05;
        changeSupport.firePropertyChange("tag05", oldTag05, tag05);
    }

    public Integer getTag06() {
        return tag06;
    }

    public void setTag06(Integer tag06) {
        Integer oldTag06 = this.tag06;
        this.tag06 = tag06;
        changeSupport.firePropertyChange("tag06", oldTag06, tag06);
    }

    public Integer getTag07() {
        return tag07;
    }

    public void setTag07(Integer tag07) {
        Integer oldTag07 = this.tag07;
        this.tag07 = tag07;
        changeSupport.firePropertyChange("tag07", oldTag07, tag07);
    }

    public Integer getTag08() {
        return tag08;
    }

    public void setTag08(Integer tag08) {
        Integer oldTag08 = this.tag08;
        this.tag08 = tag08;
        changeSupport.firePropertyChange("tag08", oldTag08, tag08);
    }

    public Integer getTag09() {
        return tag09;
    }

    public void setTag09(Integer tag09) {
        Integer oldTag09 = this.tag09;
        this.tag09 = tag09;
        changeSupport.firePropertyChange("tag09", oldTag09, tag09);
    }

    public Integer getTag10() {
        return tag10;
    }

    public void setTag10(Integer tag10) {
        Integer oldTag10 = this.tag10;
        this.tag10 = tag10;
        changeSupport.firePropertyChange("tag10", oldTag10, tag10);
    }

    public Integer getTag11() {
        return tag11;
    }

    public void setTag11(Integer tag11) {
        Integer oldTag11 = this.tag11;
        this.tag11 = tag11;
        changeSupport.firePropertyChange("tag11", oldTag11, tag11);
    }

    public Integer getTag12() {
        return tag12;
    }

    public void setTag12(Integer tag12) {
        Integer oldTag12 = this.tag12;
        this.tag12 = tag12;
        changeSupport.firePropertyChange("tag12", oldTag12, tag12);
    }

    public Integer getTag13() {
        return tag13;
    }

    public void setTag13(Integer tag13) {
        Integer oldTag13 = this.tag13;
        this.tag13 = tag13;
        changeSupport.firePropertyChange("tag13", oldTag13, tag13);
    }

    public Integer getTag14() {
        return tag14;
    }

    public void setTag14(Integer tag14) {
        Integer oldTag14 = this.tag14;
        this.tag14 = tag14;
        changeSupport.firePropertyChange("tag14", oldTag14, tag14);
    }

    public Integer getTag15() {
        return tag15;
    }

    public void setTag15(Integer tag15) {
        Integer oldTag15 = this.tag15;
        this.tag15 = tag15;
        changeSupport.firePropertyChange("tag15", oldTag15, tag15);
    }

    public Integer getTag16() {
        return tag16;
    }

    public void setTag16(Integer tag16) {
        Integer oldTag16 = this.tag16;
        this.tag16 = tag16;
        changeSupport.firePropertyChange("tag16", oldTag16, tag16);
    }

    public Integer getTag17() {
        return tag17;
    }

    public void setTag17(Integer tag17) {
        Integer oldTag17 = this.tag17;
        this.tag17 = tag17;
        changeSupport.firePropertyChange("tag17", oldTag17, tag17);
    }

    public Integer getTag18() {
        return tag18;
    }

    public void setTag18(Integer tag18) {
        Integer oldTag18 = this.tag18;
        this.tag18 = tag18;
        changeSupport.firePropertyChange("tag18", oldTag18, tag18);
    }

    public Integer getTag19() {
        return tag19;
    }

    public void setTag19(Integer tag19) {
        Integer oldTag19 = this.tag19;
        this.tag19 = tag19;
        changeSupport.firePropertyChange("tag19", oldTag19, tag19);
    }

    public Integer getTag20() {
        return tag20;
    }

    public void setTag20(Integer tag20) {
        Integer oldTag20 = this.tag20;
        this.tag20 = tag20;
        changeSupport.firePropertyChange("tag20", oldTag20, tag20);
    }

    public Integer getTag21() {
        return tag21;
    }

    public void setTag21(Integer tag21) {
        Integer oldTag21 = this.tag21;
        this.tag21 = tag21;
        changeSupport.firePropertyChange("tag21", oldTag21, tag21);
    }

    public Integer getTag22() {
        return tag22;
    }

    public void setTag22(Integer tag22) {
        Integer oldTag22 = this.tag22;
        this.tag22 = tag22;
        changeSupport.firePropertyChange("tag22", oldTag22, tag22);
    }

    public Integer getTag23() {
        return tag23;
    }

    public void setTag23(Integer tag23) {
        Integer oldTag23 = this.tag23;
        this.tag23 = tag23;
        changeSupport.firePropertyChange("tag23", oldTag23, tag23);
    }

    public Integer getTag24() {
        return tag24;
    }

    public void setTag24(Integer tag24) {
        Integer oldTag24 = this.tag24;
        this.tag24 = tag24;
        changeSupport.firePropertyChange("tag24", oldTag24, tag24);
    }

    public Integer getTag25() {
        return tag25;
    }

    public void setTag25(Integer tag25) {
        Integer oldTag25 = this.tag25;
        this.tag25 = tag25;
        changeSupport.firePropertyChange("tag25", oldTag25, tag25);
    }

    public Integer getTag26() {
        return tag26;
    }

    public void setTag26(Integer tag26) {
        Integer oldTag26 = this.tag26;
        this.tag26 = tag26;
        changeSupport.firePropertyChange("tag26", oldTag26, tag26);
    }

    public Integer getTag27() {
        return tag27;
    }

    public void setTag27(Integer tag27) {
        Integer oldTag27 = this.tag27;
        this.tag27 = tag27;
        changeSupport.firePropertyChange("tag27", oldTag27, tag27);
    }

    public Integer getTag28() {
        return tag28;
    }

    public void setTag28(Integer tag28) {
        Integer oldTag28 = this.tag28;
        this.tag28 = tag28;
        changeSupport.firePropertyChange("tag28", oldTag28, tag28);
    }

    public Integer getTag29() {
        return tag29;
    }

    public void setTag29(Integer tag29) {
        Integer oldTag29 = this.tag29;
        this.tag29 = tag29;
        changeSupport.firePropertyChange("tag29", oldTag29, tag29);
    }

    public Integer getTag30() {
        return tag30;
    }

    public void setTag30(Integer tag30) {
        Integer oldTag30 = this.tag30;
        this.tag30 = tag30;
        changeSupport.firePropertyChange("tag30", oldTag30, tag30);
    }

    public Integer getTag31() {
        return tag31;
    }

    public void setTag31(Integer tag31) {
        Integer oldTag31 = this.tag31;
        this.tag31 = tag31;
        changeSupport.firePropertyChange("tag31", oldTag31, tag31);
    }

    public Integer getTag32() {
        return tag32;
    }

    public void setTag32(Integer tag32) {
        Integer oldTag32 = this.tag32;
        this.tag32 = tag32;
        changeSupport.firePropertyChange("tag32", oldTag32, tag32);
    }

    public Integer getTag33() {
        return tag33;
    }

    public void setTag33(Integer tag33) {
        Integer oldTag33 = this.tag33;
        this.tag33 = tag33;
        changeSupport.firePropertyChange("tag33", oldTag33, tag33);
    }

    public Integer getTag34() {
        return tag34;
    }

    public void setTag34(Integer tag34) {
        Integer oldTag34 = this.tag34;
        this.tag34 = tag34;
        changeSupport.firePropertyChange("tag34", oldTag34, tag34);
    }

    public Integer getTag35() {
        return tag35;
    }

    public void setTag35(Integer tag35) {
        Integer oldTag35 = this.tag35;
        this.tag35 = tag35;
        changeSupport.firePropertyChange("tag35", oldTag35, tag35);
    }

    public Integer getTag36() {
        return tag36;
    }

    public void setTag36(Integer tag36) {
        Integer oldTag36 = this.tag36;
        this.tag36 = tag36;
        changeSupport.firePropertyChange("tag36", oldTag36, tag36);
    }

    public Integer getTag37() {
        return tag37;
    }

    public void setTag37(Integer tag37) {
        Integer oldTag37 = this.tag37;
        this.tag37 = tag37;
        changeSupport.firePropertyChange("tag37", oldTag37, tag37);
    }

    public Integer getTag38() {
        return tag38;
    }

    public void setTag38(Integer tag38) {
        Integer oldTag38 = this.tag38;
        this.tag38 = tag38;
        changeSupport.firePropertyChange("tag38", oldTag38, tag38);
    }

    public Integer getTag39() {
        return tag39;
    }

    public void setTag39(Integer tag39) {
        Integer oldTag39 = this.tag39;
        this.tag39 = tag39;
        changeSupport.firePropertyChange("tag39", oldTag39, tag39);
    }

    public Integer getTag40() {
        return tag40;
    }

    public void setTag40(Integer tag40) {
        Integer oldTag40 = this.tag40;
        this.tag40 = tag40;
        changeSupport.firePropertyChange("tag40", oldTag40, tag40);
    }

    public Integer getTag41() {
        return tag41;
    }

    public void setTag41(Integer tag41) {
        Integer oldTag41 = this.tag41;
        this.tag41 = tag41;
        changeSupport.firePropertyChange("tag41", oldTag41, tag41);
    }

    public Integer getTag42() {
        return tag42;
    }

    public void setTag42(Integer tag42) {
        Integer oldTag42 = this.tag42;
        this.tag42 = tag42;
        changeSupport.firePropertyChange("tag42", oldTag42, tag42);
    }

    public Integer getTag43() {
        return tag43;
    }

    public void setTag43(Integer tag43) {
        Integer oldTag43 = this.tag43;
        this.tag43 = tag43;
        changeSupport.firePropertyChange("tag43", oldTag43, tag43);
    }

    public Integer getTag44() {
        return tag44;
    }

    public void setTag44(Integer tag44) {
        Integer oldTag44 = this.tag44;
        this.tag44 = tag44;
        changeSupport.firePropertyChange("tag44", oldTag44, tag44);
    }

    public Integer getTag45() {
        return tag45;
    }

    public void setTag45(Integer tag45) {
        Integer oldTag45 = this.tag45;
        this.tag45 = tag45;
        changeSupport.firePropertyChange("tag45", oldTag45, tag45);
    }

    public Integer getTag46() {
        return tag46;
    }

    public void setTag46(Integer tag46) {
        Integer oldTag46 = this.tag46;
        this.tag46 = tag46;
        changeSupport.firePropertyChange("tag46", oldTag46, tag46);
    }

    public Integer getTag47() {
        return tag47;
    }

    public void setTag47(Integer tag47) {
        Integer oldTag47 = this.tag47;
        this.tag47 = tag47;
        changeSupport.firePropertyChange("tag47", oldTag47, tag47);
    }

    public Integer getTag48() {
        return tag48;
    }

    public void setTag48(Integer tag48) {
        Integer oldTag48 = this.tag48;
        this.tag48 = tag48;
        changeSupport.firePropertyChange("tag48", oldTag48, tag48);
    }

    public Integer getTag49() {
        return tag49;
    }

    public void setTag49(Integer tag49) {
        Integer oldTag49 = this.tag49;
        this.tag49 = tag49;
        changeSupport.firePropertyChange("tag49", oldTag49, tag49);
    }

    public Integer getTag50() {
        return tag50;
    }

    public void setTag50(Integer tag50) {
        Integer oldTag50 = this.tag50;
        this.tag50 = tag50;
        changeSupport.firePropertyChange("tag50", oldTag50, tag50);
    }

    public Integer getTag51() {
        return tag51;
    }

    public void setTag51(Integer tag51) {
        Integer oldTag51 = this.tag51;
        this.tag51 = tag51;
        changeSupport.firePropertyChange("tag51", oldTag51, tag51);
    }

    public Integer getTag52() {
        return tag52;
    }

    public void setTag52(Integer tag52) {
        Integer oldTag52 = this.tag52;
        this.tag52 = tag52;
        changeSupport.firePropertyChange("tag52", oldTag52, tag52);
    }

    public Integer getTag53() {
        return tag53;
    }

    public void setTag53(Integer tag53) {
        Integer oldTag53 = this.tag53;
        this.tag53 = tag53;
        changeSupport.firePropertyChange("tag53", oldTag53, tag53);
    }

    public Integer getTag54() {
        return tag54;
    }

    public void setTag54(Integer tag54) {
        Integer oldTag54 = this.tag54;
        this.tag54 = tag54;
        changeSupport.firePropertyChange("tag54", oldTag54, tag54);
    }

    public Integer getTag55() {
        return tag55;
    }

    public void setTag55(Integer tag55) {
        Integer oldTag55 = this.tag55;
        this.tag55 = tag55;
        changeSupport.firePropertyChange("tag55", oldTag55, tag55);
    }

    public Integer getTag56() {
        return tag56;
    }

    public void setTag56(Integer tag56) {
        Integer oldTag56 = this.tag56;
        this.tag56 = tag56;
        changeSupport.firePropertyChange("tag56", oldTag56, tag56);
    }

    public Integer getTag57() {
        return tag57;
    }

    public void setTag57(Integer tag57) {
        Integer oldTag57 = this.tag57;
        this.tag57 = tag57;
        changeSupport.firePropertyChange("tag57", oldTag57, tag57);
    }

    public Integer getTag58() {
        return tag58;
    }

    public void setTag58(Integer tag58) {
        Integer oldTag58 = this.tag58;
        this.tag58 = tag58;
        changeSupport.firePropertyChange("tag58", oldTag58, tag58);
    }

    public Integer getTag59() {
        return tag59;
    }

    public void setTag59(Integer tag59) {
        Integer oldTag59 = this.tag59;
        this.tag59 = tag59;
        changeSupport.firePropertyChange("tag59", oldTag59, tag59);
    }

    public Integer getTag60() {
        return tag60;
    }

    public void setTag60(Integer tag60) {
        Integer oldTag60 = this.tag60;
        this.tag60 = tag60;
        changeSupport.firePropertyChange("tag60", oldTag60, tag60);
    }

    public Integer getTag61() {
        return tag61;
    }

    public void setTag61(Integer tag61) {
        Integer oldTag61 = this.tag61;
        this.tag61 = tag61;
        changeSupport.firePropertyChange("tag61", oldTag61, tag61);
    }

    public Integer getTag62() {
        return tag62;
    }

    public void setTag62(Integer tag62) {
        Integer oldTag62 = this.tag62;
        this.tag62 = tag62;
        changeSupport.firePropertyChange("tag62", oldTag62, tag62);
    }

    public Integer getTag63() {
        return tag63;
    }

    public void setTag63(Integer tag63) {
        Integer oldTag63 = this.tag63;
        this.tag63 = tag63;
        changeSupport.firePropertyChange("tag63", oldTag63, tag63);
    }

    public Integer getTag64() {
        return tag64;
    }

    public void setTag64(Integer tag64) {
        Integer oldTag64 = this.tag64;
        this.tag64 = tag64;
        changeSupport.firePropertyChange("tag64", oldTag64, tag64);
    }

    public Integer getTag65() {
        return tag65;
    }

    public void setTag65(Integer tag65) {
        Integer oldTag65 = this.tag65;
        this.tag65 = tag65;
        changeSupport.firePropertyChange("tag65", oldTag65, tag65);
    }

    public Integer getTag66() {
        return tag66;
    }

    public void setTag66(Integer tag66) {
        Integer oldTag66 = this.tag66;
        this.tag66 = tag66;
        changeSupport.firePropertyChange("tag66", oldTag66, tag66);
    }

    public Integer getTag67() {
        return tag67;
    }

    public void setTag67(Integer tag67) {
        Integer oldTag67 = this.tag67;
        this.tag67 = tag67;
        changeSupport.firePropertyChange("tag67", oldTag67, tag67);
    }

    public Integer getTag68() {
        return tag68;
    }

    public void setTag68(Integer tag68) {
        Integer oldTag68 = this.tag68;
        this.tag68 = tag68;
        changeSupport.firePropertyChange("tag68", oldTag68, tag68);
    }

    public Integer getTag69() {
        return tag69;
    }

    public void setTag69(Integer tag69) {
        Integer oldTag69 = this.tag69;
        this.tag69 = tag69;
        changeSupport.firePropertyChange("tag69", oldTag69, tag69);
    }

    public Integer getTag70() {
        return tag70;
    }

    public void setTag70(Integer tag70) {
        Integer oldTag70 = this.tag70;
        this.tag70 = tag70;
        changeSupport.firePropertyChange("tag70", oldTag70, tag70);
    }

    public Integer getTag71() {
        return tag71;
    }

    public void setTag71(Integer tag71) {
        Integer oldTag71 = this.tag71;
        this.tag71 = tag71;
        changeSupport.firePropertyChange("tag71", oldTag71, tag71);
    }

    public Integer getTag72() {
        return tag72;
    }

    public void setTag72(Integer tag72) {
        Integer oldTag72 = this.tag72;
        this.tag72 = tag72;
        changeSupport.firePropertyChange("tag72", oldTag72, tag72);
    }

    public Integer getTag73() {
        return tag73;
    }

    public void setTag73(Integer tag73) {
        Integer oldTag73 = this.tag73;
        this.tag73 = tag73;
        changeSupport.firePropertyChange("tag73", oldTag73, tag73);
    }

    public Integer getTag74() {
        return tag74;
    }

    public void setTag74(Integer tag74) {
        Integer oldTag74 = this.tag74;
        this.tag74 = tag74;
        changeSupport.firePropertyChange("tag74", oldTag74, tag74);
    }

    public Integer getTag75() {
        return tag75;
    }

    public void setTag75(Integer tag75) {
        Integer oldTag75 = this.tag75;
        this.tag75 = tag75;
        changeSupport.firePropertyChange("tag75", oldTag75, tag75);
    }

    public Integer getTag76() {
        return tag76;
    }

    public void setTag76(Integer tag76) {
        Integer oldTag76 = this.tag76;
        this.tag76 = tag76;
        changeSupport.firePropertyChange("tag76", oldTag76, tag76);
    }

    public Integer getTag77() {
        return tag77;
    }

    public void setTag77(Integer tag77) {
        Integer oldTag77 = this.tag77;
        this.tag77 = tag77;
        changeSupport.firePropertyChange("tag77", oldTag77, tag77);
    }

    public Integer getTag78() {
        return tag78;
    }

    public void setTag78(Integer tag78) {
        Integer oldTag78 = this.tag78;
        this.tag78 = tag78;
        changeSupport.firePropertyChange("tag78", oldTag78, tag78);
    }

    public Integer getTag79() {
        return tag79;
    }

    public void setTag79(Integer tag79) {
        Integer oldTag79 = this.tag79;
        this.tag79 = tag79;
        changeSupport.firePropertyChange("tag79", oldTag79, tag79);
    }

    public Integer getTag80() {
        return tag80;
    }

    public void setTag80(Integer tag80) {
        Integer oldTag80 = this.tag80;
        this.tag80 = tag80;
        changeSupport.firePropertyChange("tag80", oldTag80, tag80);
    }

    public Integer getTag81() {
        return tag81;
    }

    public void setTag81(Integer tag81) {
        Integer oldTag81 = this.tag81;
        this.tag81 = tag81;
        changeSupport.firePropertyChange("tag81", oldTag81, tag81);
    }

    public Integer getTag82() {
        return tag82;
    }

    public void setTag82(Integer tag82) {
        Integer oldTag82 = this.tag82;
        this.tag82 = tag82;
        changeSupport.firePropertyChange("tag82", oldTag82, tag82);
    }

    public Integer getTag83() {
        return tag83;
    }

    public void setTag83(Integer tag83) {
        Integer oldTag83 = this.tag83;
        this.tag83 = tag83;
        changeSupport.firePropertyChange("tag83", oldTag83, tag83);
    }

    public Integer getTag84() {
        return tag84;
    }

    public void setTag84(Integer tag84) {
        Integer oldTag84 = this.tag84;
        this.tag84 = tag84;
        changeSupport.firePropertyChange("tag84", oldTag84, tag84);
    }

    public Integer getTag85() {
        return tag85;
    }

    public void setTag85(Integer tag85) {
        Integer oldTag85 = this.tag85;
        this.tag85 = tag85;
        changeSupport.firePropertyChange("tag85", oldTag85, tag85);
    }

    public Integer getTag86() {
        return tag86;
    }

    public void setTag86(Integer tag86) {
        Integer oldTag86 = this.tag86;
        this.tag86 = tag86;
        changeSupport.firePropertyChange("tag86", oldTag86, tag86);
    }

    public Integer getTag87() {
        return tag87;
    }

    public void setTag87(Integer tag87) {
        Integer oldTag87 = this.tag87;
        this.tag87 = tag87;
        changeSupport.firePropertyChange("tag87", oldTag87, tag87);
    }

    public Integer getTag88() {
        return tag88;
    }

    public void setTag88(Integer tag88) {
        Integer oldTag88 = this.tag88;
        this.tag88 = tag88;
        changeSupport.firePropertyChange("tag88", oldTag88, tag88);
    }

    public Integer getTag89() {
        return tag89;
    }

    public void setTag89(Integer tag89) {
        Integer oldTag89 = this.tag89;
        this.tag89 = tag89;
        changeSupport.firePropertyChange("tag89", oldTag89, tag89);
    }

    public Integer getTag90() {
        return tag90;
    }

    public void setTag90(Integer tag90) {
        Integer oldTag90 = this.tag90;
        this.tag90 = tag90;
        changeSupport.firePropertyChange("tag90", oldTag90, tag90);
    }

    public Integer getTag91() {
        return tag91;
    }

    public void setTag91(Integer tag91) {
        Integer oldTag91 = this.tag91;
        this.tag91 = tag91;
        changeSupport.firePropertyChange("tag91", oldTag91, tag91);
    }

    public Integer getTag92() {
        return tag92;
    }

    public void setTag92(Integer tag92) {
        Integer oldTag92 = this.tag92;
        this.tag92 = tag92;
        changeSupport.firePropertyChange("tag92", oldTag92, tag92);
    }

    public Integer getTag93() {
        return tag93;
    }

    public void setTag93(Integer tag93) {
        Integer oldTag93 = this.tag93;
        this.tag93 = tag93;
        changeSupport.firePropertyChange("tag93", oldTag93, tag93);
    }

    public Integer getTag94() {
        return tag94;
    }

    public void setTag94(Integer tag94) {
        Integer oldTag94 = this.tag94;
        this.tag94 = tag94;
        changeSupport.firePropertyChange("tag94", oldTag94, tag94);
    }

    public Integer getTag95() {
        return tag95;
    }

    public void setTag95(Integer tag95) {
        Integer oldTag95 = this.tag95;
        this.tag95 = tag95;
        changeSupport.firePropertyChange("tag95", oldTag95, tag95);
    }

    public Integer getTag96() {
        return tag96;
    }

    public void setTag96(Integer tag96) {
        Integer oldTag96 = this.tag96;
        this.tag96 = tag96;
        changeSupport.firePropertyChange("tag96", oldTag96, tag96);
    }

    public Integer getTag97() {
        return tag97;
    }

    public void setTag97(Integer tag97) {
        Integer oldTag97 = this.tag97;
        this.tag97 = tag97;
        changeSupport.firePropertyChange("tag97", oldTag97, tag97);
    }

    public Integer getTag98() {
        return tag98;
    }

    public void setTag98(Integer tag98) {
        Integer oldTag98 = this.tag98;
        this.tag98 = tag98;
        changeSupport.firePropertyChange("tag98", oldTag98, tag98);
    }

    public Integer getTag99() {
        return tag99;
    }

    public void setTag99(Integer tag99) {
        Integer oldTag99 = this.tag99;
        this.tag99 = tag99;
        changeSupport.firePropertyChange("tag99", oldTag99, tag99);
    }

    public Informants getInformant() {
        return informant;
    }

    public void setInformant(Informants informant) {
        Informants oldInformant = this.informant;
        this.informant = informant;
        changeSupport.firePropertyChange("informant", oldInformant, informant);
    }

    public Interviews getInterviewnumber() {
        return interviewnumber;
    }

    public void setInterviewnumber(Interviews interviewnumber) {
        Interviews oldInterviewnumber = this.interviewnumber;
        this.interviewnumber = interviewnumber;
        changeSupport.firePropertyChange("interviewnumber", oldInterviewnumber, interviewnumber);
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

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
