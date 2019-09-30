package app_from_CV.list;

public class ListElement {
    private Object value;
    private ListElement next;

    public ListElement(Object value, ListElement next) {
        this.value = value;
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public ListElement getNext() {
        return next;
    }

    public void setNext(ListElement next) {
        this.next = next;
    }
}
