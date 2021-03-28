package lexercicio01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Main app = new Main();
		app.start();

	}

	private Map<Integer, Candidato> mapaDeCandidatos = new HashMap<Integer, Candidato>();

	private void start() {

		inicializarMapaDeCandidatos();

		while (true) {

			int voto = obterVoto();
			if (voto == 0) {
				break;
			}

			System.out.println("Numero do voto " + voto);

			registrarVoto(voto);
		}

		apurarVotos();

		System.out.println("Fim da aplicação");
	}

	private void apurarVotos() {

		List<Candidato> candidatos = new ArrayList<Candidato>();

		for (Candidato candidato : mapaDeCandidatos.values()) {

			candidatos.add(candidato);

		}
		
		candidatos.sort((a, b) -> {
			return b.getNumeroDeVotos() - a.getNumeroDeVotos();
		});
		
		
		
		
		Candidato candidatoEleito = candidatos.get(0);
		
		System.out.println("O candidato eleito é o "+ candidatoEleito.getNome() + " com " + candidatoEleito.getNumeroDeVotos() + " votos!");
		
		for (int i = 0; i < candidatos.size(); i++) {
			
			int posicao = i + 1;
			
			Candidato candidato = candidatos.get(i);
			System.out.println("Lugar "+ posicao+" Candidato " + candidato.getNome() + " - " + candidato.getNumeroDeVotos()+"Votos");
		}

	}

	private void inicializarMapaDeCandidatos() {

		Candidato joao = new Candidato(1, "João Batista");
		mapaDeCandidatos.put(joao.getId(), joao);

		Candidato maria = new Candidato(2, "Maria");
		mapaDeCandidatos.put(maria.getId(), maria);

		Candidato jose = new Candidato(3, "Jose Sebastiao");
		mapaDeCandidatos.put(jose.getId(), jose);

		Candidato antonio = new Candidato(4, "Antonio Cesar");
		mapaDeCandidatos.put(antonio.getId(), antonio);

		Candidato tiburssinho = new Candidato(5, "Tiburssinho Tião");
		mapaDeCandidatos.put(tiburssinho.getId(), tiburssinho);

	}

	private int obterVoto() {

		System.out.print("Digite seu voto: ");
		Scanner teclado = new Scanner(System.in);

		try {
			return teclado.nextInt();
		} catch (Exception e) {
			teclado.next();

			System.out.println("Valor invalido");
			return -1;
		}
	}

	private void registrarVoto(int voto) {

		if (mapaDeCandidatos.containsKey(voto)) {
			Candidato candidato = mapaDeCandidatos.get(voto);
			candidato.adicionarVoto();

			System.out.println("Você votou em: " + candidato.getNome() + ".");
			System.out.println("Obrigado pelo seu voto!");
		} else {
			System.out.println("Desculpa, porém este candidato(a) não existe. Tente novamente.");
		}

	}

}
