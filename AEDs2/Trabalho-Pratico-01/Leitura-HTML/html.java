import java.io.*;
import java.net.*;

class html {
   public static String getHtml(String endereco){
      URL url;
      InputStream is = null;
      BufferedReader br;
      String resp = "", line;

      try {
         url = new URL(endereco);
         is = url.openStream();  // throws an IOException
         br = new BufferedReader(new InputStreamReader(is));

         while ((line = br.readLine()) != null) {
            resp += line + "\n";
         }
      } catch (MalformedURLException mue) {
         mue.printStackTrace();
      } catch (IOException ioe) {
         ioe.printStackTrace();
      } 

      try {
         is.close();
      } catch (IOException ioe) {
         // nothing to see here

      }

      return resp;
   }

   public static void main(String[] args) {
         while(true){
            String nome, endereco, html;
            nome = MyIO.readLine();

            int con=0, a=0, e=0, in=0, o=0, u=0, aa=0, ee=0, ii=0, oo=0, uu=0, aaa=0, eee=0, iii=0, ooo=0, uuu=0, at=0, ot=0, ac=0, ec=0, ic=0, oc=0, uc=0, br=0, table=0;
            if(nome.compareTo("FIM") == 0){
               break;
            }else{
               endereco = MyIO.readLine();
               html = getHtml(endereco);
               for(int i = 0; i < html.length(); i++){
                  if(html.charAt(i) == '\u0061'){
                     a += 1;
                  }
                  else if(html.charAt(i) == '\u0065'){
                     e += 1;
                  }
                  else if(html.charAt(i) == '\u0069'){
                     in += 1;
                  }
                  else if(html.charAt(i) == '\u006f'){
                     o += 1;
                  }
                  else if(html.charAt(i) == '\u0075'){
                     u += 1;
                  }
                  else if(html.charAt(i) == '\u00e1' ){
                     aa += 1;
                  }
                  else if(html.charAt(i) == '\u00e9'){
                     ee += 1;
                  }
                  else if(html.charAt(i) == '\u00ed'){
                     ii += 1;
                  }
                  else if(html.charAt(i) == '\u00f3'){
                     oo += 1;
                  }
                  else if(html.charAt(i) == '\u00fa'){
                     uu += 1;
                  }
                  else if(html.charAt(i) == '\u00e0'){
                     aaa += 1;
                  }
                  else if(html.charAt(i) == '\u00e8'){
                     eee += 1;
                  }
                  else if(html.charAt(i) == '\u00ec'){
                     iii += 1;
                  }
                  else if(html.charAt(i) == '\u00f2'){
                     ooo += 1;
                  }
                  else if(html.charAt(i) == '\u00f9'){
                     uuu += 1;
                  }
                  else if(html.charAt(i) == '\u00e3'){
                     at += 1;
                  }
                  else if(html.charAt(i) == '\u00f5'){
                     ot += 1;
                  }
                  else if(html.charAt(i) == '\u00e2'){
                     ac += 1;
                  }
                  else if(html.charAt(i) == '\u00ea'){
                     ec += 1;
                  }
                  else if(html.charAt(i) == '\u00ee'){
                     ic += 1;
                  }
                  else if (html.charAt(i) == '<' && html.charAt((i+1)) == 't' && html.charAt((i+2)) == 'a' && html.charAt((i+3)) == 'b' && html.charAt((i+4)) == 'l' && html.charAt((i+5)) == 'e' && html.charAt((i+6)) == '>') {
                     table += 1;  
                     con -= 3;
                     e -= 1;
                     a -= 1;
                  }
                  else if(html.charAt(i) == '\u00f4'){
                     oc += 1;
                  }
                  else if(html.charAt(i) == '\u00fb'){
                     uc += 1;
                  }
                  else if (html.charAt(i) == '<' && html.charAt((i+1)) == 'b' && html.charAt((i+2)) == 'r' && html.charAt((i+3)) == '>'){
                     br++;
                  }
                  else if ((html.charAt(i) >= 'a' && html.charAt(i) <= 'z'))  {
                     con += 1;
                  }
               }
               MyIO.println("a("+ a +") e("+e+") i("+in+") o("+o+") u("+u+") á("+aa+") é("+ee+") í("+ii+") ó("+oo+") ú("+uu+") à("+aaa+") è("+eee+") ì("+iii+") ò("+ooo+") ù("+uuu+") ã("+ooo+") õ("+ooo+") â("+ac+") ê("+ec+") î("+ic+") ô("+oc+") û("+uc+") consoante("+con+") <br>("+br+") <table>("+table+") " +nome);
           }
        }
    }
}