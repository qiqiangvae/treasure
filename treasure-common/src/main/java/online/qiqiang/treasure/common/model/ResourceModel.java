package online.qiqiang.treasure.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import online.qiqiang.forest.common.utils.DateConvertor;
import online.qiqiang.treasure.common.enums.FileType;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 资源模型
 *
 * @author qiqiang
 */
@Data
@Accessors(chain = true)
public class ResourceModel implements Serializable {
    private String name;
    private String path;
    private FileType fileType;
    private String mediaType;
    private Long size;
    private String accessUrl;
    @JsonFormat(pattern = DateConvertor.Pattern.USUAL_DATE_TIME)
    private LocalDateTime modifyTime;
}
