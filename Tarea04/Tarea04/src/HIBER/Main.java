package HIBER;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;

public class Main {

    public static void main(String[] args) throws ParseException {       
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();       
        
        Scanner teclado = new Scanner(System.in);
        int seleccion;        
     
        do { 
            espacioPrint();
            menuPrincipalPrint();        
           
            seleccion = teclado.nextInt();
            
            switch(seleccion){
           
                case 1: espacioPrint(); MostrarListaEmpleados(sesion); pulsarParaVolver();
                    break;
                case 2: espacioPrint(); AgregarEmpleado(sesion); pulsarParaVolver();
                    break;
                case 3: espacioPrint(); seleccionarEmpleado(sesion); pulsarParaVolver();
                    break;
                case 4: espacioPrint(); ModificarEmpleado(sesion); pulsarParaVolver();
                    break;
                case 5: espacioPrint(); EliminarEmpleado(sesion); pulsarParaVolver();
                    break;
                case 6: espacioPrint(); DepartamentoMayorSueldoEmpleado(sesion); pulsarParaVolver();
                    break;
                case 7: espacioPrint(); QuienCobraMasQue(sesion); pulsarParaVolver();
                    break;
                case 0:  espacioPrint();System.out.println("Programa Finalizado");
                    break;
                
                default: System.out.println("Valor introducido no valido");  
       
             }
            
        } while (seleccion != 0);                     
                     
       
        sesion.close();
        System.exit(0);
    }
    
    public static void menuPrincipalPrint (){
        
        System.out.println("Seleccione Una Opción");
        System.out.println("------------------------------");
        System.out.println("1. Visualizar Tabla de Empleados");
        System.out.println("CRUD--------------------------");
        System.out.println("2. Agregar Empleado (Create)");
        System.out.println("3. Seleccionar Datos Empleado (Read)");
        System.out.println("4. Modificar Empleado (Update)");
        System.out.println("5. Eliminar Empleado (Delete)");
        System.out.println("Consultas---------------------");
        System.out.println("6. Departamento con el Empleado con Mayor sueldo");
        System.out.println("7. Quienes Cobran más que X");   
        System.out.println("0. Salir");   
    
    }
    
    public static void espacioPrint(){    
        System.out.println("\n");   
    }
    
    public static void MostrarListaEmpleados(Session sesion){
       
       SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
       
       Query hql = sesion.createQuery("from Emp");
       List listaEmp = hql.list();
       
       Iterator it = listaEmp.iterator();
      
       String formato = "%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s";
       System.out.printf(formato, "NumeroEmpleado", "Nombre", "Trabajo", "MGR", "FechaContrato", "Salario", "Comision", "Departamento");
       System.out.println("");
       System.out.println("------------------------------------------------------------------------------------------------------------------------");
       
       
       while(it.hasNext()){
           
          Emp empleado = (Emp) it.next();
          
          Dept departamento = empleado.getDept();          
          String fechaContrato = formatoFecha.format(empleado.getHiredate());
          
          System.out.printf(formato, empleado.getEmpno(),  empleado.getEname(),  empleado.getJob(), empleado.getMgr(), 
                  fechaContrato, empleado.getSal(), empleado.getComm(), departamento.getDeptno()); 
           System.out.println("");
           
       }   
    
    }
    
    
    public static void AgregarEmpleado(Session sesion) throws ParseException{
    
        Scanner teclado = new Scanner(System.in);        
        Emp empleado = new Emp();
        sesion.beginTransaction();
        
        try {
            
            System.out.println("Introduzca Numero del Empleado");
            int NumEmp = teclado.nextInt();
            empleado.setEmpno(NumEmp);

            System.out.println("Introduzca Nombre del Empleado");
            String nombre = teclado.next();
            empleado.setEname(nombre);

            System.out.println("Introduzca Trabajo del Empleado");
            String Trabajo = teclado.next();
            empleado.setJob(Trabajo);

            System.out.println("Introduzca MGR del Empleado");
            empleado.setMgr(teclado.nextInt());

            System.out.println("Introduzca Fecha de contratación del Empleado");
            String fechaContratado = teclado.next();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = formatoFecha.parse(fechaContratado);
            empleado.setHiredate(fecha);

            System.out.println("Introduzca Salario del Empleado");
            empleado.setSal(teclado.nextBigDecimal());

            System.out.println("Introduzca Comisión del Empleado");
            empleado.setComm(teclado.nextBigDecimal());

            System.out.println("Introduzca Numero del de Departamento del Empleado");
            Dept departamento = (Dept) sesion.load(Dept.class, teclado.nextInt());
            empleado.setDept(departamento);        
            
            sesion.save(empleado);
            sesion.getTransaction().commit();
            
            System.out.println("Empleado Guardado con Exito");
        } catch (Exception e) {
            
            System.out.println("Valor o Valores Incorrectos!!");           
            sesion.getTransaction().rollback();
        }
    
    }
    
