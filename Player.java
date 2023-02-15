import java.util.*;
public abstract class Player implements Personagem{
    protected int atk, def, x, y, acoes;
    protected boolean atacado;

    Player(){
        this.setXY();
        this.setAcoes();
        this.setAtacado(false);
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

    public boolean getAtacado(){
        return this.atacado;
    }

    public abstract void setAtk();
    
    public void setAtk(int atk){
        this.atk = atk;
    }

    public abstract void setDef();
    public void setDef(int def){
        this.def = def;
    }

    public void setAtacado(boolean estado){
        this.atacado = estado;
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

    public void atacar(Setor setor, Scanner sc){
        int numeroInimigos = setor.getNumeroInimigos();
        if (numeroInimigos <= 0){
            System.out.println("Setor vazio");
            return;
        }
        for(int i = 0; i < numeroInimigos; i++){
            System.out.println((i + 1) + "- Inimigo " + (i + 1));
        }
        boolean flag = true;
        String tmp;
        int opcao;
        while(flag){
            tmp = sc.next();
            opcao = Integer.parseInt(tmp);
            if(opcao < 1 || opcao > numeroInimigos){
                System.out.println("Opcao invalida, selecione novamente.");
            }else{
                setor.getInimigo(opcao - 1).dano(this.atk);
                if (setor.getInimigo(opcao - 1).getDef() <= 0){
                    setor.removerInimigo((opcao - 1), numeroInimigos, setor);
                }

                flag = false;
            }

        }
    }

    public void procurar(Setor setor, Banner banner){
        Random gerador = new Random();
        int sorteado = gerador.nextInt(6) + 1;
        if(sorteado == 4){
            System.out.println("+1 de defesa");
            int def = this.getDef();
            this.setDef(def + 1);
        }else if(sorteado == 5){
            System.out.println("+2 de defesa");
            int def = this.getDef();
            this.setDef(def + 2);
        }else if (sorteado == 6){
            System.out.println("Todos os inimigos perdem 1 de defesa");
            int numeroInimigos = setor.getNumeroInimigos();
            for(int i = 0; i < numeroInimigos; i++){
                Inimigo tmp = setor.getInimigo(i);
                tmp.dano(1);
                if (tmp.getDef() <= 0){
                    setor.removerInimigo(i, numeroInimigos, setor);
                    numeroInimigos--;
                }
                banner.atualizarInimigos(setor, this);



            }
            banner.desenhar();

        }else{
            System.out.println("Nada encontrado");

        }
        
    }

    public void dano(int x){
        this.def = this.def - x;
    }


}