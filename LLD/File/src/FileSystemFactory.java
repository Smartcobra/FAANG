public class FileSystemFactory {
    public static File createFile(String name, Permission permission, String content, String type) {
        return new File(name, permission, content, type);
    }
    public static Directory createDirectory(String name, Permission permission) {
        return new Directory(name, permission);
    }
}
