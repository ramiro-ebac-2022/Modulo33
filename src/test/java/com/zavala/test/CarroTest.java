package com.zavala.test;

import org.junit.Assert;
import org.junit.Test;

import com.zavala.dao.AcessorioDao;
import com.zavala.dao.CarroDao;
import com.zavala.dao.IAcessorioDao;
import com.zavala.dao.ICarroDao;
import com.zavala.dao.IMarcaDao;
import com.zavala.dao.MarcaDao;
import com.zavala.domain.Acessorio;
import com.zavala.domain.Carro;
import com.zavala.domain.Marca;

public class CarroTest {

	private ICarroDao carroDao;
	private IMarcaDao marcaDao;
	private IAcessorioDao acessorioDao;
	
	public CarroTest() {
		carroDao = new CarroDao();
		marcaDao = new MarcaDao();
		acessorioDao = new AcessorioDao();
	}
	
	private Acessorio criarAcessorio(String codigo) {
		Acessorio aces = new Acessorio();
		aces.setCodigo(codigo);
		aces.setClassificacao("Item Segurança");
		aces.setDetalhes_tecnicos("Detalhes Técnicos");
		return aces;
	}
	
	private Marca criarMarca(String codigo) {
		Marca marca = new Marca();
		marca.setCodigo(codigo);
		marca.setModelo("Polo");
		return marcaDao.cadastrar(marca);
	}
	
	@Test
	public void cadastrarCarro() {
		Acessorio acess1 = criarAcessorio("FAROL");
		Acessorio acess2 = criarAcessorio("BAGAGEIRO");
		Marca marca = criarMarca("VolksWagen");
		Carro carro = new Carro();
		carro.setAno_fabricacao(2023L);
		carro.setChassi("CHASSI-01");
		carro.setCor("Azul");
		carro.addAcessorio(acess1);
		carro.addAcessorio(acess2);
		carro.setMarca(marca);
		carro = carroDao.cadastrar(carro);
		//
		Assert.assertNotNull(carro);
		Assert.assertNotNull(carro.getId());
		//testando jpql : buscar por chassi do carro
		Carro carroBD = carroDao.buscarPorChassi(carro.getChassi());
		Assert.assertNotNull(carroBD);
		Assert.assertEquals(carroBD.getId(), carro.getId());
	}
	
}
