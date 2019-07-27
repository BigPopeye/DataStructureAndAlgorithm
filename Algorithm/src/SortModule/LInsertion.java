package SortModule;

public class LInsertion {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int x, ListNode node){
            val = x;
            next = node;
        }
    }
    private ListNode createList(int[] arr){
        ListNode head = new ListNode(arr[arr.length-1]);
        for(int i = arr.length-2;i>=0;i--){
            // always add item before head, so we need to add items from end to front
            head = new ListNode(arr[i],head);
        }
        ListNode  p = head;
        while(p != null){
            System.out.print(p.val + " > ");
            p = p.next;
        }
        System.out.println();
        return head;
    }
    public ListNode sortList(int[] arr) {
        ListNode head = createList(arr);
        if(head == null){
            return head;
        }
        ListNode curr = head, next = null;
        ListNode sentinel = new ListNode(0);

        while(curr!= null){
            next = curr.next;
            ListNode p = sentinel;
            while(p.next != null && p.next.val < curr.val){
                p = p.next;
            }
            curr.next = p.next;
            p.next = curr;
            curr = next;
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        LInsertion insertion = new LInsertion();
        int[] arr = new int[]{5,12,2,33,90,-1};
        ListNode head = insertion.sortList(arr);
        ListNode p = head;
        while(p != null){
            System.out.print(p.val + " > ");
            p = p.next;
        }

    }
}
