package hungpt.entites;

import hungpt.entites.Account;
import hungpt.entites.AccountEventPK;
import hungpt.entites.Event;
import hungpt.entites.EventDetail;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-27T14:51:24")
@StaticMetamodel(AccountEvent.class)
public class AccountEvent_ { 

    public static volatile SingularAttribute<AccountEvent, AccountEventPK> accountEventPK;
    public static volatile SingularAttribute<AccountEvent, Event> event;
    public static volatile SingularAttribute<AccountEvent, Account> account;
    public static volatile SingularAttribute<AccountEvent, Boolean> status;
    public static volatile CollectionAttribute<AccountEvent, EventDetail> eventDetailCollection;

}