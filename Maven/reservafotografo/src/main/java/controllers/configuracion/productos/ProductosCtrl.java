package controllers.configuracion.productos;

public class ProductosCtrl {
    
    private ProductoCtrl oProductoCtrl;
    private PackCtrl oPackCtrl;
    private PackProductoCtrl oPackProductoCtrl;

    public ProductosCtrl(){

        oProductoCtrl = new ProductoCtrl();
        oPackCtrl = new PackCtrl();
        oPackProductoCtrl = new PackProductoCtrl();
    }

    public ProductoCtrl getoProductoCtrl() {
        return oProductoCtrl;
    }

    public PackCtrl getoPackCtrl() {
        return oPackCtrl;
    }

    public PackProductoCtrl getoPackProductoCtrl() {
        return oPackProductoCtrl;
    }
    
}
