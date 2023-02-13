import java.util.Random;
public class Setor {
    /* 0-normal, 1-oculto, 2-privado, 3-C, 4-X */
    protected int tipo, players, numeroInimigos;
    /* true porta, false parede */
    protected boolean cima, baixo, esq, dir;
    /* passou 0-n, 1-s */
    protected boolean passou;

    protected Inimigo[] inimigos;

    Setor(int i, int j){
        this.setTipo();
        this.setPassou(false);
        this.setPlayers(0);

        int pos = i * 5 + j;
        switch(pos){
            case 0:
            case 15:
            case 18:
                this.baixo = true;
                this.dir = true;
                break;
            
            case 1:
            case 2:
                this.esq = true;
                this.baixo = true;
                this.dir = true;
                break;
            
            case 3:
            case 21:
            case 22:
                this.esq = true;
                this.dir = true;
                break;

            case 4:
            case 24:
                this.esq = true;
                break;

            case 5:
            case 6:
            case 7:
                this.cima = true;
                this.baixo = true;
                break;
            
            case 8:
            case 9:
                this.baixo = true;
                break;
            
            case 10:
            case 17:
                this.cima = true;
                break;
            
            case 11:
            
                this.cima = true;
                this.dir = true;
                this.baixo = true;
                break;

            case 12:
            
                this.cima = true;
                this.dir = true;
                this.baixo = true;
                this.esq = true;
                break;
            
            case 13:
            case 23:

                this.cima = true;
                this.esq = true;
                this.dir = true;
                break;

            case 14:
                
                this.cima = true;
                this.esq = true;
                this.baixo = true;
                break;

            case 16:
            case 19:

                this.cima = true;
                this.esq = true;
                break;

            case 20:

                this.cima = true;
                this.dir = true;
                break;
                    
            }   

        
    }
    
    public int getTipo(){
        return this.tipo;
    }

    public boolean getPassou(){
        return this.passou;
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

    public int getPlayers(){
        return this.players;
    }

    public int getNumeroInimigos(){
        return this.numeroInimigos;
    }


    public void setTipo(){
        Random gerador = new Random();
        this.tipo = gerador.nextInt(2);
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
        int numeroInimigos = gerador.nextInt(2) + 1;
        this.numeroInimigos = numeroInimigos;
        this.inimigos = new Inimigo[numeroInimigos];
        
        for(int i = 0; i < numeroInimigos; i++){
            inimigos[i] = new Inimigo();
        }
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
        
}
