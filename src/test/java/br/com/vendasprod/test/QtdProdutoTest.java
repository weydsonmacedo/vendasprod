package br.com.vendasprod.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import br.com.vendasprod.entity.Produto;
import br.com.vendasprod.entity.QtdProduto;
import br.com.vendasprod.service.QtdProdutoService;
import br.com.vendasprod.service.QtdProdutoServiceEJB;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class QtdProdutoTest {

	
	@InjectMocks
	QtdProdutoService qtdProdutoService =  new QtdProdutoServiceEJB();

	@Test
	public void parseProdutoToQtdProdutooTest(@Mock List<Produto> produtos) {	

		Mockito.lenient().when(qtdProdutoService.parseProdutoToQtdProduto(produtos)).then( new Answer() {
			
			@Mock
            List<QtdProduto> prod;
			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				Object[] args = invocation.getArguments();
	             Object mock = invocation.getMock();
				return  prod;
			}
			
		});
	}
}
