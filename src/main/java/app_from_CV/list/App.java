package app_from_CV.list;

public class App {

    public static void main(String[] args) throws Exception {

        MyList list = new MyList();

        list.add(2);
        list.add(1);
        list.add(5);
        list.add(9);
        list.add(2);
        list.add(3);
        list.add(14);
        list.add(19);
        list.add_by_index(2,8);
        list.delete(1);

        list.show();
        System.out.println("List size = " + list.size());

    }
}
