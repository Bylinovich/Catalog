package controller;

import models.Car;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.ArrayList;

/**
 * Created by Влад on 23.10.2016.
 */
public class MyClient {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String user = "root";
    private static final String password = "root";
    private static final String driverPath = "com.mysql.jdbc.Driver";
    private Connection con;
    private Statement stmt;
    private ResultSet resultSet;

    public MyClient(){
        try {
            Class.forName(driverPath);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Car convertToCar(ResultSet set){
        try {
            Car c=new Car();
            c.setId(set.getInt("id"));
            c.setCarMark(set.getString("carMark"));
            c.setCarModel(set.getString("carModel"));
            c.setYear(set.getInt("year"));
            c.setColor(set.getString("color"));
            return c;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    private ArrayList convertToList(ResultSet set) throws SQLException{
        ArrayList<Car> arrayList=new ArrayList<Car>();
        try {
            while (set.next()) {
                Car c=convertToCar(set);
                arrayList.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }


    public Car Select(String id){
        try {
            resultSet = stmt.executeQuery("Select * from cars where id = '" + id + "'");
            return (Car) convertToList(resultSet).get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public ArrayList Select(){
        try {
            resultSet = stmt.executeQuery("SELECT * from cars");
            return convertToList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void Insert(Car car){
        try {
            int i=stmt.executeUpdate("insert into cars(carmark, carmodel, year, color) " +
                    "values('"+car.getCarMark()+"','"+car.getCarModel()+"','"+
                    car.getYear()+"','" + car.getColor() +"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void Update(Car car){
        try {
            int i = stmt.executeUpdate("update cars set carMark='" +car.getCarMark() + "', carModel='" +
                    car.getCarModel()+"', year='"+car.getYear()+"', color='" + car.getColor() +
                    "' where id =" + car.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void Delete(String id){
        try {
            int i = stmt.executeUpdate("delete from cars where id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void finalize(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}