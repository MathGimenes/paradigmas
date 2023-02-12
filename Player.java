import java.util.Scanner;

public abstract class Player implements Personagem{
    protected int atk, def, x, y, acoes;

    Player(){
        this.setXY();
        this.setAcoes();
    }

    public int getAtk(){
        return this.atk;
    }

    public int getDef(){
        return this.def;
    }

    public abstract void setAtk();

    public abstract void setDef();

    public void setAcoes(){
        this.acoes = 2;
    }

    public void setXY(){
        this.x = 3;
        this.y = 3;
    }

    public void movimentar(int i, int j){
        try (Scanner sc = new Scanner(System.in)) {
            String teste = sc.next();
            //teste.trim();
            if(teste.compareTo("w") == 0){
                System.out.println("cima");
                if(x == 0)
                    System.out.println("Deu nao");
                else{
                    this.x--;
                }
            }
            if(teste.compareTo("a") == 0){
                System.out.println("esq");
                if(y == 0)
                    System.out.println("Deu nao");
                else{
                    this.y--;
                }
            }
            if(teste.compareTo("s") == 0){
                System.out.println("baixo");
                if(x == 4)
                    System.out.println("Deu nao");
                else{
                    this.x++;
                }
                
            }
            if(teste.compareTo("d") == 0){
                System.out.println("dir");
                if(y == 4)
                    System.out.println("Deu nao");
                else{
                    this.y++;
                }
            }
        }
    }

    public void procurar(){
        
    }

    public void atacar(){

    }
}