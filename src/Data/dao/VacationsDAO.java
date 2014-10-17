package Data.dao;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import Data.model.Vacations;
import java.util.List;

/**
 * Created by Manfred on 27/10/2014.
 */

@Stateless
@LocalBean
public class VacationsDAO {
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
    public VacationsDAO()
    {
        // TODO Auto-generated constructor stub
    }
    //-----------------------------------------------------------------------------
    public Vacations findById(Integer id)
    {
        return entityManager.find(Vacations.class, id);
    }
    //----------------------------------------------------------------------------
    public List<Vacations> findAll()
    {
        Query query = entityManager.createQuery(
                "SELECT Vacations FROM Vacations Vacations "
                        + "ORDER BY Vacations.id DESC");
        List l = query.getResultList();

        return (List<Vacations>)l;
    }
    //-----------------------------------------------------------------------------

    public  Vacations persist(Vacations Vacations){
        entityManager.persist(Vacations);
        return Vacations;

    }
    //-----------------------------------------------------------------------------

    public Vacations update (Vacations Vacations){
        return entityManager.merge(Vacations);

    }
    //-----------------------------------------------------------------------------

    public void remove(Vacations Vacations){
        entityManager.remove(entityManager.merge(Vacations));
    }

}
