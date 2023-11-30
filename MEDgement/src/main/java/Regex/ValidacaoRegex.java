/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author miche
 */
public class ValidacaoRegex {
    
    public boolean validarCep(String cep){
        Pattern p = Pattern.compile("^[0-9]{2}(\\.?)[0-9]{3}(-?)[0-9]{3}$");
        Matcher m = p.matcher(cep);
        Boolean b = m.matches();
        return b;
    }
    
    public boolean validarCNPJ(String cnpj){
        Pattern p = Pattern.compile("([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})");
        Matcher m = p.matcher(cnpj);
        Boolean b = m.matches();
        return b;
    }
    
    public boolean validarInsEst(String InsEst){
        Pattern p = Pattern.compile("^[\\\\p{L}\\\\s'-]{1,45}$");
        Matcher m = p.matcher(InsEst);
        Boolean b = m.matches();
        return b;
    }
    
    public boolean validarNome(String nome){
        Pattern p = Pattern.compile("^[A-Za-z ']{1,35}$");
        Matcher m = p.matcher(nome);
        Boolean b = m.matches();
        return b;
    }
    
    public boolean validarSenha(String senha){
        Pattern p = Pattern.compile("^[A-Za-zÀ-ÿ0-9\\\\p{Punct} ]{1,20}$");
        Matcher m = p.matcher(senha);
        Boolean b = m.matches();
        return b;
    }
    
    public boolean validarCPF(String cpf){
        Pattern p = Pattern.compile("\\\\d{3}\\\\.\\\\d{3}\\\\.\\\\d{3}-\\\\d{2}");
        Matcher m = p.matcher(cpf);
        Boolean b = m.matches();
        return b;
    }
    
    public boolean validarCargo(String cargo){
        Pattern p = Pattern.compile("^[\\\\p{L}\\\\s'-]{1,45}$");
        Matcher m = p.matcher(cargo);
        Boolean b = m.matches();
        return b;
    }
    
    public boolean validarRua(String rua){
        Pattern p = Pattern.compile("^[\\\\p{L}\\\\d\\\\s'-]{1,35}$");
        Matcher m = p.matcher(rua);
        Boolean b = m.matches();
        return b;
    }
    
    public boolean validarNum(String num){
        Pattern p = Pattern.compile("^\\\\d{1,6}[A-Za-z]?$");
        Matcher m = p.matcher(num);
        Boolean b = m.matches();
        return b;
    }
    
    public boolean validarComplemento(String compl){
        Pattern p = Pattern.compile("^(|.{1,35})$");
        Matcher m = p.matcher(compl);
        Boolean b = m.matches();
        return b;
    }
    
    public boolean validarBairro(String bairro){
        Pattern p = Pattern.compile("^[\\\\p{L}\\\\d\\\\s'-]{1,35}$");
        Matcher m = p.matcher(bairro);
        Boolean b = m.matches();
        return b;
    }
    
    public boolean validarUF(String uf){
        Pattern p = Pattern.compile("^[A-Z]{2}$");
        Matcher m = p.matcher(uf);
        Boolean b = m.matches();
        return b;
    }
    
    public boolean validarValor(String valor){
        Pattern p = Pattern.compile("^\\\\d{1,10},\\\\d{2}$");
        Matcher m = p.matcher(valor);
        Boolean b = m.matches();
        return b;
    }
    
    public boolean validarEstoque(String est){
        Pattern p = Pattern.compile("^\\\\d{1,7}$");
        Matcher m = p.matcher(est);
        Boolean b = m.matches();
        return b;
    }
    
    public boolean validarData(String data){
        Pattern p = Pattern.compile("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec)))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)(?:0?2|(?:Feb))\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
        Matcher m = p.matcher(data);
        Boolean b = m.matches();
        return b;
    }
    
    public boolean validarNumNf(String numNf){
        Pattern p = Pattern.compile("^\\\\d{1,9}$");
        Matcher m = p.matcher(numNf);
        Boolean b = m.matches();
        return b;
    }
    
    
    
}
