package Data.dao;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Data.model.Vacation;

import java.util.List;

/**
 * Created by Manfred on 27/10/2014.
 */

@Stateless
@LocalBean
public class VacationDAO {
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
    public VacationDAO()
    {
        // TODO Auto-generated constructor stub
    }
    //-----------------------------------------------------------------------------
    public Vacation findById(Integer id)
    {
        return entityManager.find(Vacation.class, id);
    }
    //----------------------------------------------------------------------------
    public List<Vacation> findAll()
    {
        Query query = entityManager.createQuery(
                "SELECT Vacation FROM Vacation Vacation "
                        + "ORDER BY Vacation.id DESC");
        List l = query.getResultList();

        return (List<Vacation>)l;
    }
    //-----------------------------------------------------------------------------
    public List<Vacation> findByManagerId(int managerId){
        Query query = entityManager.createQuery("" +
                "SELECT Vacation FROM Vacation Vacation " +
                "WHERE Vacation.managerId IS " + managerId);
        return query.getResultList();
    }
    //-----------------------------------------------------------------------------
    public List<Vacation> findByHrId(int hrId){
        Query query = entityManager.createQuery("" +
                "SELECT Vacation FROM Vacation Vacation " +
                "WHERE Vacation.hrId IS " + hrId);
        return query.getResultList();
    }
    //-----------------------------------------------------------------------------
    public List<Vacation> findByEmployeeId(int employeeId){
        Query query = entityManager.createQuery("" +
                "SELECT Vacation FROM Vacation Vacation " +
                "WHERE Vacation.employeeId IS " + employeeId);
        return query.getResultList();
    }
    //-----------------------------------------------------------------------------
    public List<Vacation> findByEmployeeAndStatus(){
        //TODO
        return null;
    }
    //-----------------------------------------------------------------------------
    public Vacation persist(Vacation Vacation){
        entityManager.persist(Vacation);
        return Vacation;

    }
    //-----------------------------------------------------------------------------

    public Vacation update (Vacation Vacation){
        return entityManager.merge(Vacation);

    }
    //-----------------------------------------------------------------------------

    public void remove(Vacation Vacation){
        entityManager.remove(entityManager.merge(Vacation));
    }

}
