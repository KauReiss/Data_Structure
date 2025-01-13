import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        ListaDinamica l1 = new ListaDinamica(10);
        int opcao = 1;
        while (opcao != 0){
            System.out.println("---------Escolha uma opção---------");
            System.out.println(" > 1- Inserir na lista.");
            System.out.println(" > 2- Remover da lista.");
            System.out.println(" > 3- Atualizar a lista.");
            System.out.println(" > 4- Qual o tamanho da lista.");
            System.out.println(" > 5- Imprimir lista.");
            System.out.println(" > 6- Limpar a lista.");
            System.out.println(" > 0- Para encerrar.");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o elemento a ser inserido na lista: ");
                    int dado = input.nextInt();
                    if (l1.getQuantidade() != 0){
                        System.out.println("Digite a posição da lista que será inserido o elemento: ");
                        int posicao = input.nextInt();
                        l1.inserir(dado, posicao);
                    } else {
                        l1.inserir(dado, 1);
                    }
                    break;

                case 2:
                    System.out.println("Digite a posição do dado que será removido: ");
                    int posicao = input.nextInt();
                    l1.remover(posicao);
                    break;

                case 3:
                    System.out.println("Digite o elemento que irá atualizar a lista: ");
                    int elemento = input.nextInt();
                    System.out.println("Digite a posição que será atualizada: ");
                    int position = input.nextInt();
                    l1.atualizar(elemento, position);
                    break;

                case 4:
                    System.out.println(l1.quantElementos());
                    break;

                case 5:
                    l1.imprimir();
                    break;

                case 6:
                    l1.limpar();
                    break;
            
                default:
                    break;
            }
        }
    }
}
