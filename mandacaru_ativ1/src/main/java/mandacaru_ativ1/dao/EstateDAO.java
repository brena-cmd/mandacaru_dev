package mandacaru_ativ1.dao;

import java.util.List;

import mandacaru_ativ1.entities.Estate;

public interface EstateDAO {
	public void save(Estate entity);
	 
    public void delete(int id);
 
    public Estate find(int id);
 
    public List<Estate> findAll();
    
    public Estate findByName(String str);
 
    public List<Estate> findAllByName(String str);
}
