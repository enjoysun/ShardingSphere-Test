CREATE TABLE `pay_notify` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `order_number` varchar(64) DEFAULT NULL COMMENT '订单编号',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    PRIMARY KEY (`id`),
    index (`order_number`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='订单';

CREATE TABLE `pay_notify_record` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `order_number` varchar(64) DEFAULT NULL COMMENT '订单编号',
    `notify_url` varchar(128) DEFAULT NULL COMMENT '回调地址',
    `notify_code` varchar(16) DEFAULT NULL COMMENT '回调状态',
    `notify_result` text DEFAULT NULL COMMENT '回调结果',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    PRIMARY KEY (`id`),
    index (`order_number`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='订单详情';

CREATE TABLE `global_dictionary` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `dic_type` varchar(64) DEFAULT NULL COMMENT '字典类型',
  `dic_code` varchar(64) DEFAULT NULL COMMENT '字典编码',
  `dic_name` varchar(64) DEFAULT NULL COMMENT '字典名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '解释说明',
  `sort` int(3) DEFAULT NULL COMMENT '排序',
  `status` int(12) DEFAULT NULL COMMENT '是否有效 1有效，0无效',
  `ctime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `utime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  index (`dic_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COMMENT='字典表';