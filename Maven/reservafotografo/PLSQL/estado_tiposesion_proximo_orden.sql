CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`estado_tiposesion_proximo_orden`(IN P_TablaName VARCHAR(255), IN P_NombreTipoSesion VARCHAR(255))
BEGIN
	SET @Sentencia = CONCAT('SELECT MAX(orden) FROM ',P_TablaName,' WHERE nombreTipoSesion = "',P_NombreTipoSesion ,'"');
	
   	PREPARE stmt FROM @Sentencia;
   	EXECUTE stmt;
	DEALLOCATE PREPARE stmt;
END