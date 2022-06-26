package com.integracaoDB.conections;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.integracaoDB.conections.constants.RabbitmqConstantes;

@Component
public class RabbitMQConection {
	private static final String NOME_EXCHANGE = "amq.direct";
	
	  private AmqpAdmin amqpAdmin;

	  public RabbitMQConection(AmqpAdmin amqpAdmin){
	    this.amqpAdmin = amqpAdmin;
	  }
	  
	//Filas
	  private Queue fila(String nomeFila){
	    return new Queue(nomeFila, true, false, false);
	  }
	  
	//Exchange == Encaminham as mensagens às filas
	  private DirectExchange trocaDireta() {
	    return new DirectExchange(NOME_EXCHANGE);
	  }
	  
	  private Binding relacionamento(Queue fila, DirectExchange troca){
	    return new Binding(fila.getName(), Binding.DestinationType.QUEUE, troca.getName(), fila.getName(), null);
	  }

	  //está função é executada assim que nossa classe é instanciada pelo Spring, devido a anotação @Component
	  @PostConstruct
	  private void adiciona(){
	    Queue filaCursos = this.fila(RabbitmqConstantes.FILA_CURSOS);
	    Queue filaAlunos   = this.fila(RabbitmqConstantes.FILA_ALUNOS);

	    DirectExchange troca = this.trocaDireta();

	    Binding ligacaoCursos = this.relacionamento(filaCursos, troca);
	    Binding ligacaoAlunos   = this.relacionamento(filaAlunos, troca);

	    //Criando as filas no RabbitMQ
	    this.amqpAdmin.declareQueue(filaCursos);
	    this.amqpAdmin.declareQueue(filaAlunos);

	    this.amqpAdmin.declareExchange(troca);

	    this.amqpAdmin.declareBinding(ligacaoCursos);
	    this.amqpAdmin.declareBinding(ligacaoAlunos);
	  }
}
