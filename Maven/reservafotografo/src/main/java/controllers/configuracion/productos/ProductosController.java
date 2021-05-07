package controllers.configuracion.productos;

public class ProductosController {
    
    private ProductoController oProductoCtrl;
    private PackController oPackCtrl;
    private PackProductoController oPackProductoCtrl;

    public ProductosController(){

        oProductoCtrl = new ProductoController();
        oPackCtrl = new PackController();
        oPackProductoCtrl = new PackProductoController();
    }

    public ProductoController getoProductoCtrl() {
        return oProductoCtrl;
    }

    public PackController getoPackCtrl() {
        return oPackCtrl;
    }

    public PackProductoController getoPackProductoCtrl() {
        return oPackProductoCtrl;
    }
    
}
