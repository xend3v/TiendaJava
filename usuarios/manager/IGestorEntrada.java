package manager;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import model.Usuario;

public interface IGestorEntrada {
	public boolean CompruebaUsuario(Usuario u);
	public DefaultComboBoxModel<Usuario>getUsuarios();
	public ArrayList<Usuario> listaUsuarios();
	public void incVisitas(Usuario u);
	public void addUsuarios(Usuario u);
	public void updateUsuario(Usuario u, int indice);
	public void deleteUsuario(int indice);
}
