package hungpt.entites;

import hungpt.entites.AccountEvent;
import hungpt.entites.Attendance;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-27T14:51:24")
@StaticMetamodel(EventDetail.class)
public class EventDetail_ { 

    public static volatile SingularAttribute<EventDetail, Date> dateEvent;
    public static volatile SingularAttribute<EventDetail, String> detailName;
    public static volatile CollectionAttribute<EventDetail, Attendance> attendanceCollection;
    public static volatile SingularAttribute<EventDetail, Integer> eventDetail;
    public static volatile SingularAttribute<EventDetail, AccountEvent> accountEvent;

}