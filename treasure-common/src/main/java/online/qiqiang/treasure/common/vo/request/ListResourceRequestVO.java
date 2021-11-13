package online.qiqiang.treasure.common.vo.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import online.qiqiang.forest.query.AbstractQueryParam;

/**
 * @author qiqiang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ListResourceRequestVO extends AbstractQueryParam {
    private String path;
}
