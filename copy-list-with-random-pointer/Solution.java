public class Solution {
    public static RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> lookup = new HashMap<RandomListNode, RandomListNode>();

        if (head == null) {
            return null;
        }

        RandomListNode newHead = new RandomListNode(head.label);
        lookup.put(head, newHead);

        RandomListNode currNode = head.next;
        RandomListNode prevNodeInNewList = newHead;
        RandomListNode currNodeInNewList;

        while (currNode != null) {
            System.out.println(currNode.label);
            currNodeInNewList = new RandomListNode(currNode.label);
            prevNodeInNewList.next = currNodeInNewList;

            prevNodeInNewList = currNodeInNewList;

            lookup.put(currNode, currNodeInNewList);

            currNode = currNode.next;
        }

        currNode = head;
        currNodeInNewList = newHead;

        while (currNode != null) {
            RandomListNode randomTargetNode = currNode.random;
            if (randomTargetNode == null) {
                currNodeInNewList.random = null;
            } else {
                RandomListNode randomTargetNodeInNewList = lookup.get(randomTargetNode);

                currNodeInNewList.random = randomTargetNodeInNewList;
            }

            currNode = currNode.next;
            currNodeInNewList = currNodeInNewList.next;
        }

        return newHead;
    }
}
