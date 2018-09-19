CREATE TABLE IF NOT EXISTS `filtered_telemetry` (
	`rule_id` int,
	`device_id` varchar(36),
	`key` varchar(255),
	`ts` bigint,
	`bool_v` boolean,
	`str_v` varchar(255),
	`long_v` bigint,
	`dbl_v` double,
	PRIMARY KEY(`rule_id`,`device_id`,`key`,`ts`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;