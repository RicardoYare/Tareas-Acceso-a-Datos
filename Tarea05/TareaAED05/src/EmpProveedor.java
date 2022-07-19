
public class EmpProveedor {
    
    private int codEmp;
    private String nombre;
    private String telefono;
    private String calle;
    private int numero;
    private String Producto;

    public EmpProveedor(int codEmp, String nombre, String telefono, String calle, int numero, String Producto) {
        this.codEmp = codEmp;
        this.nombre = nombre;
        this.telefono = telefono;
        this.calle = calle;
        this.numero = numero;
        this.Producto = Producto;
    }

    public int getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(int codEmp) {
        this.codEmp = codEmp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }
    
  
    
}
