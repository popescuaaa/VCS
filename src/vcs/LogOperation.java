package vcs;

import utils.Context;
import utils.OperationType;

import java.util.ArrayList;

public class LogOperation extends VcsOperation {
    public LogOperation(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    /**
     *
     * @param vcs the vcs
     * @return commit id and commit message
     */
    @Override
    public int execute(Vcs vcs) {


        Branch currentHead = Context.getInstance().getCurrentBranch();
        ArrayList<Commit> branchCommits = currentHead.getCommits();

        for (int j = 0; j < branchCommits.size(); j++) {
            Commit c = branchCommits.get(j);

            vcs.getActiveSnapshot().getOutputWriter()
                    .write("Commit id: "
                            + c.getCommitID());

            vcs.getActiveSnapshot().getOutputWriter()
                    .write("\nMessage: ");

            if (j != branchCommits.size() - 1) {

                for (int i = 0; i < c.getCommitMessage().size(); i++) {
                    if (i == c.getCommitMessage().size() - 1) {

                        vcs.getActiveSnapshot()
                                .getOutputWriter()
                                .write(c.getCommitMessage().get(i) + "\n");

                        vcs.getActiveSnapshot().getOutputWriter().write("\n");

                    } else {

                        vcs.getActiveSnapshot()
                                .getOutputWriter()
                                .write(c.getCommitMessage().get(i) + " ");

                    }
                }

            } else {
                for (int i = 0; i < c.getCommitMessage().size(); i++) {
                    if (i == c.getCommitMessage().size() - 1) {

                        vcs.getActiveSnapshot()
                                .getOutputWriter()
                                .write(c.getCommitMessage().get(i) + "\n");

                    } else {

                        vcs.getActiveSnapshot()
                                .getOutputWriter()
                                .write(c.getCommitMessage().get(i) + " ");

                    }
                }
            }

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
