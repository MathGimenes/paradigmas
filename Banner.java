public class Banner {
    protected char[] banner;

    Banner(){
        this.setBanner();

    }

    public void setBanner(){
        String tmp = "";
        tmp = tmp.concat("  Setor (3,3)   ");
        tmp = tmp.concat("  Setor (3,3)   \n");
        for(int i = 0; i < 7; i++){
            for(int k = 0; k < 2; k++){
                for(int j = 0; j < 15; j++){
                    if(j % 14 == 0)
                        if(i == 3)
                            tmp = tmp.concat("*");
                        else
                            tmp = tmp.concat("|");
                    else if(i % 6 == 0)
                        if(j == 7)
                            tmp = tmp.concat("*");
                        else
                            tmp = tmp.concat("-");
                    else
                        tmp = tmp.concat(" ");
                }
                tmp = tmp.concat(" ");  
        }
            tmp = tmp.concat("\n");            
        }
        this.banner = tmp.toCharArray();
        
        this.banner[167] = 'P';
        this.banner[167 + 1] = '1';
        this.banner[167 + 16] = 'P';
        this.banner[167 + 17] = '2';

        this.banner[200] = '2';
        this.banner[200 + 1] = '/';
        this.banner[200 + 2] = '6';
        this.banner[200 + 16] = '1';
        this.banner[200 + 17] = '/';
        this.banner[200 + 18] = '7';

        
    }

    public void desenhar(){
        System.out.println(this.banner);
    }

    public void atualizarCabecalho(Player P, Tabuleiro tab){
        if(P instanceof PlayerSimples){
            Integer tmp = P.getX() + 1;
            this.banner[9] = tmp.toString().toCharArray()[0];
            tmp = P.getY() + 1;
            this.banner[11] = tmp.toString().toCharArray()[0];
        }else{
            Integer tmp = P.getX() + 1;
            this.banner[25] = tmp.toString().toCharArray()[0];
            tmp = P.getY() + 1;
            this.banner[27] = tmp.toString().toCharArray()[0];
        }
    }

    public void atualizarInimigos(Setor setor, Player P){
        if(P instanceof PlayerSimples){
            int primeiro = 2*32+2+2;
            this.banner[primeiro] = 'T';
        }else{
            int primeiro = 2*32+2+2+16;
            this.banner[primeiro] = 'T';
        }

    }
}