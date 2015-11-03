-- Create 'address' table
CREATE TABLE IF NOT EXISTS `address` ( `id` bigint(20) NOT NULL AUTO_INCREMENT, `ocean` varchar(50) NOT NULL, `reef` varchar(50) NOT NULL, `dept` int(11) NOT NULL,  `is_home` bit(1) NOT NULL,  `poliseaholder_id` bigint(20) NOT NULL,  `idx` int(11) DEFAULT NULL,  PRIMARY KEY (`id`),  KEY `FK_POLISEAHOLDER_ADDRESS` (`poliseaholder_id`)) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

-- Create 'address' table
CREATE TABLE IF NOT EXISTS `person` (  `id` bigint(20) NOT NULL AUTO_INCREMENT,  `f_name` varchar(50) NOT NULL,  `m_name` varchar(50) NOT NULL,  `l_name` varchar(50) NOT NULL,  `sex` varchar(50) NOT NULL,  `date_of_birth` date NOT NULL,  PRIMARY KEY (`id`)) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

-- Populating 'person' table
INSERT INTO `person` (`id`, `f_name`, `m_name`, `l_name`, `sex`, `date_of_birth`) VALUES (1, 'First', 'Middle', 'Last', 'Salmon/Trout/Pike', '2015-10-26');

-- Populating 'address' table
INSERT INTO `address` (`id`, `ocean`, `reef`, `dept`, `is_home`, `poliseaholder_id`, `idx`) VALUES  (1, 'Pacific', 'Big reef', 13, b'1', 1, 0),  (2, 'Atlantic', 'Small', 11, b'0', 1, 1),  (3, 'Atlantic', 'MiddleReef', 5, b'0', 1, 2);

-- Configuring FK
ALTER TABLE `address` ADD CONSTRAINT `FK_POLISEAHOLDER_ADDRESS` FOREIGN KEY (`poliseaholder_id`) REFERENCES `person` (`id`);
