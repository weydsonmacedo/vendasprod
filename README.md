SISTEMAS DE VENDAS DE PRODUTOS (DESAFIO INEMA - vendasprod)
===============
 Aplicativo desenvolvido para testar conhecimento nas tecnologias listadas abaixo.
 
 Detalhes da implementa��o
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
* Banco de dados - H2 (DBMS) - pode ser colocado qualquer outro banco (MySQL, PostgreSql, SqlServer) bastando apenas trocar
o *<jta-data-source>* e a propriedade do *dialect* na classe *persistence.xml* (inclusive deixei uma como exemplo comentado no c�digo);

Instala��o:
-------
* Baixe o aplicativo ou clone pelo link do *Github*. Instale o *Eclipse*,*WildFly* e o *JBoss Tools* pelo (Marketplace do eclipse);
* Importe o projeto usando o *Existing Maven Projects*.
* Fa�a *update projects* e logo em seguida fa�a *Maven clean* e *Maven install*.
* Para finalizar, no servidor em *add and remove* adicione o build do projeto (vendasprod-0.0.1-SNAPSHOT) no *Wildfly*.
* OBS: o projeto j� est� configurado com o banco de dados H2 (interno do eclipse). Ent�o j� funcionar� assim que subir a aplica��o.
* Ap�s tudo finalizado, pode subir a aplica��o e *carpe diem*;

Observa��es Sobre o Sistema:
-------
O sistema automaticamente (em c�digo) j� tem cadastrado uma lista de clientes na classe *(ClienteServiceEJB)*, s� para o funcionamento do mesmo.
O sistema  permite o cadastro de *Produtos* e compra dos mesmos atrav�s de *Pedidos*.
Tamb�m � poss�vel editar e excluir *Produtos* e excluir os *Pedidos*.

*Os testes ainda n�o est�o implementados, mas o sistema est� configurado para isso.*  
