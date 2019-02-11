package vcs;

import filesystem.FileSystemSnapshot;
import utils.IDGenerator;

import java.util.ArrayList;

public class Commit {
    private Integer commitID;
    private ArrayList<String> commitMessage;
    private FileSystemSnapshot commitSnapshot;

    /**
     *  Commit Constructor.
     */
    public Commit(final ArrayList<String> commitMessage,
                   final FileSystemSnapshot commitSnapshot) {
        this.commitID = IDGenerator.generateCommitID();
        this.commitMessage = commitMessage;
        this.commitSnapshot = commitSnapshot;
    }

    /**
     *
     * @return commitID
     */
    public Integer getCommitID() {
        return commitID;
    }

    /**
     *
     * @return commitMessage
     */
    public ArrayList<String> getCommitMessage() {
        return commitMessage;
    }

    /**
     *
     * @return commitSnapshot
     */
    public FileSystemSnapshot getCommitSnapshot() {
        return commitSnapshot;
    }


}
