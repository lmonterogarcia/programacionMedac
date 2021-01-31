
public class Libreria {

	public static String deNumeroToLetrasHasta9999(short shNumero) {
		String sNumero = "";
		byte bUnidad, bDecena, bCentena, bMillar;

		if (shNumero < 1000) {
			sNumero = deNumeroToLetrasHasta999(shNumero);
		} else {
			bUnidad = (byte) (shNumero % 10);
			bDecena = (byte) (((short) (shNumero / 10)) % 10);
			bCentena = (byte) (((byte) (shNumero / 100)) % 10);
			bMillar = (byte) (shNumero / 1000);

			switch (bMillar) {
			case 1:
				sNumero = "mil";
				if (bUnidad != 0 || bDecena != 0 || bCentena != 0) {
					sNumero += " " + deNumeroToLetrasHasta999((short) ((bCentena * 100) + (bDecena * 10) + bUnidad));
				}
				break;
			default:
				sNumero = deNumeroToLetrasHasta15(bMillar) + "mil";
				if (bUnidad != 0 || bDecena != 0 || bCentena != 0) {
					sNumero += " " + deNumeroToLetrasHasta999((short) ((bCentena * 100) + (bDecena * 10) + bUnidad));
				}
			}
		}

		return sNumero;
	}

	private static String deNumeroToLetrasHasta999(short shNumero) {
		String sNumero = "";
		byte bUnidad, bDecena, bCentena;

		if (shNumero < 100) {
			sNumero = deNumeroToLetrasHasta99((byte) shNumero);
		} else {
			bUnidad = (byte) (shNumero % 10);
			bDecena = (byte) (((byte) (shNumero / 10)) % 10);
			bCentena = (byte) (shNumero / 100);

			switch (bCentena) {
			case 1:
				if (bUnidad != 0 && bDecena != 0) {
					sNumero = "cien";
				} else {
					sNumero = "ciento " + deNumeroToLetrasHasta99((byte) ((bDecena * 10) + bUnidad));
				}
				break;
			case 2:
				sNumero = "doscientos";
				if (bUnidad != 0 && bDecena != 0) {
					sNumero += " " + deNumeroToLetrasHasta99((byte) ((bDecena * 10) + bUnidad));
				}
				break;
			case 3:
				sNumero = "trescientos";
				if (bUnidad != 0 && bDecena != 0) {
					sNumero += " " + deNumeroToLetrasHasta99((byte) ((bDecena * 10) + bUnidad));
				}
				break;
			case 4:
				sNumero = "cuatrocientos";
				if (bUnidad != 0 && bDecena != 0) {
					sNumero += " " + deNumeroToLetrasHasta99((byte) ((bDecena * 10) + bUnidad));
				}
				break;
			case 5:
				sNumero = "quinientos";
				if (bUnidad != 0 && bDecena != 0) {
					sNumero += " " + deNumeroToLetrasHasta99((byte) ((bDecena * 10) + bUnidad));
				}
				break;
			case 6:
				sNumero = "seiscientos";
				if (bUnidad != 0 && bDecena != 0) {
					sNumero += " " + deNumeroToLetrasHasta99((byte) ((bDecena * 10) + bUnidad));
				}
				break;
			case 7:
				sNumero = "setecientos";
				if (bUnidad != 0 && bDecena != 0) {
					sNumero += " " + deNumeroToLetrasHasta99((byte) ((bDecena * 10) + bUnidad));
				}
				break;
			case 8:
				sNumero = "ochocientos";
				if (bUnidad != 0 && bDecena != 0) {
					sNumero += " " + deNumeroToLetrasHasta99((byte) ((bDecena * 10) + bUnidad));
				}
				break;
			default:
				sNumero = "novecientos";
				if (bUnidad != 0 && bDecena != 0) {
					sNumero += " " + deNumeroToLetrasHasta99((byte) ((bDecena * 10) + bUnidad));
				}
			}
		}

		return sNumero;
	}

	private static String deNumeroToLetrasHasta99(byte bNumero) {
		String sNumero = "";
		byte bUnidad, bDecena;

		if (bNumero < 16) {
			sNumero = deNumeroToLetrasHasta15(bNumero);
		} else {
			bUnidad = (byte) (bNumero % 10);
			bDecena = (byte) (bNumero / 10);

			switch (bDecena) {
			case 1:
				sNumero = "dieci" + deNumeroToLetrasHasta15(bUnidad);
				break;
			case 2:
				if (bUnidad != 0) {
					sNumero = "veinti" + deNumeroToLetrasHasta15(bUnidad);
				} else {
					sNumero = "veinte";
				}
				break;
			case 3:
				sNumero = "treinta";
				if (bUnidad != 0) {
					sNumero += " y " + deNumeroToLetrasHasta15(bUnidad);
				}
				break;
			case 4:
				sNumero = "cuarenta";
				if (bUnidad != 0) {
					sNumero += " y " + deNumeroToLetrasHasta15(bUnidad);
				}
				break;
			case 5:
				sNumero = "cincuenta";
				if (bUnidad != 0) {
					sNumero += " y " + deNumeroToLetrasHasta15(bUnidad);
				}
				break;
			case 6:
				sNumero = "sesenta";
				if (bUnidad != 0) {
					sNumero += " y " + deNumeroToLetrasHasta15(bUnidad);
				}
				break;
			case 7:
				sNumero = "setenta";
				if (bUnidad != 0) {
					sNumero += " y " + deNumeroToLetrasHasta15(bUnidad);
				}
				break;
			case 8:
				sNumero = "ochenta";
				if (bUnidad != 0) {
					sNumero += " y " + deNumeroToLetrasHasta15(bUnidad);
				}
				break;
			default:
				sNumero = "noventa";
				if (bUnidad != 0) {
					sNumero += " y " + deNumeroToLetrasHasta15(bUnidad);
				}
			}
		}

		return sNumero;
	}

	private static String deNumeroToLetrasHasta15(byte bNumero) {
		String sNumero;

		switch (bNumero) {
		case 0:
			sNumero = "cero";
			break;
		case 1:
			sNumero = "uno";
			break;
		case 2:
			sNumero = "dos";
			break;
		case 3:
			sNumero = "tres";
			break;
		case 4:
			sNumero = "cuatro";
			break;
		case 5:
			sNumero = "cinco";
			break;
		case 6:
			sNumero = "seis";
			break;
		case 7:
			sNumero = "siete";
			break;
		case 8:
			sNumero = "ocho";
			break;
		case 9:
			sNumero = "nueve";
			break;
		case 10:
			sNumero = "diez";
			break;
		case 11:
			sNumero = "once";
			break;
		case 12:
			sNumero = "doce";
			break;
		case 13:
			sNumero = "trece";
			break;
		case 14:
			sNumero = "catorce";
			break;
		default:
			sNumero = "quince";
		}

		return sNumero;
	}

	private static String primeraLetraMayus(String sCadena){
		String sMensaje, cLetra = Character.toString(sCadena.charAt(0));

		
		sMensaje = cLetra.toUpperCase()+sCadena.substring(1, sCadena.length());
		
		return sMensaje;
	}
}
