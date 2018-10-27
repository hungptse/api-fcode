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
@Table(name = "EventStatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventStatus.findAll", query = "SELECT e FROM EventStatus e")
    , @NamedQuery(name = "EventStatus.findByStatusID", query = "SELECT e FROM EventStatus e WHERE e.statusID = :statusID")
    , @NamedQuery(name = "EventStatus.findByStatusName", query = "SELECT e FROM EventStatus e WHERE e.statusName = :statusName")})
public class EventStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "StatusID")
    private Integer statusID;
    @Size(max = 50)
    @Column(name = "StatusName")
    private String statusName;
    @OneToMany(mappedBy = "statusID")
    private Collection<Event> eventCollection;

    public EventStatus() {
    }

    public EventStatus(Integer statusID) {
        this.statusID = statusID;
    }

    public Integer getStatusID() {
        return statusID;
    }

    public void setStatusID(Integer statusID) {
        this.statusID = statusID;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @XmlTransient
    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusID != null ? statusID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventStatus)) {
            return false;
        }
        EventStatus other = (EventStatus) object;
        if ((this.statusID == null && other.statusID != null) || (this.statusID != null && !this.statusID.equals(other.statusID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "h.EventStatus[ statusID=" + statusID + " ]";
    }
    
}
