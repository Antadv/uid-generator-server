package com.somelogs.uniqueid.config;

import com.baidu.fsg.uid.UidGenerator;
import com.baidu.fsg.uid.impl.CachedUidGenerator;
import com.baidu.fsg.uid.worker.DisposableWorkerIdAssigner;
import com.baidu.fsg.uid.worker.WorkerIdAssigner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述
 *
 * @author LBG - 2019/5/7
 */
@Configuration
public class UidGeneratorConfig {

    @Value("${timeBits}")
    private int timeBits;
    @Value("${workerBits}")
    private int workerBits;
    @Value("${seqBits}")
    private int seqBits;
    @Value("${epochDate}")
    private String epochDate;

    @Bean
    public WorkerIdAssigner workerIdAssigner() {
        return new DisposableWorkerIdAssigner();
    }

    @Bean
    public UidGenerator uidGenerator() {
        CachedUidGenerator uidGenerator = new CachedUidGenerator();
        uidGenerator.setWorkerIdAssigner(workerIdAssigner());
        uidGenerator.setTimeBits(timeBits);
        uidGenerator.setWorkerBits(workerBits);
        uidGenerator.setSeqBits(seqBits);
        uidGenerator.setEpochStr(epochDate);
        // 还有一些可选配置，此处使用默认值
        return uidGenerator;
    }
}
