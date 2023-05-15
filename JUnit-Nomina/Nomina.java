package nomina;

import java.util.InputMismatchException;
/**
 * Este clase calcula el Salario Neto de un empleado
 * @author mcfal
 * @version: 15/05/2023/v.1
 * @category: Proyecto Git
 */

public class Nomina {
	
	//Atributos de la clase Nomina
	private float bruto;
	private float irpf;
	
	/**
	 * Constructor para Nomina, al que se le pasan como 
	 * parametros el bruto nominal y el importe de irpf
	 */
	public Nomina(float bruto, float irpf) {
		super();
		this.bruto = bruto;
		this.irpf = irpf;
	}//Cierre del constructor	
	
	//Getters y Setters de la clase Nomina
	/**
	 * Get y Set de bruto
	 */
	public float getBruto() {
		return bruto;
	}

	public void setBruto(float bruto) {
		this.bruto = bruto;
	}
	/**
	 * Get y Set de irpf
	 */
	public float getIrpf() {
		return irpf;
	}

	public void setIrpf(float irpf) {
		this.irpf = irpf;
	}

	//Metodos de la clase
	/**
	 * El metodo calculaNeto indica que si el bruto es menor que 0
	 * o el irpf menor que 0, arrojará una excepcion.
	 * @return El importe bruto calculado de restar al bruto, el bruto 
	 * por el porcentaje de irpf
	 */
	public float calculaNeto() {
		if(bruto<0 || irpf<0) {
			throw new InputMismatchException();
		}
		return bruto - bruto * irpf /100;
	}
	
	/**
	 * El metodo datosCorrectos comprueba con un valor booleano si
	 * el bruto es mayor de 0 y el valor del irpf menor de 100 y mayor
	 * de 0, los datos serán correctos, en caso contrario @return un valor 
	 * falso
	 */
	public boolean datosCorrectos() {
		boolean correcto = false;
		if (bruto > 0 && (irpf < 100 && irpf > 0)) {
			correcto = true;
		}
		return correcto;
	}//Cierre del metodo
	
}	//Fin de la clase
	

