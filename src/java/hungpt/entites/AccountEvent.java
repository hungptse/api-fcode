/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungpt.entites;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author THANH HUNG
 */
@Entity
@Table(name = "AccountEvent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountEvent.findAll", query = "SELECT a FROM AccountEvent a")
    , @NamedQuery(name = "AccountEvent.findByEventId", query = "SELECT a FROM AccountEvent a WHERE a.accountEventPK.eventId = :eventId")
    , @NamedQuery(name = "AccountEvent.findByStudentID", query = "SELECT a FROM AccountEvent a WHERE a.accountEventPK.studentID = :studentID")
    , @NamedQuery(name = "AccountEvent.findByStatus", query = "SELECT a FROM AccountEvent a WHERE a.status = :status")})
public class AccountEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccountEventPK accountEventPK;
    @Column(name = "Status")
    private Boolean status;
    @JoinColumn(name = "StudentID", referencedColumnName = "StudentID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Account account;
    @JoinColumn(name = "EventId", referencedColumnName = "EventId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Event event;
    @OneToMany( mappedBy = "accountEvent")
    private Collection<EventDetail> eventDetailCollection;

    public AccountEvent() {
    }

    public AccountEvent(AccountEventPK accountEventPK, Boolean status) {
        this.accountEventPK = accountEventPK;
        this.status = status;
    }

    
    public AccountEvent(AccountEventPK accountEventPK) {
        this.accountEventPK = accountEventPK;
    }

    public AccountEvent(int eventId, String studentID) {
        this.accountEventPK = new AccountEventPK(eventId, studentID);
    }

    public AccountEventPK getAccountEventPK() {
        return accountEventPK;
    }

    public void setAccountEventPK(AccountEventPK accountEventPK) {
        this.accountEventPK = accountEventPK;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @XmlTransient
    public Collection<EventDetail> getEventDetailCollection() {
        return eventDetailCollection;
    }

    public void setEventDetailCollection(Collection<EventDetail> eventDetailCollection) {
        this.eventDetailCollection = eventDetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountEventPK != null ? accountEventPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountEvent)) {
            return false;
        }
        AccountEvent other = (AccountEvent) object;
        if ((this.accountEventPK == null && other.accountEventPK != null) || (this.accountEventPK != null && !this.accountEventPK.equals(other.accountEventPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hungpt.entites.AccountEvent[ accountEventPK=" + accountEventPK + " ]";
    }
    
}
