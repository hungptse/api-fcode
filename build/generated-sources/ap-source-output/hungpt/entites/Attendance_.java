package hungpt.entites;

import hungpt.entites.EventDetail;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-22T16:15:23")
@StaticMetamodel(Attendance.class)
public class Attendance_ { 

    public static volatile SingularAttribute<Attendance, Date> dateEvent;
    public static volatile SingularAttribute<Attendance, Boolean> isPresent;
    public static volatile SingularAttribute<Attendance, Integer> attendanceId;
    public static volatile CollectionAttribute<Attendance, EventDetail> eventDetailCollection;

}