package com.lqb.ss.MyShardingSphere.common;

//import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;

/**
 * 雪花算法封装成工具类
 * date:2021-04-15
 * @author lvqibin
 *
 */
public class SnowFlakeUtils {
//    public static Comparable<?>  getId(Long workerId) {
//        if (!(workerId >= 0 && workerId < 1024L)) {
//            throw new RuntimeException(String.format("workerId is not support range must be [0,1024)"));
//        }
//        SnowflakeShardingKeyGenerator snowflakeShardingKeyGenerator = new SnowflakeShardingKeyGenerator();
//        snowflakeShardingKeyGenerator.getProperties().put("worker.id", String.valueOf(workerId));
//        Comparable<?> generateKey = snowflakeShardingKeyGenerator.generateKey();
//        return generateKey;
//    }
}