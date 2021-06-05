package com.spring.guru.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.spring.guru.domain.Product;

//this service interact with jpa using DAO basis
@Service
@Profile("jpadao")
public class ProductServiceJpaDaoImpl implements ProductService{
	
	private EntityManagerFactory emf;
	
	

	public EntityManagerFactory getEmf() {
		return emf;
	}
	
	@PersistenceUnit
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List<Product> listAllProducts() {
	EntityManager em = emf.createEntityManager();
	return em.createQuery("from Product",Product.class).getResultList();
	}

	@Override
	public Product getproductById(Integer id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Product.class, id);
	}

	@Override
	public Product saveOrUpdateProduct(Product product) {
		EntityManager em = emf.createEntityManager();
		 em.getTransaction().begin();
		 Product savedproduct = em.merge(product);
		 em.getTransaction().commit();
		 System.out.println("!!!!!!! get product inside saveOrUpdateProduct DAO"+product + ":::"+savedproduct);
		 return savedproduct;
	}

	@Override
	public void deleteProduct(Integer id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Product.class, id));
		em.getTransaction().commit();
		
		
		
	}

}
