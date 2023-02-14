
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
    
    public void setAtk(int atk){
        this.atk = atk;
    }

    public abstract void setDef();
    public void setDef(int def){
        this.def = def;
    }

    public void setAcoes(){
        this.acoes = 2;
    }

    public void setXY(){
        this.x = 2;
        this.y = 2;
    }

    public boolean movimentar(Player P, String opcao, Tabuleiro tab){
        int x = P.getX();
        int y = P.getY();


        if(tab.getSetor(x, y).getPlayers() == 1)
            tab.apagarRastro(x, y);

        if(opcao.compareTo("w") == 0){
            System.out.println("cima");
            if(x == 0 || !(tab.getSetor(x, y).getCima())){
                return false;
            }
            else{
                this.x--;
                if(tab.getSetor(x, y).getPlayers() != 1)
                    tab.apagarRastro(x, y, P);
                tab.getSetor(x, y).updatePlayers(false);

                return true;
            }
        }
        if(opcao.compareTo("a") == 0){
            System.out.println("esq");
            if(y == 0 || !(tab.getSetor(x, y).getEsq())){
                return false;
            }
            else{
                this.y--;
                if(tab.getSetor(x, y).getPlayers() != 1)
                    tab.apagarRastro(x, y, P);
                tab.getSetor(x, y).updatePlayers(false);

                return true;
            }
        }
        if(opcao.compareTo("s") == 0){
            System.out.println("baixo");
            if(x == 4 || !(tab.getSetor(x, y).getBaixo())){
                return false;
            }
            else{
                this.x++;
                if(tab.getSetor(x, y).getPlayers() != 1)
                    tab.apagarRastro(x, y, P);
                tab.getSetor(x, y).updatePlayers(false);

                return true;
            }
            
        }
        if(opcao.compareTo("d") == 0){
            System.out.println("dir");
            if(y == 4 || !(tab.getSetor(x, y).getDir())){
                return false;
            }
            else{
                this.y++;
                if(tab.getSetor(x, y).getPlayers() != 1)
                    tab.apagarRastro(x, y, P);
                tab.getSetor(x, y).updatePlayers(false);

                return true;
            }
        }



        return false;
    }

    public void procurar(){
        
    }

    public void dano(int x){
        this.def = this.def - x;
    }

    public void atacar(){

    }
}