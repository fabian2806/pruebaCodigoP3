using RHStoreBaseBO;
using RHStoreBaseBO.ServiciosWeb;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RHStoreUsuariosBO
{
	public class ClienteBO : BaseBO
	{
        public int insertar(string dni, string nombres, string apellidos, string correo, string contrasenha, DateTime fechaRegistro, bool recibePromociones)
        {
            return ClienteWS.insertarCliente(dni, nombres, apellidos, correo, contrasenha, fechaRegistro, recibePromociones);
        }

        public int modificar(int idUsuario, string dni, string nombres, string apellidos, string correo, string contrasenha, DateTime fechaRegistro, bool recibePromociones)
        {
            return ClienteWS.modificarCliente(idUsuario, dni, nombres, apellidos, correo, contrasenha, fechaRegistro, recibePromociones);
        }

        public int eliminar(int idCliente)
        {
            return ClienteWS.eliminarCliente(idCliente);
        }

        public BindingList<cliente> listarTodos()
        {
            return new BindingList<cliente>(ClienteWS.listarClientesTodos());
        }

        public cliente obtenerPorId(int idCliente)
        {
            return ClienteWS.obtenerClientePorId(idCliente);
        }
    }
}
