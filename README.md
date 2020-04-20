SISTEMAS DE VENDAS DE PRODUTOS (DESAFIO INEMA - vendasprod)
===============
 Aplicativo desenvolvido para testar conhecimento nas tecnologias listadas abaixo.
 
 Detalhes da Implementa��o
-------
Tecnologias utilizadas na implementa��o:

* CDI
* JSF - Primefaces
* EJB 3
* JPA
* Hibernate ORM
* JUnit
* Mockito

Pre-requisitos para o Funcionamento:
-------
* JDK - vers�oo 1.8 do Java;
* Eclipse -  IDE;
* Plugin para Eclipse - JBoss Tools;
* Maven - para build e depend�ncias;
* Application Server Java EE - Wildfly 18;
* __OBS: Caso voc� n�o queira ter muito trabalho e deseje subir o sistema pelo banco de dados H2 (padr�o no wildfly), desconsidere as informa��es abaixo e pule para a pr�xima sess�o__

* Banco de dados MySQL 
(A conex�o do banco tem que ser feita tamb�m no servidor de aplica��o (*standalone.xml*) ex: 

					<datasource jta="true" jndi-name="java:jboss/datasources/vendasprod_db" pool-name="vendasprod_db" enabled="true">
						<connection-url>jdbc:mysql://localhost:3306/vendasprod_db?useUnicode=true&amp;useJDBCCompliantTimezoneShift=true&amp;useLegacyDatetimeCode=false&amp;serverTimezone=UTC</connection-url>
						<driver-class>com.mysql.cj.jdbc.Driver</driver-class>
						<driver>mysql</driver>
						<security>
						<user-name>*****</user-name>
						<password>*****</password>
						</security>
				 </datasource> 
)


* e informar o driver: 

		<driver name="mysql" module="com.mysql"/>
* Na pasta do servidor: *wildfly/modules/com/msql/main* (se nao tiver crie)
* crie um arquivo com o nome *module.xml*:
	
	
		<?xml version="1.0" encoding="UTF-8"?>
		<module xmlns="urn:jboss:module:1.1" name="com.mysql"> 
		    <resources>
		        <resource-root path="mysql-connector-java-8.0.19.jar"/>
		    </resources>
		    <dependencies>
		        <module name="javax.api"/>
		        <module name="javax.transaction.api"/>
		    </dependencies>
		</module>

* Nesta mesma pasta baixe o conector da internet e coloque l�. ex: *mysql-connector-java-8.0.19.jar*.
* ap�s todos os passos dentro do projeto na pasta: *webapp/resources/sql/*  tem um arquivo chamado *Dump.sql*.
* Execute este arquivo e ter� tanto as tabelas quanto alguns dados como (*clientes*) importados no banco.

OBSERVA��O IMPORTANTE:
-------
* Banco de dados - H2 (DBMS) - Para habilitar este banco no lugar do MySQL basta apenas trocar
o *jta-data-source* (inclusive deixei o exemplo comentado no c�digo) e comentar a propriedade do *dialect* na classe *persistence.xml*
* Ap�s isso, descomente o trecho de c�digo que faz a inser��o do cliente (*findAll*) no banco na classe:(*ClienteServiceEJB*)

Instala��o:
-------
* Baixe o aplicativo ou clone pelo link do *Github*. Instale o *Eclipse*;*WildFly*; e o *JBoss Tools* (pelo Marketplace do eclipse);
* Importe o projeto usando o *Existing Maven Projects*.
* Fa�a *update projects* e logo em seguida fa�a *Maven clean* e *Maven install*.
* Para finalizar, no servidor em *add and remove* adicione o build do projeto (vendasprod-0.0.1-SNAPSHOT) no *Wildfly*.
* Ap�s tudo finalizado, pode subir a aplica��o e *carpe diem*;

Observa��es Sobre o Sistema:
-------
* O sistema  permite o cadastro de *Produtos* e compra dos mesmos atrav�s de *Pedidos*.
* Tamb�m � poss�vel editar e excluir *Produtos* e excluir os *Pedidos*.

*Os testes ainda n�o est�o implementados, mas o sistema est� configurado para isso.*  
