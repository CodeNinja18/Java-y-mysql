import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Main{
    public static void main(String[] args) throws SQLException {
        //Instanciamos el metodo conectar
        Conexion.conectar();
        
        //El metodo getMenu() se encarga de llamar a todos los metodos mediante el metodo getOpciones()
        getMenu();
        
    }
    //metodo para crear un registro
    public static void getCreate() throws SQLException{
        String nombre ="",apellido ="",genero ="";
        int edad =0,dni =0;
        nombre =JOptionPane.showInputDialog(null, "Ingrese nombre: ");
        apellido =JOptionPane.showInputDialog(null,"Ingrese apellido: ");
        edad =Integer.parseInt(JOptionPane.showInputDialog(null,"Digite su edad: "));
        genero =JOptionPane.showInputDialog(null,"Ingrese genero (1 digito): ");
        dni =Integer.parseInt(JOptionPane.showInputDialog(null,"Digite su DNI (8 digitos): "));

        String query ="insert  into persona (Nombre,Apellido,Edad,Genero,DNI)values("+"'"+nombre+"'"+","+"'"+apellido+"'"+","+"'"+edad+"'"+","+"'"+genero+"'"+","+"'"+dni+ "'"+")";

        PreparedStatement stm =Conexion.conectar().prepareStatement(query);
        stm.execute();
        JOptionPane.showMessageDialog(null,"El registro ha sido creado ");
    }
    //metodo para leer registros
    public static void getRead() throws SQLException{
        String mensaje ="";
        String query ="select *from persona";
        PreparedStatement stm =Conexion.conectar().prepareStatement(query);
        ResultSet res =stm.executeQuery();

        while(res.next()){
            mensaje +=res.getInt(1)+ " - "+res.getString(2)+ " - "+res.getString(3)+
             " - "+res.getInt(4)+ " - "+res.getString(5)+ " - "+res.getInt(6)+"\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);

    }
    //metodo para actualizar un registro
    public static void getUpdate()throws SQLException{
        String nombreU ="",apellidoU ="",generoU ="";
        int edadU =0,dniU =0,Id_personaU=0;
        nombreU =JOptionPane.showInputDialog(null, "Ingrese nombre: ");
        apellidoU =JOptionPane.showInputDialog(null,"Ingrese apellido: ");
        edadU =Integer.parseInt(JOptionPane.showInputDialog(null,"Digite su edad: "));
        generoU =JOptionPane.showInputDialog(null,"Ingrese genero (1 digito): ");
        dniU =Integer.parseInt(JOptionPane.showInputDialog(null,"Digite su DNI (8 digitos): "));
        Id_personaU =Integer.parseInt(JOptionPane.showInputDialog(null,"Digite el ID ha actualizar: "));
        String query ="update persona set Nombre="+"'"+nombreU+"'"+","+"Apellido="+"'"+apellidoU+"'"+","+"Edad="+edadU+","+"Genero="+"'"+generoU+"'"+","+"DNI="+dniU+ " where Id_Persona="+Id_personaU;
        PreparedStatement stm =Conexion.conectar().prepareStatement(query);
        stm.execute();
        JOptionPane.showMessageDialog(null,"El registro ha sido actualizado ");
    }
    //metodo para eliminar un registro
    public static void getDelete()throws SQLException{
        int Id_personaD =0;
        Id_personaD =Integer.parseInt(JOptionPane.showInputDialog(null,"Digite el ID ha eliminar: "));
        String query ="delete from persona where Id_persona="+Id_personaD;
        PreparedStatement stm =Conexion.conectar().prepareStatement(query);
        stm.execute();
        JOptionPane.showMessageDialog(null,"El registro "+Id_personaD+ " ha sido eliminado ");
    }
    //metodo del menu principal (menu repetitivo)
    public static void getMenu() throws SQLException{
        int opcion =0;
        do{
            opcion =Integer.parseInt(JOptionPane.showInputDialog("BIENVENIDO\n1. Crear Registro\n2. Actualizar Registro\n3. Leer Registros\n4. Eliminar Registro\n5. Salir\n"));
            getOpciones(opcion);
        }while(opcion!=5);
    }
    //metodo para salir del menu
    public static void getSalir(){
        JOptionPane.showMessageDialog(null,"Usted. Salio del sistema ");
    }
    //metodo para seleccionar una accion en especifico
    public static void getOpciones(int opcion) throws SQLException{
        switch(opcion){
            case 1:
                getCreate();
            break;
            case 2:
                getUpdate();
            break;
            case 3:
                getRead();
            break;
            case 4:
                getDelete();
            break;
            case 5:
                getSalir();
            break;
            default:
                JOptionPane.showMessageDialog(null, "El numero ingresado no es valido ");
            break;
        }
    }
}
    
