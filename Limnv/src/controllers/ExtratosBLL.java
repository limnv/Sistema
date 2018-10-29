package controllers;

import java.util.*;
import models.*;

/**
 *
 * @author luism
 */
public class ExtratosBLL {
    
    private static List<Extrato> depositos, pagamentos, saques, transferencias, extratos;
    
    private static ExtratoArvore arvore;
    
    private static void GeraExtrato(String DataInicial, String DataFinal){                
        
        depositos = DepositoBLL.ObterListaPorData(DataInicial, DataFinal);
        pagamentos = PagamentosBLL.ObterListaPorData(DataInicial, DataFinal);
        saques = SaquesBLL.ObterListaPorData(DataInicial, DataFinal);
        transferencias = TransferenciasBLL.ObterListaPorData(DataInicial, DataFinal);    
        
    } 
    
    private static ExtratoArvore GeraArvore(ExtratoArvore arv_atual, ExtratoArvore sub_arv, Extrato e){
        if(sub_arv == null) {
            try {
                sub_arv = new ExtratoArvore();
                sub_arv.setEsquerda(null);
                sub_arv.setDireita(null);
                sub_arv.setDado(e);
                
                if(arv_atual == null){
                    return sub_arv;
                }                
                
                if(e.getData().compareTo(arv_atual.getDado().getData()) < 0){
                    arv_atual.setEsquerda(sub_arv);
                } else {
                    arv_atual.setDireita(sub_arv);
                }
                return sub_arv;
            }
            catch (Exception ex){
                return null;
            }
        }
                
        if(e.getData().compareTo(sub_arv.getDado().getData()) < 0){
            GeraArvore(sub_arv, sub_arv.getEsquerda(), e);
        } else {
            GeraArvore(sub_arv, sub_arv.getDireita(), e);
        }
        return null;
    }
    
    private static void InserirArvore(Extrato e){
        if (arvore == null){
                arvore = GeraArvore(arvore, arvore, e);
        } else {
            GeraArvore(arvore, arvore, e);
        }
    }
    
    private static void Percorrer_EmOrdem(ExtratoArvore arv){
        if (arv != null){
            Percorrer_EmOrdem(arv.getEsquerda());
            extratos.add(arv.getDado());
            Percorrer_EmOrdem(arv.getDireita());
        }
    }
        
    public static List<Extrato> ObterListaExtrato(String DataInicial, String DataFinal){
        arvore = null;
        GeraExtrato(DataInicial, DataFinal);
        
        for (int i = 0; i < depositos.size(); i++) {
            Extrato get = depositos.get(i);
            
            InserirArvore(get);
            
        }
           
        for (int i = 0; i < pagamentos.size(); i++) {
            Extrato get = pagamentos.get(i);
            
            InserirArvore(get);
            
        }
        
        for (int i = 0; i < saques.size(); i++) {
            Extrato get = saques.get(i);
            
            InserirArvore(get);
            
        }
        
        for (int i = 0; i < transferencias.size(); i++) {
            Extrato get = transferencias.get(i);
            
            InserirArvore(get);
            
        }
        
        extratos = new ArrayList<Extrato>();
        
        Percorrer_EmOrdem(arvore);
        
        return extratos;    
    }   
      
}
