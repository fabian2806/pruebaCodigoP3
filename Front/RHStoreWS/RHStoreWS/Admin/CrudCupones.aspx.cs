﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace RHStoreWS.Admin
{
	public partial class CrudCupones : System.Web.UI.Page
	{
		protected void Page_Load(object sender, EventArgs e)
		{

		}

        protected void lbRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("GestionarCupones.aspx");
        }

        protected void lbGuardar_Click(object sender, EventArgs e)
        {

        }
    }
}