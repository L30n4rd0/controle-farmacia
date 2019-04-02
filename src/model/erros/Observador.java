package model.erros;

import java.util.ArrayList;

import model.vos.ErroVO;

public abstract class Observador
{   
	protected Observador() {
		// TODO Auto-generated constructor stub
	}
    /**
     * FUNCAO USADA PARA NOTIFICAR ESSA CLASSE QUE A CLASSE QUE ELA OBSERVA MUDOU
     * @throws Exception 
     */
    protected abstract void processarErro(ArrayList<ErroVO> erro) throws Exception;
}
