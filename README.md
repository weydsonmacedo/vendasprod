SISTEMAS DE VENDAS DE PRODUTOS (DESAFIO INEMA - vendasprod)
===============
 Aplicativo desenvolvido para testar conhecimento nas tecnologias listadas abaixo.
 
 Detalhes da implementação
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
* Banco de dados - H2 (DBMS) - pode ser colocado qualquer outro banco (MySQL, PostgreSql, SqlServer) bastando apenas trocar
o *<jta-data-source>* e a propriedade do *dialect* na classe *persistence.xml* (inclusive deixei uma como exemplo comentado no código);

Instalação:
-------
* Baixe o aplicativo ou clone pelo link do *Github*. Instale o *Eclipse*,*WildFly* e o *JBoss Tools* pelo (Marketplace do eclipse);
* Importe o projeto usando o *Existing Maven Projects*.
* Faça *update projects* e logo em seguida faça *Maven clean* e *Maven install*.
* Para finalizar, no servidor em *add and remove* adicione o build do projeto (vendasprod-0.0.1-SNAPSHOT) no *Wildfly*.
* OBS: o projeto já está configurado com o banco de dados H2 (interno do eclipse). Então já funcionará assim que subir a aplicação.
* Após tudo finalizado, pode subir a aplicação e *carpe diem*;

Observações Sobre o Sistema:
-------
O sistema automaticamente (em código) já tem cadastrado uma lista de clientes na classe *(ClienteServiceEJB)*, só para o funcionamento do mesmo.
O sistema  permite o cadastro de *Produtos* e compra dos mesmos através de *Pedidos*.
Também é possível editar e excluir *Produtos* e excluir os *Pedidos*.

*Os testes ainda não estão implementados, mas o sistema está configurado para isso.*  
