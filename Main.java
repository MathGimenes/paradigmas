
import java.util.*;
import java.lang.Thread;  
import java.io.*;  
public class Main{
    public static void main(String[] args){
        Player[] ps = new Player[2];
        ps[0] = new PlayerSimples();
        ps[1] = new PlayerSuporte();
        Tabuleiro tab = new Tabuleiro(ps);
        Scanner sc = new Scanner(System.in);
        String opcao;
        int turno = 1;
        boolean emJogo = true, ganhou = false, gameOver = false;
        /* false-Simples true-Suporte */
        boolean qualPlayer = false, temInimigos = false;
        Banner banner = new Banner();
        Setor setorTmp;

        
        while (emJogo){
            
            for (int i = 0; i < 2; i++){
                tab.desenhar();
                banner.desenhar();
                setorTmp = tab.getSetor(ps[i].getX(), ps[i].getY());
                temInimigos = setorTmp.getNumeroInimigos() > 0;

                if (!temInimigos){
                    opcao = sc.next();
                    if (setorTmp.getNumeroInimigos() > 0)
                        banner.atualizarInimigos(setorTmp, ps[i]);
                    while (!ps[i].movimentar(ps[i], opcao, tab))
                        opcao = sc.next();
                }
                setorTmp = tab.getSetor(ps[i].getX(), ps[i].getY());
                
                
                if(setorTmp.getTipo() == 4){
                    emJogo = false;
                    ganhou = true;
                    if(ps[i] instanceof PlayerSimples)
                        qualPlayer = false;
                    else
                        qualPlayer = true;
                    break;
                }
                
                if (!temInimigos)
                    setorTmp.updatePlayers(true);
                
                tab.atualizarTabela(ps[i].getX(), ps[i].getY(), ps[i]);
                if(!setorTmp.getPassou()){
                    setorTmp.setInimigo();
                    setorTmp.setPassou(true);
                }
                if (setorTmp.getNumeroInimigos() > 0)
                    banner.atualizarInimigos(setorTmp, ps[i]);
                banner.atualizarCabecalho(ps[i], tab);
                banner.atualizarSetor(ps[i], tab);
                
                
                tab.desenhar();
                banner.desenhar();
                for(int j = 0; j < 2; j++){
                    tab.jogar(setorTmp, ps[i], sc, banner);
                }
                try{
                    Thread.sleep(2000);
                }catch(Exception e){

                }

            }

            for(int i = 0; i < 2; i++){
                setorTmp = tab.getSetor(ps[i].getX(), ps[i].getY());
                int numeroInimigos = setorTmp.getNumeroInimigos();
                for(int j = 0; j < numeroInimigos && !gameOver; j++){
                    gameOver = setorTmp.getInimigo(j).atacar(setorTmp, tab, ps[i]);
                    banner.atualizarDefPlayer(ps[i]);
                }
            }

            for(int i = 0; i < 2; i++){
                ps[i].setAtacado(false);

            }

            turno++;
            if(turno > 25)
                emJogo = false;
            if(gameOver){
                emJogo = false;
            }
        }

        if(ganhou){
            if(qualPlayer)
                System.out.println("Player suporte ganhou");
            else
                System.out.println("Player simples ganhou");
        }

        sc.close();


    }
}