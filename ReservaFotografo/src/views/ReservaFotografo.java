package views;

import java.time.LocalDate;
import java.time.LocalTime;

import models.lugar.*;
import models.sesion.*;
import models.productos.*;
import models.personas.*;

public class ReservaFotografo {
    public static void main(String[] args) {
        Provincia oProvincia = new Provincia("Sevilla");
        Pais oPais = new Pais("Espania", (short) 123, "ES");
        PaisProvincia oPaisProvincia = new PaisProvincia(oProvincia, oPais);
        Localidad oLocalidad = new Localidad("Sevilla");
        CodigoPostal oCodigoPostal = new CodigoPostal("41007");
        CodigoPostalLocalidadPaisProvincia oCodigoPostalLocalidadPaisProvincia = new CodigoPostalLocalidadPaisProvincia(
                oLocalidad, oCodigoPostal, oPaisProvincia);
        Lugar oLugar = new Lugar("Prueba",
                "https://www.google.es/maps/place/MEDAC+Sevilla+Este+-+Formación+Profesional/@37.4122534,-5.9596897,15z/data=!4m8!1m2!2m1!1smedac+sevilla!3m4!1s0x0:0xe78091d604579c0c!8m2!3d37.4064864!4d-5.9330383",
                "Calle Falsa", "12B", 37.406630f, -5.932992f, oCodigoPostalLocalidadPaisProvincia);
        Usuario oUsuario = new Usuario("elmio@gmail.com", "qweqwe");
        Cliente oCliente = new Cliente("28818261C", "luis", "Montero", "Garcia-Manjaron", "625478547",
                LocalDate.of(1984, 04, 24), oUsuario, oLugar);
        Participante oParticipante = new Participante("24578746R", "Miguel", "Alacid", "Mierder", "654785142", LocalDate.of(1990,05,12), "juarjuar@gmail.com");
        Fotografo oFotografo = new Fotografo("25486514T", "IreneFoto");
        Empresa oEmpresa = new Empresa("41574865E", "Empresa Falsa", "empresa@gmail.com", "954875447", oLugar);
        TipoSesion oTipoSesion = new TipoSesion("Comunion", (short)240);
        Estado oEstado = new Estado("Presesion");
        EstadoTipoSesion oEstadoTipoSesion = new EstadoTipoSesion(oEstado, oTipoSesion, (byte) 1);
        Producto oProducto = new Producto("Copias 10x15", 25f, "Mate y con borde");
        Pack oPack = new Pack("Sesion Comunion", 250f, "2 horas de sesion mas iglesia");
        PackProducto oPackProducto = new PackProducto(oPack, oProducto);
        Pedido oPedido = new Pedido(false, oEmpresa);
        Sesion oSesion = new Sesion(874, oCliente, oPedido, LocalDate.of(2021, 4, 12), LocalTime.of(18, 00), oLugar, oEstadoTipoSesion);
        PackSesion oPackSesion = new PackSesion(oPack, oSesion);
        ProductoSesion oProductoSesion = new ProductoSesion(oSesion, oProducto);
        FotografoSesion oFotografoSesion = new FotografoSesion(oFotografo, oSesion);
        ParticipanteSesion oParticipanteSesion = new ParticipanteSesion(oParticipante, oSesion);

        System.out.println(oProvincia);
        System.out.println("\n#######################################################");
        System.out.println(oPais);
        System.out.println("\n#######################################################");
        System.out.println(oPaisProvincia);
        System.out.println("\n#######################################################");
        System.out.println(oLocalidad);
        System.out.println("\n#######################################################");
        System.out.println(oCodigoPostal);
        System.out.println("\n#######################################################");
        System.out.println(oCodigoPostalLocalidadPaisProvincia);
        System.out.println("\n#######################################################");
        System.out.println(oLugar);
        System.out.println("\n#######################################################");
        System.out.println(oUsuario);
        System.out.println("\n#######################################################");
        System.out.println(oCliente);
        System.out.println("\n#######################################################");
        System.out.println(oParticipante);
        System.out.println("\n#######################################################");
        System.out.println(oFotografo);
        System.out.println("\n#######################################################");
        System.out.println(oEmpresa);
        System.out.println("\n#######################################################");
        System.out.println(oTipoSesion);
        System.out.println("\n#######################################################");
        System.out.println(oEstado);
        System.out.println("\n#######################################################");
        System.out.println(oEstadoTipoSesion);
        System.out.println("\n#######################################################");
        System.out.println(oProducto);
        System.out.println("\n#######################################################");
        System.out.println(oPack);
        System.out.println("\n#######################################################");
        System.out.println(oPackProducto);
        System.out.println("\n#######################################################");
        System.out.println(oPedido);
        System.out.println("\n#######################################################");
        System.out.println(oSesion);
        System.out.println("\n#######################################################");
        
        // Estos objeton no tienen toString!!!!!!!!!
        System.out.println(oPackSesion);
        System.out.println("\n#######################################################");
        System.out.println(oProductoSesion);
        System.out.println("\n#######################################################");
        System.out.println(oFotografoSesion);
        System.out.println("\n#######################################################");
        System.out.println(oParticipanteSesion);
        


    }
}
