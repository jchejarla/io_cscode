package io.cscode.algorithms.linkedlist;

public class MergeTwoSortedLists {

    static class ListNode {
        int element;
        ListNode next;
        public ListNode (int element) {
            this.element = element;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode temp = this;
            while(temp != null) {
                sb.append(temp.element);
                if(temp.next !=null) {
                    sb.append("->");
                    temp = temp.next;
                } else {
                    break;
                }
            }
            return sb.toString();
        }

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);// create a new ListNode with a dummy head
        ListNode temp = result; // purpose of this temp List is to hold the tail of ListNode

        while (list1 != null || list2 != null) {

            if(list1 == null) {
                temp.next = list2;
                break;
            }
            if(list2 == null)  {
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

            temp = temp.next; // for the next iteration update the tail to current tail

        }

        return result.next; // return result by removing teh dummy head created in step-1
    }

}
