CREATE TABLE `users` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	`username` VARCHAR(254) NULL,
	`password` VARCHAR(64) NULL,
	`enabled` TINYINT(1) NULL DEFAULT '1',
	`created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `username_UNIQUE` (`username`)
)

ENGINE=InnoDB
ROW_FORMAT=DYNAMIC;
