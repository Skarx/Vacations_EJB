package Data.dao;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import Data.model.Comments;
import java.util.List;
/**
 * Created by Manfred on 27/10/2014.
 */
@Stateless
@LocalBean
public class CommentsDAO {
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
    public CommentsDAO()
    {
        // TODO Auto-generated constructor stub
    }
    //-----------------------------------------------------------------------------
    public Comments findById(Integer id)
    {
        return entityManager.find(Comments.class, id);
    }
    //----------------------------------------------------------------------------
    public List<Comments> findAll()
    {
        Query query = entityManager.createQuery(
                "SELECT Comments FROM Comments Comments "
                        + "ORDER BY Comments.id DESC");
        List l = query.getResultList();

        return (List<Comments>)l;
    }
    //-----------------------------------------------------------------------------

    public List<Comments> findByVacation(int vacationId){

        //TODO
        return null;
    }
    //-----------------------------------------------------------------------------

    public  Comments persist(Comments Comments){
        entityManager.persist(Comments);
        return Comments;

    }
    //-----------------------------------------------------------------------------

    public Comments update (Comments Comments){
        return entityManager.merge(Comments);

    }
    //-----------------------------------------------------------------------------

    public void remove(Comments Comments){
        entityManager.remove(entityManager.merge(Comments));
    }

}
