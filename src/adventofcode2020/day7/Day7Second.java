package src.adventofcode2020.day7;

import java.util.ArrayList;
import java.util.List;

import src.lib.FileHandler;

public class Day7Second {

    public static void main(String[] args) {
        String[] inputPath = { "day7", "input.txt" };
        List<String> lines = FileHandler.readByLine(2020, inputPath);

        Graph luggageRules = Day7InputHandler.processInput(lines);

        int shinyGoldContentCount = luggageRules.getChildrenNodes(new ArrayList<>(), "shiny gold").size();

        System.out.println("Number of bag colors that shiny gold bag needs to contain: " + shinyGoldContentCount);

    }
}