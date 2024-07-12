var idSeleccionadoIda = null;
var idSeleccionadoRetorno = null;
var Asientos = "";
var TypeCabina= 1;
var asientosRetorno = null;
var asientosSalida = null;
var  TypeCabina = null;

function applyFilters() {
  var tipoCabina = document.getElementById('cabina').value;
  var checkboxIda = document.getElementById('inlineCheckbox2').checked;
  FiltroA(tipoCabina);
  

  if (!checkboxIda) {
      FiltroB(tipoCabina);
      
  }
}

function clearFilters() {
  
  document.getElementById('origen_id').value = '';
  document.getElementById('destino_id').value = '';
  document.getElementById('selected_origen_id').value = '';
  document.getElementById('selected_destino_id').value = '';
  document.getElementById('fechaRegreso').value = '';
  

    document.getElementById('cabina').selectedIndex = 0;

  document.getElementById('fechaSalida').value = '';

  
}



document.addEventListener('DOMContentLoaded', function() {
    const checkbox1 = document.getElementById('inlineCheckbox1');
    const checkbox2 = document.getElementById('inlineCheckbox2');
    const fechaRegreso = document.getElementById('fechaRegreso');

    if (checkbox1.checked) {
      
        fechaRegreso.disabled = true;
    } else if (checkbox2.checked) {
        fechaRegreso.disabled = false;
    }
});

function toggleCheckbox(checkbox, otherCheckboxId) {
  const otherCheckbox = document.getElementById(otherCheckboxId);
  const fechaRegreso = document.getElementById('fechaRegreso');
  const returnFlightDetails = document.getElementById('returnFlightDetails');

  if (checkbox.checked) {
      otherCheckbox.checked = false;
      if (checkbox.id === 'inlineCheckbox2') {
          returnFlightDetails.style.display = 'none';
          fechaRegreso.disabled = true;
          fechaRegreso.value = '';
      } else {
          returnFlightDetails.style.display = 'block';
          fechaRegreso.disabled = false;
      }
  } else {
      checkbox.checked = true;
  }
}



// function almacenarID(checkbox, tipo, item) {
//   var checkboxes = document.getElementsByClassName('registro-checkbox-' + tipo);
  
//   // Deseleccionar todos los checkboxes excepto el actual
//   for (var i = 0; i < checkboxes.length; i++) {
//       if (checkboxes[i] !== checkbox) {
//           checkboxes[i].checked = false;
//       }
//   }

//   // Guardar el registro completo del vuelo seleccionado
//   if (checkbox.checked) {
//       if (tipo === 'ida') {
//           idSeleccionadoIda = item;
//       } else if (tipo === 'retorno') {
//           idSeleccionadoRetorno = item;
//       }
//   } else {
//       if (tipo === 'ida') {
//           idSeleccionadoIda = null;
//       } else if (tipo === 'retorno') {
//           idSeleccionadoRetorno = null;
//       }
//   }
//   console.log("ID seleccionado (ida):", idSeleccionadoIda);
//   console.log("ID seleccionado (retorno):", idSeleccionadoRetorno);
// }


// function almacenarID(checkbox, tipo, item, tipoCabina,asientosDiponibles) {
//   var checkboxes = document.getElementsByClassName('registro-checkbox-' + tipo);
  
//   // Deseleccionar todos los checkboxes excepto el actual
//   for (var i = 0; i < checkboxes.length; i++) {
//       if (checkboxes[i] !== checkbox) {
//           checkboxes[i].checked = false;
//       }
//   }

//   // Guardar el registro completo del vuelo seleccionado
//   if (checkbox.checked) {
//       if (tipo === 'ida') {

//           idSeleccionadoIda = {
//               item: item,
//               tipoCabina: tipoCabina
//           };
//           asintosSalida= asientosDiponibles;
//       } else if (tipo === 'retorno') {
//           idSeleccionadoRetorno = {
//               item: item,
//               tipoCabina: tipoCabina
//           };
//           asientosRetorno = asientosDiponibles;
//       }
//   } else {
//       if (tipo === 'ida') {
//           idSeleccionadoIda = null;
//       } else if (tipo === 'retorno') {
//           idSeleccionadoRetorno = null;
//       }
//   }
//   console.log("ID seleccionado (ida):", idSeleccionadoIda);
//   console.log("ID seleccionado (retorno):", idSeleccionadoRetorno);
// }


