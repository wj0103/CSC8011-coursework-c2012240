package csc8011;

public class Exhibit{
    private String exhibitID;
    private String description;
    private int acquired_year;
    private int exhibit_value;
    public Exhibit(String id,String des,int year,int value){
        exhibitID = id;
        description = des;
        acquired_year = year;
        exhibit_value = value;
    }
    /*Get exhibit value*/
    public int getValue(){
        return exhibit_value;
    }
    /*Get exhibit description*/
    public String getDes(){
        return description;
    }
    /*Get exhibit acquired year*/
    public int getYear(){
        return acquired_year;
    }
    /*Get exhibit ID*/
    public String getID(){
        return  exhibitID;
    }

}

