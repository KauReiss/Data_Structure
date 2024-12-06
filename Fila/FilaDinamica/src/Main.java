import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        FilaDinamica f1 = new FilaDinamica(5);
        int opcao = 1;
        while (opcao != 0){
            System.out.println("---------Escolha uma opção---------");
            System.out.println(" > 1- Entrar na fila.");
            System.out.println(" > 2- Sair da fila.");
            System.out.println(" > 3- Mostrar o primeiro da fila.");
            System.out.println(" > 4- Qual o tamanho da fila.");
            System.out.println(" > 5- Imprimir a fila.");
            System.out.println(" > 0- Para encerrar");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o elemento que irá entrar na fila:");
                    int elemento = input.nextInt();
                    f1.entrar(elemento);
                    break;

                case 2:
                    f1.sair();
                    break;

                case 3:
                    System.out.println(f1.primeiroFila());    
                    break;

                case 4:
                    System.out.println(f1.qualTamanho());
                    break;

                case 5:
                    f1.imprimir();
                    break;
            
                default:
                    break;
            }
        }
    }
}