// function reservar() {
//   var pasajeros = document.getElementById('pasajeros').value;

//   if (pasajeros > Asientos) {
//       alert("No hay asientos disponibles");
//   } else {
//       console.log("🚀 ~ reservar ~ IdsIda:", idSeleccionadoIda);
//       console.log("🚀 ~ reservar ~ IdsRetorno:", idSeleccionadoRetorno);

//       localStorage.removeItem("Idcabina");
//       localStorage.setItem("Idcabina", TypeCabina);

//       // Guardar los registros seleccionados en localStorage
//       if (idSeleccionadoIda) {
//           localStorage.setItem("idSeleccionadoIda", JSON.stringify(idSeleccionadoIda));
//           console.log("ID de ida seleccionado:", idSeleccionadoIda);
//       } else {
//           localStorage.removeItem("idSeleccionadoIda");
//           console.log("No se ha seleccionado ningún ID de ida");
//       }

//       if (idSeleccionadoRetorno) {
//           localStorage.setItem("idSeleccionadoRetorno", JSON.stringify(idSeleccionadoRetorno));
//           console.log("ID de retorno seleccionado:", idSeleccionadoRetorno);
//       } else {
//           localStorage.removeItem("idSeleccionadoRetorno");
//           console.log("No se ha seleccionado ningún ID de retorno");
//       }

//       setTimeout(() => {
//           window.open("../../view/Operational/confirmacion.html")
//       }, 300);
//   }
// }












// function FiltroA(tipoCabina) {
//   var isCheckedA = document.getElementById('flexCheckCheckedA').checked;
//   var isCheckedB = document.getElementById('flexCheckCheckedB').checked;

//   var origen = parseInt($("#selected_origen_id").val());
//   var destino = parseInt($("#selected_destino_id").val());
//   var fecha = $("#fechaSalida").val();

//   var consult = {
//       "origen": origen,
//       "destino": destino,
//       "fechaS": fecha,
//       "tresDias" :isCheckedA,
//       "tresDiaR":isCheckedB
//   };

//   $.ajax({
//       url: "http://localhost:9000/Airlines/v1/api/Schedules/Filtro-Ida",
//       method: "POST",
//       dataType: "json",
//       contentType: "application/json",
//       data: JSON.stringify(consult),
//       success: function(response) {
//           var data = response.data;
//           var dataTable = $('#primer').DataTable();
//           dataTable.clear(); // Limpia la tabla

//           data.forEach(function(item) {
//               if (!item.deletedAt) {
//                   var precioFinal = 0;
//                   var precioCabina = parseFloat(item.precioCabina);

//                   if (tipoCabina === "Economy") {
//                       precioFinal = precioCabina;
//                   } else if (tipoCabina === "Ejecutiva") {
//                       precioFinal = Math.round(precioCabina * 1.35);
//                   } else if (tipoCabina === "Primera clase") {
//                       var precioEjecutivo = Math.round(precioCabina * 1.35);
//                       precioFinal = Math.round(precioEjecutivo * 1.30);
//                   }

//                   dataTable.row.add([
//                       `<input type="checkbox" class="registro-checkbox-ida" value="${item.id}" onchange='almacenarID(this, "ida", ${JSON.stringify(item)})'>`,
//                       item.origen,
//                       item.destino,
//                       item.fecha,
//                       formatHora(item.hora),
//                       item.numeroVuelo,
//                       `$${precioFinal}`
//                   ]);
//               }
//           });

//           dataTable.draw(); // Dibuja la tabla con los nuevos datos
//       },
//       error: function(error) {
//           console.error("Error en la solicitud:", error);
//       },
//   });
// }

// function FiltroB(tipoCabina) {
//   var isCheckedA = document.getElementById('flexCheckCheckedA').checked;
//   var isCheckedB = document.getElementById('flexCheckCheckedB').checked;

//   var origen = parseInt($("#selected_origen_id").val());
//   var destino = parseInt($("#selected_destino_id").val());
//   var fecha = $("#fechaRegreso").val();

