package modele;


public class Edge {

	private int index;
	private int indiceDebut;
	private int indiceFin;
	
	
	public Edge(){
		
	}
	public Edge(int index){
		this.setIndex(index);
	}
	
	public Edge(int index, int indiceDeb, int indiceFin){
		this.setIndiceDebut(indiceDeb);
		this.setIndiceFin(indiceFin);
	}
	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}
	/**
	 * @param indiceDebut the indiceDebut to set
	 */
	public void setIndiceDebut(int indiceDebut) {
		this.indiceDebut = indiceDebut;
	}
	/**
	 * @return the indiceDebut
	 */
	public int getIndiceDebut() {
		return indiceDebut;
	}
	/**
	 * @param indiceFin the indiceFin to set
	 */
	public void setIndiceFin(int indiceFin) {
		this.indiceFin = indiceFin;
	}
	/**
	 * @return the indiceFin
	 */
	public int getIndiceFin() {
		return indiceFin;
	}
	
	
	
	
}
