public class Banner {
    protected char[] banner;

    Banner(){
        this.setBanner();

    }

    public char[] getBanner(){
        return this.banner;
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

    public void atualizarSetor(Player P, Tabuleiro tab){
        if(P instanceof PlayerSimples){
            int idx = 4 * 32 + 4;
            if(tab.getSetor(P.getX(), P.getY()).getEsq())
                this.banner[idx] = '*';
            else
                this.banner[idx] = '|';
        
            idx = 32 + 1 +7;

            if(tab.getSetor(P.getX(), P.getY()).getCima())
                this.banner[idx] = '*';
            else
                this.banner[idx] = '-';

            idx = 4* 32 + 4 + 14;

            if(tab.getSetor(P.getX(), P.getY()).getDir())
                this.banner[idx] = '*';
            else
                this.banner[idx] = '|';

            idx = 7 * 32 + 7 + 7;

            if(tab.getSetor(P.getX(), P.getY()).getBaixo())
                this.banner[idx] = '*';
            else
                this.banner[idx] = '-';


        }else{

            int idx = 4 * 32 + 4 + 16;
            if(tab.getSetor(P.getX(), P.getY()).getEsq())
                this.banner[idx] = '*';
            else
                this.banner[idx] = '|';
        
            idx = 32 + 1 + 7 + 16;

            if(tab.getSetor(P.getX(), P.getY()).getCima())
                this.banner[idx] = '*';
            else
                this.banner[idx] = '-';

            idx = 4* 32 + 4 + 14 + 16;

            if(tab.getSetor(P.getX(), P.getY()).getDir())
                this.banner[idx] = '*';
            else
                this.banner[idx] = '|';

            idx = 7 * 32 + 7 + 7 + 16;

            if(tab.getSetor(P.getX(), P.getY()).getBaixo())
                this.banner[idx] = '*';
            else
                this.banner[idx] = '-';

        }
    }

    public void apagarInimigos(Player P){
        if(P instanceof PlayerSimples){
            int idx = 2*32+2+2;
            for(int i = 0; i < 3; i++){
                this.banner[idx++] = ' ';
                this.banner[idx++] = ' ';
                this.banner[idx] = ' ';
                idx+=2;
                
            }
        }else{
            int idx = 2*32+2+2+16;
            for(int i = 0; i < 3; i++){
                this.banner[idx++] = ' ';
                this.banner[idx++] = ' ';
                this.banner[idx] = ' ';
                idx+=2;
                
            }
        }
    }

    public void atualizarInimigos(Setor setor, Player P){

        if(P instanceof PlayerSimples || setor.getPlayers() == 2){
            this.apagarInimigos(P);
            int idx = 2*32+2+2;
            int numeroInimigos = setor.getNumeroInimigos();
            for(int i = 0; i < numeroInimigos; i++){
                Integer atk = setor.getInimigo(i).getAtk(), def = setor.getInimigo(i).getDef() ;
                this.banner[idx++] = atk.toString().toCharArray()[0];
                this.banner[idx++] = '/';
                this.banner[idx] = def.toString().toCharArray()[0];
                idx+=2;
                
            }
        }
        if(P instanceof PlayerSuporte || setor.getPlayers() == 2){
            this.apagarInimigos(P);
            int idx = 2*32+2+2+16;
            int numeroInimigos = setor.getNumeroInimigos();
            for(int i = 0; i < numeroInimigos; i++){
                Integer atk = setor.getInimigo(i).getAtk(), def = setor.getInimigo(i).getDef() ;
                this.banner[idx++] = atk.toString().toCharArray()[0];
                this.banner[idx++] = '/';
                this.banner[idx] = def.toString().toCharArray()[0];
                idx+=2;
                
            }
        }

    }

    public void atualizarDefPlayer(Player P){
        if(P instanceof PlayerSimples){
            Integer def = P.getDef();
            this.banner[200 + 2] = def.toString().toCharArray()[0];

        }else{
            Integer def = P.getDef();
            this.banner[200 + 18] = def.toString().toCharArray()[0];
        }
    }

}