//   var consult = {
//       "origen": origen,
//       "destino": destino,
//       "fechaR": fecha,
//       "tresDias": isCheckedA,
//       "tresDiaR": isCheckedB
//   };

//   $.ajax({
//       url: "http://localhost:9000/Airlines/v1/api/Schedules/Filtro-Retorno",
//       method: "POST",
//       dataType: "json",
//       contentType: "application/json",
//       data: JSON.stringify(consult),
//       success: function(response) {
//           var data = response.data;
//           var dataTable = $('#example').DataTable();
//           dataTable.clear(); // Limpia la tabla

//           data.forEach(function(item) {
//               if (!item.deletedAt) {
//                   var precioFinal = 0;
//                   var precioCabina = parseFloat(item.precioCabina);

//                   if (tipoCabina === "Economy") {
//                       precioFinal = precioCabina;
//                   } else if (tipoCabina === "Ejecutiva") {
//                       precioFinal = Math.round(precioCabina * 1.35);
//                   } else if (tipoCabina === "Primera clase") {
//                       var precioEjecutivo = Math.round(precioCabina * 1.35);
//                       precioFinal = Math.round(precioEjecutivo * 1.30);
//                   }

//                   dataTable.row.add([
//                       `<input type="checkbox" class="registro-checkbox-retorno" value="${item.id}" onchange='almacenarID(this, "retorno", ${JSON.stringify(item)})'>`,
//                       item.origen,
//                       item.destino,
//                       item.fecha,
//                       formatHora(item.hora),
//                       item.numeroVuelo,
//                       `$${precioFinal}`
//                   ]);
//               }
//           });

//           dataTable.draw(); // Dibuja la tabla con los nuevos datos
//       },
//       error: function(error) {
//           console.error("Error en la solicitud:", error);
//       },
//   });
// }

