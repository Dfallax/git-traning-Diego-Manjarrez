public class Piloto extends Thread {
    
	private final int MAX_VUELTAS=10;//constante porque el valor no cambiará
	private Marcador marcador;
	private String nombre;
	private int vuelta;
	
	
	public Piloto(Marcador marcador) {
		
		this.marcador=marcador;
	}
	
	public Piloto() {
		
	}
	
	public Piloto(String nombre, int vuelta) {
		this.nombre = nombre;
		this.vuelta = vuelta;
	}
	
	public void run() {
		
		
			
			try {
				
				while(this.vuelta!=MAX_VUELTAS) {// los hilos que van llegando iran haciendo 10 vueltas 
				Thread.sleep(new Random().nextInt(300,3001)); // representa el tiempo en dar una vuelta
				this.vuelta++;
				marcador.actualizarMarcador(nombre,vuelta);//le enviamos el nombre y la vuelta del 
												//hilo que se encuentra en este momento
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		
						
	
	}
	
	
	public Marcador getMarcador() {
		return marcador;
	}
	public void setMarcador(Marcador marcador) {
		this.marcador = marcador;
	}
	public int getVuelta() {
		return vuelta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setVuelta(int vuelta) {
		this.vuelta = vuelta;
	}

	public int getMAX_VUELTAS() {
		return MAX_VUELTAS;
	}
	
	
	
}
