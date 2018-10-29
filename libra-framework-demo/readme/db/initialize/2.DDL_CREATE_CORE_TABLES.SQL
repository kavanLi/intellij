

CREATE TABLE `t_identification_patient` (
  `oid` BIGINT NOT NULL AUTO_INCREMENT,
  
  `name` VARCHAR(256) DEFAULT NULL,
  `gender_code` VARCHAR(8) DEFAULT NULL,
  `ethnic_code` VARCHAR(8) DEFAULT NULL,
  `id_no` VARCHAR(64) DEFAULT NULL,
  
  `patient_id` VARCHAR(256) DEFAULT NULL,
  `inpatient_id` VARCHAR(256) DEFAULT NULL,
  `outpatient_id` VARCHAR(256) DEFAULT NULL,
  `security_id` VARCHAR(256) DEFAULT NULL,
  `other_id` VARCHAR(256) DEFAULT NULL,
  
  `create_timestamp` datetime DEFAULT NULL,
  `create_by` VARCHAR(128) DEFAULT NULL,
  `update_timestamp` datetime DEFAULT NULL,
  `update_by` VARCHAR(128) DEFAULT NULL,
  `version` INT NOT NULL DEFAULT '0',
  
  `active` TINYINT(1) NOT NULL DEFAULT 1,
  
  PRIMARY KEY (oid)
) 
