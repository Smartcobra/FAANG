public class FileSystem {
    private static FileSystem instance;
    private Directory root;
    private FileSystem() {
        this.root = FileSystemFactory.createDirectory("root", new Permission(true, true, true));
    }
    public static FileSystem getInstance() {
        if (instance == null)
            instance = new FileSystem();
        return instance;
    }
    public Directory getRoot() { return root; }
    public void createFile(Directory parent, String name, Permission p, String content) {
        File file = FileSystemFactory.createFile(name, p, content, "text");
        parent.addChild(file);
    }
    public void createDirectory(Directory parent, String name, Permission p) {
        Directory d = FileSystemFactory.createDirectory(name, p);
        parent.addChild(d);
    }
    public void deleteEntity(Directory parent, String name) {
        parent.removeChild(name);
    }
}
