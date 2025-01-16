import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        PilhaDinamica p1 = new PilhaDinamica(7);
        int opcao = 1;
        while (opcao != 0){
            System.out.println("---------Escolha uma opção--------");
            System.out.println(" > 1- Adicionar um elemento a pilha.");
            System.out.println(" > 2- Excluir um elemento da pilha.");
            System.out.println(" > 3- Mostrar o elemento do topo da pilha.");
            System.out.println(" > 4- Qual o tamanho da pilha.");
            System.out.println(" > 5- Imprimir a pilha.");
            System.out.println(" > 0- Para encerrar");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o elemento a ser inserido:");
                    int elemento = input.nextInt();
                    p1.inserir(elemento);
                    break;

                case 2:
                    p1.remover();
                    break;

                case 3:
                    System.out.println(p1.topo());    
                    break;

                case 4:
                    System.out.println(p1.qualTamanho());
                    break;

                case 5:
                    p1.imprimir();
                    break;
            
                default:
                    break;
            }
        }
    }
}
