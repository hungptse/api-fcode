/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungpt.entites;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author THANH HUNG
 */
@Entity
@Table(name = "Attendance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attendance.findAll", query = "SELECT a FROM Attendance a")
    , @NamedQuery(name = "Attendance.findByAttendanceId", query = "SELECT a FROM Attendance a WHERE a.attendanceId = :attendanceId")
    , @NamedQuery(name = "Attendance.findByIsPresent", query = "SELECT a FROM Attendance a WHERE a.isPresent = :isPresent")
    , @NamedQuery(name = "Attendance.findByNote", query = "SELECT a FROM Attendance a WHERE a.note = :note")
    , @NamedQuery(name = "Attendance.findByIsUsed", query = "SELECT a FROM Attendance a WHERE a.isUsed = :isUsed")})
public class Attendance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AttendanceId")
    private Integer attendanceId;
    @Column(name = "isPresent")
    private Boolean isPresent;
    @Size(max = 50)
    @Column(name = "Note")
    private String note;
    @Column(name = "isUsed")
    private Boolean isUsed;
    @JoinColumn(name = "EventDetail", referencedColumnName = "EventDetail")
    @ManyToOne
    private EventDetail eventDetail;

    @JoinColumn(name = "StudentID", referencedColumnName = "StudentID")
    @ManyToOne
    private Account studentID;

    public Attendance() {
    }

    public Attendance(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Integer getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Boolean getIsPresent() {
        return isPresent;
    }

    public void setIsPresent(Boolean isPresent) {
        this.isPresent = isPresent;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Boolean isUsed) {
        this.isUsed = isUsed;
    }

    public EventDetail getEventDetail() {
        return eventDetail;
    }

    public void setEventDetail(EventDetail eventDetail) {
        this.eventDetail = eventDetail;
    }

    public Account getStudentID() {
        return studentID;
    }

    public void setStudentID(Account studentID) {
        this.studentID = studentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attendanceId != null ? attendanceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attendance)) {
            return false;
        }
        Attendance other = (Attendance) object;
        if ((this.attendanceId == null && other.attendanceId != null) || (this.attendanceId != null && !this.attendanceId.equals(other.attendanceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "h.Attendance[ attendanceId=" + attendanceId + " ]";
    }

}
