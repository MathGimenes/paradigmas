import java.util.Random;
public class Tabuleiro {
    protected Setor[][] tabuleiro;
    protected char[] representacaoGrafica;
    Tabuleiro() {
        this.tabuleiro = new Setor[5][5];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                this.tabuleiro[i][j] = new Setor(i, j);
            }
        }

        this.tabuleiro[2][2].setTipo(3);
        
        Random gerador = new Random();
        int x = gerador.nextInt(2);
        int y = gerador.nextInt(2);
        while (x == 2 && y == 2){
            x = gerador.nextInt(2);
            y = gerador.nextInt(2);
        }
        this.tabuleiro[x][y].setTipo(4);

        this.setRepresentacaoGrafica();
    }


    public void setRepresentacaoGrafica(){
    String tmp = "";
    for(int i = 0; i < 11; i++){
        for(int j = 0; j < 21; j++){
            if(j % 4 == 0)
                tmp = tmp.concat("|");
            else if(i % 2 == 0)
                tmp = tmp.concat("-");
            else
                tmp = tmp.concat(" ");
        }
        tmp = tmp.concat("\n");
    }
    this.representacaoGrafica = tmp.toCharArray();
    this.representacaoGrafica[6*21+6+10]= '*';
    this.representacaoGrafica[4*21+4+10]= '*';
    this.representacaoGrafica[5*21+5+8]= '*';
    this.representacaoGrafica[5*21+5+10]= 'C';
    this.representacaoGrafica[5*21+5+12]= '*';
    }

    public void desenhar(){
        System.out.println(this.representacaoGrafica);
    }
}