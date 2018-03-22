package com.devloper.joker.redundant.test.rdt;

import com.devloper.joker.redundant.mongo.MongoRdtOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

@Service
public class RdtAsyncService {

    @Resource
    private MongoRdtOperation mongoRdtOperation;

    private final Logger log = LoggerFactory.getLogger(getClass());

    //@Async
    public void updateRelevant(Object... entitys) {
        try {
            if (entitys != null && entitys.length > 0) {
                for (Object entity : entitys) {
                    if (entity == null) continue;
                    if (entity instanceof Collection) {
                        for (Object current: (Collection) entity) {
                            if (current == null) continue;
                            mongoRdtOperation.updateMulti(current);
                        }
                    } else mongoRdtOperation.updateMulti(entity);
                }
            }
        } catch (Exception e) {
            log.warn("", e);
        }
    }

}
