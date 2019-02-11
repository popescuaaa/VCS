package vcs;


import java.util.ArrayList;

public class Branch {
    private static final Integer COMMITS_INIT_CAPACITY = 10;
    private String branchName;
    private ArrayList<Commit> commits;



    /**
     *
     * @param branchName
     */
    public Branch(final String branchName) {
        this.branchName = branchName;
        commits = new ArrayList<>(COMMITS_INIT_CAPACITY);

    }

    /**
     *
     * @param commit
     */
    public void addCommit(final Commit commit) {
        commits.add(commit);
    }

    /**
     *
     * @return head = last Commit
     */
    public Commit getHead() {
        return commits.get(commits.size() - 1);
    }

    /**
     *
     * @return branchName
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     *
     * @return commits
     */
    public ArrayList<Commit> getCommits() {
        return commits;
    }

    /**
     *
     * @param commits
     */
    public void setCommits(ArrayList<Commit> commits) {
        this.commits = commits;
    }
}
