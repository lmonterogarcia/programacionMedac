package controllers.configuracion.productos;

public class ProductoPackCtrl {
    
    private ProductoCtrl oProductoCtrl;
    private PackCtrl oPackCtrl;

    public ProductoPackCtrl(){

        oProductoCtrl = new ProductoCtrl();
        oPackCtrl = new PackCtrl();
    }

    public ProductoCtrl getoProductoCtrl() {
        return oProductoCtrl;
    }

    public PackCtrl getoPackCtrl() {
        return oPackCtrl;
    }
    
}
