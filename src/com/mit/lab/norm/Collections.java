package com.mit.lab.norm;

import org.apache.commons.collections.MapUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: MIT Lab Project</p>
 * <p>Description: com.mit.lab.norm.Collections</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: MIT Labs Co., Inc</p>
 *
 * @author <chao.deng@mit.lab>
 * @version 1.0
 * @since 5/2/2017
 */
public class Collections {

    public List<Object> extractPK(List<Map<String, Object>> source, String name) {
        List<Object> lstUnids = null;
        if (source != null && source.size() > 0) {
            lstUnids = new ArrayList<>();
            for (Map<String, Object> item : source) {
                lstUnids.add(MapUtils.getLong(item, name));
            }
        }
        return lstUnids;
    }
}
