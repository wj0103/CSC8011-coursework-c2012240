package csc8011;

import java.util.ArrayList;

import static java.lang.Integer.MAX_VALUE;

public class Museum {
    String museum_name ;
    ArrayList<Exhibit> exhibitions = new ArrayList<Exhibit>();


    /*Set the museum name*/
    public void setName(String m_name){

        this.museum_name = m_name;
    }
    /* Add exhibits to the museum*/
    public void addExhibit(String id,String des,int year,int value){

        exhibitions.add(new Exhibit(id,des,year,value));
    }
    /*Find and return the exhibit with the highest value*/
    public Exhibit highestValue(){
        int h_value = 0;
        Exhibit high = new Exhibit("","",0,0);
        for(int i =0;i<exhibitions.size();i++){
            Exhibit e = exhibitions.get(i);
            int curr_val = e.getValue();
            if(curr_val > h_value){
                h_value = curr_val;
                high = e;
            }
        }
        return high;
    }
    /*Find and return the exhibit that the museum acquired first*/
    public Exhibit firstExhibit(){
        int f_year =Integer.MAX_VALUE;
        Exhibit first = new Exhibit("","",0,0);
        for(int i = 0;i<exhibitions.size();i++){
            Exhibit e = exhibitions.get(i);
            int curr_year = e.getYear();
            if(curr_year<f_year){
                f_year = curr_year;
                first = e;
            }
        }
        return first;
    }
    /*Calculate and return the average value of all exhibits */
    public int averageValue(){
        int average = 0;
        for(int i = 0;i<exhibitions.size();i++){
            Exhibit e = exhibitions.get(i);
            average += e.getValue();
        }
        return average;
    }



}
