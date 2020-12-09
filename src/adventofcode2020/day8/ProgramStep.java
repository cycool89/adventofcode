package src.adventofcode2020.day8;

class ProgramStep {
    int index;
    Instruction instruction;
    Integer value;
    boolean executed = false;

    public ProgramStep(int index, Instruction instruction, Integer value) {
        this.index = index;
        this.instruction = instruction;
        this.value = value;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction newInstruction) {
        instruction = newInstruction;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer newValue) {
        value = newValue;
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

	public int getIndex() {
		return index;
	}
}