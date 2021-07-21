-- ds0
-- 绑定表 t_order0 t_order1 t_order_item0 t_order_item1
-- 广播表 global_dictionary
-- 单表 t_address

CREATE TABLE `t_user` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_name` varchar(64) DEFAULT NULL COMMENT '用户名',
    `pwd` varchar(64)  DEFAULT NULL COMMENT '用户密码',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='用户';

CREATE TABLE `t_order` (
    `id` bigint NOT NULL COMMENT '主键',
    `user_id` bigint DEFAULT NULL COMMENT '用户ID',
    `address_id` bigint DEFAULT NULL COMMENT '地址ID',
    `status` int DEFAULT NULL COMMENT '订单状态',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='订单';

CREATE TABLE `t_order_item` (
    `id` bigint NOT NULL COMMENT '主键',
    `user_id` bigint DEFAULT NULL COMMENT '用户ID',
    `order_id` bigint DEFAULT NULL COMMENT '订单ID',
    `status` int DEFAULT NULL COMMENT '状态',
    `item_name` varchar(64) DEFAULT NULL COMMENT '商品名称',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='订单详情';

CREATE TABLE `t_address` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `address_name` varchar(64) DEFAULT NULL COMMENT '地址',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='收货地址';

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