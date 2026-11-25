public class ObjClientes {
    private String Cedula;
    private String Nombre;
    private String Apellido;
    private String Telefono;
    private String Direccion;
    private String Licencia_Coduccion;

    public ObjClientes(){

    }

    public ObjClientes(String cedula, String nombre, String apellido, String telefono, String direccion, String licencia) {
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.Licencia_Coduccion = Licencia_Coduccion; 
    }

    public String getCedula() {
        return Cedula;
    }
    public void setCedula(String cedula) {
        Cedula = cedula;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getApellido() {
        return Apellido;
    }
    public void setApellido(String apellido) {
        Apellido = apellido;
    }
    public String getTelefono() {
        return Telefono;
    }
    public void setTelefono(String telefono) {
        Telefono = telefono;
    }
    public String getDireccion() {
        return Direccion;
    }
    public void setDireccion(String direccion) {
        Direccion = direccion;
    }
    public String getLicencia_Coduccion() {
        return Licencia_Coduccion;
    }
    public void setLicencia_Coduccion(String licencia_Coduccion) {
        Licencia_Coduccion = licencia_Coduccion;
    }

    


}