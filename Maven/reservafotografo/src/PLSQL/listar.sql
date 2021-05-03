CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`listar`(IN P_TablaName VARCHAR(255))
BEGIN
	SET @Sentencia = CONCAT('SELECT * FROM ',P_TablaName);
   	PREPARE stmt FROM @Sentencia;
   	EXECUTE stmt;
	DEALLOCATE PREPARE stmt;

END