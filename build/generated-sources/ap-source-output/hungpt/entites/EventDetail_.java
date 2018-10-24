package hungpt.entites;

import hungpt.entites.Account;
import hungpt.entites.Attendance;
import hungpt.entites.Event;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-22T16:15:23")
@StaticMetamodel(EventDetail.class)
public class EventDetail_ { 

    public static volatile SingularAttribute<EventDetail, Account> studentID;
    public static volatile SingularAttribute<EventDetail, Event> eventId;
    public static volatile SingularAttribute<EventDetail, Date> jointAt;
    public static volatile SingularAttribute<EventDetail, Integer> eventDetail;
    public static volatile SingularAttribute<EventDetail, Attendance> attendanceId;

}