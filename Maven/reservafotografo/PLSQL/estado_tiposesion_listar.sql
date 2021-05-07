CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`estado_tiposesion_listar`(IN P_TablaName VARCHAR(255), IN P_NombrePack VARCHAR(255))
BEGIN
	SET @Sentencia = CONCAT('SELECT * FROM ',P_TablaName,' WHERE nombrePack = "',P_NombrePack ,'"');
	
   	PREPARE stmt FROM @Sentencia;
   	EXECUTE stmt;
	DEALLOCATE PREPARE stmt;
END