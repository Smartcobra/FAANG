import java.util.HashMap;
import java.util.Map;

public class Directory extends  FileSystemEntity {
    private Map<String, FileSystemEntity> children = new HashMap<>();
    public Directory(String name, Permission permission) {
        super(name, permission);
    }
    public void addChild(FileSystemEntity entity) {
        if (children.containsKey(entity.getName())) {
            throw new RuntimeException("Entity already exists");
        }
        children.put(entity.getName(), entity);
        updateModifiedTime();
    }
    public void removeChild(String name) {
        if (!children.containsKey(name)) {
            throw new RuntimeException("Entity not found");
        }
        children.remove(name);
        updateModifiedTime();
    }
    public FileSystemEntity getChild(String name) {
        return children.get(name);
    }
    public void listChildren() {
        children.keySet().forEach(System.out::println);
    }
}
