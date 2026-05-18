import java.time.LocalDateTime;

public abstract class FileSystemEntity {
        protected String name;
        protected Permission permission;
        protected LocalDateTime createdAt;
        protected LocalDateTime modifiedAt;
        public FileSystemEntity(String name, Permission permission) {
            this.name = name;
            this.permission = permission;
            this.createdAt = LocalDateTime.now();
            this.modifiedAt = LocalDateTime.now();
        }
        public String getName() { return name; }
        public void setPermission(Permission permission) {
            this.permission = permission;
        }
        public void updateModifiedTime() {
            this.modifiedAt = LocalDateTime.now();
        }
}
