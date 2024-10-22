/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();

        ListNode temp = head;
        int n = 0;
        while(temp != null){
            n++;
            temp = temp.next;
        }

        int ans[]  = new int[n];
        HashMap<ListNode, Integer> map = new HashMap<>();
        int c=0;
        while(head != null){
            map.put(head, c);
            if(st.isEmpty()){
                st.add(head);
            } else{
                if( head.val <= st.peek().val){
                    st.add(head);
                }
                else{
                    while(!st.isEmpty() && st.peek().val < head.val){
                        int ind = map.get(st.pop());
                        ans[ind] = head.val;
                    }
                    st.add(head);
                }
            }

            c++;
            head = head.next;
        }

        return ans;
    }
}