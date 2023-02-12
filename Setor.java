import java.util.Random;
public class Setor {
    /* 0-normal, 1-oculto, 2-privado, 3-C, 4-X */
    protected int tipo;
    /* true porta, false parede */
    protected boolean cima, baixo, esq, dir;
    /* passou 0-n, 1-s */
    protected boolean passou;

    Setor(int i, int j){
        this.setTipo();
        this.setPassou(false);

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
            case 23:
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
                    
            }   

        
    }
    
    public int getTipo(){
        return this.tipo;
    }

    public boolean getPassou(){
        return this.passou;
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
        
}
