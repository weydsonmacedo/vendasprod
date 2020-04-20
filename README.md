SISTEMAS DE VENDAS DE PRODUTOS (DESAFIO INEMA - vendasprod)
===============
 Aplicativo desenvolvido para testar conhecimento nas tecnologias listadas abaixo.
 
 Detalhes da Implementação
-------
Tecnologias utilizadas na implementação:

* CDI
* JSF - Primefaces
* EJB 3
* JPA
* Hibernate ORM
* JUnit
* Mockito

Pre-requisitos para o Funcionamento:
-------
* JDK - versãoo 1.8 do Java;
* Eclipse -  IDE;
* Plugin para Eclipse - JBoss Tools;
* Maven - para build e dependências;
* Application Server Java EE - Wildfly 18;
* __OBS: Caso você não queira ter muito trabalho e deseje subir o sistema pelo banco de dados H2 (padrão no wildfly), desconsidere as informações abaixo e pule para a próxima sessão__

* Banco de dados MySQL 
(A conexão do banco tem que ser feita também no servidor de aplicação (*standalone.xml*) ex: 

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

* Nesta mesma pasta baixe o conector da internet e coloque lá. ex: *mysql-connector-java-8.0.19.jar*.
* após todos os passos dentro do projeto na pasta: *webapp/resources/sql/*  tem um arquivo chamado *Dump.sql*.
* Execute este arquivo e terá tanto as tabelas quanto alguns dados como (*clientes*) importados no banco.

OBSERVAÇÃO IMPORTANTE:
-------
* Banco de dados - H2 (DBMS) - Para habilitar este banco no lugar do MySQL basta apenas trocar
o *jta-data-source* (inclusive deixei o exemplo comentado no código) e comentar a propriedade do *dialect* na classe *persistence.xml*
* Após isso, descomente o trecho de código que faz a inserção do cliente (*findAll*) no banco na classe:(*ClienteServiceEJB*)

Instalação:
-------
* Baixe o aplicativo ou clone pelo link do *Github*. Instale o *Eclipse*;*WildFly*; e o *JBoss Tools* (pelo Marketplace do eclipse);
* Importe o projeto usando o *Existing Maven Projects*.
* Faça *update projects* e logo em seguida faça *Maven clean* e *Maven install*.
* Para finalizar, no servidor em *add and remove* adicione o build do projeto (vendasprod-0.0.1-SNAPSHOT) no *Wildfly*.
* Após tudo finalizado, pode subir a aplicação e *carpe diem*;

Observações Sobre o Sistema:
-------
* O sistema  permite o cadastro de *Produtos* e compra dos mesmos através de *Pedidos*.
* Também é possível editar e excluir *Produtos* e excluir os *Pedidos*.

*Os testes ainda não estão implementados, mas o sistema está configurado para isso.*  
