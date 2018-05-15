package escalonamento;

import java.util.ArrayList;
import java.util.List;

import processo.Processo;

public class SJF  implements AlgoritmoEscalonamento {
        
        static final int Max = 999, Min = 0;
    
	private List<Processo> listaProcessos = new ArrayList<Processo>();

	@Override
	public void adicionaProcesso(Processo processo) {
            listaProcessos.add(processo);
	}

	@Override
	public Processo escalonaProcesso() {
            int minDuracao = Max, minInicio = Max;
            int i = Min, tira = Min ;
                        
            for (Processo processo : listaProcessos) {
                if(processo.getDuracao()< minDuracao ||
                        processo.getTempoInicio() < minInicio) {
                    
                    minDuracao = processo.getDuracao();
                    minInicio = processo.getTempoInicio();
                    tira = i;
                    
                }
                i++;
            }
            return listaProcessos.remove(tira);
	}

	@Override
	public void trocaProcessoExecucao() {
		// SJF nao troca processo em execucao
		
	}

	@Override
	public boolean filaVazia() {
		return listaProcessos.isEmpty();
	}

	@Override
	public void imprimeEstadoFila() {
		System.out.println("Lista de Processos Prontos");
		System.out.println("--------------------------");
		for (Processo processo : listaProcessos) {
			processo.imprime();
		}
		System.out.println("--------------------------");
		
	}

	@Override
	public void incrementaTempoEspera() {
		for (Processo processo : listaProcessos) {
			processo.setTempoEspera(processo.getTempoEspera() + 1);
		}		
	}

}