package core;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-17T12:35:43")
@StaticMetamodel(Post.class)
public class Post_ { 

    public static volatile SingularAttribute<Post, Date> createTime;
    public static volatile SingularAttribute<Post, String> imagePath;
    public static volatile SingularAttribute<Post, Integer> creatorId;
    public static volatile SingularAttribute<Post, Boolean> isThread;
    public static volatile SingularAttribute<Post, Integer> id;
    public static volatile SingularAttribute<Post, String> text;

}