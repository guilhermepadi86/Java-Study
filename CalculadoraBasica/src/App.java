import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;
        double a = 0;
        double b = 0;

        while (escolha != 0) {
            System.out.println("=== Calculadora ===");
            System.out.println("1 - Soma");
            System.out.println("2 - Subtração");
            System.out.println("3 - Multiplicação");
            System.out.println("4 - Divisão");
            System.out.println("0 - Sair");

            escolha = scanner.nextInt();
            
            switch (escolha) {

                case 1:
                    System.out.println("Digite o valor 1: ");
                    a = scanner.nextDouble();
                    System.out.println("Digite o valor 2: ");
                    b = scanner.nextDouble();

                    soma(a, b);
                    break;

                case 2:
                    System.out.println("Digite o valor 1: ");
                    a = scanner.nextDouble();
                    System.out.println("Digite o valor 2: ");
                    b = scanner.nextDouble();

                    subtracao(a, b);
                    break;

                case 3:
                    System.out.println("Digite o valor 1: ");
                    a = scanner.nextDouble();
                    System.out.println("Digite o valor 2: ");
                    b = scanner.nextDouble();

                    multiplicacao(a, b);
                    break;

                case 4:
                    System.out.println("Digite o valor 1: ");
                    a = scanner.nextDouble();
                    System.out.println("Digite o valor 2: ");
                    b = scanner.nextDouble();

                    divisao(a, b);
                    break;
                
                case 0:
                    System.out.println("\nFinalizando...");
                    break;

                default:
                    System.err.println("Valor inválido digitado. Escolha uma opção válida.\n");
                    break;
            }
        }

        scanner.close();
    }

    static void soma(double a, double b)
    {
        System.out.printf("%.2f + %.2f = %.2f\n", a, b, a + b);
    }

    static void subtracao(double a, double b)
    {
        System.out.printf("%.2f - %.2f = %.2f\n", a, b, a - b);
    }

    static void multiplicacao(double a, double b)
    {
        System.out.printf("%.2f x %.2f = %.2f\n", a, b, a * b);
    }

    static void divisao(double a, double b)
    {
        if (b != 0) {
            System.out.printf("%.2f / %.2f = %.2f\n", a, b, a / b);
        }
        else {
            System.err.println("O divisor não pode ser zero!!\n");
        }
    }
}
