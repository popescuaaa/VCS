package vcs;

import utils.Context;
import utils.OperationType;

import java.util.ArrayList;

public class StatusOperation extends VcsOperation {
    public StatusOperation(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    /**
     *
     * @param vcs the vcs
     * @return 0 for success and execute the printing of the staged actions
     */
    @Override
    public int execute(Vcs vcs) {

        vcs.getActiveSnapshot().getOutputWriter()
                .write("On branch: "
                        + Context.getInstance()
                        .getCurrentBranch().getBranchName() + '\n');

        vcs.getActiveSnapshot().getOutputWriter().write("Staged changes:");
        for (String s : Context.getInstance().getStagedChanges()) {
            String[] commandStrings = s.split("\\s+");
            switch (commandStrings[0].toLowerCase()) {
                case "touch":
                    vcs.getActiveSnapshot().
                            getOutputWriter().write("\n\tCreated file "
                                                        + commandStrings[1]);
                    break;
                case "mkdir":
                    vcs.getActiveSnapshot().
                            getOutputWriter().write("\n\tCreated directory "
                                                        + commandStrings[1]);
                    break;
                case "writetofile":
                    vcs.getActiveSnapshot().
                            getOutputWriter().write("\n\tAdded \""
                                                    + commandStrings[2]
                                                    + "\" to file "
                                                    + commandStrings[1]);
                    break;
                case "rm":
                    vcs.getActiveSnapshot().
                            getOutputWriter().write("\n\tRemoved "
                            + commandStrings[1]);

                    break;
                case "cd":
                    vcs.getActiveSnapshot().
                            getOutputWriter().write("\n\tChanged directory to "
                            + commandStrings[1]);

                    break;
                default:
                    break;
            }

        }

        vcs.getActiveSnapshot().getOutputWriter().write("\n");
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
     * @return operation type
     */
    @Override
    public OperationType getType() {
        return super.getType();
    }
}
