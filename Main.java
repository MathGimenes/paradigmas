
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Tabuleiro teste = new Tabuleiro();
        PlayerSimples P1 = new PlayerSimples();
        Scanner sc = new Scanner(System.in);
        String opcao;
        while(true){
            System.out.println("Entrou");
            opcao = sc.next();
            P1.movimentar(P1, opcao);
        
        }
    }
}