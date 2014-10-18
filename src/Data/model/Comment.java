package Data.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Hervé on 17/10/2014.
 */
@Entity
public class Comment {
    private int id;
    private Timestamp creadate;
    private String comments;
    private Employee creator;
    private Vacation vacation;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "creatorId")
    public Employee getCreator(){
        return creator;
    }
    public void setCreator(Employee emp){
        creator = emp;
    }
    @ManyToOne
    @JoinColumn(name = "vacationId")
    public Vacation getVacation(){
        return vacation;
    }
    public void setVacation(Vacation vac){
        vacation = vac;
    }
    @Basic
    @Column(name = "creadate", nullable = false, insertable = true, updatable = true)
    public Timestamp getCreadate() {
        return creadate;
    }

    public void setCreadate(Timestamp creadate) {
        this.creadate = creadate;
    }

    @Basic
    @Column(name = "comments", nullable = false, insertable = true, updatable = true, length = 500)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment1 = (Comment) o;

        if (id != comment1.id) return false;
        if (comments != null ? !comments.equals(comment1.comments) : comment1.comments != null) return false;
        if (creadate != null ? !creadate.equals(comment1.creadate) : comment1.creadate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (creadate != null ? creadate.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        return result;
    }
}
