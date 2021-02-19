public class B11_EJ4 {
    public static void main(String[] args) {
        BonoTarifaPlanaUnDia oBono1Dia = new BonoTarifaPlanaUnDia(1234567);
        BonoTarifaPlanaTresDias oBono3Dia = new BonoTarifaPlanaTresDias(2235767);
        BonoTarifaPlanaUnMes oBono1mes = new BonoTarifaPlanaUnMes(1236567);
        BonoTarifaPlanaUnAnio oBono1anio = new BonoTarifaPlanaUnAnio(1234787);
        BonoDiezViajes oBono10 = new BonoDiezViajes(8475126);
        BonoDiezViajesConTrasbordo bono10Trasbordo = new BonoDiezViajesConTrasbordo(1539876);

        System.out.println(oBono1Dia.picarViaje((short) 14, (byte) 1, (byte) 1, (short) 2020, (byte) 8, (byte) 0)); //True
        System.out.println(oBono1Dia.picarViaje((short) 14, (byte) 2, (byte) 1, (short) 2020, (byte) 8, (byte) 0)); //False
        System.out.println(oBono1Dia);

        System.out.println(oBono3Dia.picarViaje((short) 14, (byte) 1, (byte) 1, (short) 2020, (byte) 8, (byte) 0)); //True
        System.out.println(oBono3Dia.picarViaje((short) 14, (byte) 2, (byte) 1, (short) 2020, (byte) 8, (byte) 0)); //True
        System.out.println(oBono3Dia);

        System.out.println(oBono1mes.picarViaje((short) 14, (byte) 1, (byte) 1, (short) 2020, (byte) 8, (byte) 0)); //True
        System.out.println(oBono1mes.picarViaje((short) 14, (byte) 1, (byte) 2, (short) 2020, (byte) 8, (byte) 0)); //False
        System.out.println(oBono1mes);

        System.out.println(oBono1anio.picarViaje((short) 14, (byte) 1, (byte) 1, (short) 2020, (byte) 8, (byte) 0)); //True
        System.out.println(oBono1anio.picarViaje((short) 14, (byte) 1, (byte) 1, (short) 2021, (byte) 8, (byte) 0)); //False
        System.out.println(oBono1anio);

        System.out.println(oBono10.picarViaje((short) 14, (byte) 1, (byte) 1, (short) 2020, (byte) 8, (byte) 0)); //True
        System.out.println(oBono10.picarViaje((short) 14, (byte) 1, (byte) 1, (short) 2020, (byte) 8, (byte) 1)); //True
        System.out.println(oBono10.picarViaje((short) 14, (byte) 1, (byte) 1, (short) 2020, (byte) 8, (byte) 2)); //True
        System.out.println(oBono10);

        System.out.println(bono10Trasbordo.picarViaje((short) 14, (byte) 1, (byte) 1, (short) 2020, (byte) 8, (byte) 0)); //True
        System.out.println(bono10Trasbordo.picarViaje((short) 15, (byte) 1, (byte) 1, (short) 2020, (byte) 8, (byte) 30)); //True
        System.out.println(bono10Trasbordo);


    }
}
