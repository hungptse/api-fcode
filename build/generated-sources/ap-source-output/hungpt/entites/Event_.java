package hungpt.entites;

import hungpt.entites.EventDetail;
import hungpt.entites.EventStatus;
import hungpt.entites.EventType;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-22T16:15:23")
@StaticMetamodel(Event.class)
public class Event_ { 

    public static volatile SingularAttribute<Event, Integer> eventId;
    public static volatile SingularAttribute<Event, String> postBy;
    public static volatile SingularAttribute<Event, String> description;
    public static volatile SingularAttribute<Event, String> banner;
    public static volatile SingularAttribute<Event, Date> dateEnd;
    public static volatile SingularAttribute<Event, Boolean> isSign;
    public static volatile CollectionAttribute<Event, EventDetail> eventDetailCollection;
    public static volatile SingularAttribute<Event, Date> dateBegin;
    public static volatile SingularAttribute<Event, Date> dateCreated;
    public static volatile SingularAttribute<Event, EventStatus> statusID;
    public static volatile SingularAttribute<Event, String> eventName;
    public static volatile SingularAttribute<Event, String> location;
    public static volatile SingularAttribute<Event, EventType> typeID;

}