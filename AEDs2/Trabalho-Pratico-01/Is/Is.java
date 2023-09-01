
/*
 * Crie um método iterativo que recebe uma string e retorna true se a mesma é composta somente por vogais. Crie outro método iterativo que recebe uma string e retorna true se a mesma é composta somente por consoantes. Crie um terceiro método iterativo que recebe uma string e retorna true se a mesma corresponde a um número inteiro. Crie um quarto método iterativo que recebe uma string e retorna true se a mesma corresponde a um número real.

Na saída padrão, para cada linha de entrada, escreva outra de saída da seguinte forma X1 X2 X3 X4 onde cada Xi é um booleano indicando se a é entrada é: composta somente por vogais (X1); composta somente somente por consoantes (X2); um número inteiro (X3); um número real (X4). Se Xi for verdadeiro, seu valor será SIM, caso contrário, NÃO.
 */
public class Is {
    public static boolean IsVogal(String fra){

        boolean is = true;
        for(int i=0; i < fra.length(); i++){
            if((fra.charAt(i) >= 97 && fra.charAt(i) <= 122) || (fra.charAt(i) >= 65 && fra.charAt(i) <= 90)){
                is = true;
                if(fra.charAt(i) != 'a' || fra.charAt(i) != 'e'|| fra.charAt(i) != 'i'|| fra.charAt(i) != 'o'|| fra.charAt(i) != 'u'|| fra.charAt(i) != 'A'|| fra.charAt(i) != 'E'|| 
                fra.charAt(i) != 'I'|| fra.charAt(i) != 'O'|| fra.charAt(i) != 'U'){
                    is = false;
                }
            }else{
                is = false;
            }
        }

        return is;
    }

    public static boolean IsConsoante(String fra){

        boolean is = true;
        for(int i=0; i < fra.length(); i++){
            if(fra.charAt(i) >= 65 && fra.charAt(i) <= 90 || fra.charAt(i) >= 97 && fra.charAt(i) <= 122){
                if(fra.charAt(i) == 'a' || fra.charAt(i) == 'e'|| fra.charAt(i) == 'i'|| fra.charAt(i) == 'o'|| fra.charAt(i) == 'u'|| fra.charAt(i) == 'A'|| fra.charAt(i) == 'E'|| 
                    fra.charAt(i) == 'I'|| fra.charAt(i) == 'O'|| fra.charAt(i) == 'U'){
                    is = false;
                }
            }else{
                is = false;
            }
        }

        return is;
    }

    public static boolean IsInt(String fra){
        boolean is = false;
        for(int i=0; i < fra.length(); i++){
            if(fra.charAt(i) == '0' || fra.charAt(i) == '1'|| fra.charAt(i) == '2'|| fra.charAt(i) == '3'|| fra.charAt(i) == '4'|| fra.charAt(i) == '5'|| fra.charAt(i) == '6'|| 
                        fra.charAt(i) == '7'|| fra.charAt(i) == '8'|| fra.charAt(i) == '9'){
                            is = true;
                        }
        }
                            for(int i=0; i < fra.length(); i++){
                                if(fra.charAt(i) == ',' ||fra.charAt(i) == '.'){
                                    is = false;
                        }
                    }
        return is;
    }

    public static boolean IsReal(String fra){
        boolean is = false;
        int count = 0;
        for(int i=0; i < fra.length(); i++){
            if(fra.charAt(i) == '0' || fra.charAt(i) == '1'|| fra.charAt(i) == '2'|| fra.charAt(i) == '3'|| fra.charAt(i) == '4'|| fra.charAt(i) == '5'|| fra.charAt(i) == '6'|| 
                        fra.charAt(i) == '7'|| fra.charAt(i) == '8'|| fra.charAt(i) == '9'){
                            is = true;
                        } 
                    }
        for(int i=0; i < fra.length(); i++){
            if(fra.charAt(i) == ',' ||fra.charAt(i) == '.'){
                count++;
            }
        }
        if(count>1){
            is = false;
        }
        return is;
    }

    public static void main(String[] args) {
        while (true) {
            String fra = MyIO.readLine();
            if(fra.compareTo("FIM") == 0){
                break;
            }else{
                String resp = "";
                if(IsVogal(fra) == true){
                    resp += "SIM";
                }else{
                    resp += "NAO";
                }
                if(IsConsoante(fra) == true){
                    resp += " SIM";
                }else{
                    resp += " NAO";
                }
                if(IsInt(fra) == true){
                    resp += " SIM";
                }else{
                    resp += " NAO";
                }
                if(IsReal(fra) == true){
                    resp += " SIM";
                }else{
                    resp += " NAO";
                }
                System.out.println(resp);                      
            }
        }
    }
}
