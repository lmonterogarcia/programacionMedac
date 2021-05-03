CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`empresa_create`(IN oObject JSON)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE cifNifParam VARCHAR(9);
    DECLARE nombreEmpresaParam VARCHAR(50);
    DECLARE emailEmpresaParam VARCHAR(100);    
    DECLARE telefonoEmpresaParam VARCHAR(250);    
    DECLARE idLugarParam MEDIUMINT;
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO

                SET cifNifParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sCifNif')));
                SET nombreEmpresaParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNombreEmpresa')));
                SET emailEmpresaParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sEmailEmpresa')));
                SET telefonoEmpresaParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sTelefonoEmrpesa')));
                SET idLugarParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].oLugar.iIdLugar')));
               
                -- AQUI TENDRA QUE IR LA LLAMADA AL PROCEDIMEITNO PARA CREAR EL LUGAR CUANDO SE IMPLEMENTE
                
                INSERT INTO Empresa VALUES (`cifNifParam`, `nombreEmpresaParam`, `emailEmpresaParam`, `telefonoEmpresaParam`, idLugarParam);
                  
                SET vIndex = vIndex + 1;
            END WHILE;
            
        END IF;	
    END IF;    
END