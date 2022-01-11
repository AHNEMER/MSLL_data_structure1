public class MSLLNode<T> {
    public T info;
    public SLL<T> list;
    public MSLLNode<T> next;

    public MSLLNode() {
        info = null;
        list = null;
        next = null;
    }
    public MSLLNode(T el) {
        this(el,null);
    }
    public MSLLNode(SLL<T> list) {
        this(list,null);
    }
    public MSLLNode(T el, MSLLNode<T> ptr) {
        info = el;
        next = ptr;
    }
    public MSLLNode(SLL<T> list, MSLLNode<T> ptr) {
        this.list = list;
        next = ptr;
    }
    public MSLLNode(T el, SLL<T> list, MSLLNode<T> ptr) {
        info = el;
        this.list = list;
        next = ptr;
    }
}

