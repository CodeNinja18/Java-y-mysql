import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    //Creamos el metodo para la conexion con la base de datos mysql workbench
    public static Connection conectar(){
        Connection cn =null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //cambiar el localhost, nombre de la DB, el usuario y la contraseña
            cn =DriverManager.getConnection("jdbc:mysql://localhost:3306/BasePersona","root","123456");
            //si ingresaste correctamente los datos imprimira por pantalla "Conexion exitosa"
            System.out.println("Conexion exitosa");
        }catch(Exception e){
            //Imprimira este mensaje cuando ocurre un error en la conexion
            System.out.println("No conectado");
        }
        return cn;
    }
}
