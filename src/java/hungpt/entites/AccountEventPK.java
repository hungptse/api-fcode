/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungpt.entites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author THANH HUNG
 */
@Embeddable
public class AccountEventPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "EventId")
    private int eventId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "StudentID")
    private String studentID;

    public AccountEventPK() {
    }

    public AccountEventPK(int eventId, String studentID) {
        this.eventId = eventId;
        this.studentID = studentID;
    }

    
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) eventId;
        hash += (studentID != null ? studentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountEventPK)) {
            return false;
        }
        AccountEventPK other = (AccountEventPK) object;
        if (this.eventId != other.eventId) {
            return false;
        }
        if ((this.studentID == null && other.studentID != null) || (this.studentID != null && !this.studentID.equals(other.studentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "h.AccountEventPK[ eventId=" + eventId + ", studentID=" + studentID + " ]";
    }
    
}
