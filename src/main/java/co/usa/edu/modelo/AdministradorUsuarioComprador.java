package co.usa.edu.modelo;

public class AdministradorUsuarioComprador {
    
    private static UsuarioComprador usuariocomprador;

    public AdministradorUsuarioComprador(){
        usuariocomprador = new UsuarioComprador();
        usuariocomprador.setSaldoUsuario(0);
    }

    public void añadirSaldo(int saldo){
        int agregarsaldo;
        agregarsaldo = (usuariocomprador.getSaldoUsuario()) + saldo;
        usuariocomprador.setSaldoUsuario(agregarsaldo);
    }

    public void reiniciarSaldo(){
        int saldocero=0;
        usuariocomprador.setSaldoUsuario(saldocero);
    }

    public int obtenerSaldo(){
        int saldocero;
        saldocero = usuariocomprador.getSaldoUsuario();
        return saldocero;
    }
}
