package Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Riyaad on 8/7/2017.
 */
@Entity
public class BookCar implements Serializable
{

    @Id
    @Column(name="bookRef", unique=false)
    @GeneratedValue
    private String bookRef;

    @Column(name="startDate")
    private String startDate;

    @Column(name="endDate")
    private String endDate;

    @ManyToOne
    @JoinColumn(name = "catID")
    private List<Domain.Category> catList;

    @ManyToOne
    @JoinColumn(name = "carRegNo")
    private List<Domain.Car> carList;

    public BookCar()
    {

    }

    public BookCar(BookCar.Builder build)
    {
        this.startDate = build.startDate;
        this.endDate= build.endDate;
        this.bookRef=build.bookRef;
    }

    public static class Builder {
        private String startDate;
        private String endDate;
        private String bookRef;

        public Builder startDate(String value) {
            this.startDate = value;
            return this;
        }

        public Builder endDate(String value) {
            this.endDate = value;
            return this;
        }

        public Builder bookRef(String value) {

            this.bookRef = value;

            return this;
        }
        public BookCar build()
        {
            return new BookCar(this);

        }

    }


    public String getStartDate()
    {
        return startDate;
    }

    public String getEndDate()
    {
        return endDate;
    }

    public String getBookRef()
    {
        return bookRef;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookCar book = (BookCar) o;

        return bookRef.equals(book.bookRef);
    }
    @Override
    public int hashCode()

    {
        return bookRef.hashCode();
    }




}
