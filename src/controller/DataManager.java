package controller;

import models.Car;
import java.util.ArrayList;

/**
 * Created by Влад on 23.10.2016.
 */
public class DataManager {
    private MyClient dbClient;
    public DataManager(){
        dbClient = new MyClient();
    }


    public void add(Car car){
        dbClient.Insert(car);
    }


    public void update(Car car){
        dbClient.Update(car);
    }


    public void delete(String id){
        dbClient.Delete(id);
    }


    public ArrayList getList(){
        return dbClient.Select();
    }


    public Car getRecord(String id){
        return dbClient.Select(id);
    }
}
