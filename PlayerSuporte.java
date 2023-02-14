import java.util.Scanner;
public class PlayerSuporte extends Player{
    
    PlayerSuporte(){
        super();
        this.setAtk();
        this.setDef();
    }
    
    public void setAtk(){
        this.atk = 1;
    }

    public void setDef(){
        this.def = 7;
    }
    
    public void recuperarDefesa(Player[] ps, Scanner sc, Banner banner){
        /* player simples */
        int x1 = ps[0].getX();
        int y1 = ps[0].getY();

        /* player suporte */
        int x2 = ps[1].getX();
        int y2 = ps[1].getY();

        System.out.println("Recuperar a sua defesa, ou a do outro player?");
        System.out.println("1-Minha");

        boolean mesmoSetor = x1 == x2 && y1 == y2;
        if(mesmoSetor){
            System.out.println("2-Outro player");

        }

        String tmp;
        boolean flag = true;

        while(flag){
            tmp = sc.next();
            if(tmp.compareTo("1") == 0){
                int defAtual = this.getDef();
                defAtual += 2;
                this.setDef(defAtual);
                banner.atualizarDefPlayer(ps[1]);
                flag = false;
            }else if(mesmoSetor && tmp.compareTo("2") == 0){
                int defAtual = ps[0].getDef();
                defAtual += 2;
                ps[0].setDef(defAtual);
                banner.atualizarDefPlayer(ps[0]);
                flag = false;
            }else{
                System.out.println("Opcao invalida, escolha novamente.");
                flag = true;
            }
        }

    }
}
