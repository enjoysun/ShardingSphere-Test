package com.myou.shardingsphere.config;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:youming@cai-inc.com">斜照</a>
 * @datetime 2021-12-21 16:56:34
 */
public class BetweenTableShardingAlgorithm implements RangeShardingAlgorithm<String> {
    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<String> rangeShardingValue) {
        Set<String> tables = new HashSet<>();
        Range<String> valueRange = rangeShardingValue.getValueRange();
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("yyyy-M")
                .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                .toFormatter();
        LocalDate lowerEndpoint = LocalDate.parse(valueRange.lowerEndpoint(), formatter);
        LocalDate upperEndpoint = LocalDate.parse(valueRange.upperEndpoint(), formatter);
        for (String table:collection){
            String name = table.replaceAll("_", "-").substring(7);
            LocalDate date = LocalDate.parse(name, formatter);
            if (lowerEndpoint.isBefore(date)&&upperEndpoint.isAfter(date)){
                tables.add(table);
            }
        }
        return tables;
    }
}
