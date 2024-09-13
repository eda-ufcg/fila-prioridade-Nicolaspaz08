public class InsereOrdenadoFilaPrioridade implements FilaPrioridade {

	private Pair[] fila;
	private int head;
	private int last;

	public InsereOrdenadoFilaPrioridade(int capacidade) {
		this.fila = new Pair[capacidade];
		this.last = -1;
		this.head = -1;
	}
	
	// criar um Pair e inserir de forma ordenada decrescente no array.
	public void add(String elemento, int prioridade) {
		Pair pair = new Pair(elemento, prioridade);

		last += (last + 1) % fila.length;

		int i = fila.length-1;
		while(i > 0 && fila[i].getPrioridade() > fila[i-1].getPrioridade()){
			this.swap(fila, i, i-1);
		}

	}


	// remover e retornar o primeiro elemento do array, que é o de maior prioridade. lembrar manipular head e tail
	// para ser uma fila circular. assim a remoção fica O(1)
	public String removeNext() {
		String value = fila[head].getElemento();

		if(this.head == this.last){
			this.head = -1;
			this.last = -1;
		}
		else{
			head = (this.head + 1) % fila.length;
		}

		head = (head + 1) % fila.length;
		return value;
		
	}

	public void swap(Pair[] fila, int i, int j){
		Pair aux = fila[i];
		fila[i] = fila[j];
		fila[j] = aux;
	}

}
