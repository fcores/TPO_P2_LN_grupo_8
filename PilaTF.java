package chiteado.pilas;

public class PilaTF implements PilaTDA {
	int[] arr;
	int inx;
	
	public void InicializarPila() {
		arr = new int[100];
		inx = 0;
	}
	
	public void Apilar(int x) {
		arr[inx] = x;
		inx++;
	}
	
	public void Desapilar() {
		inx--;
	}
	
	public boolean PilaVacia() {
		return (inx == 0);
	}
	
	public int Tope() {
		return (arr[inx - 1]);
	}
	
	public void MostrarPila() {
		PilaTDA aux = new PilaTF();
		aux.InicializarPila();
		while(!this.PilaVacia()){
			System.out.println(this.Tope());
			aux.Apilar(this.Tope());
			this.Desapilar();
		}
		while(!aux.PilaVacia()) {
			this.Apilar(aux.Tope());
			aux.Desapilar();
		}
	}
	
	public void PasarPila(PilaTDA destino) {
		while(!this.PilaVacia()){
			destino.Apilar(this.Tope());
			this.Desapilar();
		}
	}
	
	public void CopiarPila(PilaTDA destino){
		PilaTDA aux = new PilaTF();
		aux.InicializarPila();
		while(!this.PilaVacia()) {
			aux.Apilar(this.Tope());
			this.Desapilar();
		}
		while(!aux.PilaVacia()) {
			destino.Apilar(aux.Tope());
			aux.Desapilar();
		}
	}
	
	public void InvertirPila() {
		PilaTDA aux = new PilaTF();
		PilaTDA aux2 = new PilaTF();
		aux.InicializarPila();
		aux2.InicializarPila();
		while(!this.PilaVacia()) {
			aux.Apilar(this.Tope());
			this.Desapilar();
		}
		while(!aux.PilaVacia()) {
			aux2.Apilar(aux.Tope());
			aux.Desapilar();
		}
		while(!aux2.PilaVacia()) {
			this.Apilar(aux2.Tope());
			aux2.Desapilar();
		}
	}
	
	public int ContarElementos() {
		PilaTDA aux = new PilaTF();
		aux.InicializarPila();
		int i=0;
		while(!this.PilaVacia()) {
			i++;
			aux.Apilar(this.Tope());
			this.Desapilar();
		}
		while(!aux.PilaVacia()) {
			this.Apilar(aux.Tope());
			aux.Desapilar();
		}
		return i;
	}
	
	public int SumarElementos() {
		PilaTDA aux = new PilaTF();
		aux.InicializarPila();
		int n=0;
		while(!this.PilaVacia()) {
			n+=this.Tope();
			aux.Apilar(this.Tope());
			this.Desapilar();
		}
		while(!aux.PilaVacia()) {
			this.Apilar(aux.Tope());
			aux.Desapilar();
		}
		return n;
	}
	
	public float CalcularPromedio() {
		PilaTDA aux = new PilaTF();
		aux.InicializarPila();
		float suma=0;
		float resultado=0;
		float cantidad=0;
		while(!this.PilaVacia()) {
			suma+=this.Tope();
			aux.Apilar(this.Tope());
			this.Desapilar();
			cantidad++;
		}
		while(!aux.PilaVacia()) {
			this.Apilar(aux.Tope());
			aux.Desapilar();
		}
		resultado=suma/cantidad;
		return resultado;
	}
	
	public boolean EsCapicua() {
		PilaTDA aux1 = new PilaTF();
		PilaTDA aux2 = new PilaTF();
		PilaTDA aux3 = new PilaTF();
		aux1.InicializarPila();
		aux2.InicializarPila();
		aux3.InicializarPila();
		boolean capicua=true;
		while(!this.PilaVacia()) {
			aux1.Apilar(this.Tope());
			aux2.Apilar(this.Tope());
			this.Desapilar();
		}
		while (!aux1.PilaVacia()) {
			this.Apilar(aux1.Tope());
			aux3.Apilar(aux1.Tope());
			aux1.Desapilar();
		}
		while(!aux2.PilaVacia()) {
			if (aux2.Tope()!=aux3.Tope()) {
				capicua=false;
			}
			aux2.Desapilar();
			aux3.Desapilar();
		}
		return capicua;
	}
	
