package hungpt.entites;

import hungpt.entites.Account;
import hungpt.entites.EventDetail;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-27T14:51:24")
@StaticMetamodel(Attendance.class)
public class Attendance_ { 

    public static volatile SingularAttribute<Attendance, Account> studentID;
    public static volatile SingularAttribute<Attendance, String> note;
    public static volatile SingularAttribute<Attendance, Boolean> isPresent;
    public static volatile SingularAttribute<Attendance, EventDetail> eventDetail;
    public static volatile SingularAttribute<Attendance, Integer> attendanceId;
    public static volatile SingularAttribute<Attendance, Boolean> isUsed;

}