create database `upgradeAssessment`;

use `upgradeAssessment`;

CREATE TABLE `upgradeassessment`.`tbl_profiles` (
  `IdProfile` INT NOT NULL AUTO_INCREMENT,
  `Profile` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`IdProfile`));
                            
CREATE TABLE `upgradeassessment`.`tbl_users` (
  `IdUser` INT NOT NULL AUTO_INCREMENT,
  `UserName` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `IdProfile` INT NOT NULL,
  `IdEmployee` INT NOT NULL,
  `Status` VARCHAR(45) NOT NULL,
  `CreatedDate` DATE NOT NULL,
  `UpdateDate` DATE NOT NULL,
  `Login` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`IdUser`),
  INDEX `IdProfile_idx` (`IdProfile` ASC) VISIBLE,
  CONSTRAINT `IdProfile`
    FOREIGN KEY (`IdProfile`)
    REFERENCES `upgradeassessment`.`tbl_profiles` (`IdProfile`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
INSERT INTO `upgradeassessment`.`tbl_profiles` (`Profile`) VALUES ('Profile 1');
INSERT INTO `upgradeassessment`.`tbl_users` (`UserName`, `Password`, `IdProfile`, `IdEmployee`, `Status`, `CreatedDate`, `UpdateDate`, `Login`) VALUES ('User 1', 'password1', '1', '1', 'Status 1', '2022/02/08', '2022/02/08', 'Login 1');
