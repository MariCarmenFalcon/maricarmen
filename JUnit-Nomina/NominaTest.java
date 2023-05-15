package nomina;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.InputMismatchException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NominaTest {
	
	private Nomina n;
	
	@BeforeEach
	public void inicializa() {
		n = new Nomina(1500, 15);
	}

	@ParameterizedTest
	@CsvSource({"-1500, 10", "2000, -15"})
	void testCalculaNetoExcepcion(int bruto, int irpf) {
		n.setBruto(bruto);
		n.setIrpf(irpf);
		Assertions.assertThrows(InputMismatchException.class, () -> {
			n.calculaNeto();
		});
	}
	
	@ParameterizedTest
	@CsvSource({"1500, 10, 1350", "2000, 15, 1700"})
	void testCalculaNetoOk(float bruto, float irpf, float resEsperado) {
		n.setBruto(bruto);
		n.setIrpf(irpf);
		assertEquals(n.calculaNeto(), resEsperado);
	}
	
	@ParameterizedTest
	@CsvSource({"600, 2", "900, 5", "3200, 18"})
	void testDatosCorrectosOk(float bruto, float irpf) {
		n.setBruto(bruto);
		n.setIrpf(irpf);
		assertTrue(n.datosCorrectos());
	}
	
	@ParameterizedTest
	@CsvSource({"-600, 2", "900, -1", "3200, 101"})
	void testDatosCorrectosKo(float bruto, float irpf) {
		n.setBruto(bruto);
		n.setIrpf(irpf);
		assertFalse(n.datosCorrectos());
	
	}
}
