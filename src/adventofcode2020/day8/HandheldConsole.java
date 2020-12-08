package src.adventofcode2020.day8;

import java.util.ArrayList;
import java.util.List;

class HandheldConsole {
    int instructionIndex;
    int accumulator;
    boolean isRunning = false;
    List<ProgramStep> program = new ArrayList<>();

    public HandheldConsole(List<String> instructions) {
        processInput(instructions);
    }

    public void start() {
        instructionIndex = 0;
        accumulator = 0;

        isRunning = true;
        executeProgram();
    }

    public void stop() {
        isRunning = false;
        System.out.println("[STOPPED] Program has stopped. Accumulator state is: " + accumulator);
    }

    private void executeProgram() {
        do {
            boolean canContinue = executeProgramStep(program.get(instructionIndex));
            if (!canContinue)
                stop();
        } while (isRunning);
    }

    private boolean executeProgramStep(ProgramStep step) {
        System.out.println("Executing line " + instructionIndex + ":\t" + step.getInstruction() + " " + step.getValue() + "\t(" + accumulator + ")");
        if (!step.hasBeenExecuted()) {
            switch (step.getInstruction()) {
                case ACC:
                    accumulator += step.getValue();
                    instructionIndex++;
                    break;
                case JMP:
                    instructionIndex += step.getValue();
                    break;
                case NOP:
                default:
                    instructionIndex++;
                    break;
            }
            step.setExecuted(true);
            return true;
        } else {
            return false;
        }
    }

    private void processInput(List<String> instructions) {
        for (String line : instructions) {
            String[] progStepDef = line.split(" ");

            program.add(new ProgramStep(Instruction.valueOf(progStepDef[0].toUpperCase()),
                    Integer.parseInt(progStepDef[1])));
        }
    }
}