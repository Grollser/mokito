package mokito;

public class FakeHinnoittelija implements IHinnoittelija {

	private float alennus;
	public FakeHinnoittelija(float alennus) {
	this.alennus = alennus;
	}
	public float getAlennusProsentti(Asiakas asiakas, Tuote tuote) {
	return alennus;
	}
	public void aloita(){
		//Feikki lopetus
	}
	public void setAlennusProsentti(Asiakas asiakas, Float prosentti){
		this.alennus = prosentti;
		
	}
	public void lopeta(){
		//Feikki lopetus
	}

}
