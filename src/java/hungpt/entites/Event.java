/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungpt.entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author THANH HUNG
 */
@Entity
@Table(name = "Event")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e")
    , @NamedQuery(name = "Event.findByEventId", query = "SELECT e FROM Event e WHERE e.eventId = :eventId")
    , @NamedQuery(name = "Event.findByEventName", query = "SELECT e FROM Event e WHERE e.eventName = :eventName")
    , @NamedQuery(name = "Event.findByLocation", query = "SELECT e FROM Event e WHERE e.location = :location")
    , @NamedQuery(name = "Event.findByDescription", query = "SELECT e FROM Event e WHERE e.description = :description")
    , @NamedQuery(name = "Event.findByBanner", query = "SELECT e FROM Event e WHERE e.banner = :banner")
    , @NamedQuery(name = "Event.findByDateBegin", query = "SELECT e FROM Event e WHERE e.dateBegin = :dateBegin")
    , @NamedQuery(name = "Event.findByDateEnd", query = "SELECT e FROM Event e WHERE e.dateEnd = :dateEnd")
    , @NamedQuery(name = "Event.findByDateCreated", query = "SELECT e FROM Event e WHERE e.dateCreated = :dateCreated")
    , @NamedQuery(name = "Event.findByIsSign", query = "SELECT e FROM Event e WHERE e.isSign = :isSign")
    , @NamedQuery(name = "Event.findByIsPublish", query = "SELECT e FROM Event e WHERE e.isPublish = :isPublish")})
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EventId")
    private Integer eventId;
    @Size(max = 50)
    @Column(name = "EventName")
    private String eventName;
    @Size(max = 50)
    @Column(name = "Location")
    private String location;
    @Size(max = 1073741823)
    @Column(name = "Description")
    private String description;
    @Size(max = 50)
    @Column(name = "Banner")
    private String banner;
    @Column(name = "DateBegin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateBegin;
    @Column(name = "DateEnd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnd;
    @Column(name = "DateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "isSign")
    private Boolean isSign;
    @Column(name = "isPublish")
    private Boolean isPublish;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private Collection<AccountEvent> accountEventCollection;
    @JoinColumn(name = "PostBy", referencedColumnName = "StudentID")
    @ManyToOne
    private Account postBy;
    @JoinColumn(name = "StatusID", referencedColumnName = "StatusID")
    @ManyToOne
    private EventStatus statusID;
    @JoinColumn(name = "TypeID", referencedColumnName = "TypeID")
    @ManyToOne
    private EventType typeID;

    public Event() {
    }

    public Event(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Boolean getIsSign() {
        return isSign;
    }

    public void setIsSign(Boolean isSign) {
        this.isSign = isSign;
    }

    public Boolean getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(Boolean isPublish) {
        this.isPublish = isPublish;
    }

    @XmlTransient
    public Collection<AccountEvent> getAccountEventCollection() {
        return accountEventCollection;
    }

    public void setAccountEventCollection(Collection<AccountEvent> accountEventCollection) {
        this.accountEventCollection = accountEventCollection;
    }

    public Account getPostBy() {
        return postBy;
    }

    public void setPostBy(Account postBy) {
        this.postBy = postBy;
    }

    public EventStatus getStatusID() {
        return statusID;
    }

    public void setStatusID(EventStatus statusID) {
        this.statusID = statusID;
    }

    public EventType getTypeID() {
        return typeID;
    }

    public void setTypeID(EventType typeID) {
        this.typeID = typeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventId != null ? eventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventId == null && other.eventId != null) || (this.eventId != null && !this.eventId.equals(other.eventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "h.Event[ eventId=" + eventId + " ]";
    }
    
}
