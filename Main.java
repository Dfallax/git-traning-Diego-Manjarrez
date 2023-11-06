public class Main {
	static final int N = 10;//la variable N la volvemos una constante
	static ArrayList<Piloto> pilotos = new ArrayList<Piloto>(); //hilos Pilotos
	static Marcador marcador = new Marcador();// El cual se utilizará para mostrar la carrera 

	public static void main(String[] args) {

		for (int i = 0; i < N; i++) {

			Piloto p = new Piloto(marcador);
			p.setNombre("C" + (i + 1));
			marcador.setPilotos(p.getNombre());//al mismo tiempo que vamos llenando el arraylist del main, también 
			marcador.setVueltas(p.getVuelta());//llenamos el arrayList de la clase MArcador, para tener la "Lista" llena
			pilotos.add(p);
			p.start();

		}

		do {
			System.out.println("Coche  Vuelta Posicion");
			System.out.println("-----------------------");

			try {
				Thread.sleep(1000);// Acá usamos el sleep para esperar un segundo y mostrar 
									//la carrera actualizada despues del segundo

				for (int i = 0; i < marcador.getPilotos().size(); i++) {//mostramos el marcador. 

					System.out.printf("%-8s %-5s %-5s%n", marcador.getPilotos().get(i)
					, marcador.getVueltas().get(i),"("+ (i + 1) + ")");			
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("------------------------\n\n");
										//Detenemos el bucle cuando el ultimo piloto haya realizado su decima vuelta
		} while (marcador.getVueltas().get(N-1)!=pilotos.get(0).getMAX_VUELTAS());//usamos el valor de MAX_vuelta 
																			//para indicar el numero de la ultima vuelta
												

	}

}
