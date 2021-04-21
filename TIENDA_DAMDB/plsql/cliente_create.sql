DROP PROCEDURE IF EXISTS `cliente_create`;
DELIMITER $$
CREATE PROCEDURE `cliente_create` (
	IN oObject JSON
)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE sDniParam VARCHAR(9);
    DECLARE sNombreParam VARCHAR(250);
    DECLARE sApellidosParam VARCHAR(250);    
    DECLARE sDireccionParam VARCHAR(250);    
    DECLARE sTelefonoParam VARCHAR(9);    
    DECLARE sEmailParam VARCHAR(250);    
    DECLARE sNumeroDireccionParam VARCHAR(250);    
    DECLARE sPasswordParam VARCHAR(12); # Columna para anadir el usuario desde aqui
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO

                SET sDniParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sDni')));
                SET sNombreParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNombre')));
                SET sApellidosParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sApellidos')));
                SET sDireccionParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sDireccion')));
                SET sTelefonoParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sTelefono')));
                SET sEmailParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].oUsuario.sEmail')));
                SET sNumeroDireccionParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNumeroDireccion')));
                SET sPasswordParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].oUsuario.sPassword')));
                
                CALL usuario_create(JSON_ARRAY(JSON_OBJECT("sEmail", `sEmailParam`, "sPassword", `sPasswordParam`)));
                
                INSERT INTO Cliente VALUES (`sDniParam`, `sNombreParam`, `sApellidosParam`, `sDireccionParam`, `sTelefonoParam`, `sEmailParam`, `sNumeroDireccionParam`);
                  
                SET vIndex = vIndex + 1;
            END WHILE;
            
        END IF;	
    END IF;    
END $$
DELIMITER ;