package com.nikonhacker.disassembly;

public class Instruction {

    /** Type of flow control assigned to each instruction (if suitable) */
    public static enum FlowType {
        /** This instruction does not change the program flow */
        NONE,

        /** This instruction changes the program flow to a subroutine (with return foreseen) */
        CALL,

        /** This instruction changes the program flow unconditionally (with no return foreseen) */
        JMP,

        /** This instruction changes the program flow conditionally (with no return foreseen) */
        BRA,

        /** This instruction changes the program flow by calling an interrupt */
        INT,

        /** This instruction changes the program flow by returning from a subroutine or interrupt */
        RET
    }

    /** Type of delay slot */
    public static enum DelaySlotType {
        /** This instruction is not followed by a delay slot */
        NONE,

        /** This instruction is followed by a normal delay slot, executed unconditionally */
        NORMAL,

        /** This instruction is followed by a delay slot, executed only if the branch is followed */
        LIKELY
    }

    private String name;
    private String operandFormat;
    private String formula;
    private String commentFormat;
    private String action;
    public FlowType flowType;
    private boolean isConditional;
    private DelaySlotType delaySlotType;
    private SimulationCode simulationCode;

    public Instruction(String name, String operandFormat, String formula, String commentFormat, String action, FlowType flowType, boolean isConditional, DelaySlotType delaySlotType, SimulationCode simulationCode) {
        this.name = name;
        this.operandFormat = operandFormat;
        this.formula = formula;
        this.commentFormat = commentFormat;
        this.action = action;
        this.flowType = flowType;
        this.isConditional = isConditional;
        this.delaySlotType = delaySlotType;
        this.simulationCode = simulationCode;
    }

    public String getName() {
        return name;
    }

    public String getOperandFormat() {
        return operandFormat;
    }

    public String getFormula() {
        return formula;
    }

    public String getCommentFormat() {
        return commentFormat;
    }

    public String getAction() {
        return action;
    }

    public FlowType getFlowType() {
        return flowType;
    }

    public boolean isConditional() {
        return isConditional;
    }

    public boolean hasDelaySlot() {
        return delaySlotType != DelaySlotType.NONE;
    }

    public DelaySlotType getDelaySlotType() {
        return delaySlotType;
    }

    public SimulationCode getSimulationCode() {
        return simulationCode;
    }
}
