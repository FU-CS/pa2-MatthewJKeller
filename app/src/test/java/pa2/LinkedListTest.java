package pa2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    @Test
    void testAdd() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals("1 2 3 ", list.traverse());
    }

    @Test
    void testRemove() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        assertEquals("1 3 ", list.traverse());
    }

    @Test
    void testAddEmpty() {
        LinkedList list = new LinkedList();
        list.add(10);
        assertEquals("10 ", list.traverse());
    }

    @Test
    void testAddLongList() {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(5);
        list.add(15);
        list.add(30);
        list.add(45);
        list.add(2);
        assertEquals("2 5 10 15 30 45 ", list.traverse());
    }

    @Test
    void testAddDup() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(1);
        assertEquals("1 1 ", list.traverse());
    }

    @Test
    void testAddFront() {
        LinkedList list = new LinkedList();
        list.add(20);
        list.add(30);
        list.add(10);
        assertEquals("10 20 30 ", list.traverse());
    }

    @Test
    void testRemoveFromEmpty() {
        LinkedList list = new LinkedList();
        list.remove(10);
        assertEquals("", list.traverse());
    }

    @Test
    void testRemoveInvalid() {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);
        list.remove(25);
        assertEquals("10 20 ", list.traverse());
    }

    @Test
    void testRemoveHead() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(10);
        list.add(15);
        list.remove(5);
        assertEquals("10 15 ", list.traverse());
    }

    @Test
    void testRemoveAll() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        list.remove(2);
        list.remove(3);
        assertEquals("", list.traverse());
    }

    @Test
    void testTraverseEmptyList() {
        LinkedList list = new LinkedList();
        assertEquals("", list.traverse());
    }


    @Test
    void testTraverseWithSingleElement() {
        LinkedList list = new LinkedList();
        list.add(10);
        assertEquals("10 ", list.traverse());
    }

    @Test
    void testReverseEmptyList() {
        LinkedList list = new LinkedList();
        assertEquals("", list.reverse());
    }

    @Test
    void testReverse() {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals("30 20 10", list.reverse());
    }

    @Test
    void testReverseOne() {
        LinkedList list = new LinkedList();
        list.add(1);
        assertEquals("1", list.reverse());
    }

    @Test
    void testReverseRepeat() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(5);
        list.add(5);
        assertEquals("5 5 5", list.reverse());
    }

    @Test
    void testMergeTwoEmptyLists() {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        LinkedList merged = LinkedList.merge(list1, list2);
        assertEquals("", merged.traverse());
    }

    @Test
    void testMergeEmptyOnList() {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        list2.add(1);
        list2.add(2);
        LinkedList merged = LinkedList.merge(list1, list2);
        assertEquals("1 2 ", merged.traverse());
    }

    @Test
    void testMergeTwoLists() {
        LinkedList list1 = new LinkedList();
        list1.add(1);
        list1.add(2);
        LinkedList list2 = new LinkedList();
        list2.add(5);
        list2.add(6);
        LinkedList merged = LinkedList.merge(list1, list2);
        assertEquals("1 2 5 6 ", merged.traverse());
    }

    @Test
    void testMergeDups() {
        LinkedList list1 = new LinkedList();
        list1.add(1);
        list1.add(3);
        LinkedList list2 = new LinkedList();
        list2.add(1);
        list2.add(3);
        LinkedList merged = LinkedList.merge(list1, list2);
        assertEquals("1 1 3 3 ", merged.traverse());
    }
}
