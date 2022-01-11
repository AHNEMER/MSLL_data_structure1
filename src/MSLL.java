public class MSLL<T> {
    protected MSLLNode<T> head, tail;

    public MSLL() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void addToMSLLHead(String s1) throws Exception {
        if (isInMSLList(s1))
            throw new Exception("element already exist");
        else {
            head = new MSLLNode(s1, new SLL(), head);
            if (tail == null)
                tail = head;
        }
    }
    public void addToMSLLTail(String s1) throws Exception {
        if (isInMSLList(s1))
            throw new Exception("element already exist");
        else {
            if (!isEmpty()) {
                tail.next = new MSLLNode(s1, new SLL(), head);
                tail = tail.next;
            } else head = tail = new MSLLNode(s1, new SLL(), head);
        }
    }

    public boolean isInMSLList(String s1) {
        if (isEmpty())
            return false;
        else {
            MSLLNode<T> tmp;
            for (tmp = head; tmp != null && !tmp.info.equals(s1); tmp = tmp.next) ;
            return tmp != null;
        }
    }

    public void addCityToSublistAtRear(City cityObject) throws Exception {

        char a = cityObject.getName().charAt(0);
        String s = "" + Character.toUpperCase(a);

        if (!isInMSLList(s)) {
            addToMSLLTail(s);
        }
            MSLLNode tmp;
            for (tmp = head; tmp != null && !tmp.info.equals(s); tmp = tmp.next);

            if (tmp.list.isInList(cityObject))
                throw new Exception("city already exist");
            else
            tmp.list.addToTail(cityObject);




    }

    public void addToCitySublistList(City c1, int position) throws Exception {

        char a = c1.getName().charAt(0);
        String s = "" + Character.toUpperCase(a);

        if (!isInMSLList(s)) {
            addToMSLLTail(s);
        }
        MSLLNode tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(s); tmp = tmp.next);

        if (tmp.list.isInList(c1))
            throw new Exception("city already exist");
        else
            tmp.list.incertAtPosition(c1,position);

    }




    public boolean cityIsInSubList(City c1){
        if (isEmpty())
            return false;
        else {
            char a = c1.getName().charAt(0);
            String s = "" + Character.toUpperCase(a);

            MSLLNode tmp;
            for (tmp = head; tmp != null && !tmp.info.equals(s); tmp = tmp.next) ;


            if (tmp != null)
                return tmp.list.isInList(c1);
            else
                return false;
        }
    }

    public void deleteCityFromSublist(City c1) throws Exception {

        if (!cityIsInSubList(c1))
            throw new Exception("city already exist");

        char a = c1.getName().charAt(0);
        String s = "" + Character.toUpperCase(a);


        MSLLNode tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(s); tmp = tmp.next);
        tmp.list.delete(c1);

    }

    public void deleteCitySublist(String str) throws Exception {
        if (!isInMSLList(str))
            throw new Exception("city is not in sublist");
        else {
            char a = str.charAt(0);
            String s = "" + Character.toUpperCase(a);

            MSLLNode tmp;
            for (tmp = head; tmp != null && !tmp.info.equals(s); tmp = tmp.next) ;
            tmp.list = null;
        }
    }

    public void makeCitySublistEmpty(String str) throws Exception {
        if (!isInMSLList(str))
            throw new Exception("elemnt is not in MSLL");
        else {
            char a = str.charAt(0);
            String s = "" + Character.toUpperCase(a);


            MSLLNode tmp;
            for (tmp = head; tmp != null && !tmp.info.equals(s); tmp = tmp.next) ;
            tmp.list.clear();
        }
    }

    public void displayCitySublist(String s1) throws Exception {
        if (!isInMSLList(s1))
            throw new Exception("elemnt is not in MSLL");
        else {
            char a = s1.charAt(0);
            String s = "" + Character.toUpperCase(a);


            MSLLNode tmp;
            for (tmp = head; tmp != null && !tmp.info.equals(s); tmp = tmp.next) ;
            tmp.list.printAll();
        }


    }


    public void deleteFromMSLL(String s1){
        if (!isEmpty())
            if (head == tail && s1.equals(head.info)) // if only one
                head = tail = null;       // node on the list;
            else if (s1.equals(head.info)) // if more than one node on the list;
                head = head.next;    // and el is in the head node;
            else {                    // if more than one node in the list
                MSLLNode<T> pred, tmp;// and el is in a nonhead node;
                for (pred = head, tmp = head.next;
                     tmp != null && !tmp.info.equals(s1);
                     pred = pred.next, tmp = tmp.next);
                if (tmp != null) {   // if el was found;
                    pred.next = tmp.next;
                    if (tmp == tail) // if el is in the last node;
                        tail = pred;
                }
            }
    }


    public double getDistance(String city1, String city2) throws Exception {
        City c1 = new City(city1);
        City c2 = new City(city2);

        if (!cityIsInSubList(c1) || !cityIsInSubList(c2)) {
            throw new Exception("City is not in sublist");
        } else {

            char a = city1.charAt(0);
            String s = "" + Character.toUpperCase(a);

            MSLLNode tmp;
            for (tmp = head; tmp != null && !tmp.info.equals(s); tmp = tmp.next) ;

            SLLNode city;
            for (city = tmp.list.head; city != null; city = city.next) {
                if (c1.compareTo((City) city.info) == 0)
                    c1 = (City) city.info;
            }


             a = city2.charAt(0);
             s = "" + Character.toUpperCase(a);


            for (tmp = head; tmp != null && !tmp.info.equals(s); tmp = tmp.next) ;


            for (city = tmp.list.head; city != null; city = city.next) {
                if (c2.compareTo((City) city.info) == 0)
                    c2 = (City) city.info;
            }
            double distance;
            double φ1 = c1.decimalLatitude;
            double φ2 = c2.decimalLatitude;
            double λ1 = c1.decimalLongitude;
            double λ2 = c2.decimalLongitude ;

            double latitudeD = Math.toRadians(φ2 - φ1);
            double longitudeD = Math.toRadians(λ2 - λ1);

             φ1 = Math.toRadians(c1.decimalLatitude);
             φ2 = Math.toRadians(c2.decimalLatitude);

            double d = Math.pow(Math.sin( latitudeD / 2), 2) + Math.cos(φ1) * Math.cos(φ2) * Math.pow(Math.sin( longitudeD / 2), 2);
            distance = 2 * City.r * Math.asin(Math.sqrt(d));
            return distance;
        }
    }

    public int length() {
        if (isEmpty()) {
            return 0;
        } else {
            int length = 0;
            for (MSLLNode tmp = head; tmp != null; tmp = tmp.next) {
                length++;
            }
            return length;
        }
    }
}



