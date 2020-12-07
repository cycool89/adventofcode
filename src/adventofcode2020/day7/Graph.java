package src.adventofcode2020.day7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Graph {
    Map<String, Node> nodes = new HashMap<>();

    public void addNode(Node node) {
        if (!nodes.containsKey(node.id)) {
            nodes.put(node.getId(), node);
        }
    }

    public Node getNode(String nodeId) {
        Node n = nodes.get(nodeId);
        if (n == null) {
            n = new Node(nodeId);
            addNode(n);
        }
        return n;
    }

    public List<Node> getNodes() {
        return new ArrayList<>(nodes.values());
    }

    public Set<Node> getContainerNodes(Set<Node> containers, String nodeId) {
        Node rootNode = nodes.get(nodeId);
        for (String parentId : rootNode.parentIds) {
            containers.add(nodes.get(parentId));
            getContainerNodes(containers, parentId);
        }
        return containers;
    }

    public List<Node> getChildrenNodes(List<Node> children, String nodeId) {
        Node rootNode = nodes.get(nodeId);

        for (String childId : rootNode.childrenIds) {
            children.add(getNode(childId));
            getChildrenNodes(children, childId);
        }

        return children;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Node> entry : nodes.entrySet()) {
            sb.append("[");
            sb.append(entry.getKey());
            sb.append("] - (");
            for (String parentId : entry.getValue().parentIds) {
                sb.append("|");
                sb.append(parentId);
                sb.append("|");
            }
            sb.append(") - (");
            for (String childId : entry.getValue().childrenIds) {
                sb.append("|");
                sb.append(childId);
                sb.append("|");
            }
            sb.append(")\n");
        }
        return sb.toString();
    }
}