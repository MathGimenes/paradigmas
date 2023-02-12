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

    public void movimentar(){
        
    }

    public void procurar(){
        
    }

    public void atacar(){

    }
}