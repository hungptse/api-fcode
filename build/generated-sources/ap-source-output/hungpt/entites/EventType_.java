package hungpt.entites;

import hungpt.entites.Event;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-27T14:51:24")
@StaticMetamodel(EventType.class)
public class EventType_ { 

    public static volatile CollectionAttribute<EventType, Event> eventCollection;
    public static volatile SingularAttribute<EventType, String> typeName;
    public static volatile SingularAttribute<EventType, Integer> typeID;

}