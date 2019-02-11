package vcs;

import filesystem.FileSystemSnapshot;
import utils.Context;
import utils.OperationType;

import java.util.ArrayList;

public class RollBackOperation extends VcsOperation {
    public RollBackOperation(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    /**
     *
     * @param vcs the vcs
     * @return always successful
     */
    @Override
    public int execute(Vcs vcs) {

        // empty the staging
        Context.getInstance().getStagedChanges().clear();

        // return the FS to the version of the last commit
        Integer index = Context.getInstance().getCurrentBranch().getCommits().size();
        FileSystemSnapshot fileSystemSnapshot = Context.getInstance()
                                                .getCurrentBranch()
                                                .getCommits()
                                                .get(index - 1)
                                                .getCommitSnapshot()
                                                .cloneFileSystem();
        vcs.setActiveSnapshot(fileSystemSnapshot);
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
