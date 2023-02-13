
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
        Banner banner = new Banner();

        tab.desenhar();
        banner.desenhar();
        while (emJogo){
            
            for (int i = 0; i < 2; i++){
                opcao = sc.next();
                while (!ps[i].movimentar(ps[i], opcao, tab))
                    opcao = sc.next();
                tab.getSetor(ps[i].getX(), ps[i].getY()).updatePlayers(true);
                tab.atualizarTabela(ps[i].getX(), ps[i].getY(), ps[i]);
                if(!tab.getSetor(ps[i].getX(), ps[i].getY()).getPassou()){
                    tab.getSetor(ps[i].getX(), ps[i].getY()).setInimigo();
                    tab.getSetor(ps[i].getX(), ps[i].getY()).setPassou(true);
                }
                if (tab.getSetor(ps[i].getX(), ps[i].getY()).getNumeroInimigos() > 0)
                    banner.atualizarInimigos(tab.getSetor(ps[i].getX(), ps[i].getY()), ps[i]);
                banner.atualizarCabecalho(ps[i], tab);
                tab.desenhar();
                banner.desenhar();
            }

            turno++;
            if(turno > 25)
                emJogo = false;
        }

        sc.close();


    }
}