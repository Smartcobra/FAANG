public class File extends  FileSystemEntity {
    private String content;
    private int size;
    private String fileType;
    public File(String name, Permission permission, String content, String fileType) {
        super(name, permission);
        this.content = content;
        this.size = content.length();
        this.fileType = fileType;
    }
    public String readContent() {
        if (!permission.canRead()) {
            throw new RuntimeException("Read permission denied");
        }
        return content;
    }
    public void writeContent(String data) {
        if (!permission.canWrite()) {
            throw new RuntimeException("Write permission denied");
        }
        this.content = data;
        this.size = data.length();
        updateModifiedTime();
    }
    public int getSize() {
        return size;
    }
}
