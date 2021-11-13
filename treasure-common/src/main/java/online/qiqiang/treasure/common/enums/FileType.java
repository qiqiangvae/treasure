package online.qiqiang.treasure.common.enums;

import java.io.File;

/**
 * @author qiqiang
 */
public enum FileType {
    unknown,
    directory,
    file;

    public static FileType fileType(File file) {
        if (file.isFile()) {
            return FileType.file;
        } else if (file.isDirectory()) {
            return FileType.directory;
        } else {
            return FileType.unknown;
        }
    }
}
