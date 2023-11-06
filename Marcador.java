public class Marcador {

	private ArrayList<String> pilotos = new ArrayList<String>();//guardar los nombres
    private ArrayList<Integer> vueltas = new ArrayList<Integer>();//guardar sus vueltas
	
    
    public Marcador() {
		
	}
    

	public  synchronized void actualizarMarcador(String nombre, int vuelta) {
		
		//en este for lo que hace es indicar qué piloto llego al metodo, 
		//en donde posNmb vendria siendo "los nombres del arraylist de pilotos" 
		for(int posNmb = 0; posNmb < pilotos.size();posNmb++ ) {
			
		if(pilotos.get(posNmb).equals(nombre)) { //acá se encuentra el piloto que llegó (hilo)
			
			//en este for se compara el numero de vuelta del piloto que llegó  con el resto de pilotos
			//comparando siempre desde el primer puesto hasta el último 
			for(int posVuelta = 0; posVuelta < vueltas.size();posVuelta++) {
				
				if(vuelta>vueltas.get(posVuelta)) {//cuando la vuelta del piloto que llegó es mayor a otro piloto de la lista
					vueltas.set(posNmb,vuelta); //le actualizamos el numero de vueltas del piloto que llegó en la lista
					Collections.swap(pilotos, posNmb, posVuelta);//acá actualizamos el marcador cambiando sus posiciones
					Collections.swap(vueltas, posNmb, posVuelta);//acá hacemos lo mismo para  la sincronizacion de nombre y vuelta
					
					posNmb=pilotos.size();//acá cerramos el bucle posNmb para que deje de dar vueltas
					break;	//cerramos el bucle de posVuelta
			   }
				
			}
		}
	
	}
						
	}
	
	public void listaPilotos(ArrayList<String> pilotos) {
		this.pilotos=pilotos;
	}
	
	public ArrayList<String> getPilotos() {
		return pilotos;
	}
	public void setPilotos(String pilotos) {
		this.pilotos.add(pilotos);
	}
	public ArrayList<Integer> getVueltas() {
		return vueltas;
	}
	public void setVueltas(int vueltas) {
		this.vueltas.add(vueltas);
	}
	
	
	
}
