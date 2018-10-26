package hungpt.entites;

import hungpt.entites.Course;
import hungpt.entites.Event;
import hungpt.entites.EventDetail;
import hungpt.entites.Major;
import hungpt.entites.Role;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-26T18:26:04")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile CollectionAttribute<Account, Event> eventCollection;
    public static volatile SingularAttribute<Account, String> address;
    public static volatile SingularAttribute<Account, Major> majorId;
    public static volatile SingularAttribute<Account, Boolean> gender;
    public static volatile SingularAttribute<Account, Role> roleId;
    public static volatile SingularAttribute<Account, String> dayJoin;
    public static volatile SingularAttribute<Account, String> avatar;
    public static volatile SingularAttribute<Account, Boolean> isActive;
    public static volatile SingularAttribute<Account, String> aboutMe;
    public static volatile SingularAttribute<Account, String> studentID;
    public static volatile SingularAttribute<Account, String> linkFB;
    public static volatile SingularAttribute<Account, String> password;
    public static volatile ListAttribute<Account, EventDetail> eventDetailList;
    public static volatile SingularAttribute<Account, Long> phone;
    public static volatile SingularAttribute<Account, String> dayOfBirth;
    public static volatile SingularAttribute<Account, String> name;
    public static volatile SingularAttribute<Account, Course> courseId;
    public static volatile SingularAttribute<Account, String> email;

}