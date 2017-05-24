package co.usa.edu.modelo;

public class AdministradorUsuarioAdministrativo {

    public UsuarioAdministrativo usuarioadministrativo;

    public AdministradorUsuarioAdministrativo() {
        usuarioadministrativo = new UsuarioAdministrativo();
    }

    public boolean ComprobarContraseña(String contraseña) {
        if (usuarioadministrativo.getContrasena().equals(contraseña)) {
            return true;
        }
        return false;
    }
}
