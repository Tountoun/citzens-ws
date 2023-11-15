USE citz;

DROP TABLE IF EXISTS `citz`;
DROP TABLE IF EXISTS `job`;

CREATE TABLE `job` (
        `id` bigint NOT NULL AUTO_INCREMENT,
        `domain` varchar(255) NOT NULL,
        `name` varchar(255) NOT NULL,
        PRIMARY KEY (`id`),
        UNIQUE KEY (`name`,`domain`)
);

CREATE TABLE `citz` (
        `id` bigint NOT NULL AUTO_INCREMENT,
        `birth` date DEFAULT NULL,
        `cin` varchar(255) NOT NULL UNIQUE ,
        `first_name` varchar(255) DEFAULT NULL,
        `blood` enum('ABRN','ABRP','ARN','ARP','BRN','BRP','ORN','ORP') DEFAULT NULL,
        `height` double DEFAULT NULL,
        `last_name` varchar(255) DEFAULT NULL,
        `father_id` bigint DEFAULT NULL,
        `mother_id` bigint DEFAULT NULL,
        `job_id` bigint DEFAULT NULL,
        PRIMARY KEY (`id`),
        FOREIGN KEY (`mother_id`) REFERENCES `citz` (`id`),
        FOREIGN KEY (`father_id`) REFERENCES `citz` (`id`),
        FOREIGN KEY (`job_id`) REFERENCES `job` (`id`)
);