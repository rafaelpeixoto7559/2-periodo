//Refaça a questão Is de forma recursiva.

public class IsRecursivo {

    public static boolean IsVogal(String fra, boolean was){
        
        if(fra.length() > 0){
            boolean is = true;
            if((fra.charAt(0) >= 97 && fra.charAt(0) <= 122) || (fra.charAt(0) >= 65 && fra.charAt(0) <= 90)){
                is = true;
                if(fra.charAt(0) != 'a' && fra.charAt(0) != 'e'&& fra.charAt(0) != 'i'&& fra.charAt(0) != 'o'&& fra.charAt(0) != 'u'&& fra.charAt(0) != 'A'&& fra.charAt(0) != 'E'&& 
                fra.charAt(0) != 'I'&& fra.charAt(0) != 'O'&& fra.charAt(0) != 'U'){
                    is = false;
                }
            }else{
                is = false;
            }
            is = IsVogal(fra.substring(1), is);
            return is;
        }
        else{
            return was;
        }
    }

    public static boolean IsConsoante(String fra, boolean was){
        if(fra.length() > 0){
            boolean is = true;
            if(fra.charAt(0) >= 65 && fra.charAt(0) <= 90 || fra.charAt(0) >= 97 && fra.charAt(0) <= 122){
                if(fra.charAt(0) != 'a' && fra.charAt(0) != 'e'&& fra.charAt(0) != 'i'&& fra.charAt(0) != 'o'&& fra.charAt(0) != 'u'&& fra.charAt(0) != 'A'&& fra.charAt(0) != 'E'&& 
                fra.charAt(0) != 'I'&& fra.charAt(0) != 'O'&& fra.charAt(0) != 'U'){
                    is = true;
                }
            }else{
                is = false;
            }
            is = IsConsoante(fra.substring(1), is);
            return is;
        }
        return was;
    }

    public static boolean IsInt(String fra, boolean was){
        
        if(fra.length() > 0){
            boolean is = false;
            if(fra.charAt(0) >= '0' && fra.charAt(0) <= '9'){
                is = true;
            }
            if(fra.charAt(0) == ',' ||fra.charAt(0) == '.'){
                is = false;
            }
            is = IsInt(fra.substring(1), is);
            return is;
        }
        return was;
    }

    public static boolean IsReal(String fra, boolean was){
        if(fra.length() > 0){
            boolean is = false;
            if(fra.charAt(0) >= '0' && fra.charAt(0) <= '9'){
                is = true;
            }
            if(fra.charAt(0) == ',' ||fra.charAt(0) == '.'){
                is = false;
            }
            is = IsReal(fra.substring(1), is);
            return is;
        }
        return was;
    }

    public static void main(String[] args) {
        while (true) {
            String fra = MyIO.readLine();
            if(fra.compareTo("FIM") == 0){
                break;
            }else{
                String resp = "";
                if(IsVogal(fra, false) == true){
                    resp += "SIM";
                }else{
                    resp += "NAO";
                }
                if(IsConsoante(fra, false) == true){
                    resp += " SIM";
                }else{
                    resp += " NAO";
                }
                if(IsInt(fra, false) == true){
                    resp += " SIM";
                }else{
                    resp += " NAO";
                }
                if(IsReal(fra, false) == true){
                    resp += " SIM";
                }else{
                    resp += " NAO";
                }
                System.out.println(resp);                      
            }
        }
    }
    
}