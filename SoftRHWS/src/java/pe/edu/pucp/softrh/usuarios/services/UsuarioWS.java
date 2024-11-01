package pe.edu.pucp.softrh.usuarios.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import pe.edu.pucp.softrh.usuarios.bo.UsuarioBO;

@WebService(serviceName = "UsuarioWS", targetNamespace = "softrh.services")
public class UsuarioWS {

	private final UsuarioBO usuarioBO;

	public UsuarioWS() {
		usuarioBO = new UsuarioBO();
	}

	@WebMethod(operationName = "verificarIngresoUsuario")
	public Integer verificarIngresoUsuario(String correo, String contrasenha) {
		return usuarioBO.verificarIngresoUsuario(correo, contrasenha);
	}
}
