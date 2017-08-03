/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author admin
 */
@Stateless
public class PostFacade extends AbstractFacade<Post> {

    @PersistenceContext(unitName = "chanEngine-ejbPU")
    private EntityManager em;
    public static final int POSTS_PER_PAGE = 10;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PostFacade() {
        super(Post.class);
    }
    
    public List < Post > findAllOrderByTime( Integer page ) {
        List < Post > lst = getEntityManager().createNamedQuery( "Post.findAllOrderByTime" ).getResultList();
        Integer b1 = ( page - 1 ) * POSTS_PER_PAGE;
        Integer b2 = Math.min( lst.size(), ( page ) * POSTS_PER_PAGE );
        if ( ( b1 >= 0 ) && ( b1 <= lst.size() ) && ( b1 < b2 ) ) {
            return lst.subList( b1, b2 );
        }
        return new ArrayList <> ();
    }
    
}
