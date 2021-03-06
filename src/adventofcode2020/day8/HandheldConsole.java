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
    int changedStackIndex;

    public boolean tryToFix = false;

    public HandheldConsole(List<String> instructions) {
        processInput(instructions);
    }

    public void start() {
        instructionIndex = 0;
        accumulator = 0;
        changedStackIndex = Integer.MAX_VALUE;

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
                if (changedStackIndex > stackTrace.size() && toggleActualStep()) {
                    changedStackIndex = stackTrace.size();
                    runningDirection = 1;
                } else if (changedStackIndex == stackTrace.size() && toggleActualStep()) {
                    toggleActualStep();
                }
                instructionIndex = actualStep.getIndex();
            }

            instructionIndex = executeProgramStep();
        } while (runningDirection != 0 && hasNextStep());
        stop();
    }

    private boolean toggleActualStep() {
        if (actualStep.getInstruction() == Instruction.JMP) {
            actualStep.setInstruction(Instruction.NOP);
            actualStep.setExecuted(!actualStep.hasBeenExecuted());
            return true;
        } else if (actualStep.getInstruction() == Instruction.NOP) {
            actualStep.setInstruction(Instruction.JMP);
            actualStep.setExecuted(!actualStep.hasBeenExecuted());
            return true;
        }
        return false;
    }

    private boolean hasNextStep() {
        boolean hasNextStep = false;

        if (runningDirection > 0) {
            hasNextStep = instructionIndex >= 0 && instructionIndex < program.size();

            if (!hasNextStep && instructionIndex < program.size() && tryToFix) {
                runningDirection = -1;
                stackTrace.pop();
                hasNextStep = true;
            }
        } else if (runningDirection < 0) {
            hasNextStep = !stackTrace.isEmpty();
            if (!hasNextStep) {
                runningDirection = 0;
            }
        }

        return hasNextStep;
    }

    private int executeProgramStep() {
        int nextInstructionIndex = -1;

        if ((runningDirection > 0 && !actualStep.hasBeenExecuted())
                || (runningDirection < 0 && actualStep.hasBeenExecuted())) {

            switch (actualStep.getInstruction()) {
                case ACC:
                    accumulator += actualStep.getValue() * runningDirection;
                    nextInstructionIndex = actualStep.getIndex() + 1;
                    break;
                case JMP:
                    nextInstructionIndex = actualStep.getIndex() + actualStep.getValue();
                    break;
                case NOP:
                default:
                    nextInstructionIndex = actualStep.getIndex() + 1;
                    break;
            }
            actualStep.setExecuted(runningDirection > 0);
        } else {
            nextInstructionIndex = -1;
        }
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