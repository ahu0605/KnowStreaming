package com.xiaojukeji.know.streaming.km.core.service.oprecord.impl;

import com.didiglobal.logi.log.ILog;
import com.didiglobal.logi.log.LogFactory;
import com.didiglobal.logi.security.common.dto.oplog.OplogDTO;
import com.didiglobal.logi.security.service.OplogService;
import com.xiaojukeji.know.streaming.km.core.service.oprecord.OpLogWrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpLogWrapServiceImpl implements OpLogWrapService {
    private static final ILog log = LogFactory.getLog(OpLogWrapServiceImpl.class);

    @Autowired
    private OplogService oplogService;

    @Override
    public Integer saveOplogAndIgnoreException(OplogDTO oplogDTO) {
        try {
            return oplogService.saveOplog(oplogDTO);
        } catch (Exception e) {
            log.error("method=saveOplogAndIgnoreException||oplogDTO={}||errMsg=exception.", oplogDTO, e);
        }

        return 0;
    }
}
