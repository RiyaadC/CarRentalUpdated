package Domain;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;
import java.awt.print.Book;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Riyaad on 8/7/2017.
 */
@Entity
public class Category implements Serializable
{

    @Id
    @Column(name="catID", unique = false)
    @GeneratedValue
    private String catID;

    @Column(name="catType", unique = false)
    private String catType;

    @Column(name="rentalRate")
    private String rentalRate;

    @Column(name="custNumber",unique=false)
    private long custNumber;

    @ManyToOne
    @JoinColumn(name = "bookRef")
    private List<Book> bookRef;


    public Category(Builder build)
    {
        this.catID = build.catID;
        this.catType= build.catType;
        this.rentalRate=build.rentalRate;
    }

    public String getCatID()
    {
        return catID;
    }

    public String getCatType()
    {
        return catType;
    }

    public String getRentalRate()
    {
        return rentalRate;
    }
    public static class Builder
    {
        private String catID;
        private String catType;
        private String rentalRate;
        public Builder catID(String value)
        {
            this.catID = value;
            return this;
        }

        public Builder catType(String value)
        {
            this.catType= value;
            return this;
        }

        public Builder RentalRate(String value)
        {
            this.rentalRate=value;
            return this;
        }


        public Category build()
        {
            return new Category(this);
        }
    }
}
