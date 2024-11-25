package dio.springboot;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringPrimeirosPassosApplicationTests {
	@Autowired
	private Calculadora calculadora;

	@Test
	@DisplayName("01 Soma Somando")
	void contextLoads() {
		assertEquals(7,calculadora.somar(2,5),"Numeros iguais!!");
	}

	@Test
	@DisplayName("02 Soma de inteiros")
	public void testSoma() {
		assertEquals(5, calculadora.soma(3, 3), "A soma de 2 e 3 deveria ser 5"); //Deve falhar e apresentar a mensagem
	}

	@Test
	@DisplayName("03 Soma de Float")
	public void testSomaFloat() {
		assertEquals(6.0f, calculadora.somaFloat(2.5f, 3.5f), 0.001, "A soma de 2.5 e 3.5 deveria ser 6.0");
	}

	@Test
	@DisplayName("04 Soma Long")
	public void testSomaLong() {
		assertEquals(3000L, calculadora.somaLong(1000L, 2000L), "A soma de 1000 e 2000 deveria ser 3000");
	}
}
