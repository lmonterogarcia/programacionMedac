CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`sesion_search_by_cliente`(IN P_TablaName VARCHAR(255), IN P_iIdCliente MEDIUMINT)
BEGIN
	SET @Sentencia = CONCAT('SELECT * FROM ',P_TablaName,' WHERE idCliente = ',P_iIdCliente);
	
   	PREPARE stmt FROM @Sentencia;
   	EXECUTE stmt;
	DEALLOCATE PREPARE stmt;
END