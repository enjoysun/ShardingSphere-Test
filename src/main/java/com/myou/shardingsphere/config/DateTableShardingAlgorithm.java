package com.myou.shardingsphere.config;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

/**
 * @author <a href="mailto:youming@cai-inc.com">斜照</a>
 * @datetime 2021-12-20 20:36:55
 */
public class DateTableShardingAlgorithm implements PreciseShardingAlgorithm<String> {
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {
//        String value = preciseShardingValue.getValue();
//        LocalDate parse = LocalDate.parse(value);
//        String tableName = String.format("t_user_%s_%s", parse.getYear(), parse.getMonthValue());
//        Optional<String> first = collection.stream().filter(item -> item.equals(tableName)).findFirst();
//        return first.orElse("");
        String shardingValue = preciseShardingValue.getValue();
        int i = Integer.parseInt(shardingValue) % 16;
        String tableName = String.format("t_user_%s", i);
        Optional<String> first = collection.stream().filter(item -> item.equals(tableName)).findFirst();
        return first.orElse("");
    }
}
