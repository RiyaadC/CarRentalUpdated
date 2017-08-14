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
public class Customer implements Serializable
{

    @Id
    @Column(name="custName")
    @GeneratedValue
    private String custName;

    @Column(name="custLastName")
    private String custLastName;

    @Column(name="custID",unique = false)
    private String custID;

    @Column(name="custNumber",unique=false)
    private long custNumber;

    @Column(name="custEmail")
    private String custEmail;

    public Customer()
    {

    }


    public Customer(Builder builder)
    {
        this.custName=builder.custName;
        this.custLastName=builder.custLastName;
        this.custID=builder.custID;
        this.custEmail=builder.custEmail;
    }
    //Builder class
    public static class Builder
    {

        private String custName;
        private String custLastName;
        private String custID;
        private long custNumber;
        private String custEmail;



        public Builder custName(String value)
        {
            this.custName = value;
            return this;
        }

        public Builder custLastName(String value)
        {
            this.custLastName = value;
            return this;
        }
        public Builder custID(String value)
        {
            this.custID = value;
            return this;
        }
        public Builder custNumber(long value)
        {
            this.custNumber = value;
            return this;
        }
        public Builder custEmail(String value)
        {
            this.custEmail = value;
            return this;
        }

        public Customer build()
        {
            return new Customer(this);
        }
    }
    //end Builder class

    public String getCustName()
    {
        return custName;
    }

    public String getCustLastName() {
        return custLastName;
    }

    public  String getCustID() {
        return custID;
    }

    public long getCustNumber() {
        return custNumber;
    }

    public String getCustEmail()
    {
        return custEmail;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer cust = (Customer) o;

        return custID.equals(cust.custID);
    }

    @Override
    public int hashCode()
    {
        return custID.hashCode();
    }
}
