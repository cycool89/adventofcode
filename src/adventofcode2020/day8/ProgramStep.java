package src.adventofcode2020.day8;

class ProgramStep {
    Instruction instruction;
    Integer value;
    boolean executed = false;

    public ProgramStep(Instruction instruction, Integer value) {
        this.instruction = instruction;
        this.value = value;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public Integer getValue() {
        return value;
    }

    public boolean hasBeenExecuted() {
        return executed;
    }

    public void setExecuted(boolean value) {
        executed = value;
    }

    public void reset() {
        executed = false;
    }
}