package br.com.comida.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.com.comida.model.ComidaModel;

public class ComidaRepository {
	
	private static ComidaRepository instance;
	private static Map<Long, ComidaModel> comidas;
	
	public static ComidaRepository getInstance() {
		
		if(instance == null) {
			instance = new ComidaRepository();
		}
		return instance;
	}
	
	//repository representando um banco de dados, dados mockados com 6 atributos
	private ComidaRepository() {
		comidas = new HashMap<Long, ComidaModel>();
		
		comidas.put(1L, new ComidaModel(1L, "Macarrao", "Massa ao molho sugo com toque especial da casa", 20.0,
				"Massas italiana", "vinho tinto e salada com molho caezar"));
		comidas.put(2L, new ComidaModel(2L, "Prato Feito", "Arroz, feijao, bife, ovo frito e salada", 20.0,
				"Culinaria brasileira", "Suco natural"));
		comidas.put(3L, new ComidaModel(3L, "Feijoada", "Tipica culinaria brasileira com arroz e batata", 30.0,
				"Culinaria brasileira", "Farofa caseira e suco de laranja"));
		comidas.put(4L, new ComidaModel(4L, "X-TUDO", "Lanche com tudo que voce pode imaginar", 30.0,
				"Fast Food", "refrigerante e batata"));
		comidas.put(5L, new ComidaModel(5L, "CheeseBurger", "Hamburguer com queijo especial", 20.0,
				"Fast Food", "refrigerante Dolly"));
		comidas.put(6L, new ComidaModel(6L, "Route64", "Hamburguer com fungi", 32.0,
				"Fast Food", "refrigerante e batata"));
		comidas.put(7L, new ComidaModel(7L, "Hamburguer tradicional", "Pão, maionese, hamburguer, queijo e salada", 25.0,
				"Fast Food", "refrigerante e batata"));
	}
	public ArrayList<ComidaModel> findAll() {
		return new ArrayList<ComidaModel>(comidas.values());
	}

	public ComidaModel findById(long id) {
		return comidas.get(id);
	}

	public void save(ComidaModel comidaModel) {
		Long newId = (long) (comidas.size() + 1);
		comidaModel.setId(newId);
		comidas.put(newId, comidaModel);
	}
	
	public void update(ComidaModel comidaModel) {
		comidas.put(comidaModel.getId(), comidaModel);
	}
	
	public void deleteById(long id) {
		comidas.remove(id);
	}
	
	
}
