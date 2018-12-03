CREATE TABLE `tickets` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`participant_id` INT(11) NOT NULL,
	`state` ENUM('ACTIVE','DRAWN') NOT NULL DEFAULT 'ACTIVE',
	`drawn_date` DATETIME NULL DEFAULT NULL,
	`created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`),
	INDEX `fk_tickets_participants` (`participant_id`),
	CONSTRAINT `fk_tickets_participants` FOREIGN KEY (`participant_id`) REFERENCES `participants` (`id`)
)
ENGINE=InnoDB;
