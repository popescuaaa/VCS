package vcs;

import utils.Context;
import utils.ErrorCodeManager;
import utils.OperationType;


import java.util.ArrayList;

public class CheckOutOperation extends VcsOperation {
    public CheckOutOperation(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    /**
     *
     * @param vcs the vcs
     * @return error or 0 for success
     */
    @Override
    public int execute(Vcs vcs) {

        operationArgs.remove("checkout");
        if (Context.getInstance().getStagedChanges().size() != 0) {
            return ErrorCodeManager.VCS_STAGED_OP_CODE;
        }

        if (operationArgs.get(0).equals("-c")) {
            // we are on the current branch
            Commit toGo = null;
            Integer commitID = Integer.parseInt(operationArgs.get(1));

            for (Commit c : Context.getInstance().getCurrentBranch().getCommits()) {
                if (c.getCommitID().equals(commitID)) {
                    toGo = c;
                }
            }

            if (toGo != null) {
                // search for its index and then remove all after
                ArrayList<Commit> commits = Context.getInstance()
                        .getCurrentBranch()
                        .getCommits();

                Integer commitIndex = commits.size(); // last position
                for (int i  = 0; i < commits.size(); i++) {

                    if (toGo.getCommitID().equals(commits.get(i).getCommitID())) {
                        commitIndex = i;
                    }

                }

                for (int i  = commitIndex + 1; i < commits.size(); i++) {
                        // remove all commits after that specific pos
                        commits.remove(i);

                }

                // set the FS to the commit version of FS
                vcs.setActiveSnapshot(toGo.getCommitSnapshot());

            } else {
                return ErrorCodeManager.VCS_BAD_PATH_CODE;
            }
        } else {

            // move the head cursor from this branch to another
            String branchName = operationArgs.get(0);
            Branch toGo = null;

            ArrayList<Branch> branches  = Context.getInstance().getBranches();
            for (Branch b  : branches) {
                if (b.getBranchName().equals(branchName)) {
                    toGo = b;
                }
            }

            if (toGo == null) {
                return ErrorCodeManager.VCS_BAD_CMD_CODE;
            }

            Context.getInstance().changeBranch(toGo);
            vcs.setActiveSnapshot(toGo.getCommits()
                    .get(toGo.getCommits().size() - 1)
                    .getCommitSnapshot());
        }
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
