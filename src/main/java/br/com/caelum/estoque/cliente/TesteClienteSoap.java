package br.com.caelum.estoque.cliente;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import br.com.caelum.estoque.ws.EstoqueWS;
import br.com.caelum.estoque.ws.Filtro;
import br.com.caelum.estoque.ws.Filtros;
import br.com.caelum.estoque.ws.ListaItens;
import br.com.caelum.estoque.ws.TipoItem;

public class TesteClienteSoap {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/estoquews-web/EstoqueWS?wsdl");
        QName qname = new QName("http://ws.estoque.caelum.com.br/", "EstoqueWS");
        Service service = Service.create(url, qname);

        EstoqueWS cliente = service.getPort(EstoqueWS.class);
        
        Filtro filtro = new Filtro();
        filtro.setNome("IPhone");
        filtro.setTipo(TipoItem.CELULAR);

        Filtros filtros = new Filtros();
        filtros.addFiltro(filtro);
        
        ListaItens lista = cliente.todosOsItens(filtros);
        System.out.println("Resposta do serviço: " + lista);
    }
}