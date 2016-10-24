package BusinessLayer;

import JDBCClient.MyClient;
import Model.Car;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Влад on 23.10.2016.
 */
public class DataManager {
    private MyClient dbClient;
    public DataManager(){
        try {
            dbClient = new MyClient();
        } catch (IOException | SQLException | ClassNotFoundException e) {
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

    public Car requestToCar(HttpServletRequest request){
        Car car = new Car();
        car.setCarMark(request.getParameter("carMark"));
        car.setCarModel(request.getParameter("carModel"));
        car.setYear(Integer.parseInt(request.getParameter("year")));
        car.setColor(request.getParameter("color"));
        return car;
    }

    public void add(HttpServletRequest request){
        Car car = requestToCar(request);
        dbClient.Insert("insert into cars(carmark, carmodel, year, color) " +
                "values('"+car.getCarMark()+"','"+car.getCarModel()+"','"+
                car.getYear()+"','" + car.getColor() +"')");

    }

    public void update(HttpServletRequest request){
        Car car = requestToCar(request);
        int id = (int) request.getServletContext().getAttribute("editId");
        dbClient.Update("update cars set carMark='" +car.getCarMark() + "', carModel='" +
        car.getCarModel()+"', year='"+car.getYear()+"', color='" + car.getColor() +
        "' where id =" + id);
    }

    public void delete(HttpServletRequest request){
        String id = request.getParameter("id");
        dbClient.Delete("delete from cars where id=" + id);
    }

    public ArrayList getList(){
        ResultSet rs = dbClient.Select("SELECT * from cars");
        try {
            return convertToList(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Car getRecord(String id){
        ResultSet rs = dbClient.Select("Select * from cars where id = '" + id + "'");
        try {
            return (Car) convertToList(rs).get(0); //Change
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