    public static void seleccionarEmpleado(Session sesion){
       
        try {
            
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");       
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introducir Numero del Empleado");
        Emp empleado = (Emp) sesion.load(Emp.class,teclado.nextInt());        
            
        String fechaContrato = formatoFecha.format(empleado.getHiredate());
        Dept departamento =  empleado.getDept();
        
        System.out.println("Datos del Empleado con Número: " +empleado.getEmpno());
        String formato = "%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s";
        System.out.printf(formato, "NumeroEmpleado", "Nombre", "Trabajo", "MGR", "FechaContrato", "Salario", "Comision", "Departamento");
        System.out.println("");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.printf(formato, empleado.getEmpno(),  empleado.getEname(),  empleado.getJob(), empleado.getMgr(), 
                  fechaContrato, empleado.getSal(), empleado.getComm(), departamento.getDeptno()); 
        System.out.println("");
            
        } catch (Exception e) {            
            System.out.println("Empleado No encontrado");
        }       
       
    }
    
    public static void ModificarEmpleado(Session sesion) throws ParseException{      
       
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");       
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introducir Numero de Empleado a Modificar");
        Emp empleado = (Emp) sesion.load(Emp.class,teclado.nextInt());      
        sesion.beginTransaction();
        
       try {
           
        String fechaContrato = formatoFecha.format(empleado.getHiredate());
        Dept departamento =  empleado.getDept();
        
        System.out.println("Datos del Empleado con Número a Modificar: " +empleado.getEmpno());
        String formato = "%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s";
        System.out.printf(formato, "NumeroEmpleado", "Nombre", "Trabajo", "MGR", "FechaContrato", "Salario", "Comision", "Departamento");
        System.out.println("");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.printf(formato, empleado.getEmpno(),  empleado.getEname(),  empleado.getJob(), empleado.getMgr(), 
                  fechaContrato, empleado.getSal(), empleado.getComm(), departamento.getDeptno()); 
        System.out.println("");
            
        } catch (Exception e) {            
            System.out.println("Empleado No encontrado");
            return;
        }
       
        try {
            
            System.out.println("Introduzca Nuevo Nombre del Empleado");
            String nombre = teclado.next();
            empleado.setEname(nombre);

            System.out.println("Introduzca Nuevo Trabajo del Empleado");
            String Trabajo = teclado.next();
            empleado.setJob(Trabajo);

            System.out.println("Introduzca Nuevo MGR del Empleado");
            empleado.setMgr(teclado.nextInt());

            System.out.println("Introduzca Nueva Fecha de contratación del Empleado");
            String fechaContratado = teclado.next();            
            Date fecha = formatoFecha.parse(fechaContratado);
            empleado.setHiredate(fecha);

            System.out.println("Introduzca Nuevo Salario del Empleado");
            empleado.setSal(teclado.nextBigDecimal());

            System.out.println("Introduzca Nueva Comisión del Empleado");
            empleado.setComm(teclado.nextBigDecimal());

            System.out.println("Introduzca Nuevo Numero del de Departamento del Empleado");
            Dept departamento = (Dept) sesion.load(Dept.class, teclado.nextInt());
            empleado.setDept(departamento);        

            sesion.update(empleado);
            sesion.getTransaction().commit();
            
            System.out.println("Empleado Modificado con Exito");
            
        } catch (Exception e) {
            
            System.out.println("Valor o Valores Incorrectos!!");           
            sesion.getTransaction().rollback();
        }
        
    }
    
