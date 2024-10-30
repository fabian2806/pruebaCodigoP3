﻿using SoftRhBaseBO.Servicios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftRhBaseBO
{
	public class BaseBO
	{
		private AdministradorWSClient administradorWS;
		private ClienteWSClient clienteWS;
		private TrabajadorWSClient trabajadorWS;
		private DireccionWSClient direccionWS;
		private CuponWSClient cuponWS;
		private PrendaWSClient prendaWS;
		private PromocionWSClient promocionWS;

		public BaseBO()
		{
			administradorWS = new AdministradorWSClient();
			clienteWS = new ClienteWSClient();
			trabajadorWS = new TrabajadorWSClient();
			direccionWS = new DireccionWSClient();
			cuponWS = new CuponWSClient();
			prendaWS = new PrendaWSClient();
			promocionWS = new PromocionWSClient();
		}

		public AdministradorWSClient AdministradorWS { get => administradorWS; set => administradorWS = value; }
		public ClienteWSClient ClienteWS { get => clienteWS; set => clienteWS = value; }
		public TrabajadorWSClient TrabajadorWS { get => trabajadorWS; set => trabajadorWS = value; }
		public DireccionWSClient DireccionWS { get => direccionWS; set => direccionWS = value; }
		public CuponWSClient CuponWS { get => cuponWS; set => cuponWS = value; }
		public PrendaWSClient PrendaWS { get => prendaWS; set => prendaWS = value; }
		public PromocionWSClient PromocionWS { get => promocionWS; set => promocionWS = value; }
	}
}