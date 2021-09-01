package com.nelioalves.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.cursomc.domain.CategoriaDomain;
import com.nelioalves.cursomc.domain.CidadeDomain;
import com.nelioalves.cursomc.domain.EstadoDomain;
import com.nelioalves.cursomc.domain.ProdutosDomain;
import com.nelioalves.cursomc.repositories.*;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		CategoriaDomain cat1 = new CategoriaDomain(null,"informática");
		CategoriaDomain cat2 = new CategoriaDomain(null,"escritório");
		
		ProdutosDomain p1 = new ProdutosDomain(null, "Computador", 2000.00);
		ProdutosDomain p2 = new ProdutosDomain(null, "Impressora", 800.00);
		ProdutosDomain p3 = new ProdutosDomain(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategoria().addAll(Arrays.asList(cat1));
		p2.getCategoria().addAll(Arrays.asList(cat1,cat2));
		p3.getCategoria().addAll(Arrays.asList(cat1));
				
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		EstadoDomain est1 = new EstadoDomain(null,"Minas Gerais");
		EstadoDomain est2 = new EstadoDomain(null,"São Paulo");
		
		CidadeDomain c1 = new CidadeDomain(null,"Uberlândia",est1);
		CidadeDomain c2 = new CidadeDomain(null,"São Paulo",est2);
		CidadeDomain c3 = new CidadeDomain(null,"Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
	}

}
