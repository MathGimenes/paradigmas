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
        int stat = gerador.nextInt(2) + 1;
        this.atk = stat;
        this.def = stat;
    }

    public void dano(int x){
        this.def = this.def - x;
    }

    public void atacar(){

    }
    
}
