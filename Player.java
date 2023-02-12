
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

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public abstract void setAtk();

    public abstract void setDef();

    public void setAcoes(){
        this.acoes = 2;
    }

    public void setXY(){
        this.x = 2;
        this.y = 2;
    }

    public void movimentar(Player P, String opcao){
        int x = P.getX();
        int y = P.getY();
        if(opcao.compareTo("w") == 0){
            System.out.println("cima");
            if(x == 0)
                System.out.println("Deu nao");
            else{
                this.x--;
            }
        }
        if(opcao.compareTo("a") == 0){
            System.out.println("esq");
            if(y == 0)
                System.out.println("Deu nao");
            else{
                this.y--;
            }
        }
        if(opcao.compareTo("s") == 0){
            System.out.println("baixo");
            if(x == 4)
                System.out.println("Deu nao");
            else{
                this.x++;
            }
            
        }
        if(opcao.compareTo("d") == 0){
            System.out.println("dir");
            if(y == 4)
                System.out.println("Deu nao");
            else{
                this.y++;
            }
        }

}

    public void procurar(){
        
    }

    public void atacar(){

    }
}