package online.qiqiang.treasure.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author qiqiang
 */
public class PathUtils {
    public static String join(List<String> path) {
        return join(path.toArray(new String[0]));
    }

    public static String join(String... path) {
        StringBuilder builder;
        if (StringUtils.isBlank(path[0])) {
            builder = new StringBuilder();
        } else {
            builder = new StringBuilder(path[0]);
        }
        for (int i = 1; i < path.length; i++) {
            if (StringUtils.isBlank(path[i])) {
                continue;
            }
            if (path[i].equals("/")) {
                continue;
            }
            if (path[i].endsWith("/")) {
                path[i] = path[i].substring(0, path[i].length() - 2);
            }
            if (!path[i].startsWith("/")) {
                builder.append("/");
            }
            builder.append(path[i]);
        }
        return builder.toString();
    }
}
