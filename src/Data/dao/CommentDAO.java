package Data.dao;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Data.model.Comment;

import java.util.List;
/**
 * Created by Manfred on 27/10/2014.
 */
@Stateless
@LocalBean
public class CommentDAO {
    //-----------------------------------------------------------------------------
    /**
     * Référence vers le gestionnaire de persistance.
     */
    @PersistenceContext
    EntityManager entityManager;
    //-----------------------------------------------------------------------------
    /**
     * Default constructor.
     */
    public CommentDAO()
    {
        // TODO Auto-generated constructor stub
    }
    //-----------------------------------------------------------------------------
    public Comment findById(Integer id)
    {
        return entityManager.find(Comment.class, id);
    }
    //----------------------------------------------------------------------------
    public List<Comment> findAll()
    {
        Query query = entityManager.createQuery(
                "SELECT Comment FROM Comment Comment "
                        + "ORDER BY Comment.id DESC");
        List l = query.getResultList();

        return (List<Comment>)l;
    }
    //-----------------------------------------------------------------------------

    public List<Comment> findByVacation(int vacationId){

        //TODO
        return null;
    }
    //-----------------------------------------------------------------------------

    public Comment persist(Comment Comment){
        entityManager.persist(Comment);
        return Comment;

    }
    //-----------------------------------------------------------------------------

    public Comment update (Comment Comment){
        return entityManager.merge(Comment);

    }
    //-----------------------------------------------------------------------------

    public void remove(Comment Comment){
        entityManager.remove(entityManager.merge(Comment));
    }

}
