package co.udea.dlloemp.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(value = XmlAccessType.PROPERTY)
@XmlRootElement
public class ConverterToRoman {
		String[][] bases = { { "I", "V", "X" }, { "X", "L", "C" },
				{ "C", "D", "M" }, { "M", "", "" } };

		public ConverterToRoman() {
			super();
		}

		public String toRoman(int value) {

			if (isInRange(value)) {
				String result = "";
				int exponent = valueSize(value);
				do {
					exponent--;
					// se descompone el número en la unidad mayor al dividirla por
					// 10 elevado a un exponente correspondiente
					// ejm 1324 / 1000 
					int alfa = (int) (value / Math.pow(10, exponent));
					// y el sobrante de la división se deja para el siguiente ciclo
					//ejem 1324 %1000 = 324
					value = (int) (value % Math.pow(10, exponent));
					result += convertModule(alfa, bases[exponent][0],
							bases[exponent][1], bases[exponent][2]);

					// el valor ha de llegar a 0, puesto q al final no sobrará nada
				} while (value != 0);

				return result;
			} else {
				return null;
			}
		}

		private String convertModule(int value, String baseMono, String basePenta,
				String baseDeca) {
			// Todos los números romanos se pueden escribir en funcion de base 1,5 y
			// 10
			switch (value) {
			case 1:
				return baseMono;
			case 2:
				return baseMono + baseMono;
			case 3:
				return baseMono + baseMono + baseMono;
			case 4:
				return baseMono + basePenta;
			case 5:
				return basePenta;
			case 6:
				return basePenta + baseMono;
			case 7:
				return basePenta + baseMono + baseMono;
			case 8:
				return basePenta + baseMono + baseMono + baseMono;
			case 9:
				return baseMono + baseDeca;
			default:
				return "";
			}

		}

		private int valueSize(int value) {
			//método para obtener el número de dígitos
			return String.valueOf(value).length();
		}

		public boolean isInRange(int value) {
			//método para verificar que este dentro de los números que se pueden representar
			if (0 < value && value < 4000) {
				return true;
			} else {
				return false;
			}
		}
	}
