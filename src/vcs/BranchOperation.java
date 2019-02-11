package vcs;


import utils.Context;
import utils.ErrorCodeManager;
import utils.OperationType;

import java.util.ArrayList;

public class BranchOperation extends VcsOperation {
    public BranchOperation(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    /**
     *
     * @param vcs the vcs
     * @return error or 0 for success
     */
    @Override
    public int execute(Vcs vcs) {

        // Create new Branch if the stage is empty and the path is correct
        operationArgs.remove("branch");
        String newBranchName = operationArgs.get(0);


        if (Context.getInstance().getStagedChanges().size() != 0) {
            return ErrorCodeManager.VCS_STAGED_OP_CODE;
        }

        ArrayList<Branch> currentBranches = Context.getInstance().getBranches();
        for (Branch b : currentBranches) {
            if (b.getBranchName().equals(newBranchName)) {
                return ErrorCodeManager.VCS_BAD_CMD_CODE;
            }
        }

        Branch newBranch = new Branch(newBranchName);

        // copy all commit from the master branch

        newBranch.setCommits((ArrayList<Commit>) Context.getInstance()
                                                         .getCurrentBranch()
                                                         .getCommits()
                                                         .clone());
        Context.getInstance().addNewBranch(newBranch);

        return 0;
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
