var idSeleccionadoIda = null;
var idSeleccionadoRetorno = null;
var Asientos = "";
var TypeCabina= 1;

function almacenarID(checkbox, tipo, asientos) {
  var checkboxes = document.getElementsByClassName('registro-checkbox-' + tipo);
  Asientos = asientos;
  console.log("🚀 ~ almacenarID ~ Asientos:", Asientos)
  
  // Deseleccionar todos los checkboxes excepto el actual
  for (var i = 0; i < checkboxes.length; i++) {
      if (checkboxes[i] !== checkbox) {
          checkboxes[i].checked = false;
      }
  }

  // Guardar el ID del checkbox seleccionado
  if (checkbox.checked) {
      if (tipo === 'ida') {
          idSeleccionadoIda = checkbox.value;
      } else if (tipo === 'retorno') {
          idSeleccionadoRetorno = checkbox.value;
      }
  } else {
      if (tipo === 'ida') {
          idSeleccionadoIda = null;
      } else if (tipo === 'retorno') {
          idSeleccionadoRetorno = null;
      }
  }
  console.log("ID seleccionado (ida):", idSeleccionadoIda);
  console.log("ID seleccionado (retorno):", idSeleccionadoRetorno);
}



function reservar() {
    var pasajeros = document.getElementById('pasajeros').value;

if (pasajeros > Asientos) {
    alert("No hay asientos diponnibles")
} else {
    

  console.log("🚀 ~ reservar ~ IdsIda:", idSeleccionadoIda);
  console.log("🚀 ~ reservar ~ IdsRetorno:", idSeleccionadoRetorno);

  
  localStorage.removeItem("Idcabina");
  localStorage.setItem("Idcabina", TypeCabina);
  // Guardar los IDs seleccionados en localStorage
  if (idSeleccionadoIda) {
      localStorage.setItem("idSeleccionadoIda", idSeleccionadoIda);
      
      
      console.log("ID de ida seleccionado:", idSeleccionadoIda);
  } else {
      localStorage.removeItem("idSeleccionadoIda");
      console.log("No se ha seleccionado ningún ID de ida");
  }

  if (idSeleccionadoRetorno) {
      localStorage.setItem("idSeleccionadoRetorno", idSeleccionadoRetorno);
      console.log("ID de retorno seleccionado:", idSeleccionadoRetorno);
  } else {
      localStorage.removeItem("idSeleccionadoRetorno");
      console.log("No se ha seleccionado ningún ID de retorno");
  }

  setTimeout(()=>{

    window.open("../../view/Operational/confirmacion.html")
  },300)
}

}

function loadSalida(tipoCabina) {
    $.ajax({
        url: "http://localhost:9000/Airlines/v1/api/Schedules/Salida",
        method: "GET",
        dataType: "json",
        success: function (response) {
            console.log(response.data);
            var html = "";
            var data = response.data;
            console.log(data);
            data.forEach(function (item) {
                // Construir el HTML para cada objeto, incluyendo el checkbox con el ID del registro
                if (!item.deletedAt) {
                    var precioFinal = 0;
                    var precioCabina = parseFloat(item.precioCabina); // Convertir el precio de la cabina a un número

                    if (tipoCabina === "Economy") {
                        precioFinal = precioCabina;
                        
                        
                    } else if (tipoCabina === "Ejecutiva") {
                        precioFinal = Math.round(precioCabina * 1.35);
                        TypeCabina= 2 ;
                    } else if (tipoCabina === "Primera clase") {
                        TypeCabina = 3;
                        var precioEjecutivo = Math.round(precioCabina * 1.35);
                        precioFinal = Math.round(precioEjecutivo * 1.30);
                    }
                    
                    html +=
                        `<tr>
                            <td><input type="checkbox" class="registro-checkbox-ida" value="` + item.id + `" onchange="almacenarID(this, 'ida', ` + item.totalSeats + `)"></td>
                            <td>` + item.origen + `</td>
                            <td>` + item.destino + `</td>
                            <td>` + item.fecha + `</td>
                            <td>` + item.hora + `</td>
                            <td>` + item.numeroVuelo + `</td>
                            <td >$`+ precioFinal + `</td>
                        </tr>`;
                }
            });

            $("#resultSalida").html(html);
        },
        error: function (error) {
            // Función que se ejecuta si hay un error en la solicitud
            console.error("Error en la solicitud:", error);
        },
    });
}






function Filtro(tipoCabina) {
  var tipoDeReserva = "";
  var url = "";
  var Tabla = "";
  var fechaId = ""; // Usaremos esto para almacenar el ID del campo de fecha

  // Verificar qué tipo de reserva se seleccionó
  if (document.getElementById('inlineCheckbox1').checked) {
      tipoDeReserva = 'retorno';
  } else if (document.getElementById('inlineCheckbox2').checked) {
      tipoDeReserva = 'ida';
  }

  switch (tipoDeReserva) {
      case 'retorno':
          Tabla = "resultRegreso";
          url = "http://localhost:9000/Airlines/v1/api/Schedules/Filtro-Retorno";
          fechaId = "fechaRegreso";
          break;
      case 'ida':
          Tabla = "resultSalida";
          url = "http://localhost:9000/Airlines/v1/api/Schedules/Filtro-Ida";
          fechaId = "fechaSalida";
          break;
      default:
          alert("Seleccione un tipo de reserva");
          return;
  }

  var origen = $("#origen").val();
  var destino = $("#destino").val();
  var fecha = $("#" + fechaId).val();

  var consult = {
      "origen": origen,
      "destino": destino,
      "fecha": fecha
  };

  $.ajax({
      url: url,
      method: "POST",
      dataType: "json",
      contentType: "application/json",
      data: JSON.stringify(consult),
      success: function (response) {
          if (response.data == null || response.data.length === 0) {
              alert("No se encontraron datos");
          } else {

              console.log(response.data);
              var html = "";
              var data = response.data;

              console.log(data);
              data.forEach(function (item) {
                  if (!item.deletedAt) {

                    var precioFinal = 0;
                    var precioCabina = parseFloat(item.precioCabina); 

                    if (tipoCabina === "Economy") {
                        precioFinal = precioCabina;
                    } else if (tipoCabina === "Ejecutiva") {
                        precioFinal = Math.round(precioCabina * 1.35);
                    } else if (tipoCabina === "Primera clase") {
                        var precioEjecutivo = Math.round(precioCabina * 1.35);
                        precioFinal = Math.round(precioEjecutivo * 1.30);
                    }
                    
                      html +=
                          `<tr>
                      <td><input type="checkbox" class="registro-checkbox-retorno" value="` + item.id + `" onchange="almacenarID(this, 'retorno')"></td>

                          <td>` + item.origen + `</td>
                          <td>` + item.destino + `</td>
                          <td>` + item.fecha + `</td>
                          <td>` + item.hora + `</td>
                          <td>` + item.numeroVuelo + `</td>
                        <td >$`+ precioFinal + `</td>
                      </tr>`;
                  }
              });

              $("#" + Tabla).html(html); // Usar el nombre de la tabla dinámicamente
          }
      },
      error: function (error) {
          // Función que se ejecuta si hay un error en la solicitud
          console.error("Error en la solicitud:", error);
      },
  });
}

