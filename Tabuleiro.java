import java.util.Random;
public class Tabuleiro {
    protected Setor[][] tabuleiro;

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
    }

    public char desenharPortas(int x1, int y1, int x2, int y2, boolean ehLinha){
        if(this.tabuleiro[x1][y1].getPassou() || this.tabuleiro[x2][y2].getPassou())
            return '*';
        if (ehLinha)
            return '-';
        return '|';
    }

    public void desenhar(){
        System.out.println("|---|---|---|---|---|");

        System.out.println("|   " + this.desenharPortas(0, 0, 0, 1, false) +"   "+this.desenharPortas(0, 1, 0, 2, false)+"   "+this.desenharPortas(0, 2, 0, 3, false)+"   "+this.desenharPortas(0, 3, 0, 4, false)+"   |");
        System.out.println("|-"+this.desenharPortas(0, 0, 1, 0, true)+"-|-"+this.desenharPortas(0, 1, 1, 1, true)+"-|-"+this.desenharPortas(0, 2, 1, 2, true)+"-|---|---|");
        System.out.println("|   |   |   |   |   |");
        System.out.println("|-"+this.desenharPortas(1, 0, 2, 0, true)+"-|-"+this.desenharPortas(1, 1, 2, 1, true)+"-|-*-|-"+this.desenharPortas(1, 3, 2, 3, true)+"-|-"+this.desenharPortas(1, 4, 2, 4, true)+"-|");
        System.out.println("|   |   * C *   "+this.desenharPortas(2, 3, 2, 4, false)+"   |");
        System.out.println("|---|-"+this.desenharPortas(2, 1, 3, 1, true)+"-|-*-|---|-"+this.desenharPortas(2, 4, 3, 4, true)+"-|");
        System.out.println("|   "+this.desenharPortas(3, 0, 3, 1, false)+"   |   |   "+this.desenharPortas(3, 3, 3, 4, false)+"   |");
        System.out.println("|-"+this.desenharPortas(3, 0, 4, 0, true)+"-|---|---|-"+this.desenharPortas(3, 3, 4, 3, true)+"-|---|");
        System.out.println("|   "+this.desenharPortas(4, 0, 4, 1, false)+"   "+this.desenharPortas(4, 1, 4, 2, false)+"   "+this.desenharPortas(4, 2, 4, 3, false)+"   "+this.desenharPortas(4, 3, 4, 4, false)+"   |");
        
        System.out.println("|---|---|---|---|---|");
    }

    public void desenhar(int x){
    //     for(int j = 0; j < 11;j++){
    //         if(j %2 == 0){
    //             for(int i = 0; i < 5; i++){
    //                 System.out.print("|---");
    //             }
    //             System.out.println("|");
    //         }else{
    //             for(int i = 0; i < 5; i++){
    //                 System.out.print("|   ");
    //             }
    //             System.out.println("|");
    //         }
    //     }

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
    char[] tmp2 = tmp.toCharArray();
    tmp2[6*21+6+10]= '*';
    tmp2[4*21+4+10]= '*';
    tmp2[5*21+5+8]= '*';
    tmp2[5*21+5+10]= 'C';
    tmp2[5*21+5+12]= '*';
    tmp2[24+44*2+4*3] = 'P';
    System.out.print(tmp2);
    }
}