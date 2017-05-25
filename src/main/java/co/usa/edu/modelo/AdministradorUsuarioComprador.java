package co.usa.edu.modelo;

public class AdministradorUsuarioComprador {
    
    private static UsuarioComprador usuariocomprador;

    public AdministradorUsuarioComprador(){
        usuariocomprador = new UsuarioComprador();
        usuariocomprador.setSaldoUsuario(0);
    }

    public int añadirSaldo(int saldo){
        int nuevoSaldo= (usuariocomprador.getSaldoUsuario()) + saldo;
        usuariocomprador.setSaldoUsuario(nuevoSaldo);
        return nuevoSaldo;
    }

    public int reiniciarSaldo(){
        int nuevoSaldo=0;
        usuariocomprador.setSaldoUsuario(nuevoSaldo);
        return nuevoSaldo;
    }

    public int obtenerSaldo(){
        int saldo;
        saldo = usuariocomprador.getSaldoUsuario();
        return saldo;
    }
}
