package csc8011;

import java.io.File;
import java.util.Scanner;

public class MuseumIO {

    public static void main(String[] args) {

        String menu = """
                ----Menu----
                Enter 0 : Quit
                Enter 1 : Enter museum name
                Enter 2 : Read csv information and print summary of exhibits
                Enter 3 : Show exhibit with highest value
                Enter 4 : Show first exhibit acquired
                Enter 5 : Show average value of exhibits in the museum's collection
                """;
        System.out.println(menu);
        Scanner sw = new Scanner(System.in);
        boolean quit = false;
        Museum museum = new Museum() ;
        while(!quit){
            int choice = sw.nextInt();
            switch(choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("---Please Enter Museum Name---");
                    Scanner enter_name = new Scanner(System.in);
                    String museum_name = enter_name.nextLine();
                    System.out.println("Museum Name:" + museum_name);
                    museum.setName(museum_name);
                    break;
                case 2:
                    String id;
                    String des;
                    String s_year;
                    String s_value;
                    int year;
                    int value;
                    try{
                        Scanner sc = new Scanner(new File("src/csc8011/exhibits.csv"));
                        sc.useDelimiter(",");
                        while(sc.hasNext()){
                            String str = sc.nextLine();
                            String [] exhibits = str.split(",");
                            id = exhibits[0];
                            des = exhibits[1];
                            s_year = exhibits[2];
                            year = Integer.parseInt(s_year);
                            s_value = exhibits[3];
                            value = Integer.parseInt(s_value);
                            museum.addExhibit(id,des,year,value);
                            System.out.println("Exhibit ID: " + id +" Description: " + des + " Year acquired: " + s_year + " Value: £" + s_value);
                        }
                        System.out.println("File successfully load!");
                        sc.close();
                    }catch (Exception e) {
                        System.out.print(e);
                    }
                    break;
                case 3:
                    Exhibit highestV_exhibit = museum.highestValue();
                    System.out.println("Highest value exhibit: " + highestV_exhibit.getDes() + "(" + highestV_exhibit.getID() + ")" + "," + "£" + highestV_exhibit.getValue());
                    break;
                case 4:
                    Exhibit first_exhibit = museum.firstExhibit();
                    System.out.println("First exhibit acquired: " + first_exhibit.getDes()+ "(Acquired " + first_exhibit.getYear() + ")" );
                    break;
                case 5:
                    System.out.println("Average value of exhibits: £" + museum.averageValue());
                    break;
            }
        }





    }



}
