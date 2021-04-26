DROP PROCEDURE IF EXISTS `usuario_search_all`;
DELIMITER $$
CREATE PROCEDURE `usuario_search_all` (
)
BEGIN
	SELECT * FROM Usuario;  
END $$
DELIMITER ;