package vcs;

import utils.ErrorCodeManager;
import utils.OperationType;

import java.util.ArrayList;

public class VcsInvalidOp extends VcsOperation {
    public VcsInvalidOp(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    /**
     *
     * @param vcs the vcs
     * @return error code for invalid operation
     */
    @Override
    public int execute(Vcs vcs) {

        return ErrorCodeManager.VCS_BAD_CMD_CODE;
    }

    /**
     *
     * @return operationArgs
     */
    @Override
    public ArrayList<String> getOperationArgs() {
        return super.getOperationArgs();
    }

    /**
     *
     * @return command type
     */
    @Override
    public OperationType getType() {
        return super.getType();
    }
}
