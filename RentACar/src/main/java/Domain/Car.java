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
public class Car implements Serializable
{
    private String carName;
    private String carModel;
    private String carRegNo;
    private String carYear;

    private Car()
    {

    }

    public Car(Builder builder)
    {
        this.carName=builder.carName;
        this.carModel=builder.carModel;
        this.carRegNo=builder.carRegNo;
        this.carYear=builder.carYear;
    }
    //Builder class
    public static class Builder
    {

        @Id
        @Column(name="carName")
        @GeneratedValue
        private String carName;

        @Column(name="carModel")
        private String carModel;

        @Column(name="carRegNo",unique = false)
        private String carRegNo;

        @Column(name="carYear")
        private String carYear;



        public Builder carName(String value)
        {
            this.carName = value;
            return this;
        }

        public Builder carModel(String value)
        {
            this.carModel = value;
            return this;
        }
        public Builder carRegNo(String value)
        {
            this.carRegNo = value;
            return this;
        }

        public Builder carYear(String value)
        {
            this.carYear=value;
            return this;

        }


        public Car build()

        {
            return new Car(this);
        }
    }
    //end Builder class

    public String getCarName()

    {
        return carName;
    }

    public String getcarModel()
    {
        return carModel;
    }

    public  String getCarRegNo()
    {
        return carRegNo;
    }

    public String getCarYear()
    {
        return carYear;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return carRegNo.equals(car.carRegNo);
    }

    @Override
    public int hashCode()

    {
        return carRegNo.hashCode();
    }





}
