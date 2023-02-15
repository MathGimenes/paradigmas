import java.util.Random;
public class Inimigo implements Personagem{

    protected int atk;
    protected int def;

    Inimigo(){
        this.setAtkDef();
    }

    public int getAtk(){
        return this.atk;
    }

    public int getDef(){
        return this.def;
    }
    
    public void setAtkDef(){
        Random gerador = new Random();
        int stat = gerador.nextInt(3) + 1;
        this.atk = stat;
        this.def = stat;
    }

    public void dano(int x){
        this.def = this.def - x;
    }

    public boolean atacar(Setor setor, Tabuleiro tab, Player P){
        System.out.println("atacar");
        int numeroPlayers = setor.getPlayers();
        Random gerador = new Random();
        int player = gerador.nextInt(2);
        boolean vaiAtacar = (gerador.nextInt(6) + 1) % 2 == 0;
        if (numeroPlayers == 2){

            if(!tab.getPlayer(player).getAtacado() && vaiAtacar){
                tab.getPlayer(player).dano(this.atk);
                tab.getPlayer(player).setAtacado(true);
                if(tab.getPlayer(player).getDef() <= 0){
                    return true;
                }
            }else{
                player = (player == 1) ? 2 : 1;
                if(!tab.getPlayer(player).getAtacado() && vaiAtacar){
                    tab.getPlayer(player).dano(this.atk);
                    tab.getPlayer(player).setAtacado(true);
                    if(tab.getPlayer(player).getDef() <= 0){
                        return true;
                    }
                }
            }
        }else if (!P.getAtacado() && vaiAtacar){
            P.dano(this.atk);
            P.setAtacado(true);
            if(P.getDef() <= 0){
                System.out.println("Morreu");
                return true;
            }
        }
        return false;
    }


    
}
