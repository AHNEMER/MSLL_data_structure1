import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {


    public static void main(String[] args) throws Exception {





        

        Scanner kb = new Scanner(System.in);
        MSLL<City> citys = new MSLL<>();
        String city ,city2;
        double decimalLatitude;
        double decimalLongitude;
        int choice = 0;
        int p;
        City c;

        

        do {
            try {
                System.out.println();
                System.out.println("1.\tAddCityToSublistAtRear\n" +
                        "2.\tAddCityToSublistAtPosition\n" +
                        "3.\tSearchForCity\n" +
                        "4.\tDeleteCityFromCitySublist\n" +
                        "5.\tDeleteCitySublist\n" +
                        "6.\tMakeCitySublistEmpty\n" +
                        "7.\tDisplayCitySublist\n" +
                        "8.\taddToMSSLAtHead\n" +
                        "9.\tAddToMSSLAtTail\n" +
                        "10.\tSearchMSLList\n" +
                        "11.\tgetDistance\n" +
                        "12.\tExit\n");

                choice = kb.nextInt();


                if (choice > 12 || choice <= 0)
                    throw new IllegalAccessException("wrong menu choice");


                switch (choice) {


                    case 1:
                        System.out.println("enter city name: ");
                        city = kb.next();
                        System.out.println("enter city decimal Latitude: ");
                        decimalLatitude = kb.nextDouble();
                        System.out.println("enter city decimal Longitude: ");
                        decimalLongitude = kb.nextDouble();
                        c = new City(city, decimalLatitude, decimalLongitude);
                        citys.addCityToSublistAtRear(c);
                        System.out.println("city is added to sublist ");
                        break;


                    case 2:
                        System.out.println("enter city name: ");
                        city = kb.next();
                        System.out.println("enter city decimal Latitude: ");
                        decimalLatitude = kb.nextDouble();
                        System.out.println("enter city decimal Longitude: ");
                        decimalLongitude = kb.nextDouble();
                        c = new City(city, decimalLatitude, decimalLongitude);
                        System.out.println("enter wanted position: ");
                        p = kb.nextInt();
                        citys.addToCitySublistList(c, p);
                        System.out.println("city is added to sublist in position "+p);


                        break;

                    case 3:
                        System.out.println("enter city name: ");
                        city = kb.next();
                        c = new City(city);

                        if (citys.cityIsInSubList(c))
                            System.out.println("city is in a subList");
                        else
                            System.out.println("city is not in a subList");


                        break;

                    case 4:
                        System.out.println("enter city name: ");
                        city = kb.next();
                        c = new City(city);
                        citys.deleteCityFromSublist(c);
                        System.out.println("city is deleted from  subList");

                        break;

                    case 5:
                        System.out.println("enter capital character: ");
                        city = kb.next();

                        while (Character.isLowerCase(city.charAt(0)) || city.length() > 1) {
                            System.out.println("invaled input, please enter capital character: ");
                            city = kb.next();

                        }
                        citys.deleteCitySublist(city);
                        System.out.println("subList is deleted");

                        break;

                    case 6:
                        System.out.println("enter capital character: ");
                        city = kb.next();

                        while (Character.isLowerCase(city.charAt(0)) || city.length() > 1) {
                            System.out.println("invaled input, please enter capital character: ");
                            city = kb.next();

                        }
                        citys.makeCitySublistEmpty(city);
                        System.out.println("subList is empty");

                        break;

                    case 7:
                        System.out.println("enter capital character: ");
                        city = kb.next();

                        while (Character.isLowerCase(city.charAt(0)) || city.length() > 1) {
                            System.out.println("invaled input, please enter capital character: ");
                            city = kb.next();

                        }
                        citys.displayCitySublist(city);


                        break;

                    case 8:
                        System.out.println("enter capital character: ");
                        city = kb.next();

                        while (Character.isLowerCase(city.charAt(0)) || city.length() > 1) {
                            System.out.println("invaled input, please enter capital character: ");
                            city = kb.next();

                        }
                        citys.addToMSLLHead(city);
                        System.out.println("element is added to MSLL head");

                        break;

                    case 9:
                        System.out.println("enter capital character: ");
                        city = kb.next();

                        while (Character.isLowerCase(city.charAt(0)) || city.length() > 1) {
                            System.out.println("invaled input, please enter capital character: ");
                            city = kb.next();

                        }
                        citys.addToMSLLTail(city);
                        System.out.println("element is added to MSLL tail");
                        break;

                    case 10:
                        System.out.println("enter capital character: ");
                        city = kb.next();

                        while (Character.isLowerCase(city.charAt(0)) || city.length() > 1) {
                            System.out.println("invaled input, please enter capital character: ");
                            city = kb.next();

                        }
                        if (citys.isInMSLList(city)) {
                            System.out.println("elemnt is in MSLL list ");
                        } else
                            System.out.println("elemnt is in not MSLL list ");


                        break;

                    case 11:
                        System.out.println("enter city 1: ");
                        city = kb.next();
                        System.out.println("enter city 2: ");
                        city2 = kb.next();
                        double d = citys.getDistance(city, city2);
                        System.out.println("distance between the two citys is : " + d);


                        break;

                    case 12:
                        kb.close();
                        System.exit(0);

                        break;
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }catch (InputMismatchException e){
           System.out.println("wrong input \n ");
           kb.nextLine();
            }


        } while (choice != 12);



        }
    }

