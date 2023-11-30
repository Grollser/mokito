package mokito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class TilaustenKäsittelyMockitoTest {

	@Mock
	IHinnoittelija hinnoittelijaMock;
	@BeforeEach
	public void setup() {
	MockitoAnnotations.openMocks(this);
	}
	@Test
	public void testaaKäsittelijäMockitoHinnoittelijalla() {
	// Arrange
	float alkuSaldo = 80.0f;
	float listaHinta = 30.0f;
	float alennus = 20.0f;
	float loppuSaldo = alkuSaldo - (listaHinta * (1 - alennus / 100));
	Asiakas asiakas = new Asiakas(alkuSaldo);
	Tuote tuote = new Tuote("TDD in Action", listaHinta);
	// Record
	when(hinnoittelijaMock.getAlennusProsentti(asiakas, tuote))
	.thenReturn(alennus);
	// Act
	TilaustenKäsittely käsittelijä = new TilaustenKäsittely();
	käsittelijä.setHinnoittelija(hinnoittelijaMock);
	käsittelijä.käsittele(new Tilaus(asiakas, tuote));
	// Assert
	assertEquals(loppuSaldo, asiakas.getSaldo(), 0.001);
	verify(hinnoittelijaMock).getAlennusProsentti(asiakas, tuote);
	}
	@Test
	public void testaaKäsittelijäMockitoHinnoittelijallaIsompiKunSata() {
		float alkuSaldo = 100.0f;
		float listaHinta = 101.0f;
		float alennus = 20.0f;
		float loppuSaldo = alkuSaldo - (listaHinta * (1 - (alennus) / 100));
		Asiakas asiakas = new Asiakas(alkuSaldo);
		Tuote tuote = new Tuote("TDD in Action", listaHinta);
		// Record
		when(hinnoittelijaMock.getAlennusProsentti(asiakas, tuote))
		.thenReturn(alennus);
		// Act
		TilaustenKäsittely käsittelijä = new TilaustenKäsittely();
		käsittelijä.setHinnoittelija(hinnoittelijaMock);
		käsittelijä.käsittele(new Tilaus(asiakas, tuote));
		// Assert
		assertEquals(loppuSaldo, asiakas.getSaldo(), 0.001);
		verify(hinnoittelijaMock).getAlennusProsentti(asiakas, tuote);
	}
	@Test
	public void testaaKäsittelijäMockitoHinnoittelijallaYhtäsuuriKunSata() {
		float alkuSaldo = 100.0f;
		float listaHinta = 100.0f;
		float alennus = 20.0f;
		float loppuSaldo = alkuSaldo - (listaHinta * (1 - alennus / 100));
		Asiakas asiakas = new Asiakas(alkuSaldo);
		Tuote tuote = new Tuote("TDD in Action", listaHinta);
		// Record
		when(hinnoittelijaMock.getAlennusProsentti(asiakas, tuote))
		.thenReturn(alennus);
		// Act
		TilaustenKäsittely käsittelijä = new TilaustenKäsittely();
		käsittelijä.setHinnoittelija(hinnoittelijaMock);
		käsittelijä.käsittele(new Tilaus(asiakas, tuote));
		// Assert
		assertEquals(loppuSaldo, asiakas.getSaldo(), 0.001);
		verify(hinnoittelijaMock).getAlennusProsentti(asiakas, tuote);
	}

}
