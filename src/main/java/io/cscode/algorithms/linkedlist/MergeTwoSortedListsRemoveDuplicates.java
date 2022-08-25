package io.cscode.algorithms.linkedlist;

public class MergeTwoSortedListsRemoveDuplicates {

    static class ListNode {
        int element;
        ListNode next;

        public ListNode(int element) {
            this.element = element;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode temp = this;
            while (temp != null) {
                sb.append(temp.element);
                if (temp.next != null) {
                    sb.append("->");
                    temp = temp.next;
                } else {
                    break;
                }
            }
            return sb.toString();
        }
    }

    public ListNode mergeAndRemoveDuplicates(ListNode list1, ListNode list2) {
        ListNode result = merge(list1, list2);
        removeDuplicates(result);
        return result;
    }

    public void removeDuplicates(ListNode linkedList) {
        ListNode current = linkedList; // pointer to current head
        while(current.next != null) {
            if(current.element == current.next.element) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while(list1!=null || list2!=null) {
            if(list1 == null) {
                temp.next = list2;
                break;
            }

            if(list2 == null){
                temp.next = list1;
                break;
            }

            if(list1.element <= list2.element) {
                temp.next = new ListNode(list1.element);
                list1 = list1.next;
            } else if (list1.element > list2.element) {
                temp.next = new ListNode(list2.element);
                list2 = list2.next;
            }
            temp = temp.next;
        }
        return result.next;
    }

    public ListNode removeDuplicatesWhileMerging(ListNode list1, ListNode list2) {

        ListNode result = new ListNode(0);// create a new ListNode with a dummy head
        ListNode temp = result;
        int counter=0;

        while(list1 != null || list2 != null) {

            if( (list1 != null && list2 != null && list1.element <= list2.element)
                    || (list2 == null)) {
                if(counter == 0 || (list1!=null && temp.element != list1.element)) {
                    temp.next = new ListNode(list1.element);
                }
                list1 = list1.next;
            } else if( (list1 != null && list2 != null && list1.element > list2.element)
                    || (list1 == null)) {
                if(counter == 0 || (list2 != null && temp.element != list2.element)) {
                    temp.next = new ListNode(list2.element);
                }
                list2 = list2.next;
            }

            counter++;
            if(temp.next != null) {
                temp = temp.next;
            }
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(2);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(2);

        ListNode result = new MergeTwoSortedListsRemoveDuplicates().mergeAndRemoveDuplicates(list1, list2);
        System.out.println(result);
        ListNode result1 = new MergeTwoSortedListsRemoveDuplicates().removeDuplicatesWhileMerging(list1, list2);
        System.out.println(result1);
    }
}