    public static void EliminarEmpleado(Session sesion) throws ParseException{
    
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");       
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introducir Numero de Empleado a Eliminar");
        Emp empleado = (Emp) sesion.load(Emp.class,teclado.nextInt());      
        sesion.beginTransaction();
        
       try {
           
        String fechaContrato = formatoFecha.format(empleado.getHiredate());
        Dept departamento =  empleado.getDept();
        
        System.out.println("Datos del Empleado con Número a Eliminar: " +empleado.getEmpno());
        String formato = "%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s";
        System.out.printf(formato, "NumeroEmpleado", "Nombre", "Trabajo", "MGR", "FechaContrato", "Salario", "Comision", "Departamento");
        System.out.println("");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.printf(formato, empleado.getEmpno(),  empleado.getEname(),  empleado.getJob(), empleado.getMgr(), 
                  fechaContrato, empleado.getSal(), empleado.getComm(), departamento.getDeptno()); 
        System.out.println("");
            
        } catch (Exception e) {            
            System.out.println("Empleado No encontrado");
            return;
        }
       
       sesion.delete(empleado);
       sesion.getTransaction().commit();
    
       System.out.println("Empleado Eliminado con Exito");
    
    }
    
    public static void DepartamentoMayorSueldoEmpleado(Session sesion){
    
        
        Query hql = sesion.createQuery("from Emp order by sal desc").setMaxResults(1);
        List listaEmp = hql.list();
        
        Iterator it = listaEmp.iterator();          
        Emp empleado = (Emp) it.next();
        Dept departamento = empleado.getDept();       
        
        System.out.println("El departamento con el trabajador con sueldo más alto es: Nombre " +departamento.getDname() +" Numero "+departamento.getDeptno()+" Localizacion " +
                departamento.getLoc());
        
        System.out.println("El trabajador con el sueldo más alto: Nombre " +empleado.getEname()+ " Numero " +empleado.getEmpno()+ " Salario " +empleado.getSal());       
    
    
    }   
    
    public static void QuienCobraMasQue(Session sesion){
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");       
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introducir Numero del Empleado");
        Emp empleado = (Emp) sesion.load(Emp.class,teclado.nextInt()); 
        
        String formato = "%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s";
    
         try {                  

            String fechaContrato = formatoFecha.format(empleado.getHiredate());
            Dept departamento =  empleado.getDept();

            System.out.println("Datos del Empleado con Número: " +empleado.getEmpno());            
            System.out.printf(formato, "NumeroEmpleado", "Nombre", "Trabajo", "MGR", "FechaContrato", "Salario", "Comision", "Departamento");
            System.out.println("");
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
            System.out.printf(formato, empleado.getEmpno(),  empleado.getEname(),  empleado.getJob(), empleado.getMgr(), 
                      fechaContrato, empleado.getSal(), empleado.getComm(), departamento.getDeptno()); 
            System.out.println("");
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
            
            
        } catch (Exception e) {            
            System.out.println("Empleado No encontrado");
            return;
        }     
    
        System.out.println("Datos de Empleados Con Mayor Salario");
         
         BigDecimal salario = empleado.getSal();
        
         Query hql = sesion.createQuery("from Emp where sal > :salario order by sal desc");
         hql.setParameter("salario", salario);
         List listaEmp = hql.list();       
         Iterator it = listaEmp.iterator();
        
         while(it.hasNext()){
           
          Emp empleadoMasSal = (Emp) it.next();
          
          Dept departamento = empleadoMasSal.getDept();          
          String fechaContrato = formatoFecha.format(empleadoMasSal.getHiredate());
          
          System.out.printf(formato, empleadoMasSal.getEmpno(),  empleadoMasSal.getEname(),  empleadoMasSal.getJob(), empleadoMasSal.getMgr(), 
                  fechaContrato, empleadoMasSal.getSal(), empleadoMasSal.getComm(), departamento.getDeptno()); 
          System.out.println("");
           
       }   
    
    
    }
    
    
    public static void pulsarParaVolver(){
    
        Scanner teclado = new Scanner(System.in);
        
        String salida = "";
        
        do {      
            
            System.out.println("\n");
            System.out.println("0 Para Volver al Menú");
            salida = teclado.next();
            System.out.println("\n");         
            
            
        } while (!salida.equalsIgnoreCase("0"));
        
    
    
    }
    
    
}
