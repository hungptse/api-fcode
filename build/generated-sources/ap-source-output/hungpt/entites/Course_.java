package hungpt.entites;

import hungpt.entites.Account;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-27T14:51:24")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile CollectionAttribute<Course, Account> accountCollection;
    public static volatile SingularAttribute<Course, String> courseName;
    public static volatile SingularAttribute<Course, Integer> courseId;

}