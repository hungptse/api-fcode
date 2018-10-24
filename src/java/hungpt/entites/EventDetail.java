/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungpt.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author THANH HUNG
 */
@Entity
@Table(name = "EventDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventDetail.findAll", query = "SELECT e FROM EventDetail e")
    , @NamedQuery(name = "EventDetail.findByJointAt", query = "SELECT e FROM EventDetail e WHERE e.jointAt = :jointAt")
    , @NamedQuery(name = "EventDetail.findByEventDetail", query = "SELECT e FROM EventDetail e WHERE e.eventDetail = :eventDetail")})
public class EventDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "JointAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date jointAt;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EventDetail")
    private Integer eventDetail;
    @JoinColumn(name = "AttendanceId", referencedColumnName = "AttendanceId")
    @ManyToOne
    private Attendance attendanceId;
    @JoinColumn(name = "EventId", referencedColumnName = "EventId")
    @ManyToOne(optional = false)
    private Event eventId;
    @Column(name = "DetailName")
    private String detailName;
    public EventDetail() {
    }

    public EventDetail(Integer eventDetail) {
        this.eventDetail = eventDetail;
    }

    public Date getJointAt() {
        return jointAt;
    }

    public void setJointAt(Date jointAt) {
        this.jointAt = jointAt;
    }

    public Integer getEventDetail() {
        return eventDetail;
    }

    public void setEventDetail(Integer eventDetail) {
        this.eventDetail = eventDetail;
    }

    public Attendance getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Attendance attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Event getEventId() {
        return eventId;
    }

    public void setEventId(Event eventId) {
        this.eventId = eventId;
    }

//    public Account getStudentID() {
//        return studentID;
//    }
//
//    public void setStudentID(Account studentID) {
//        this.studentID = studentID;
//    }

//    public List<Account> getStudentID() {
//        return studentID;
//    }
//
//    public void setStudentID(List<Account> studentID) {
//        this.studentID = studentID;
//    }
    

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventDetail != null ? eventDetail.hashCode() : 0);
        return hash;
    }
    
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventDetail)) {
            return false;
        }
        EventDetail other = (EventDetail) object;
        if ((this.eventDetail == null && other.eventDetail != null) || (this.eventDetail != null && !this.eventDetail.equals(other.eventDetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hungpt.entites.EventDetail[ eventDetail=" + eventDetail + " ]";
    }
    
}
