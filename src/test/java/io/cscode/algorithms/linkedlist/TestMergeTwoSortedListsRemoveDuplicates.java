package io.cscode.algorithms.linkedlist;

import io.cscode.base.UnitTestBase;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;

import static io.cscode.algorithms.linkedlist.MergeTwoSortedListsRemoveDuplicates.*;
import static org.junit.Assert.assertEquals;

public class TestMergeTwoSortedListsRemoveDuplicates extends UnitTestBase {

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    MergeTwoSortedListsRemoveDuplicates  mergeTwoSortedListsRemoveDuplicates;


    @Test
    public void testMergeAndRemoveDuplicates() throws Exception {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(2);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode result = mergeTwoSortedListsRemoveDuplicates.mergeAndRemoveDuplicates(list1, list2);
        ListNode expected = new ListNode(1);
        expected.next = new ListNode(2);
        expected.next.next = new ListNode(3);
        expected.next.next.next = new ListNode(4);
        assertEquals(expected.toString(), result.toString());
    }

    @Test
    public void testRemoveDuplicatesWhileMergiing() throws Exception {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(2);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode result = mergeTwoSortedListsRemoveDuplicates.removeDuplicatesWhileMerging(list1, list2);
        ListNode expected = new ListNode(1);
        expected.next = new ListNode(2);
        expected.next.next = new ListNode(3);
        expected.next.next.next = new ListNode(4);
        assertEquals(expected.toString(), result.toString());
    }

}
