package co.usa.edu.modelo;

public class AdministradorUsuarioAdministrativo {

    private static UsuarioAdministrativo usuarioadministrativo;

    public AdministradorUsuarioAdministrativo() {
        usuarioadministrativo = new UsuarioAdministrativo();
        usuarioadministrativo.setContrasena("123");
    }

    public boolean ComprobarContraseña(String contraseña) {
        if (usuarioadministrativo.getContrasena().equals(contraseña)) {
            return true;
        }
        return false;
    }
}
