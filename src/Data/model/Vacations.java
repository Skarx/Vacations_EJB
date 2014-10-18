package Data.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * Created by Hervé on 17/10/2014.
 */
@Entity
public class Vacations {
    private int id;
    private Date begdate;
    private String begtime;
    private Date enddate;
    private String endtime;
    private String status;
    private Employees employee;
    private Employees manager;
    private Employees hr;
    private Set<Comments> comments;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "employeeId")
    public Employees getEmployee(){return employee;}

    public void setEmployee(Employees employee){this.employee = employee;}

    @ManyToOne
    @JoinColumn(name = "managerId")

    public Employees getManager(){return manager;}

    public void setManager(Employees manager){this.manager = manager;}

    @ManyToOne
    @JoinColumn(name = "hrId")
    public Employees getHr(){return hr;}

    public void setHr(Employees hr){this.hr = hr;}

    @OneToMany(mappedBy = "vacation")
    public Set<Comments> getComments(){return comments;}

    public void setComments(Set<Comments> comments) {this.comments = comments;}

    public void addComments(Comments comment){
        comments.add(comment);
    }
    public void removeComments(Comments comment){
        comments.remove(comment);
    }
    @Basic
    @Column(name = "begdate", nullable = false, insertable = true, updatable = true)
    public Date getBegdate() {
        return begdate;
    }

    public void setBegdate(Date begdate) {
        this.begdate = begdate;
    }

    @Basic
    @Column(name = "begtime", nullable = false, insertable = true, updatable = true, length = 20)
    public String getBegtime() {
        return begtime;
    }

    public void setBegtime(String begtime) {
        this.begtime = begtime;
    }

    @Basic
    @Column(name = "enddate", nullable = false, insertable = true, updatable = true)
    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    @Basic
    @Column(name = "endtime", nullable = false, insertable = true, updatable = true, length = 20)
    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    @Basic
    @Column(name = "status", nullable = false, insertable = true, updatable = true, length = 20)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vacations vacations = (Vacations) o;

        if (id != vacations.id) return false;
        if (begdate != null ? !begdate.equals(vacations.begdate) : vacations.begdate != null) return false;
        if (begtime != null ? !begtime.equals(vacations.begtime) : vacations.begtime != null) return false;
        if (enddate != null ? !enddate.equals(vacations.enddate) : vacations.enddate != null) return false;
        if (endtime != null ? !endtime.equals(vacations.endtime) : vacations.endtime != null) return false;
        if (status != null ? !status.equals(vacations.status) : vacations.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (begdate != null ? begdate.hashCode() : 0);
        result = 31 * result + (begtime != null ? begtime.hashCode() : 0);
        result = 31 * result + (enddate != null ? enddate.hashCode() : 0);
        result = 31 * result + (endtime != null ? endtime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
