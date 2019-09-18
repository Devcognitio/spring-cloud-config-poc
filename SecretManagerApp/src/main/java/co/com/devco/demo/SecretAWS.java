package co.com.devco.demo;

public class SecretAWS {
    private String driverClassName;
    private String urlDataBase;
    private String usuario;
    private String clave;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrlDataBase() {
        return urlDataBase;
    }

    public void setUrlDataBase(String urlDataBase) {
        this.urlDataBase = urlDataBase;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "SecretAWS{" +
                "driverClassName='" + driverClassName + '\'' +
                ", urlDataBase='" + urlDataBase + '\'' +
                ", usuario='" + usuario + '\'' +
                ", clave='" + clave + '\'' +
                '}';
    }
}
