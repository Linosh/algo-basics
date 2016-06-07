/**
 * Created by dmitriiiermiichuk on 6/6/16.
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode list = new ListNode(1) {
            {
                next = new ListNode(2) {
                    {
                        next = new ListNode(3){
                            {
                                next = new ListNode(4);
                            }
                        };
                    }
                };
            }
        };

        ListNode reverseList = new ReverseLinkedList().reverseList(list);

        while (reverseList != null) {
            System.out.println(reverseList.val);
            reverseList = reverseList.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
            return head;

        ListNode p1 = head;
        ListNode p2 = p1.next;
        head.next = null;
        while (p1 != null && p2 != null) {
            ListNode tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
        }

        return p1;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
