package src.adventofcode2020.day8;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class HandheldConsole {
    int instructionIndex;
    int accumulator;
    int runningDirection = 0;
    List<ProgramStep> program = new ArrayList<>();
    ProgramStep actualStep = null;

    Stack<ProgramStep> stackTrace = new Stack<>();

    public boolean tryToFix = false;

    public HandheldConsole(List<String> instructions) {
        processInput(instructions);
    }

    public void start() {
        instructionIndex = 0;
        accumulator = 0;

        runningDirection = 1;
        executeProgram();
    }

    public void stop() {
        runningDirection = 0;
        System.out.println("[STOPPED] Program has stopped. Accumulator state is: " + accumulator);
    }

    private void executeProgram() {
        do {
            if (runningDirection > 0) {
                actualStep = program.get(instructionIndex);
                stackTrace.add(actualStep);
            } else {
                actualStep = stackTrace.pop();
                instructionIndex = actualStep.getIndex();
            }

            instructionIndex = executeProgramStep();

            if (!hasNextStep() && tryToFix) {
                runningDirection = -1;
            }
        } while (runningDirection != 0 && hasNextStep());
        stop();
    }

    private boolean hasNextStep() {
        if (runningDirection > 0) {
            return instructionIndex >= 0 && instructionIndex < program.size();
        } else if (runningDirection < 0) {
            return !stackTrace.isEmpty();
        } else {
            return false;
        }
    }

    private int executeProgramStep() {
        if (runningDirection > 0) {
            System.out.println("EXECUTE line " + actualStep.getIndex() + ":\t" + actualStep.getInstruction() + " "
                    + actualStep.getValue() + "\t(" + accumulator + ")");
        } else {
            System.out.println("UNDO line " + actualStep.getIndex() + ":\t" + actualStep.getInstruction() + " "
                    + actualStep.getValue() + "\t(" + accumulator + ")");
        }
        int nextInstructionIndex = -1;

        if ((runningDirection > 0 && !actualStep.hasBeenExecuted())
                || (runningDirection < 0 && actualStep.hasBeenExecuted())) {
            switch (actualStep.getInstruction()) {
                case ACC:
                    accumulator += actualStep.getValue();
                    nextInstructionIndex = actualStep.getIndex() + runningDirection;
                    break;
                case JMP:
                    nextInstructionIndex = actualStep.getIndex() + actualStep.getValue() * runningDirection;
                    break;
                case NOP:
                default:
                    nextInstructionIndex = actualStep.getIndex() + runningDirection;
                    break;
            }
        } else {
            nextInstructionIndex = -1;
        }
        actualStep.setExecuted(runningDirection > 0);
        return nextInstructionIndex;
    }

    private void processInput(List<String> instructions) {
        int i = 0;
        for (String line : instructions) {
            String[] progStepDef = line.split(" ");

            program.add(new ProgramStep(i, Instruction.valueOf(progStepDef[0].toUpperCase()),
                    Integer.parseInt(progStepDef[1])));
            i++;
        }
    }
}