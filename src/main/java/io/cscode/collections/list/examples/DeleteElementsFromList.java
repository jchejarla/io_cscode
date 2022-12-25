package io.cscode.collections.list.examples;

import java.util.*;

public class DeleteElementsFromList {

    public void deleteUsingIndexRemoveMethod() {
        List<Integer> arrayList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("BEFORE - arrayList size : "+ arrayList.size() + " , elements : "+arrayList);
        arrayList.remove(0);
        System.out.println("AFTER - arrayList size : "+ arrayList.size() + " , elements : "+arrayList);
    }

    public void deleteUsingValueRemoveMethod() {
        List<String> arrayList = new ArrayList<>(List.of("a", "b", "c", "a"));
        System.out.println("BEFORE - arrayList size : "+ arrayList.size() + " , elements : "+arrayList);
        arrayList.remove("a");
        System.out.println("AFTER - arrayList size : "+ arrayList.size() + " , elements : "+arrayList);
    }

    public void deleteUsingRemoveIfMethod() {
        List<String> arrayList = new ArrayList<>(List.of("a", "b", "c", "a"));
        System.out.println("BEFORE - arrayList size : "+ arrayList.size() + " , elements : "+arrayList);
        arrayList.removeIf(s -> "a".equals(s));
        System.out.println("AFTER - arrayList size : "+ arrayList.size() + " , elements : "+arrayList);
    }

    public void deleteUsingIteratorMethod() {
        List<String> arrayList = new ArrayList<>(List.of("a", "b", "c", "a"));
        System.out.println("BEFORE - arrayList size : "+ arrayList.size() + " , elements : "+arrayList);
        Iterator<String> ite =  arrayList.iterator();
        while(ite.hasNext()){
            String element = ite.next();
            if("a".equals(element)) {
                ite.remove();
            }
        }
        System.out.println("AFTER - arrayList size : "+ arrayList.size() + " , elements : "+arrayList);
    }

    public void deleteWhileIteratingListUsingIterator() {
        List<String> arrayList = new ArrayList<>(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"));
        System.out.println("BEFORE - arrayList size : "+ arrayList.size() + " , elements : "+arrayList);
        Iterator<String> ite = arrayList.iterator();
        while(ite.hasNext()) {
            String element = ite.next();
            if("c".equals(element)) {
                ite.remove(); // removes current element from iterator position
            }
        }
        System.out.println("AFTER - arrayList size : "+ arrayList.size() + " , elements : "+arrayList);
    }

    public void deleteElementsAtEvenPositionUsingIterator() {
        List<Integer> arrayList = new ArrayList<>(List.of(0,1,2,3,4,5,6,7,8,9));
        System.out.println("BEFORE - arrayList size : "+ arrayList.size() + " , elements : "+arrayList);
        Iterator<Integer> ite = arrayList.iterator();
        int index =0;
        while(ite.hasNext()) {
            ite.next();
            if( (index++) % 2 == 0) {
                ite.remove(); // removes current element from iterator position
            }
        }
        System.out.println("AFTER - arrayList size : "+ arrayList.size() + " , elements : "+arrayList);
    }

    public static void main(String[] args) {
        //new DeleteElementsFromList().deleteUsingIndexRemoveMethod();
        //new DeleteElementsFromList().deleteUsingValueRemoveMethod();
        //new DeleteElementsFromList().deleteUsingRemoveIfMethod();
        //new DeleteElementsFromList().deleteUsingIteratorMethod();
        //new DeleteElementsFromList().deleteWhileIteratingListUsingIterator();
        new DeleteElementsFromList().deleteElementsAtEvenPositionUsingIterator();
    }
}
