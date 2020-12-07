package src.adventofcode2020.day7;

import java.util.ArrayList;
import java.util.List;

class Node {
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