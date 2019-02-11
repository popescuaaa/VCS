package vcs;

import filesystem.FileSystemSnapshot;
import utils.Context;
import utils.ErrorCodeManager;
import utils.OperationType;

import java.util.ArrayList;

public class CommitOperation extends VcsOperation {
    public CommitOperation(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    /**
     *
     * @param vcs the vcs
     * @return error or 0 for success
     */
    @Override
    public int execute(Vcs vcs) {

        if (Context.getInstance().getStagedChanges().size() == 0) {
            return ErrorCodeManager.VCS_BAD_CMD_CODE;
        } else {
            // empty the staging
            Context.getInstance().getStagedChanges().clear();
            // get the FS version
            FileSystemSnapshot newActiveSnapshot = vcs.getActiveSnapshot().cloneFileSystem();
            operationArgs.remove("-m");
            operationArgs.remove("commit");
            // add message to the commit
            ArrayList<String> commitMessage = operationArgs;

            Commit newCommit = new Commit(commitMessage, newActiveSnapshot);
            // add the commit to the current branch commits list

            Context.getInstance().getCurrentBranch().addCommit(newCommit);



        }
        return ErrorCodeManager.OK;
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
