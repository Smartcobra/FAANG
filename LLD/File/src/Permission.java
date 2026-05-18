public class Permission {
    private final boolean read;
    private final boolean write;
    private final boolean execute;
    public Permission(boolean read, boolean write, boolean execute) {
        this.read = read;
        this.write = write;
        this.execute = execute;
    }
    public boolean canRead() { return read; }
    public boolean canWrite() { return write; }
    public boolean canExecute() { return execute; }
    @Override
    public String toString() {
        return (read ? "r" : "-") + (write ? "w" : "-") + (execute ? "x" : "-");
    }
}
