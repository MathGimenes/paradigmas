
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Player[] ps = new Player[2];
        ps[0] = new PlayerSimples();
        ps[1] = new PlayerSuporte();
        Tabuleiro tab = new Tabuleiro(ps);
        Scanner sc = new Scanner(System.in);
        String opcao;
        int turno = 1;
        boolean emJogo = true;
        Banner banner = new Banner();

        
        while (emJogo){
            
            for (int i = 0; i < 2; i++){
                tab.desenhar();
                banner.desenhar();
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
                banner.atualizarSetor(ps[i], tab);
                
                
                tab.desenhar();
                banner.desenhar();
                for(int j = 0; j < 2; j++){
                    tab.jogar(tab.getSetor(ps[i].getX(), ps[i].getY()), ps[i], sc, banner);
                }

            }

            turno++;
            if(turno > 25)
                emJogo = false;
        }

        sc.close();


    }
}