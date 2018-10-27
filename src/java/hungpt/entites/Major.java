/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungpt.entites;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author THANH HUNG
 */
@Entity
@Table(name = "Major")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Major.findAll", query = "SELECT m FROM Major m")
    , @NamedQuery(name = "Major.findByMajorId", query = "SELECT m FROM Major m WHERE m.majorId = :majorId")
    , @NamedQuery(name = "Major.findByMajorName", query = "SELECT m FROM Major m WHERE m.majorName = :majorName")})
public class Major implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MajorId")
    private Integer majorId;
    @Size(max = 50)
    @Column(name = "MajorName")
    private String majorName;
    @OneToMany(mappedBy = "majorId")
    private Collection<Account> accountCollection;

    public Major() {
    }

    public Major(Integer majorId) {
        this.majorId = majorId;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    @XmlTransient
    public Collection<Account> getAccountCollection() {
        return accountCollection;
    }

    public void setAccountCollection(Collection<Account> accountCollection) {
        this.accountCollection = accountCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (majorId != null ? majorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Major)) {
            return false;
        }
        Major other = (Major) object;
        if ((this.majorId == null && other.majorId != null) || (this.majorId != null && !this.majorId.equals(other.majorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "h.Major[ majorId=" + majorId + " ]";
    }
    
}
