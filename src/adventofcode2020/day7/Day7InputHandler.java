package src.adventofcode2020.day7;

import java.util.List;

public class Day7InputHandler {

	static Graph processInput(List<String> lines) {
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
    
}
