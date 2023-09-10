public class AlgebraBool {

    static boolean[] analiseElementos(String frase) {
        int tamanho = 0;
        if (frase.charAt(0) == '1') {
            tamanho = 1;

        } else if (frase.charAt(0) == '2') {
            tamanho = 2;

        } else if (frase.charAt(0) == '3') {
            tamanho = 3;

        }

        boolean[] arraybool = new boolean[tamanho];
        int count = 0;
        for (int i = 0; i < tamanho * 2 + 1; i++) {

            if (frase.charAt(i) == '1') {
                arraybool[count] = true;
                count++;
            } else if (frase.charAt(i) == '0') {
                arraybool[count] = false;
                count++;
            }

        }

        return arraybool;
    }

    public static void main(String[] args) {
        boolean arraybool[];
        while (true) {
            String frase = MyIO.readLine();

            if (igual(frase)) {

                break;
            }

            arraybool = analiseElementos(frase); 
            frase = funcIntermed(frase, arraybool); 

            frase = logicIntermed(frase);

            MyIO.println(frase);

        }

    }

    public static String logicIntermed(String frase) {

        int operadores = 0;

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == '^' || frase.charAt(i) == 'V' || frase.charAt(i) == '!') {

                operadores++;
            }
        }

        int[] array = new int[operadores];

        operadores--;
        int count = operadores; 

        for (int i = frase.length() - 1; i >= 0; i--) { 
            if (frase.charAt(i) == '^' || frase.charAt(i) == 'V' || frase.charAt(i) == '!') {
                array[count] = i;
                count--;
            }
        }

        while (operadores >= 0) {
            if (frase.charAt(array[operadores]) == '^') {
                frase = andElement(frase, array[operadores]);
            } else if (frase.charAt(array[operadores]) == 'V') {
                frase = OrElement(frase, array[operadores]);
            } else if (frase.charAt(array[operadores]) == '!') {
                frase = notElementSingle(frase, array[operadores]);
            }

            operadores--;
        }

        return frase;
    }

    public static String andElement(String frase, int index) {
        String newFrase = "";
        int i = 0;
        int aux = index;

        while (i < frase.length()) {

            if (i == index) {
                int count = 0;
                int positivo = 0;

                while (frase.charAt(index) != ')') {
                    if (isnumber(frase.charAt(index))) {
                        count++;
                        if (frase.charAt(index) == '1') {
                            positivo++;
                        }

                    }
                    index++;
                }

                if (positivo == count) { 
                    newFrase += '1';
                } else {
                    newFrase += '0';
                }

                i += count + 3;
            } else {
                newFrase += frase.charAt(i);
                i++;
            }
            index = aux;
        }

        return newFrase;
    }

    public static String notElementSingle(String frase, int index) { 
        String newFrase = "";
        int i = 0;
        int aux = index;

        while (i < frase.length()) {

            if (i == index) {
                int count = 0;

                while (frase.charAt(index) != ')') {
                    if (isnumber(frase.charAt(index))) {
                        count++;
                        if (frase.charAt(index) == '1') {
                            newFrase += '0';
                        } else if (frase.charAt(index) == '0') {
                            newFrase += '1';
                        }

                    } else {

                    }
                    index++;
                }

                i += count + 3;
            } else {
                newFrase += frase.charAt(i);
                i++;
            }
            index = aux;
        }

        return newFrase;
    }

    public static String OrElement(String frase, int index) {
        String newFrase = "";
        int i = 0;
        int aux = index;

        while (i < frase.length()) {

            if (i == index) {
                int count = 0;
                int positivo = 0;

                while (frase.charAt(index) != ')') {
                    if (isnumber(frase.charAt(index))) {
                        count++;
                        if (frase.charAt(index) == '1') {
                            positivo++;
                        }

                    }
                    index++;
                }

                if (positivo > 0) {
                    newFrase += '1';
                } else {
                    newFrase += '0';
                }

                i += count + 3;
            } else {
                newFrase += frase.charAt(i);
                i++;
            }
            index = aux;
        }

        return newFrase;
    }

    public static String limpandoString(String frase) { 
        String newfrase = "";
        int newindex = 0;
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == 'V' || frase.charAt(i) == '!' || frase.charAt(i) == '^') {
                newindex = i;
                break;
            }
            if (!clear(frase.charAt(i))) {
                newfrase += frase.charAt(i);
            }
        }

        for (int i = newindex; i < frase.length(); i++) {
            if (frase.charAt(i) == ' ' || frase.charAt(i) == ',') {

            } else {
                newfrase += frase.charAt(i);
            }
        }

        return newfrase;
    }

    public static String converterString(String frase, boolean[] arraybool) { 
        String newfrase = "";
        int tamanho = frase.length();
        int qtd = arraybool.length;

        if (qtd == 1) {
            for (int i = 0; i < tamanho; i++) {
                if (frase.charAt(i) == 'A') {
                    if (arraybool[0] == true) {
                        newfrase += '1';
                    } else {
                        newfrase += '0';
                    }
                } else {
                    newfrase += frase.charAt(i);
                }
            }
        } else if (qtd == 2) {
            for (int i = 0; i < tamanho; i++) {
                if (frase.charAt(i) == 'A') {
                    if (arraybool[0] == true) {
                        newfrase += '1';
                    } else {
                        newfrase += '0';
                    }
                } else if (frase.charAt(i) == 'B') {
                    if (arraybool[1] == true) {
                        newfrase += '1';
                    } else {
                        newfrase += '0';
                    }
                } else {
                    newfrase += frase.charAt(i);
                }
            }

        } else if (qtd == 3) {
            for (int i = 0; i < tamanho; i++) {
                if (frase.charAt(i) == 'A') {
                    if (arraybool[0] == true) {
                        newfrase += '1';
                    } else {
                        newfrase += '0';
                    }
                } else if (frase.charAt(i) == 'B') {
                    if (arraybool[1] == true) {
                        newfrase += '1';
                    } else {
                        newfrase += '0';
                    }
                } else if (frase.charAt(i) == 'C') {
                    if (arraybool[2] == true) {
                        newfrase += '1';
                    } else {
                        newfrase += '0';
                    }
                } else {
                    newfrase += frase.charAt(i);
                }
            }

        }
        return newfrase;
    }

    public static String funcIntermed(String frase, boolean[] arraybool) { 

        String newFrase = "";

        frase = equalsAnd(frase);
        frase = equalsNot(frase);
        frase = equalsOr(frase);
        frase = (converterString(frase, arraybool)); 
        frase = limpandoString(frase); 

        return frase;
    }

    public static String equalsNot(String frase) {

        int count = 0;
        String newfrase = "";

        for (int i = 0; i < frase.length(); i++) {

            if (frase.charAt(i) == 'n') {
                count++;
            } else if (frase.charAt(i) == 'o' && count == 1) {
                count++;
            } else if (frase.charAt(i) == 't' && count == 2) {
                newfrase += '!';
                count = 0;
            } else {
                newfrase += frase.charAt(i);
            }

        }
        return newfrase;
    }

    public static String equalsOr(String frase) {

        int count = 0;
        String newfrase = "";

        for (int i = 0; i < frase.length(); i++) {

            if (frase.charAt(i) == 'o') {
                count++;
            } else if (frase.charAt(i) == 'r' && count == 1) {
                count = 0;
                newfrase += 'V';
            } else {
                newfrase += frase.charAt(i);
            }

        }
        return newfrase;
    }

    public static String equalsAnd(String frase) {
        int count = 0;
        String newfrase = "";

        for (int i = 0; i < frase.length(); i++) {

            if (frase.charAt(i) == 'a') {
                count++;
            } else if (frase.charAt(i) == 'n' && count == 1) {
                count++;
            } else if (frase.charAt(i) == 'd' && count == 2) {
                newfrase += '^';
                count = 0;
            } else {
                newfrase += frase.charAt(i);
            }

        }
        return newfrase;
    }

    static boolean igual(String frase) {

        if (frase.length() == 1 && frase.charAt(0) == '0') {
            return true;
        } else {
            return false;
        }

    }

    static boolean clear(char c) { 
        if (c == '1' || c == '2' || c == '3' || c == '0' || c == ' ' || c == ',' || c == '.') {
            return true;
        }

        return false;
    }

    static boolean isnumber(char c) {
        if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9'
                || c == '0') {
            return true;
        }

        return false;
    }

}
