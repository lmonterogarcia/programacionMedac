CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`pedido_create`(IN oObject JSON)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE EmpresacifNifParam VARCHAR(9);
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO

                SET EmpresacifNifParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].oEmpresa.sCifNif')));
               
                INSERT INTO Pedido VALUES (null, false,`EmpresacifNifParam`);
               	SELECT MAX(idPedido) FROM Pedido;
                
               SET vIndex = vIndex + 1;
            END WHILE;
            
        END IF;	
    END IF;
   	COMMIT;
END