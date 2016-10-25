package models;

/**
 * Created by Влад on 22.10.2016.
 */
public class Car {
    private int id;
    private String carMark;
    private String carModel;
    private int year;
    private String color;

    public int getId() {
        return id;
    }

    public String getCarMark() {
        return carMark;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCarMark(String carMark) {
        this.carMark = carMark;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