	public void EliminarRepetidos() {
		PilaTDA aux = new PilaTF();
		aux.InicializarPila();
		int cant=0;
		int g=0;
		int j=0;
		while (!this.PilaVacia()) {
			aux.Apilar(this.Tope());
			this.Desapilar();
			cant++;
		}
		while (cant>0) {
			for (int i = j;i>=0;i--) {
				g=aux.Tope();
				this.Apilar(g);
				aux.Desapilar();
			}
			while(!aux.PilaVacia()) {
				if (aux.Tope()!=g) {
					this.Apilar(aux.Tope());
				} else {
					cant--;
				}
				aux.Desapilar();
			}
			while(!this.PilaVacia()) {
				aux.Apilar(this.Tope());
				this.Desapilar();
			}
			cant--;
			j++;
			}
		while (!aux.PilaVacia()) {
			this.Apilar(aux.Tope());
			aux.Desapilar();
		}
	}
	
	public boolean Incluye(PilaTDA p2) {
		boolean incluye = false;
		PilaTDA aux = new PilaTF();
		PilaTDA aux2= new PilaTF();
		int cant=0;
		int j=0;
		int g=0;
		int cant2=0;
		aux.InicializarPila();
		aux2.InicializarPila();
		while(!this.PilaVacia()) {
			aux.Apilar(this.Tope());
			this.Desapilar();
			cant++;
		}
		while(!aux.PilaVacia()) {
			this.Apilar(aux.Tope());
			aux.Desapilar();
		}
		while(!p2.PilaVacia()) {
			aux2.Apilar(p2.Tope());
			p2.Desapilar();
			cant2++;
		}
		while(!aux2.PilaVacia()) {
			p2.Apilar(aux2.Tope());
			aux2.Desapilar();
		}
		
		while (!p2.PilaVacia() && j<cant) {
			j++;
			if (this.Tope()==p2.Tope()) {
				aux.Apilar(this.Tope());
				this.Desapilar();
				aux2.Apilar(p2.Tope());
				p2.Desapilar();
				g++;
				if (g==cant2) {
					incluye=true;
				}
			} else {
				if (g==0) {
					aux.Apilar(this.Tope());
					this.Desapilar();
				}
				while(!aux2.PilaVacia()) {
					p2.Apilar(aux2.Tope());
					aux2.Desapilar();
				}
				for(int i=0;i>j;i++) {
					this.Apilar(aux.Tope());
					aux.Desapilar();
				}
				g=0;
			}
		}
		while(!aux.PilaVacia()) {
			this.Apilar(aux.Tope());
			aux.Desapilar();
		}
		while(!aux2.PilaVacia()) {
			p2.Apilar(aux2.Tope());
			aux2.Desapilar();
		}
		return incluye;
	}

	public int ObtenerElemento(int posicion) {
		if (posicion < 0 || posicion >= Tope()) {
			throw new IndexOutOfBoundsException("Posición inválida");
		}

		PilaTF pilaTemporal = new PilaTF();
		pilaTemporal.InicializarPila();

		int elemento = 0;
		int contadorPosicion = 0;

		while (!PilaVacia()) {
			int valor = Tope();
			if (contadorPosicion == posicion) {
				elemento = valor;
			}
			pilaTemporal.Apilar(valor);
			Desapilar();
			contadorPosicion++;
		}

		while (!pilaTemporal.PilaVacia()) {
			int valor = pilaTemporal.Tope();
			Apilar(valor);
			pilaTemporal.Desapilar();
		}

		return elemento;
	}

}

	

