package hungpt.entites;

import hungpt.entites.Event;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-26T18:26:04")
@StaticMetamodel(EventStatus.class)
public class EventStatus_ { 

    public static volatile CollectionAttribute<EventStatus, Event> eventCollection;
    public static volatile SingularAttribute<EventStatus, Integer> statusID;
    public static volatile SingularAttribute<EventStatus, String> statusName;

}