package pacote;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;
        ArrayList<Tarefa> allTarefas = new ArrayList<>();

        while (escolha != 0) {
            System.out.println("\n=== Lista de Tarefas ===");
            System.out.println("1 - Exibir todas tarefas");
            System.out.println("2 - Registrar nova tarefa");
            System.out.println("3 - Alterar tarefa existente");
            System.out.println("4 - Excluir tarefa");
            System.out.println("0 - Sair");

            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    limparTela();
                    exibirTarefas(allTarefas);
                    break;
                case 2:
                    limparTela();
                    Tarefa tarefa1 = registrarTarefa(scanner);
                    allTarefas.add(tarefa1);
                    System.out.println("\nTarefa registrada com sucesso!!");
                    break;
                case 3:
                    limparTela();
                    alterarTarefa(allTarefas, scanner);
                    break;
                case 4:
                    limparTela();
                    excluirTarefa(allTarefas, scanner);
                    break;
                case 0:
                    limparTela();
                    System.out.println("\nFinalizando...");
                    break;
                default:
                    limparTela();
                    System.err.println("Opção inválida, selecione uma opção válida.");
                    break;
            }
        }

        scanner.close();
    }

    public static Tarefa registrarTarefa(Scanner scanner) {
        String tarefa;
        int tempo;
        String dificuldade;

        System.out.println("Digite o nome da tarefa: ");
        tarefa = scanner.nextLine();

        System.out.println("Quanto tempo leva para realizar esta tarefa? ");
        tempo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Qual o nível de dificuldade desta tarefa? ");
        dificuldade = scanner.nextLine();

        Tarefa tarefa1 = new Tarefa(tarefa, tempo, dificuldade);

        return tarefa1;
    }

    public static void exibirTarefas(ArrayList<Tarefa> tarefas) {
        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println((i + 1) + " - Tarefa: " + tarefas.get(i).task + " | Tempo: " + tarefas.get(i).time + " | Dificuldade: " + tarefas.get(i).difficulty);
        }
    }

    public static void alterarTarefa(ArrayList<Tarefa> tarefas, Scanner scanner) {
        int escolhaTarefa = 0;
        String tarefa;
        int tempo;
        String dificuldade;

        exibirTarefas(tarefas);
        
        System.out.println("\nQual tarefa deseja alterar? ");
        escolhaTarefa = scanner.nextInt();
        scanner.nextLine();

        if (escolhaTarefa <= tarefas.size() && escolhaTarefa > 0) {
            System.out.println("Digite o novo nome da tarefa: ");
            tarefa = scanner.nextLine();

            System.out.println("Quanto tempo leva para realizar esta tarefa? ");
            tempo = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Qual o nível de dificuldade desta tarefa? ");
            dificuldade = scanner.nextLine();

            tarefas.get(escolhaTarefa - 1).task = tarefa;
            tarefas.get(escolhaTarefa - 1).time = tempo;
            tarefas.get(escolhaTarefa - 1).difficulty = dificuldade;

            System.out.println("\nTarefa alterada com sucesso!!");
        }
        else {
            System.err.println("\nEntrada inválida, escolha uma tarefa que esteja na lista.");
        }
    }

    public static void excluirTarefa(ArrayList<Tarefa> tarefas, Scanner scanner) {
        exibirTarefas(tarefas);
        int escolhaTarefa = 0;

        System.out.println("\nQual tarefa deseja excluir? ");
        escolhaTarefa = scanner.nextInt();
        scanner.nextLine();

        if (escolhaTarefa <= tarefas.size() && escolhaTarefa > 0) {
            tarefas.remove(escolhaTarefa - 1);
            System.out.println("\nTarefa excluida com sucesso!!");
        }
        else {
            System.err.println("\nEntrada inválida, escolha uma tarefa que esteja na lista.");
        }
    }

    public static void limparTela() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}