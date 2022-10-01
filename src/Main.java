import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> sort = new ArrayList<>();

       sort.add(2);
       sort.add(4);
       sort.add(1);
       sort.add(9);
       sort.add(0);
       sort.add(3);

        ArrayList<Integer> sorted = MergeSort(sort);

        for (int i = 0; i < sorted.size(); i++) {
            System.out.println(sorted.get(i));
        }
    }

    public static ArrayList<Integer> MergeSort(ArrayList<Integer> a) {
        if (a.size() == 1) {
            return a;
        }

        ArrayList<Integer> a1 = new ArrayList<>();

        for (int i = 0; i < a.size() / 2; i++) {
            a1.add(a.get(i));
        }

        ArrayList<Integer> a2 = new ArrayList<>();
        
        for (int i = a.size() / 2; i < a.size(); i++) {
            a2.add(a.get(i));
        }

        a1 = MergeSort(a1);
        a2 = MergeSort(a2);

        return merge(a1, a2);
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> c = new ArrayList<>();

        while (a.size() != 0 && b.size() != 0) {
            if (a.get(0) > b.get(0)) {
                c.add(b.get(0));
                b.remove(0);
            } else {
                c.add(a.get(0));
                a.remove(0);
            }
        }

        // at this point either a or b is empty

        while(a.size() != 0) {
            c.add(a.get(0));
            a.remove(0);
        }

        while(b.size() != 0) {
            c.add(b.get(0));
            b.remove(0);
        }

        return c;
    }
}