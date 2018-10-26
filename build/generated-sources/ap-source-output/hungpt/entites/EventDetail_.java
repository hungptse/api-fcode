package hungpt.entites;

import hungpt.entites.Account;
import hungpt.entites.Attendance;
import hungpt.entites.Event;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-26T18:26:04")
@StaticMetamodel(EventDetail.class)
public class EventDetail_ { 

    public static volatile SingularAttribute<EventDetail, Account> studentID;
    public static volatile SingularAttribute<EventDetail, Date> dateEvent;
    public static volatile SingularAttribute<EventDetail, Event> eventId;
    public static volatile SingularAttribute<EventDetail, String> detailName;
    public static volatile CollectionAttribute<EventDetail, Attendance> attendanceCollection;
    public static volatile SingularAttribute<EventDetail, Integer> eventDetail;

}