function almacenarID(checkbox, tipo, item, tipoCabina, asientosDisponibles) {
  var checkboxes = document.getElementsByClassName('registro-checkbox-' + tipo);
 
  if (tipoCabina == 1) {
    TypeCabina = "Economy";
    asientosDisponibles = item.asientosDisponiblesEconomy;
    
  }else if(tipoCabina == 2){
    TypeCabina = "Ejecutiva";
    asientosDisponibles = item.asientosDisponiblesBusiness;

  }

  
  // Deseleccionar todos los checkboxes excepto el actual
  for (var i = 0; i < checkboxes.length; i++) {
    if (checkboxes[i] !== checkbox) {
      checkboxes[i].checked = false;
    }
  }

  // Guardar el registro completo del vuelo seleccionado
  if (checkbox.checked) {
    if (tipo === 'ida') {
      idSeleccionadoIda = {
        item: item,
        tipoCabina: tipoCabina
        
      };
      asientosSalida = asientosDisponibles;
    } else if (tipo === 'retorno') {
      idSeleccionadoRetorno = {
        item: item,
        tipoCabina: tipoCabina
      };
      asientosRetorno = asientosDisponibles;
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



// function reservar() {
//   var pasajeros = document.getElementById('pasajeros').value;
//   alert(pasajeros)
//   console.log(pasajeros);
  
//   if (pasajeros > 0  ) {
//     if (idSeleccionadoIda !=null) {
//       if(pasajeros > asintosSalida){
//         alert("cupos llenos escoja otro tipo de cabina ")
//       }
      
//     }else if (idSeleccionadoRetorno != null){
//       if(pasajeros > asientosRetorno){
//         alert("cupos llenos escoja otro tipo de cabina ")
//       }
//     }

//       alert("No hay asientos disponibles");
//   } else {
//       console.log("🚀 ~ reservar ~ IdsIda:", idSeleccionadoIda);
//       console.log("🚀 ~ reservar ~ IdsRetorno:", idSeleccionadoRetorno);

//       localStorage.removeItem("Idcabina");
//       localStorage.setItem("Idcabina", TypeCabina);
//       localStorage.removeItem("cantidadTiket");
//       localStorage.setItem("cantidadTiket",pasajeros)

//       // Guardar los registros seleccionados en localStorage
//       if (idSeleccionadoIda) {
//           localStorage.setItem("idSeleccionadoIda", JSON.stringify(idSeleccionadoIda));
//           console.log("ID de ida seleccionado:", idSeleccionadoIda);
//       } else {
//           localStorage.removeItem("idSeleccionadoIda");
//           console.log("No se ha seleccionado ningún ID de ida");
//       }

//       if (idSeleccionadoRetorno) {
//           localStorage.setItem("idSeleccionadoRetorno", JSON.stringify(idSeleccionadoRetorno));
//           console.log("ID de retorno seleccionado:", idSeleccionadoRetorno);
//       } else {
//           localStorage.removeItem("idSeleccionadoRetorno");
//           console.log("No se ha seleccionado ningún ID de retorno");
//       }

//       setTimeout(() => {
//           window.open("../../view/Operational/confirmacion.html")
//       }, 300);
//   }
// }
function reservar() {
  var tipoCabina = document.getElementById('cabina').value;
  var pasajeros = parseInt(document.getElementById('pasajeros').value);

  // Validar que se haya seleccionado un tipo de cabina
  if (!tipoCabina) {
    Swal.fire({
      title: "Ooh!",
      text: "Debe seleccionar un tipo de cabina.",
      icon: "warning"
    });
    return;
  }

  // Validar que se haya ingresado una cantidad válida de pasajeros
  if (isNaN(pasajeros) || pasajeros <= 0) {
    Swal.fire({
      title: "Ooh!",
      text: "Debe ingresar una cantidad válida de pasajeros.",
      icon: "warning"
    });
    return;
  }

  // Validar la disponibilidad de asientos para el vuelo de ida
  if (idSeleccionadoIda && pasajeros > asientosSalida) {
    Swal.fire({
      title: "Ooh!",
      text: "Cupos llenos para el vuelo de ida. Por favor, elija otro tipo de cabina o vuelo.",
      icon: "warning"
    });
    return;
  }

  // Validar la disponibilidad de asientos para el vuelo de retorno
  if (idSeleccionadoRetorno && pasajeros > asientosRetorno) {
    Swal.fire({
      title: "Ooh!",
      text: "Cupos llenos para el vuelo de retorno. Por favor, elija otro tipo de cabina o vuelo.",
      icon: "warning"
    });
    return;
  }

  // Almacenar los datos en localStorage
  localStorage.setItem("Idcabina", tipoCabina);
  localStorage.setItem("cantidadTiket", pasajeros);

  if (idSeleccionadoIda) {
    localStorage.setItem("idSeleccionadoIda", JSON.stringify(idSeleccionadoIda));
    console.log("ID de ida seleccionado:", idSeleccionadoIda);
  } else {
    localStorage.removeItem("idSeleccionadoIda");
    console.log("No se ha seleccionado ningún ID de ida");
  }

  if (idSeleccionadoRetorno) {
    localStorage.setItem("idSeleccionadoRetorno", JSON.stringify(idSeleccionadoRetorno));
    console.log("ID de retorno seleccionado:", idSeleccionadoRetorno);
  } else {
    localStorage.removeItem("idSeleccionadoRetorno");
    console.log("No se ha seleccionado ningún ID de retorno");
  }

  // Mostrar mensaje de éxito y redirigir después de la reserva
  Swal.fire({
    title: "¡Bien hecho!",
    text: "¡Se ha realizado la reserva correctamente!",
    icon: "success"
  }).then(() => {
    setTimeout(() => {
      window.open("../../view/Operational/confirmacion.html", "_self"); // Cambiado _self para que abra en la misma pestaña
    }, 300); // Cambiado a 300 milisegundos
  });
}


function FiltroA(tipoCabina) {
  var isCheckedA = document.getElementById('flexCheckCheckedA').checked;
  var isCheckedB = document.getElementById('flexCheckCheckedB').checked;
  var valor = "";
  var origen = parseInt($("#selected_origen_id").val());
  var destino = parseInt($("#selected_destino_id").val());
  var fecha = $("#fechaSalida").val();

  var consult = {
    "origen": origen,
    "destino": destino,
    "fechaS": fecha,
    "tresDias": isCheckedA,
    "tresDiaR": isCheckedB,
    "tipoCabina": tipoCabina 
  };

  $.ajax({
    url: "http://localhost:9000/Airlines/v1/api/Schedules/Filtro",
    method: "POST",
    dataType: "json",
    contentType: "application/json",
    data: JSON.stringify(consult),
    success: function(response) {
      var data = response.data;
      var dataTable = $('#primer').DataTable();
      dataTable.clear(); // Limpia la tabla

      // Objeto para agrupar registros por ID
      var groupedData = {};

      data.forEach(function(item) {
        if (!item.deletedAt) {
          if (!(item.id in groupedData)) {
            // Inicializa el registro si es la primera vez que se encuentra este ID
            groupedData[item.id] = {
              'id': item.id,
              'origen': item.origen,
              'destino': item.destino,
              'fecha': item.fecha,
              'hora': formatHora(item.hora),
              'numeroVuelo': item.numeroVuelo,
              'precioCabina': item.precioCabina,
              'asientosDisponiblesEconomy': 0,
              'asientosDisponiblesBusiness': 0
            };
          }

          // Suma los asientos disponibles según el tipo de cabina
          if (item.tipoCabina === 'Economy' && item.asientosDisponibles > 0) {
            groupedData[item.id].asientosDisponiblesEconomy += item.asientosDisponibles;
          } else if (item.tipoCabina === 'Business' && item.asientosDisponibles > 0) {
            groupedData[item.id].asientosDisponiblesBusiness += item.asientosDisponibles;
          }
        }
      });

      // Convertir el objeto agrupado en un array para agregarlo a la tabla
      var groupedArray = Object.values(groupedData);

      groupedArray.forEach(function(groupedItem) {
        var asientosDisponiblesTexto = '';
        if (groupedItem.asientosDisponiblesEconomy > 0) {
          asientosDisponiblesTexto += `Economy ${groupedItem.asientosDisponiblesEconomy}`;
        }
        if (groupedItem.asientosDisponiblesBusiness > 0) {
          asientosDisponiblesTexto += `<br>Business ${groupedItem.asientosDisponiblesBusiness}`;
        }

        dataTable.row.add([
          `<input type="checkbox" class="registro-checkbox-ida" value="${groupedItem.id}" onchange='almacenarID(this, "ida", ${JSON.stringify(groupedItem)}, "${tipoCabina}", ${groupedItem.asientosDisponiblesEconomy})'>`,
          groupedItem.origen,
          groupedItem.destino,
          groupedItem.fecha,
          groupedItem.hora,
          groupedItem.numeroVuelo,
          `$${groupedItem.precioCabina}`,
          asientosDisponiblesTexto
        ]);
      });

      dataTable.draw(); // Dibuja la tabla con los nuevos datos
    },
    error: function(error) {
      console.error("Error en la solicitud:", error);
    },
  });
}


function FiltroB(tipoCabina) {
  var isCheckedA = document.getElementById('flexCheckCheckedA').checked;
  var isCheckedB = document.getElementById('flexCheckCheckedB').checked;
  var valor = "";
  var origen = parseInt($("#selected_origen_id").val());
  var destino = parseInt($("#selected_destino_id").val());
  var fecha = $("#fechaRegreso").val();

  

  var consult = {
    "origen": destino,
    "destino":origen ,
    "fechaS": "",
    "fechaR": fecha,
    "tresDias": isCheckedA,
    "tresDiaR": isCheckedB,
    "tipoCabina": tipoCabina 
  };

  $.ajax({
    url: "http://localhost:9000/Airlines/v1/api/Schedules/Filtro",
    method: "POST",
    dataType: "json",
    contentType: "application/json",
    data: JSON.stringify(consult),
    success: function(response) {
      var data = response.data;
      var dataTable = $('#example').DataTable();
      dataTable.clear(); // Limpia la tabla

      // Objeto para agrupar registros por ID
      var groupedData = {};

      data.forEach(function(item) {
        if (!item.deletedAt) {
          if (!(item.id in groupedData)) {
            // Inicializa el registro si es la primera vez que se encuentra este ID
            groupedData[item.id] = {
              'id': item.id,
              'origen': item.origen,
              'destino': item.destino,
              'fecha': item.fecha,
              'hora': formatHora(item.hora),
              'numeroVuelo': item.numeroVuelo,
              'precioCabina': item.precioCabina,
              'asientosDisponiblesEconomy': 0,
              'asientosDisponiblesBusiness': 0
            };
          }

          // Suma los asientos disponibles según el tipo de cabina
          if (item.tipoCabina === 'Economy' && item.asientosDisponibles > 0) {
            groupedData[item.id].asientosDisponiblesEconomy += item.asientosDisponibles;
          } else if (item.tipoCabina === 'Business' && item.asientosDisponibles > 0) {
            groupedData[item.id].asientosDisponiblesBusiness += item.asientosDisponibles;
          }
        }
      });

      // Convertir el objeto agrupado en un array para agregarlo a la tabla
      var groupedArray = Object.values(groupedData);

      groupedArray.forEach(function(groupedItem) {
        var asientosDisponiblesTexto = '';
        if (groupedItem.asientosDisponiblesEconomy > 0) {
          asientosDisponiblesTexto += `Economy ${groupedItem.asientosDisponiblesEconomy}`;
        }
        if (groupedItem.asientosDisponiblesBusiness > 0) {
          asientosDisponiblesTexto += `<br>Business ${groupedItem.asientosDisponiblesBusiness}`;
        }

        dataTable.row.add([
          `<input type="checkbox" class="registro-checkbox-retorno" value="${groupedItem.id}" onchange='almacenarID(this, "retorno", ${JSON.stringify(groupedItem)}, "${tipoCabina}", ${groupedItem.asientosDisponiblesEconomy})'>`,
          groupedItem.origen,
          groupedItem.destino,
          groupedItem.fecha,
          groupedItem.hora,
          groupedItem.numeroVuelo,
          `$${groupedItem.precioCabina}`,
          asientosDisponiblesTexto
        ]);
      });

      dataTable.draw(); // Dibuja la tabla con los nuevos datos
    },
    error: function(error) {
      console.error("Error en la solicitud:", error);
    },
  });
}





function aeropuerto() {
    $.ajax({
      url: "http://localhost:9000/Airlines/v1/api/Airports",
      method: "GET",
      dataType: "json",
      success: function(response) {
        var data = response.data;
        var autocomplete = [];
            console.log("entrnado");
        data.forEach(function(item) {
          autocomplete.push({ label: item.name, value: item.id });
        });

        $("#origen").autocomplete({
          source: autocomplete,
          select: function(event, ui) {
            $(this).val(ui.item.label);
            $('#origenId').val(ui.item.value); // Set the hidden input with the selected value
            return false;
          }
        });

        $("#destino").autocomplete({
          source: autocomplete,
          select: function(event, ui) {
            $(this).val(ui.item.label);
            $('#destinoId').val(ui.item.value); // Set the hidden input with the selected value
            return false;
          }
        });
      },
      error: function(error) {
        console.error("Error fetching data: ", error);
      }
    });
  }

  function formatHora(hora) {
    const partes = hora.split('.');
    
    const tiempo = partes[0];
    
    return tiempo;
  }

  
  function loadAere() {
    console.log("ejecutando loadPerosn");
    $.ajax({
        url: "http://localhost:9000/Airlines/v1/api/Airports",
        method: "GET",
        dataType: "json",
        success: function (response) {
            if (response.status && Array.isArray(response.data)) {
              var origens = response.data.map(function(item) {
                return {
                  label: item.name,
                  value: item.id 
                };
              });
      
              $("#origen_id").autocomplete({
                source: function(request, response) {
                  var results = $.ui.autocomplete.filter(origens, request.term);
                  if (!results.length) {
                    results = [{ label: 'No se encontraron resultados', value: null }];
                  }
                  response(results);
                },
                select: function(event, ui) {
                  $("#selected_origen_id").val(ui.item.value);
                  $("#origen_id").val(ui.item.label);
                  return false; 
                }
              
              });
              $("#destino_id").autocomplete({
                source: function(request, response) {
                  var results = $.ui.autocomplete.filter(origens, request.term);
                  if (!results.length) {
                    results = [{ label: 'No se encontraron resultados', value: null }];
                  }
                  response(results);
                },
                select: function(event, ui) {
                  $("#selected_destino_id").val(ui.item.value);
                  $("#destino_id").val(ui.item.label);
                  return false; 
                }
            });
            } else {
              console.error("Error: No se pudo obtener la lista de ciudades.");
            }
        },
        error: function (error) {
            console.error("Error en la solicitud:", error);
        },
    });
}