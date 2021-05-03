CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`producto_create`(IN oObject JSON)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE nombreProductoParam VARCHAR(50);
    DECLARE precioProductoParam DECIMAL(7,2);
   	DECLARE costeProductoParam DECIMAL(7,2);
   	DECLARE ProveedorProductoParam VARCHAR(50);
    DECLARE descripcionProductoParam VARCHAR(255);
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO

                SET nombreProductoParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNombreProducto')));
                SET precioProductoParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].fPrecioProducto')));
               	SET costeProductoParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].fCosteProducto')));
              	SET ProveedorProductoParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sProveedorProducto')));
                SET descripcionProductoParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sDescripcionProducto')));
               
                -- AQUI TENDRA QUE IR LA LLAMADA AL PROCEDIMEITNO PARA CREAR EL LUGAR CUANDO SE IMPLEMENTE
                
                INSERT INTO Producto VALUES (`nombreProductoParam`, `precioProductoParam`, `costeProductoParam`, `ProveedorProductoParam`, `descripcionProductoParam`);
                  
                SET vIndex = vIndex + 1;
            END WHILE;
            
        END IF;	
    END IF;
END