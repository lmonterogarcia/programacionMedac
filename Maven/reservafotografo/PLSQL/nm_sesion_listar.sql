CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`nm_sesion_listar`(IN P_TablaName VARCHAR(255), IN P_idSesion MEDIUMINT)
BEGIN
	SET @Sentencia = CONCAT('SELECT * FROM ',P_TablaName,' WHERE idSesion = ',P_idSesion);
	
   	PREPARE stmt FROM @Sentencia;
   	EXECUTE stmt;
	DEALLOCATE PREPARE stmt;
END