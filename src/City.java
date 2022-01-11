public class City {
     String name;
    double decimalLatitude;
    double decimalLongitude;
    static final double r = 6372.8;

    public City(){

    }
    public City(String name){
        this.name = name;
    }

    public City(String name, double decimalLatitude, double decimalLongitude){
        this.name = name;
        this.decimalLatitude = decimalLatitude;
        this.decimalLongitude = decimalLongitude;
    }

    public String getName() {
        return name;
    }

    public double getDecimalLatitude() {
        return decimalLatitude;
    }

    public double getDecimalLongitude() {
        return decimalLongitude;
    }

    public int compareTo(City o){
       return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return
                "name=" + name + '\n' +
                "decimalLatitude=" + decimalLatitude +
                "\nndecimalLongitude=" + decimalLongitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDecimalLongitude(double decimalLongitude) {
        this.decimalLongitude = decimalLongitude;
    }

    public void setDecimalLatitude(double decimalLatitude) {
        this.decimalLatitude = decimalLatitude;
    }
    public boolean equals(City c){
        return name.equals(c.getName());
    }


}
