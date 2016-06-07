/**
 * Created by dmitriiiermiichuk on 6/6/16.
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedLinkedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1) {
            {
                next = new ListNode(2) {
                    {
                        next = new ListNode(5){
                            {
                                next = new ListNode(6);
                            }
                        };
                    }
                };
            }
        };


        ListNode l2 = new ListNode(3) {
            {
                next = new ListNode(4) {
                    {
                        next = new ListNode(7){
                            {
                                next = new ListNode(8);
                            }
                        };
                    }
                };
            }
        };

        ListNode merged = new MergeKSortedLinkedLists().mergeKLists(new ListNode[]{l1, l2});

        while (merged != null) {
            System.out.println(merged.val);
            merged = merged.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeSort(lists, 0, lists.length);
    }

    private ListNode mergeSort(ListNode[] lists, int lo, int hi) {
        int n = hi - lo;
        if (n < 1) {
            return null;
        }
        if (n == 1) {
            return lists[lo];
        }
        int mid = lo + n/2;
        ListNode left = mergeSort(lists,lo, mid);
        ListNode right = mergeSort(lists, mid, hi);
        return merge(left, right);
    }
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            }else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null) {
            tail.next = l1;
        }else {
            tail.next = l2;
        }
        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }
}
