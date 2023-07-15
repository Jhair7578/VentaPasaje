package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entity.Menu;
import com.proyecto.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query("select u from Usuario u where u.login =?1")
	public Usuario iniciarSesion(String vLogin);
	
	@Query("select m from CargoMenu cm join cm.menu m where cm.cargo.codigo =?1 ")
	public List<Menu> traerMenuUsuario(int codigoCargo);
	
	/*@Query("select u from Usuario u where u.clasecategoria=?1")
	public List<Usuario> listarporCodigoBrevete(String codigoBrevete);*/

	@Query("select u from Usuario u where u.nombre like ?1% and u.cargo.codigo=6")
	public List<Usuario> listarUporNombre(String n);
	
	@Query("select u from Usuario u where u.codigo=?1")
	public List<Usuario> listarporCodigoBrevete(int codigoBrevete);
	
	@Query(value="select u.* from tb_usuario u inner join tb_cargo c on c.cod_car = u.cod_car where c.cod_car=6",nativeQuery = true)
	public List<Usuario> listarChoferes();
	
	@Query("select count(u) from Usuario u where u.dni = ?1")
	public int existeDNI(String dni);
}
