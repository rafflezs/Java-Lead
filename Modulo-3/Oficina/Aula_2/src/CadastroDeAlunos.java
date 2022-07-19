

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;

public class CadastroDeAlunos {

	private enum TipoDeLog {
		ERRO, INICIAR, EXIBIR, INSERIR, EXCLUIR, ENCERRAR
	}

	private Scanner entrada;
	private final String enderecoArquivoDeDados = "C:\\info\\dados.ser";
	private final String enderecoArquivoDeLog = "C:\\info\\log.txt";
	private File arquivo;
	private HashMap<String, Aluno> alunos;

	public static void main(String[] args) {
		CadastroDeAlunos cadastro = new CadastroDeAlunos();
		
		cadastro.salvarNoLog(TipoDeLog.INICIAR, "Iniciando a aplicação.");
		cadastro.iniciar();
		cadastro.salvarNoLog(TipoDeLog.ENCERRAR, "Encerrando a aplicação.");

	}

	public CadastroDeAlunos() {
		arquivo = new File(enderecoArquivoDeDados);
		alunos = new HashMap<String, Aluno>();
		entrada = new Scanner(System.in);
	}

	private void iniciar() {
		int opcao = -1;
		try {

			lerArquivo();

			do {
				exibeMenu();
				opcao = opcaoUsuario();
				switch (opcao) {
				case 1:
					exibirAlunos();
					break;
				case 2:
					novoAluno();
					break;
				case 3:
					removerAluno();
					break;
				case 4:
					break;

				default:
					System.out.println("Opçao inexistente.");
					opcao = -1;
				}

			} while (opcao != 4);

			finalizar();

		} catch (IOException exception) {
			System.err.println("Falha durante a manipulaçao do arquivo.");
			System.err.println("Erro: " + exception.getMessage());
		} catch (ClassNotFoundException exception) {
			System.err.println("Falha durante conversao do registro em Aluno.");
		}

		System.out.println("Encerrando...");
		System.exit(0);
	}

	private void finalizar() throws IOException {
		System.out.println("Salvando dados no arquivo...");
		gravarArquivo();
	}

	private void exibeMenu() {
		System.out.println(":: Menu ::\n");
		System.out.println(" 1. Ver Alunos\n 2. Adicionar Aluno\n 3. Remover Aluno\n 4. Sair");
		System.out.print(">> ");
	}

	private int opcaoUsuario() throws IOException {
		return entrada.nextInt();
	}

	private void exibirAlunos() {
		System.out.println("# Lista de Alunos\n");
		salvarNoLog(TipoDeLog.EXIBIR, "Os dados transeuntes foram lidos da memoria.");
		for (Aluno aluno : alunos.values()) {
			System.out.println("Matricula: " + aluno.getMatricula());
			System.out.println("Nome: " + aluno.getNome());
			if (aluno.getEndereco() != null && !aluno.getEndereco().isEmpty()) {
				System.out.println("Endereco: " + aluno.getEndereco());
			}
			if (aluno.getTelefone() != null && !aluno.getTelefone().isEmpty()) {
				System.out.println("Telefone: " + aluno.getTelefone());
			}
			System.out.println();
		}
		System.out.println("-----------------------");
	}

	private void novoAluno() {
		System.out.println("Informe matricula, nome, endereco e telefone do aluno, separados por virgula.");
		System.out.print("* Apenas matricula e nome são obrigatorios. \n>>");
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
		salvarNoLog(TipoDeLog.INSERIR, "Valores inseridos: " + dados);
		alunos.put(aluno.getMatricula(), aluno);
	}

	private void removerAluno() {
		System.out.print("Informe matricula do aluno que deseja remover.\n>>");
		entrada.nextLine();

		String matricula = entrada.nextLine();

		if (alunos.containsKey(matricula)) {
			Aluno aluno = alunos.remove(matricula);
			System.out.println("Aluno " + aluno.getNome() + " removido...");
			salvarNoLog(TipoDeLog.EXCLUIR, "Excluido o registro " + aluno.getMatricula() + aluno.getNome());
		} else {
			System.out.println("Matrícula não encontrada...");
			salvarNoLog(TipoDeLog.ERRO, "A chave informada " + matricula + " nao foi encontrada.");
		}
	}

	private void lerArquivo() throws IOException, ClassNotFoundException {

		if (arquivo.length() <= 0)
			return;



		System.out.println("Carregando dados do arquivo...");
		ObjectInputStream leitor = new ObjectInputStream(new FileInputStream(arquivo));
		Aluno temp = null;

		try {
			salvarNoLog(TipoDeLog.EXIBIR, "Realizada leitura do arquivo SERIAL.");
			while ((temp = (Aluno) leitor.readObject()) != null) {
				alunos.put(temp.getMatricula(), temp);
			}

		} catch (EOFException eofe) {
			salvarNoLog(TipoDeLog.ERRO, "Não foi possível leitura do arquivo SERIAL.");
			System.out.println("Arquivo de registros vazio.");
		}
		leitor.close();
		leitor = null;
	}

	private void gravarArquivo() throws IOException {
		if (alunos != null) {
			salvarNoLog(TipoDeLog.INSERIR, "O arquivo SERIAL foi salvo.");
			ObjectOutputStream gravador = new ObjectOutputStream(new FileOutputStream(arquivo, false));
			for (Aluno a : alunos.values()) {
				gravador.writeObject(a);
			}
			gravador.flush();
			gravador.close();
			gravador = null;
		}
	}

	private void salvarNoLog(TipoDeLog tipoDeLog, String log) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime agora = LocalDateTime.now();
		
		String mensagemDeLog = "[" + agora.format(format) + "] [" + tipoDeLog + "] " + log + "\n";
		
		System.out.println(mensagemDeLog);

		try {
			File logFile = new File(enderecoArquivoDeLog);
			BufferedWriter logBuffer = new BufferedWriter(new FileWriter(logFile, true));
			if (logFile.length() == 0) {
				logBuffer.write(mensagemDeLog);
			} else {
				logBuffer.write("\n" + mensagemDeLog);
			}
			logBuffer.flush();
			logBuffer.close();
		} catch (IOException e) {
			System.out.println("Erro durante a gravação. Chamando pilha de atividades: ");
			e.printStackTrace();
		}
	}

}
