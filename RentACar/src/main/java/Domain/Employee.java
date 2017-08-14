package Domain;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Riyaad on 8/7/2017.
 */
@Entity
public class Employee implements Serializable
{

    @Id
    @Column(name="empName")
    @GeneratedValue
    private String empName;

    @Column(name="empLastName")
    private String empLastName;

    @Column(name="empID",unique = false)
    private String empID;

    @Column(name="empNumber",unique=false)
    private long empNumber;

    @Column(name="empEmail")
    private String empEmail;

    private Employee()
    {

    }

    public Employee(Builder builder)
    {
        this.empName=builder.empName;
        this.empLastName=builder.empLastName;
        this.empID=builder.empID;
        this.empEmail=builder.empEmail;
    }
    //Builder class
    public static class Builder
    {

        private String empName;
        private String empLastName;
        private String empID;
        private long empNumber;
        private String empEmail;



        public Builder empName(String value)
        {
            this.empName = value;
            return this;
        }

        public Builder empLastName(String value)
        {
            this.empLastName = value;
            return this;
        }
        public Builder empID(String value)
        {
            this.empID = value;
            return this;
        }
        public Builder empNumber(long value)
        {
            this.empNumber = value;
            return this;
        }
        public Builder empEmail(String value)
        {
            this.empEmail = value;
            return this;
        }

        public Employee build()
        {
            return new Employee(this);
        }
    }
    //end Builder class

    public String getempName()
    {
        return empName;
    }

    public String getempLastName() {
        return empLastName;
    }

    public  String getempID() {
        return empID;
    }

    public long getempNumber() {
        return empNumber;
    }

    public String getempEmail()
    {
        return empEmail;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee cust = (Employee) o;

        return empID.equals(cust.empID);
    }

    @Override
    public int hashCode()
    {
        return empID.hashCode();
    }

}
