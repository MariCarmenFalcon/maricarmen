package nomina;

import java.util.InputMismatchException;

public class Nomina {
	private float bruto;
	private float irpf;
	
	public Nomina(float bruto, float irpf) {
		super();
		this.bruto = bruto;
		this.irpf = irpf;
	}	
	
	public float getBruto() {
		return bruto;
	}

	public void setBruto(float bruto) {
		this.bruto = bruto;
	}

	public float getIrpf() {
		return irpf;
	}

	public void setIrpf(float irpf) {
		this.irpf = irpf;
	}

	public float calculaNeto() {
		if(bruto<0 || irpf<0) {
			throw new InputMismatchException();
		}
		return bruto - bruto * irpf /100;
	}
	
	public boolean datosCorrectos() {
		boolean correcto = false;
		if (bruto > 0 && (irpf < 100 && irpf > 0)) {
			correcto = true;
		}
		return correcto;
	}
	
	
	
}
