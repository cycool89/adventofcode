package src.adventofcode2020.day7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import src.lib.FileHandler;

public class Day7First {

    static class Graph {
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
            for (String parentId: rootNode.parentIds) {
                containers.add(nodes.get(parentId));
                getContainerNodes(containers, parentId);
            }
            return containers;
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

    static class Node {
        String id;
        List<String> parentIds = new ArrayList<>();
        List<String> childrenIds = new ArrayList<>();

        public String getId() {
            return id;
        }

        public Node(String id) {
            this.id = id;
        }

        public boolean addParent(String parentId) {
            return parentIds.add(parentId);
        }

        public boolean addChild(String childId) {
            return childrenIds.add(childId);
        }

        public List<String> getParents() {
            return parentIds;
        }

        public List<String> getChildren() {
            return childrenIds;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null)
                return false;
            if (!(obj instanceof Node))
                return false;

            return this.id.equals(((Node) obj).id);
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }
    }

    private static Graph processInput(List<String> lines) {
        Graph luggageRules = new Graph();

        for (String line : lines) {
            String[] nodeDef = line.split(" bags contain ");
            String id = nodeDef[0];

            Node node = luggageRules.getNode(id);

            String[] childrenDef = nodeDef[1].split(", ");
            for (String childDefs : childrenDef) {
                String[] childDef = childDefs.split(" ");
                String childId = childDef[1] + " " + childDef[2];

                try {
                    int count = Integer.parseInt(childDef[0]);

                    for (int i = 0; i < count; i++) {
                        node.addChild(childId);
                    }

                    Node childNode = luggageRules.getNode(childId);

                    childNode.addParent(node.getId());

                } catch (Exception e) {
                    // No children. It's OK :)
                }
            }
            luggageRules.addNode(node);

        }

        return luggageRules;
    }

    public static void main(String[] args) {
        String[] inputPath = { "day7", "input.txt" };
        List<String> lines = FileHandler.readByLine(2020, inputPath);

        Graph luggageRules = processInput(lines);

        Set<Node> containers = new HashSet<>();
        int shinyGoldHolderCount = luggageRules.getContainerNodes(containers, "shiny gold").size();

        System.out.println("Number of bag colors that can contain at least 1 shiny gold bag: " + shinyGoldHolderCount);
    }
}