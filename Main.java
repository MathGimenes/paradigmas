
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Tabuleiro tab = new Tabuleiro();
        Player[] ps = new Player[2];
        ps[0] = new PlayerSimples();
        ps[1] = new PlayerSuporte();
        Scanner sc = new Scanner(System.in);
        String opcao;
        int turno = 1;
        boolean emJogo = true;

        tab.desenhar();

        while (emJogo){
            
            for (int i = 0; i < 2; i++){
                opcao = sc.next();
                while (!ps[i].movimentar(ps[i], opcao, tab))
                    opcao = sc.next();
                tab.getSetor(ps[i].getX(), ps[i].getY()).updatePlayers(true);
                tab.atualizarTabela(ps[i].getX(), ps[i].getY(), ps[i]);
                if(!tab.getSetor(ps[i].getX(), ps[i].getY()).getPassou())
                    tab.getSetor(ps[i].getX(), ps[i].getY()).setInimigo();
                tab.desenhar();
            }

            turno++;
            if(turno > 25)
                emJogo = false;
        }


    }
}