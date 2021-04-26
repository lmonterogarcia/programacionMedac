DROP PROCEDURE IF EXISTS `cliente_search_all`;
DELIMITER $$
CREATE PROCEDURE `cliente_search_all` (
)
BEGIN
	SELECT * FROM Cliente;  
END $$
DELIMITER ;