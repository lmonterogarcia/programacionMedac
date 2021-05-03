package models.productos;

public class PackProducto implements IPackProducto {

    // PK
    private Pack oPack;
    private Producto oProducto;

    // ###Contructores###
    public PackProducto(Pack oPack, Producto oProducto) {
        this.setoPack(oPack);
        this.setoProducto(oProducto);
    }
    // ###GET and SET###

    public Pack getoPack() {
        return oPack;
    }

    public void setoPack(Pack oPack) {
        if (oPack != null) {
            this.oPack = oPack;
        }
    }

    public Producto getoProducto() {
        return oProducto;
    }

    public void setoProducto(Producto oProducto) {
        if (oProducto != null) {
            this.oProducto = oProducto;
        }
    }

    // ###Metodos de esta clase###

    public boolean checkPackProducto() {
        boolean booExito = false;
        if (this.getoPack().checkPack() && this.getoProducto().checkProducto()) {
            booExito = true;
        }
        return booExito;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((oProducto == null) ? 0 : oProducto.hashCode());
        result = prime * result + ((oPack == null) ? 0 : oPack.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        boolean booExito = false;
        PackProducto oPackProducto = (PackProducto) obj;
        if (oPackProducto.getoPack() != null && oPackProducto.getoProducto() != null && this.getoPack() != null
                && this.getoProducto() != null && oPackProducto.getoProducto().equals(this.getoProducto())
                && oPackProducto.getoPack().equals(this.getoPack())) {
            booExito = true;
        }
        return booExito;
    }

}
