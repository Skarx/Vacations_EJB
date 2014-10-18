package Data.model;

import javax.jws.Oneway;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Hervé on 17/10/2014.
 */
@Entity
public class Comments {
    private int id;
    private Timestamp creadate;
    private String comments;
    @OneToOne
    private Employees hrEmployee;
    @OneToOne
    private Employees mgrEmployee;
    @OneToOne
    private Vacations vacation;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employees getHrEmployee(){
        return null;
    }

    public void setHrEmployee(Employees emp){

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

        Comments comments1 = (Comments) o;

        if (id != comments1.id) return false;
        if (comments != null ? !comments.equals(comments1.comments) : comments1.comments != null) return false;
        if (creadate != null ? !creadate.equals(comments1.creadate) : comments1.creadate != null) return false;

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
