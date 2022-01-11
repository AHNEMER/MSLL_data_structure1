public class SLL<T> {
    protected SLLNode<T> head, tail;
    public SLL() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void addToHead(T el) {
        head = new SLLNode<T>(el,head);
        if (tail == null)
            tail = head;
    }

    public void clear() {
        head = tail = null;
    }

    public void addToTail(T el) {
        if (!isEmpty()) {
            tail.next = new SLLNode<T>(el);
            tail = tail.next;
        }
        else head = tail = new SLLNode<T>(el);
    }

    public void incertAtPosition(T el, int i) throws IllegalAccessException {
        SLLNode<T> tmp;
        SLLNode<T> newNode = new SLLNode<T>(el);

        if (isInList(el))
           throw new IllegalAccessException("City already exist");

        if (i <= 0 || i > length())
            throw new IllegalAccessException("invaled position ");

        if (i ==1)
            addToHead((T) el);
        else {
            int p = 1;
            for (tmp = head; tmp != null && p != i-1 ; tmp = tmp.next, p++);
            newNode.next = tmp.next;
            tmp.next = newNode;
        }

    }

    public T deleteFromHead() { // delete the head and return its info;
        if (isEmpty())
            return null;
        T el = head.info;
        if (head == tail)       // if only one node on the list;
            head = tail = null;
        else head = head.next;
        return el;
    }
    public T deleteFromTail() { // delete the tail and return its info;
        if (isEmpty())
            return null;
        T el = tail.info;
        if (head == tail)       // if only one node in the list;
            head = tail = null;
        else {                  // if more than one node in the list,
            SLLNode<T> tmp;    // find the predecessor of tail;
            for (tmp = head; tmp.next != tail; tmp = tmp.next);
            tail = tmp;        // the predecessor of tail becomes tail;
            tail.next = null;
        }
        return el;
    }

    public void delete(T el) {  // delete the node with an element el;
        if (!isEmpty())
            if (head == tail && el.equals(head.info)) // if only one
                head = tail = null;       // node on the list;
            else if (el.equals(head.info)) // if more than one node on the list;
                head = head.next;    // and el is in the head node;
            else {                    // if more than one node in the list
                SLLNode<T> pred, tmp;// and el is in a nonhead node;
                for (pred = head, tmp = head.next;
                     tmp != null && !tmp.info.equals(el);
                     pred = pred.next, tmp = tmp.next);
                if (tmp != null) {   // if el was found;
                    pred.next = tmp.next;
                    if (tmp == tail) // if el is in the last node;
                        tail = pred;
                }
            }
    }

    public void delete(City el) {  // delete the node with an element el;
        if (!isEmpty())
            if (head == tail && el.equals((City) head.info)) // if only one
                head = tail = null;       // node on the list;
            else if (el.equals((City) head.info)) // if more than one node on the list;
                head = head.next;    // and el is in the head node;
            else {                    // if more than one node in the list
                SLLNode<T> pred, tmp;// and el is in a nonhead node;
                for (pred = head, tmp = head.next;
                     tmp != null && !((City) tmp.info).equals(el);
                     pred = pred.next, tmp = tmp.next)
                    ;
                if (tmp != null) {   // if el was found;
                    pred.next = tmp.next;
                    if (tmp == tail) // if el is in the last node;
                        tail = pred;
                }
            }
    }

    public void printAll() {
        for (SLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
            System.out.print(tmp.info.toString() + "\n\n");
    }

    public boolean isInList(T el) {
        SLLNode tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next);
        return tmp != null;
    }
    public boolean isInList(City el) {
        SLLNode tmp;
        for (tmp = head; tmp != null && !((City)tmp.info).equals(el); tmp = tmp.next);
        return tmp != null;
    }

    public int length(){
        int length=0;
        if (isEmpty())
            return 0;
        else
        for (SLLNode<T> tmp = head; tmp != null; tmp = tmp.next) {
            length++;
        }
        return length;
    }


}
