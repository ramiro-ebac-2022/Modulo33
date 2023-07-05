package com.zavala.dao;

import com.zavala.domain.Carro;

public interface ICarroDao {

	public Carro cadastrar(Carro carro);

	Carro buscarPorChassi(String chassi);
}
