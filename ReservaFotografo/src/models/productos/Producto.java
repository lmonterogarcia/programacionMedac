package models.productos;

import java.math.BigDecimal;
import java.math.RoundingMode;

import models.IPlantilla;



public class Producto implements IProducto, IPlantilla {
    
    //PK
    private String sNombreProducto;
    //NN
    private float fPrecioProducto;
    //N
    private float fCosteProducto;
    private String sProveedroProducto, sDescripcionProducto;

    // ###Contructores###

    public Producto(String sNombreProducto) {
        setsNombreProducto(sNombreProducto);
    }

    public Producto(String sNombreProducto, float fPrecioProducto) {
        setsNombreProducto(sNombreProducto);
        setfPrecioProducto(fPrecioProducto);
    }

    public Producto(String sNombreProducto, float fPrecioProducto, float fCosteProducto, String sProveedroProducto, String sDescripcionProducto) {
        setsNombreProducto(sNombreProducto);
        setfPrecioProducto(fPrecioProducto);
        setfCosteProducto(fCosteProducto);
        setsProveedroProducto(sProveedroProducto);
        setsDescripcionProducto(sDescripcionProducto);
    }

    // ###GET and SET###

    public String getsNombreProducto() {
        return sNombreProducto;
    }

    public void setsNombreProducto(String sNombreProducto) {
        if (sNombreProducto != null && !sNombreProducto.isEmpty() && sNombreProducto.length() < BMAXNOMBRELARGO){
            this.sNombreProducto = sNombreProducto;
        }
    }

    public float getfPrecioProducto() {
        return fPrecioProducto;
    }

    public void setfPrecioProducto(float fPrecioProducto) {
        if (fPrecioProducto < IMAXPRECIO && fPrecioProducto >= 0) {
            BigDecimal bigVariable = new BigDecimal(fPrecioProducto).setScale(BMAXPRECIODECIMAL, RoundingMode.UP);
        this.fPrecioProducto = bigVariable.floatValue();
        }
    }

    public float getfCosteProducto() {
        return fCosteProducto;
    }

    public void setfCosteProducto(float fCosteProducto) {
        if (fCosteProducto < IMAXPRECIO && fCosteProducto >= 0) {
            BigDecimal bigVariable = new BigDecimal(fCosteProducto).setScale(BMAXPRECIODECIMAL, RoundingMode.UP);
        this.fCosteProducto = bigVariable.floatValue();
        }
    }

    public String getsProveedroProducto() {
        return sProveedroProducto;
    }

    public void setsProveedroProducto(String sProveedroProducto) {
        if (sProveedroProducto != null && !sProveedroProducto.isEmpty() && sProveedroProducto.length() < BMAXNOMBRELARGO){
            this.sProveedroProducto = sProveedroProducto;
        }
    }

    public String getsDescripcionProducto() {
        return sDescripcionProducto;
    }

    public void setsDescripcionProducto(String sDescripcionProducto) {
        if (sDescripcionProducto != null && !sDescripcionProducto.isEmpty() && sDescripcionProducto.length() < BMAX255){
            this.sDescripcionProducto = sDescripcionProducto;
        }
    }

    // ###Metodos de esta clase###

    public boolean checkProducto() {
        boolean booExito = false;
        if (this.getsNombreProducto() != null && fPrecioProducto < IMAXPRECIO && fPrecioProducto >= 0) {
            booExito = true;
        }
        return booExito;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(fPrecioProducto);
        return result;
    }

    public boolean equals(Object obj) {
        boolean booExito = false;
        Producto oProducto = (Producto) obj;
        if (oProducto.checkProducto() && this.checkProducto() && oProducto.getsNombreProducto().equals(this.getsNombreProducto())) {
            booExito = true;
        }
        return booExito;
    }

    public String toString() {
        String sMensaje = "";
        if (checkProducto()) {
            sMensaje += "\n## Producto ##";
            sMensaje += "\n Nombre: " + this.getsNombreProducto();
            sMensaje += "\n Precio: " + this.getfPrecioProducto() + "€";
            if (fCosteProducto < IMAXPRECIO && fCosteProducto > 0) {
                sMensaje += "\n Coste: " + this.getfCosteProducto() + "€";
            }
            if (this.getsProveedroProducto() != null && this.getsProveedroProducto().isEmpty()) {
                sMensaje += "\n Proveedor: " + this.getsProveedroProducto();
            }
            if (this.getsDescripcionProducto() != null && !this.getsDescripcionProducto().isEmpty()) {
                sMensaje += "\n Descripcion: " + this.getsDescripcionProducto();
            }
        }
        return sMensaje;
    }
    
}
