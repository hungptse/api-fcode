/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungpt.entites;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "Account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
    , @NamedQuery(name = "Account.findByEmail", query = "SELECT a FROM Account a WHERE a.email = :email")
    , @NamedQuery(name = "Account.findByName", query = "SELECT a FROM Account a WHERE a.name = :name")
    , @NamedQuery(name = "Account.findByIsActive", query = "SELECT a FROM Account a WHERE a.isActive = :isActive")
    , @NamedQuery(name = "Account.findByGender", query = "SELECT a FROM Account a WHERE a.gender = :gender")
    , @NamedQuery(name = "Account.findByPhone", query = "SELECT a FROM Account a WHERE a.phone = :phone")
    , @NamedQuery(name = "Account.findByDayOfBirth", query = "SELECT a FROM Account a WHERE a.dayOfBirth = :dayOfBirth")
    , @NamedQuery(name = "Account.findByAvatar", query = "SELECT a FROM Account a WHERE a.avatar = :avatar")
    , @NamedQuery(name = "Account.findByAddress", query = "SELECT a FROM Account a WHERE a.address = :address")
    , @NamedQuery(name = "Account.findByStudentID", query = "SELECT a FROM Account a WHERE a.studentID = :studentID")
    , @NamedQuery(name = "Account.findByDayJoin", query = "SELECT a FROM Account a WHERE a.dayJoin = :dayJoin")
    , @NamedQuery(name = "Account.findByLinkFB", query = "SELECT a FROM Account a WHERE a.linkFB = :linkFB")})
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Password")
    private String password;
    @Size(max = 50)
    @Column(name = "Name")
    private String name;
    @Column(name = "IsActive")
    private Boolean isActive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Gender")
    private boolean gender;
    @Column(name = "Phone")
    private Long phone;
    @Size(max = 10)
    @Column(name = "DayOfBirth")
    private String dayOfBirth;
    @Size(max = 50)
    @Column(name = "Avatar")
    private String avatar;
    @Size(max = 50)
    @Column(name = "Address")
    private String address;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "AboutMe")
    private String aboutMe;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "StudentID")
    private String studentID;
    @Size(max = 10)
    @Column(name = "DayJoin")
    private String dayJoin;
    @Size(max = 50)
    @Column(name = "LinkFB")
    private String linkFB;
    @JoinColumn(name = "CourseId", referencedColumnName = "CourseId")
    @ManyToOne
    private Course courseId;
    @JoinColumn(name = "MajorId", referencedColumnName = "MajorId")
    @ManyToOne
    private Major majorId;
    @JoinColumn(name = "RoleId", referencedColumnName = "RoleId")
    @ManyToOne
    private Role roleId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private Collection<AccountEvent> accountEventCollection;
    @OneToMany(mappedBy = "postBy")
    private Collection<Event> eventCollection;

     @OneToMany(mappedBy = "studentID")
    private Collection<Attendance> attendanceCollection;
    
    public Account() {
    }

    public Account(String studentID) {
        this.studentID = studentID;
    }

    public Account(String studentID, String email, String password, boolean gender) {
        this.studentID = studentID;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getDayJoin() {
        return dayJoin;
    }

    public void setDayJoin(String dayJoin) {
        this.dayJoin = dayJoin;
    }

    public String getLinkFB() {
        return linkFB;
    }

    public void setLinkFB(String linkFB) {
        this.linkFB = linkFB;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public Major getMajorId() {
        return majorId;
    }

    public void setMajorId(Major majorId) {
        this.majorId = majorId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    @XmlTransient
    public Collection<AccountEvent> getAccountEventCollection() {
        return accountEventCollection;
    }

    public void setAccountEventCollection(Collection<AccountEvent> accountEventCollection) {
        this.accountEventCollection = accountEventCollection;
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
        hash += (studentID != null ? studentID.hashCode() : 0);
        return hash;
    }

    public Collection<Attendance> getAttendanceCollection() {
        return attendanceCollection;
    }

    public void setAttendanceCollection(Collection<Attendance> attendanceCollection) {
        this.attendanceCollection = attendanceCollection;
    }

    
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.studentID == null && other.studentID != null) || (this.studentID != null && !this.studentID.equals(other.studentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "h.Account[ studentID=" + studentID + " ]";
    }
    
}
