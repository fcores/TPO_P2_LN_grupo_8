package chiteado.pilas;

public interface PilaTDA {
	void InicializarPila();
	void Apilar(int x);
	void Desapilar();
	boolean PilaVacia();
	int Tope();
	void MostrarPila();
	void PasarPila(PilaTDA destino);
	void CopiarPila(PilaTDA destino);
	void InvertirPila();
	int ContarElementos();
	int SumarElementos();
	float CalcularPromedio();
	boolean EsCapicua();
	void EliminarRepetidos();
	int ObtenerElemento(int posicion);
}
