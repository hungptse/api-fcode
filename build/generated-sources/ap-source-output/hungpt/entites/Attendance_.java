package hungpt.entites;

import hungpt.entites.EventDetail;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-26T18:26:04")
@StaticMetamodel(Attendance.class)
public class Attendance_ { 

    public static volatile SingularAttribute<Attendance, String> studentID;
    public static volatile SingularAttribute<Attendance, String> note;
    public static volatile SingularAttribute<Attendance, Boolean> isPresent;
    public static volatile SingularAttribute<Attendance, EventDetail> eventDetail;
    public static volatile SingularAttribute<Attendance, Integer> attendanceId;

}