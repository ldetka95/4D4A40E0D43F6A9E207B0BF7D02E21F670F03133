package core;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class BrowseGetPostListBean {
    
    @EJB
    private PostFacade posts;
    
    private Integer page;

    public Integer getPage() {
        return page;
    }

    public void setPage( Integer page ) {
        this.page = page;
    }
    
    public List < Post > getPosts() {
        if ( page == null ) {
            page = 1;
        }
        return posts.findAllOrderByTime( page );
    }
    
    
    public List < Integer > getAllowedPages() {
        List < Integer > lst = new ArrayList <> ();
        for ( int i = 1; i <= PostFacade.POSTS_PER_PAGE; i++ ) {
            lst.add( i );
        }
        return lst;
    }
    
    
}
