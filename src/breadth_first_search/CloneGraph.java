//package breadth_first_search;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * https://leetcode.com/problems/clone-graph
// * 问题：
// * 思路：
// */
//public class CloneGraph {
//    public class UndirectedGraphNode {
//        int label;
//        List<UndirectedGraphNode> neighbors;
//
//        public UndirectedGraphNode(int x) {
//            label = x;
//            neighbors = new ArrayList<UndirectedGraphNode>();
//        }
//
//        public UndirectedGraphNode(int label, List<UndirectedGraphNode> neighbors) {
//            this.label = label;
//            this.neighbors = neighbors;
//        }
//    }
//
//    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//
//    }
//
//    public static void main(String[] args) {
//        CloneGraph obj = new CloneGraph();
//        System.out.println(obj.cloneGraph(new UndirectedGraphNode(1, new UndirectedGraphNode())).label);
//    }
//}
