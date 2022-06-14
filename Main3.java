package exercicio;
import java.util.Scanner;
public class Main3 {
     
	static Scanner console = new Scanner(System.in);

		static final int TOTAL_AVALIACOES = 3;
		static final String[] NOME_AVALIACOES = {"A1", "A2", "A3"};
		static final double[] NOTA_MAX_AVALIACOES = {30.00, 30.00, 40.00};
		static double[] notas = new double [TOTAL_AVALIACOES];
		static void mostrarMenu() {
			System.out.println("\n\n");
			System.out.println("\t Menu");
			System.out.println("[ 1 ] Atualizar nota A1: ");
			System.out.println("[ 2 ] Atualizar nota A2: ");
			System.out.println("[ 3 ] Atualizar nota A3: ");
			System.out.println("[ 4 ] Mostrar notas do aluno: ");
			System.out.println("[ 0 ] Sair do Menu: ");
			System.out.println("\n Digite a opção:");
			
			byte opcao = console.nextByte();
			switch (opcao) {
			case 0:
				System.err.println("Saiu do Menu");
				System.exit(opcao);
				break;
			case 1:
				atualizarNota(0);
				break;
			case 2:
				atualizarNota(1);
				break;
			case 3:
				atualizarNota(2);
				break;
		    case 4:
				mostrarNotas();
				break;
				default:
					System.err.println("Opção inválida");
					mostrarMenu();
					break;
			}
			mostrarMenu();
		}
		static void atualizarNota(int indiceNota) {
			notas[indiceNota] = lerNota(NOME_AVALIACOES[indiceNota], NOTA_MAX_AVALIACOES[indiceNota]);
		 }
		static double lerNota(String mensagem, double notaMaxima) {
			double nota = 0.0;
			do {
				System.out.printf("%s = ", mensagem);
				nota = console.nextDouble();
			} while(nota < 0 || nota > notaMaxima);
			return nota;
		}
		static void mostrarNotas() {
			double notaFinal = 0.0;
			System.out.println("\n Notas: ");
			for (int i = 0; i < TOTAL_AVALIACOES; i++) {
				System.out.printf("\nAvaliação %s = %.2f ", NOME_AVALIACOES[i], notas[i]);
				notaFinal += notas[i];
			}
			System.out.println("\nNota Final: " + notaFinal);
			System.out.println("Situação: " + analisarSituacao(notaFinal));
			System.out.println("Média aritmética: " + calcularMedia(notas));
			System.out.println("A maior nota foi: " + maiorNota(notas));
			if (notaFinal < 70 && notaFinal > 30 && notas[0] + notas[1] < 60)
				realizarAvaliacaoIntegrada(notas);
		}
		 static double calcularMedia(double[] notas) {
			double media = 0.0;
			 for (int i = 0; i < notas.length; i++) {
				media += notas[i];
			}
			 media = media /TOTAL_AVALIACOES;
			 return media;
		}
		 static String maiorNota(double[] notas) {
			 String maiorNota = "";
		     double verMaior = 0.0;

		     for (int i = 0; i < notas.length; i++) {
		         if (notas[i] > verMaior) {
		             verMaior = notas[i];
		             maiorNota = NOME_AVALIACOES[i];
		         }
		     }
		     return maiorNota;
		 }
		  
		  static void realizarAvaliacaoIntegrada(double[] notas) {
				double ai = 0.0;
				ai = lerNota("Digite nota ai", NOTA_MAX_AVALIACOES[0]);
				if (notas[0] < notas[1] && ai > notas[0]) {
					notas[0] = ai;
				} else if (notas[1] < notas[0] && ai > notas[1]) {
					notas[1] = ai;
				}
			}
		static String analisarSituacao(double mediaNotas) {
			if(mediaNotas < 30)
				return"Reprovado";
			else if(mediaNotas < 70)
				return "Em recuperação";
				else
					return "Aprovado";
		}
		    public static void main(String[] args) {
				mostrarMenu();

		    }
}


		
	




