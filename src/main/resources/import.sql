-- Create 'address' table
CREATE TABLE IF NOT EXISTS `address` ( `id` bigint(20) NOT NULL AUTO_INCREMENT, `city` varchar(50) NOT NULL, `street` varchar(50) NOT NULL, `house` int(11) NOT NULL,  `apartment` int(11) NOT NULL,  `is_home` bit(1) NOT NULL,  `addressbook_id` bigint(20) NOT NULL,  `idx` int(11) DEFAULT NULL,  PRIMARY KEY (`id`),  KEY `FK_ADDRESSBOOK_ADDRESS` (`addressbook_id`)) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

-- Create 'address' table
CREATE TABLE IF NOT EXISTS `person` (  `id` bigint(20) NOT NULL AUTO_INCREMENT,  `f_name` varchar(50) NOT NULL,  `m_name` varchar(50) NOT NULL,  `l_name` varchar(50) NOT NULL,  `sex` varchar(50) NOT NULL,  `date_of_birth` date NOT NULL,  PRIMARY KEY (`id`)) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

-- Configuring FK
ALTER TABLE `address` ADD CONSTRAINT `FK_ADDRESSBOOK_ADDRESS` FOREIGN KEY (`addressbook_id`) REFERENCES `person` (`id`);
