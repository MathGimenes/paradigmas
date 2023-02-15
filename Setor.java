import java.util.*;
public class Setor {
    /* 0-normal, 1-oculto, 2-privado, 3-C, 4-X */
    protected int tipo, players, numeroInimigos;
    /* true porta, false parede */
    protected boolean cima, baixo, esq, dir;
    /* passou 0-n, 1-s */
    protected boolean passou;

    protected ArrayList<Inimigo> inimigos;

    Setor(int i, int j){
        this.setTipo();
        this.setPassou(false);
        this.setPlayers(0);

        int pos = i * 5 + j;
        switch(pos){
            case 0:
            case 15:
            case 18:
                this.setBaixo(true);
                this.setDir(true);
                break;
            
            case 1:
            case 2:
                this.setEsq(true);
                this.setBaixo(true);
                this.setDir(true);
                break;
            
            case 3:
            case 21:
            case 22:
                this.setEsq(true);
                this.setDir(true);
                break;

            case 4:
            case 24:
                this.setEsq(true);
                break;

            case 5:
            case 6:
            case 7:
                this.setCima(true);
                this.setBaixo(true);
                break;
            
            case 8:
            case 9:
                this.setBaixo(true);
                break;
            
            case 10:
            case 17:
                this.setCima(true);
                break;
            
            case 11:
            
                this.setCima(true);
                this.setDir(true);
                this.setBaixo(true);
                break;

            case 12:
            
                this.setCima(true);
                this.setDir(true);
                this.setBaixo(true);
                this.setEsq(true);
                break;
            
            case 13:
            case 23:

                this.setCima(true);
                this.setEsq(true);
                this.setDir(true);
                break;

            case 14:
                
                this.setCima(true);
                this.setEsq(true);
                this.setBaixo(true);
                break;

            case 16:
            case 19:

                this.setCima(true);
                this.setEsq(true);
                break;

            case 20:

                this.setCima(true);
                this.setDir(true);
                break;
                    
            }   

        
    }
    
    public int getTipo(){
        return this.tipo;
    }

    public int getPlayers(){
        return this.players;
    }

    public int getNumeroInimigos(){
        return this.numeroInimigos;
    }

    public boolean getCima(){
        return this.cima;
    }

    public boolean getEsq(){
        return this.esq;
    }

    public boolean getBaixo(){
        return this.baixo;
    }

    public boolean getDir(){
        return this.dir;
    }


    public boolean getPassou(){
        return this.passou;
    }

    public ArrayList<Inimigo> getInimigo(){
        return this.inimigos;
    }

    public Inimigo getInimigo(int idx){
        return this.inimigos.get(idx);
    }


    public void setTipo(){
        Random gerador = new Random();
        this.tipo = gerador.nextInt(3);
    }

    public void setTipo(int x){
        if(x == 3 || x == 4)
            this.tipo = x;
    }
    
    public void setPassou(boolean x){
        this.passou = x;
    }

    public void setInimigo(){
        Random gerador = new Random();
        int numeroInimigos = gerador.nextInt(3) + 1;
        this.numeroInimigos = numeroInimigos;
        this.inimigos = new ArrayList<Inimigo>(numeroInimigos);
        
        for(int i = 0; i < numeroInimigos; i++){
            this.inimigos.add(new Inimigo());
        }
    }

    public void setNumeroInimigos(int num){
        this.numeroInimigos = num;
    }

    public void setInimigo(ArrayList<Inimigo> novo){
        this.inimigos = novo;
    
    }

    public void setCima(boolean cima){
        this.cima = cima;
    }

    public void setBaixo(boolean baixo){
        this.baixo = baixo;
    }

    public void setEsq(boolean esq){
        this.esq = esq;
    }

    public void setDir(boolean dir){
        this.dir = dir;
    }

    public void setPlayers(int x){
        this.players = x;
    }
    
    /* true aumenta, false diminui */
    public void updatePlayers(boolean x){
        int tmp = this.getPlayers();
        if(x)
            tmp++;
        else
            tmp--;
        this.setPlayers(tmp);
    }

    public void removerInimigo(int inimigo, int numeroInimigos){
        this.inimigos.remove(inimigo);
        this.setNumeroInimigos(numeroInimigos - 1);
    }
        
}
