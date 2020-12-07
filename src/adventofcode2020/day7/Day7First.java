package src.adventofcode2020.day7;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import src.lib.FileHandler;

public class Day7First {

    public static void main(String[] args) {
        String[] inputPath = { "day7", "input.txt" };
        List<String> lines = FileHandler.readByLine(2020, inputPath);

        Graph luggageRules = Day7InputHandler.processInput(lines);

        Set<Node> containers = new HashSet<>();
        int shinyGoldHolderCount = luggageRules.getContainerNodes(containers, "shiny gold").size();

        System.out.println("Number of bag colors that can contain at least 1 shiny gold bag: " + shinyGoldHolderCount);
    }
}