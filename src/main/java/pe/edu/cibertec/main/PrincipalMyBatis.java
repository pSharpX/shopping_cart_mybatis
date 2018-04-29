/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.main;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pe.edu.cibertec.dominio.Categoria;
import pe.edu.cibertec.dominio.Producto;
import pe.edu.cibertec.dominio.Usuario;
import pe.edu.cibertec.dominio.busqueda.BusquedaProducto;
import pe.edu.cibertec.repositorio.ProductoRepositorio;
import pe.edu.cibertec.repositorio.impl.MyBatisProductoRepositorioImpl;
import pe.edu.cibertec.repositorio.mapper.CategoriaMapper;
import pe.edu.cibertec.repositorio.mapper.ProductoMapper;

/**
 *
 * @author Java-LM
 */
public class PrincipalMyBatis {
   
    public static SqlSessionFactory createSqlSessionFactory(){
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            return sqlSessionFactory;
        } catch (IOException e) {
            System.err.println("Error al generar SqlSessionFactory");
            e.printStackTrace(System.err);
            System.exit(-1);
            return null;
        }
    }
            
    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = createSqlSessionFactory();
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            
            System.out.println("--------------------------------------------------------");
            System.out.println("-----------------   USUARIOS   -------------------------");
            System.out.println("--------------------------------------------------------");
            
            Random random = new Random();
            Usuario nuevo = new Usuario();
            nuevo.setNombre("Juanita " + random.nextInt(10));
            nuevo.setApellido("Del Prado " + random.nextInt(10));
            nuevo.setFechaNacimiento(new Date());
            
            sqlSession.insert("pe.edu.cibertec.repositorio.mapper.UsuarioMapper.insertUsuario", nuevo);
            sqlSession.commit();
                    
                    
            Usuario usuario = sqlSession.selectOne(
                    "pe.edu.cibertec.repositorio.mapper.UsuarioMapper.selectUsuario",1L);
            System.out.println(usuario.getNombre() + " " + usuario.getApellido());
            
            usuario.setNombre(usuario.getNombre()+ " " + random.nextInt(10));
            usuario.setApellido(usuario.getApellido()+ " "+  random.nextInt(10));
            
            sqlSession.update("pe.edu.cibertec.repositorio.mapper.UsuarioMapper.updateUsuario", usuario);
            sqlSession.commit();
            
            List<Usuario> usuarios = sqlSession.selectList(
                    "pe.edu.cibertec.repositorio.mapper.UsuarioMapper.selectAllUsuario");
            
            if(usuarios != null && usuarios.size() > 0){
                usuarios.forEach(u -> {
                    System.out.println(u.getNombre() + " " + u.getApellido());
                });
            }
            
            sqlSession.delete(
                    "pe.edu.cibertec.repositorio.mapper.UsuarioMapper.deleteUsuario", 
                    usuarios.get(usuarios.size()-1).getId());
            sqlSession.commit();
            
            System.out.println("--------------------------------------------------------");
            System.out.println("----------------   PRODUCTOS   -------------------------");
            System.out.println("--------------------------------------------------------");
            
            Producto producto = sqlSession.selectOne(
                    "pe.edu.cibertec.repositorio.mapper.ProductoMapper.selectProducto", 1L);            
            printProducto(producto);
            
            Producto selected = sqlSession.getMapper(ProductoMapper.class)
                    .selectProducto(1L);
            printProducto(selected);
            
            ProductoRepositorio productoRepositorio = new MyBatisProductoRepositorioImpl(sqlSession);
            Producto p = productoRepositorio.buscar(1L);
            printProducto(p);
            
            Categoria categoria = new Categoria();
            categoria.setId(1L);
            
            Producto pro = new Producto();
            pro.setNombre("Reloj de Cuarzo");
            pro.setDescripcion("Reloj usado por mamani");
            pro.setPrecio(new BigDecimal(140));
            pro.setImagen(obtenerArchivo(RUTA_IMAGEN));
            pro.setCategoria(categoria);
            
            productoRepositorio.crear(pro);
            sqlSession.commit();
            
            System.out.println(sqlSession.getMapper(CategoriaMapper.class).obtenerTodos());
            
            BusquedaProducto busquedaProducto = new BusquedaProducto();
            busquedaProducto.setCantidadMeses(1);
            List<Producto> ultimosProductos = productoRepositorio.obtenerProductosUltimoMes(busquedaProducto);
            ultimosProductos.forEach(System.out::println);
            
            List<Producto> ultimosProductosProcedure = productoRepositorio.obtenerProductosUltimoMesProcedure(busquedaProducto);
            ultimosProductosProcedure.forEach(System.out::println);
        }
    }
    
    public static void printProducto(Producto producto){
        System.out.printf(
                    "Nombre: %s - Descripcion: %s - Precio: %s \n", 
                    producto.getNombre(), 
                    producto.getDescripcion(), 
                    producto.getPrecio().doubleValue());
    }
    
    private static final String RUTA_IMAGEN = "C:\\reloj_cuarzo.jpg";
    private static final int CHUNK_SIZE = 1024 * 4; 
    
    public static byte[] obtenerArchivo(String ruta){
        byte[] resultado = null;
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(ruta)))){
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] chunk = new byte[CHUNK_SIZE];
            int leidos = 0;
            while((leidos = bis.read(chunk)) > 0){
                baos.write(chunk, 0, leidos);
            }
            resultado = baos.toByteArray();
        }catch(IOException ex){
            ex.printStackTrace(System.out);
        }
        return resultado;
    }
}
