package views;

import java.util.InputMismatchException;

/**
 *
 * @author luism
 */
public class ValidaCPF {
    public static boolean Validar(String CPF){
        
        CPF = CPF.replace(".", "");
        CPF = CPF.replace("-", "");
        
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return(false);
          
        char dig10, dig11;
        int soma, i, r, num, peso;
          
        try {
        
            soma = 0;
            peso = 10;
            for (i=0; i<9; i++) {              
      
            num = (int)(CPF.charAt(i) - 48); 
            soma = soma + (num * peso);
            peso = peso - 1;
            }
          
            r = 11 - (soma % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); 
            
            soma = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            soma = soma + (num * peso);
            peso = peso - 1;
            }
          
            r = 11 - (soma % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);
          
        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(true);
            else return(false);
                } catch (InputMismatchException erro) {
                return(false);
            }
    }
}
