
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class CadastroAlunoTexto {
	private Scanner entrada;
	private final String enderecoArquivo = "c:\\alunos.cdt";
	private File arquivo;
	private BufferedReader leitor;
	private BufferedWriter gravador;
	private HashMap<String, Aluno> alunos;

	public static void main(String[] args) {
		CadastroAlunoTexto cadastro = new CadastroAlunoTexto();
		cadastro.iniciar();
	}

	public CadastroAlunoTexto() {
		arquivo = new File(enderecoArquivo);
		alunos = new HashMap<String, Aluno>();
		entrada = new Scanner(System.in);

		iniciar();
	}

	private void iniciar() {
		int opcao = -1;
		try {

			lerArquivo();

			do {
				exibeMenu();
				opcao = opcaoUsuario();
				switch (opcao) {
					case 1: {
						exibirAlunos();
						break;
					}
					case 2: {
						novoAluno();
						break;
					}
					case 3: {
						removerAluno();
						break;
					}
					case 4: {
						break;
					}
					default: {
						System.out.println("Opção inexistente.");
						opcao = -1;
					}
				}

			} while (opcao != 4);
			finalizar();
		} catch (IOException exception) {
			System.out.println("Falha na manipulação do arquivo.");
		}
		System.out.println("Encerrando...");
		System.exit(0);
	}

	private void finalizar() throws IOException {
		System.out.println("Salvando dados no arquivo..");
		gravarArquivo();
	}

	private void exibeMenu() {
		System.out.println(":: Menu ::\n");
		System.out.println(" 1. Ver Alunos\n 2. " + "Adicionar Aluno\n 3. Remover Aluno\n 4. Sair");
		System.out.print(">> ");
	}

	private int opcaoUsuario() throws IOException {
		return entrada.nextInt();
	}

	private void exibirAlunos() {
		System.out.println("# Lista de Alunos\n");
		for (Aluno aluno : alunos.values()) {
			System.out.println("Matrícula: " + aluno.getMatricula());
			System.out.println("Nome: " + aluno.getNome());
			if (aluno.getEndereco() != null && !aluno.getEndereco().isEmpty()) {
				System.out.println("Endereço: " + aluno.getEndereco());
			}
			if (aluno.getTelefone() != null && !aluno.getTelefone().isEmpty()) {
				System.out.println("Telefone: " + aluno.getTelefone());
			}
			System.out.println();
		}
		System.out.println("-----------------------");
	}

	private void novoAluno() {
		System.out.println("Informe matricula, nome, endereco e telefone do aluno, separados por vírgula.");
		System.out.print("* Apenas matrícula e nome são obrigatórios. \n>>");
		entrada.nextLine();

		String dados = entrada.nextLine();
		String[] dadosAluno = dados.split(",");

		Aluno aluno = new Aluno(dadosAluno[0], dadosAluno[1]);
		if (dadosAluno.length >= 3) {
			aluno.setEndereco(dadosAluno[2]);
		}
		if (dadosAluno.length >= 4) {
			aluno.setTelefone(dadosAluno[3]);
		}

		alunos.put(aluno.getMatricula(), aluno);
	}

	private void removerAluno() {
		System.out.print("Informe matricula do aluno que deseja remover.\n>>");
		entrada.nextLine();

		String matricula = entrada.nextLine();

		if (alunos.containsKey(matricula)) {
			Aluno aluno = alunos.remove(matricula);
			System.out.println("Aluno " + aluno.getNome() + " removido...");
		} else {
			System.out.println("Matricula não encontrada...");
		}
	}

	private void lerArquivo() throws IOException {

		System.out.println("Carregando dados do arquivo...");
		leitor = new BufferedReader(new FileReader(arquivo));
		String dados = "";

		while ((dados = leitor.readLine()) != null) {
			String[] dadosAluno = dados.split(",");
			Aluno aluno = new Aluno(dadosAluno[0], dadosAluno[1]);
			if (dadosAluno.length >= 3) {
				aluno.setEndereco(dadosAluno[2]);
			}
			if (dadosAluno.length >= 4) {
				aluno.setTelefone(dadosAluno[3]);
			}
			alunos.put(aluno.getMatricula(), aluno);
		}
		leitor.close();
		leitor = null;
	}

	private void gravarArquivo() throws IOException {
		if (alunos != null) {
			gravador = new BufferedWriter(new FileWriter(arquivo, false));
			for (Aluno aluno : alunos.values()) {
				String representacaoAluno = aluno.getMatricula() + "," + aluno.getNome();
				if (aluno.getEndereco() != null && !aluno.getEndereco().isEmpty()) {
					representacaoAluno += "," + aluno.getEndereco();
				}
				if (aluno.getTelefone() != null && !aluno.getTelefone().isEmpty()) {
					representacaoAluno += "," + aluno.getTelefone();
				}
				gravador.write(representacaoAluno + System.getProperty("line.separator"));
			}
			gravador.flush();
			gravador.close();
			gravador = null;
		}
	}
}
