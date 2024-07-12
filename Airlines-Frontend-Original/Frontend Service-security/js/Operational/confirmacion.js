document.getElementById('applyBtn').addEventListener('click', function (event) {
  var form = document.getElementById('myForm');

  if (form.checkValidity() === false) {
      event.preventDefault();
      event.stopPropagation();
  }

  form.classList.add('was-validated');
});



function loadReserva(){
    var idSeleccionadoIda = localStorage.getItem("idSeleccionadoIda");
    var idSeleccionadoRetorno = localStorage.getItem("idSeleccionadoRetorno");
    cabinaType = localStorage.getItem("Idcabina");
    

    if (idSeleccionadoIda !=null) {
        loadSalida();
    } 
    if(idSeleccionadoRetorno !=null){
        loadRegreso()
        
    }

}
var precioFinal = 0;
var cabinaType = parseInt(localStorage.getItem("Idcabina")); 
var TypeCabina = 1; 
var ID = 0;

var dataIda = JSON.parse(localStorage.getItem("dataIda")) || [];
var dataRetorno = JSON.parse(localStorage.getItem("dataRetorno")) || [];
var cantidadTiket = parseInt(localStorage.getItem("cantidadTiket")) || 0;
var cantidaTiketFacturados = 0;



function almacenarID(checkbox) {
  var checkboxes = document.getElementsByClassName('registro-checkbox');
  
  
  // Deseleccionar todos los checkboxes excepto el actual
  for (var i = 0; i < checkboxes.length; i++) {
      if (checkboxes[i] !== checkbox) {
          checkboxes[i].checked = false;
      }
  }
  ID = checkbox.value
  console.log("🚀 ~ almacenarID ~ ID:", ID)
 
  
}

function loadCountries() {

  $.ajax({
    url: "http://localhost:9000/Airlines/v1/api/Countries",
    method: "GET",
    dataType: "json",
    success: function (response) {
      if (response.status && Array.isArray(response.data)) {
        var cities = response.data.map(function (Countries) {
          return {
            label: Countries.name,
            value: Countries.id ,
          };
        });

        
        $("#Countries_id").autocomplete({
          source: cities,
          select: function (event, ui) {
            $("#selected_Countries_id").val(ui.item.value);
            $("#Countries_id").val(ui.item.label);
            console.log("ID de ciudad seleccionada: " + ui.item.value);
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



// function loadSalida() {
//   // Obtener los datos almacenados en localStorage
//   var item = JSON.parse(localStorage.getItem("idSeleccionadoIda"));

//   if (item) {
//       var html = "";

//       // Construir el HTML para el objeto recibido
//       if (!item.deletedAt) {
//           html += `
//               <span>Origen: ${item.origen}</span><br>
//               <span>Destino: ${item.destino}</span><br>
//               <span>Tipo de Cabina: Económica</span><br>
//               <span>Fecha: ${item.fecha}</span><br>
//               <span>Número de Vuelo: ${item.numeroVuelo}</span><br>
//           `;
//       }

//       var precioCabina = parseFloat(item.precioCabina); // Convertir el precio de la cabina a un número
//       console.log("🚀 ~ loadSalida ~ precioCabina:", precioCabina);

//       if (cabinaType == 1) {
//           precioFinal = precioCabina;
//           TypeCabina = 1;
//       } else if (cabinaType == 2) {
//           precioFinal = Math.round(precioCabina * 1.35);
//           TypeCabina = 2;
//       } else if (cabinaType == 3) {
//           var precioEjecutivo = Math.round(precioCabina * 1.35);
//           precioFinal = Math.round(precioEjecutivo * 1.30);
//           TypeCabina = 3;
//       }

//       $("#resultSalida").html(html);
//   } else {
//       console.error("No hay datos de salida almacenados en localStorage");
//   }
// }


function loadSalida() {
  // Obtener los datos almacenados en localStorage
  var idSeleccionadoIda = JSON.parse(localStorage.getItem("idSeleccionadoIda"));

  if (idSeleccionadoIda) {
      var item = idSeleccionadoIda.item;
      var tipoCabina = idSeleccionadoIda.tipoCabina;
      var cabina = "";
      if (tipoCabina == 1) {
        cabina = "Economy"
      }else if (tipoCabina == 2){
        cabina = "Ejecutive"
      }
      var html = "";

      // Construir el HTML para el objeto recibido
      if (!item.deletedAt) {
          html += `
              <span>Origen: ${item.origen}</span><br>
              <span>Destino: ${item.destino}</span><br>
              <span>Tipo de Cabina: ${cabina}</span><br>
              <span>Fecha: ${item.fecha}</span><br>
              <span>Número de Vuelo: ${item.numeroVuelo}</span><br>
          `;
      }

      $("#resultSalida").html(html);
  } else {
      console.error("No hay datos de salida almacenados en localStorage");
  }
}

function loadRegreso() {// Obtener los datos almacenados en localStorage
  var selecionadaRetornoId = JSON.parse(localStorage.getItem("idSeleccionadoRetorno"));

  if (selecionadaRetornoId) {
    var item = selecionadaRetornoId.item;
    var tipoCabina = selecionadaRetornoId.tipoCabina;
    var cabina = "";
    if (tipoCabina == 1) {
      cabina = "Economy"
    }else if (tipoCabina == 2){
      cabina = "Ejecutive"
    }
      var html = "";

      // Construir el HTML para el objeto recibido
      if (!item.deletedAt) {
        html += `
            <span>Origen: ${item.origen}</span><br>
            <span>Destino: ${item.destino}</span><br>
            <span>Tipo de Cabina: ${cabina}</span><br>
            <span>Fecha: ${item.fecha}</span><br>
            <span>Número de Vuelo: ${item.numeroVuelo}</span><br>
        `;
    }

   
     
      $("#resultRegreso").html(html);
  } else {
      console.error("No hay datos de salida almacenados en localStorage");
  }
}

function Confirmacion() {
  var idSeleccionadoIda = localStorage.getItem("idSeleccionadoIda");
  var idSeleccionadoRetorno = localStorage.getItem("idSeleccionadoRetorno");
  var dataIda = localStorage.getItem("dataIda");
  var dataRetorno = localStorage.getItem("dataRetorno");
  var precioFinal = 0;

  if (idSeleccionadoIda) {
    idSeleccionadoIda = JSON.parse(idSeleccionadoIda);
    var tipoCabinaIda = idSeleccionadoIda.tipoCabina;

    if (tipoCabinaIda == 1) {
      precioFinal += parseFloat(idSeleccionadoIda.item.precioCabina);
    } else if (tipoCabinaIda == 2) {
      precioFinal += Math.round(idSeleccionadoIda.item.precioCabina * 1.35);
    }
  }

  if (idSeleccionadoRetorno) {
    idSeleccionadoRetorno = JSON.parse(idSeleccionadoRetorno);
    var tipoCabinaRetorno = idSeleccionadoRetorno.tipoCabina;

    if (tipoCabinaRetorno == 1) {
      precioFinal += parseFloat(idSeleccionadoRetorno.item.precioCabina);
    } else if (tipoCabinaRetorno == 2) {
      precioFinal += Math.round(idSeleccionadoRetorno.item.precioCabina * 1.35);
    }
  }

  // Verificar y calcular precios basados en dataIda y dataRetorno
  if (dataIda) {
    dataIda = JSON.parse(dataIda);
    precioFinal *= dataIda.length;
  }

  if (dataRetorno) {
    dataRetorno = JSON.parse(dataRetorno);
    precioFinal *= dataRetorno.length;
  }

  setTimeout(function() {
    var precioFinalElement = document.getElementById('precio-final');
    console.log("🚀 ~ Confirmacion ~ precioFinal:", precioFinal);
    precioFinalElement.innerHTML = 'Valor: ' + precioFinal;
  }, 1000); // Añadir un retraso para asegurar que loadRegreso termine
}


function emitir() {
  var dataRetorno = JSON.parse(localStorage.getItem("dataRetorno"));
  var dataIda = JSON.parse(localStorage.getItem("dataIda"));

  if (dataRetorno !== null) {
    dataRetorno.forEach(item => {
      var data = {
        "lastName": item.lastName,
        "firstName": item.firstName,
        "cabinTypesID": {
          "id": item.cabinTypesID.id
        },
        "scheduleID": {
          "id": item.scheduleID.id
        },
        "usersID": {
          "id": item.usersID.id
        },
        "email": item.email,
        "passportCountryID": {
          "id": item.passportCountryID.id
        },
        "bookingReference": item.bookingReference,
        "passportPhoto": item.passportPhoto,
        "passportNumber": item.passportNumber,
        "confirmed": true,
        "phone": item.phone,
        "birthday": item.birthday
      };
      var jsonData = JSON.stringify(data);
      save("http://localhost:9000/Airlines/v1/api/Tickets", jsonData);
      localStorage.removeItem("dataRetorno")
    });
  }

  if (dataIda !== null) {
    dataIda.forEach(item => {
      var data = {
        "lastName": item.lastName,
        "firstName": item.firstName,
        "cabinTypesID": {
          "id": item.cabinTypesID.id
        },
        "scheduleID": {
          "id": item.scheduleID.id
        },
        "usersID": {
          "id": item.usersID.id
        },
        "email": item.email,
        "passportCountryID": {
          "id": item.passportCountryID.id
        },
        "bookingReference": item.bookingReference,
        "passportPhoto": item.passportPhoto,
        "passportNumber": item.passportNumber,
        "confirmed": true,
        "phone": item.phone,
        "birthday": item.birthday
      };
      var jsonData = JSON.stringify(data);
      save("http://localhost:9000/Airlines/v1/api/Tickets", jsonData);
      localStorage.removeItem("dataIda")
    });
  }
}

function save(url, data) {

  try {
    $.ajax({
      url: url,
      method: "POST",
      dataType: "json",
      contentType: "application/json",
      data: data,
      success: function(data) {
        alert("Registro agregado con éxito");
        loadData();
      },
      error: function(error) {
        alert(`Error: no se pudo realizar el registro.`);
        console.error("Error en la solicitud:", error);
      },
    });
  } catch (error) {
    console.error("Error en la solicitud:", error);
  }
}

function tickets() {
  var idSeleccionadoIda = localStorage.getItem("idSeleccionadoIda");
  var idSeleccionadoRetorno = localStorage.getItem("idSeleccionadoRetorno");

  var cantidadTiket = localStorage.getItem("cantidadTiket");
  var precioFinalElement = document.getElementById('valor');
 
  

  if (idSeleccionadoIda !== null && idSeleccionadoRetorno !== null) {
    precioFinalElement.innerHTML = 'Cantidad de tickets: ' + cantidadTiket * 2;
    cantidaTiketFacturados = cantidadTiket * 2;
  } else {
    precioFinalElement.innerHTML = 'Cantidad de tickets: ' + cantidadTiket;
    cantidaTiketFacturados = cantidadTiket;
  }
 
  updateCantidadOrdenada();

}
function updateCantidadOrdenada() {
  var valorOrdenadosElement = document.getElementById('valorOrdenados');
  valorOrdenadosElement.innerHTML = 'Cantidad ordenada: ' + cantidaTiketFacturados;
}









//z
function handleFileUpload(file) {
  var reader = new FileReader();

  return new Promise((resolve, reject) => {
    reader.onloadend = function() {
      resolve(reader.result); // Retornar el resultado del archivo leído como base64
    };
    reader.onerror = function() {
      reject(reader.error); // Manejar errores de lectura
    };
    
    if (file) {
      reader.readAsDataURL(file);
    } else {
      reject("No se ha seleccionado ningún archivo");
    }
  });
}

// Función para guardar los datos del registro de ida
async function saveIDa(idSeleccionadoIda, cabinaType) {
  var dataIda = JSON.parse(localStorage.getItem("dataIda")) || []; // Cargar datos existentes

  if (dataIda.length >= cantidadTiket) {
    alert("Se ha alcanzado el límite de boletos de ida");
    return;
  }

  try {
    var file = $("#formFile")[0].files[0];
    var passportPhotoBase64 = await handleFileUpload(file);

    var storedData = JSON.parse(localStorage.getItem("idSeleccionadoIda"));
    if (!storedData) {
      console.error("No se encontraron datos en localStorage");
      return;
    }

    var item = storedData.item;
    var selectedCountriesId = parseInt($("#selected_Countries_id").val());

    if (isNaN(selectedCountriesId) || selectedCountriesId === null) {
      console.error("ID de ciudad no válido");
      return;
    }

    // Crear el nuevo registro
    var newData = {
      lastName: $("#lastName").val(),
      firstName: $("#firstName").val(),
      cabinTypesID: { id: cabinaType },
      scheduleID: { id: item.id },
      usersID: { id: 1 },
      email: $("#email").val(),
      passportCountryID: { id: selectedCountriesId },
      bookingReference: "hsdeff",
      passportPhoto: passportPhotoBase64,
      passportNumber: $("#passportNumber").val(),
      confirmed: false,
      phone: $("#phone").val(),
      birthday: $("#birthday").val(),
    };

    // Verificar si el registro ya existe
    if (!dataIda.some(data => data.passportNumber === newData.passportNumber)) {
      dataIda.push(newData);
      localStorage.setItem("dataIda", JSON.stringify(dataIda));
      limpiarCampos();
      loadData(); // Actualizar la tabla de datos mostrados
    } else {
      alert("Este pasaporte ya está registrado.");
    }
  } catch (error) {
    console.error("Error al cargar la imagen:", error);
  }
}

// Función para guardar los datos del registro de retorno
async function saveRetorno(idSeleccionadoRetorno, cabinaType) {
  var dataRetorno = JSON.parse(localStorage.getItem("dataRetorno")) || []; // Cargar datos existentes

  if (dataRetorno.length >= cantidadTiket) {
    alert("Se ha alcanzado el límite de boletos de retorno");
    return;
  }

  try {
    var file = $("#formFile")[0].files[0];
    var passportPhotoBase64 = await handleFileUpload(file);

    var selecionadaRetornoId = JSON.parse(localStorage.getItem("idSeleccionadoRetorno"));
    if (!selecionadaRetornoId) {
      console.error("No se encontraron datos en localStorage");
      return;
    }

    var item = selecionadaRetornoId.item;
    var selectedCountriesId = parseInt($("#selected_Countries_id").val());

    if (isNaN(selectedCountriesId) || selectedCountriesId === null) {
      console.error("ID no válido");
      return;
    }

    // Crear el nuevo registro
    var newData = {
      lastName: $("#lastName").val(),
      firstName: $("#firstName").val(),
      cabinTypesID: { id: cabinaType },
      scheduleID: { id: item.id },
      usersID: { id: 1 },
      email: $("#email").val(),
      passportCountryID: { id: selectedCountriesId },
      bookingReference: "hsdeff",
      passportPhoto: passportPhotoBase64,
      passportNumber: $("#passportNumber").val(),
      confirmed: false,
      phone: $("#phone").val(),
      birthday: $("#birthday").val(),
    };

    // Verificar si el registro ya existe
    if (!dataRetorno.some(data => data.passportNumber === newData.passportNumber)) {
      dataRetorno.push(newData);
      localStorage.setItem("dataRetorno", JSON.stringify(dataRetorno));
      limpiarCampos();
      loadData(); 
    } else {
      alert("Este pasaporte ya está registrado.");
    }
  } catch (error) {
    console.error("Error al cargar la imagen:", error);
  }
}

// Función principal para guardar dependiendo del contexto (ida, retorno o ambos)

async function guardar() {
  var idSeleccionadoIda = localStorage.getItem("idSeleccionadoIda");
  var idSeleccionadoRetorno = localStorage.getItem("idSeleccionadoRetorno");
  var cabinaType = localStorage.getItem("Idcabina");


  if (idSeleccionadoIda) {
    await saveIDa(idSeleccionadoIda, cabinaType);
    
  }
  if (idSeleccionadoRetorno) {
    await saveRetorno(idSeleccionadoRetorno, cabinaType);
    
    
  }
}

//limpiar input
function limpiarCampos() {
  $("#formFile").val(""); // Limpiar el campo de archivo
  $("#lastName").val("");
  $("#firstName").val("");
  $("#birthday").val("");
  $("#passportNumber").val("");
  $("#selected_Countries_id").val("");
  $("#phone").val("");
  $("#email").val("");
  $("#selected_Countries_id").val("");
  

  // Eliminar las clases de validación del formulario
  var form = document.getElementById('myForm');
  form.classList.remove('was-validated');
  // Eliminar los estilos de validación de los campos individuales
  form.querySelectorAll('.form-control').forEach(function(input) {
    input.classList.remove('is-valid', 'is-invalid');
  });
}

var selectedIds = {
  salida: [],
  retorno: []
};

  // Función para cargar y mostrar los datos en la tabla
function loadData() {
  var valorOrdenadosElement = document.getElementById('valorOrdenados');
  valorOrdenadosElement.innerHTML = 'Cantidad ordenada: ' + cantidaTiketFacturados;

  var dataIda = JSON.parse(localStorage.getItem("dataIda")) || [];
  var dataRetorno = JSON.parse(localStorage.getItem("dataRetorno")) || [];

  cantidaTiketFacturados = dataIda.length + dataRetorno.length;
  updateCantidadOrdenada();
  var html = "";

  // Crear HTML para mostrar los datos de ida
  dataIda.forEach(function(dataSalida) {
    html += `
      <tr>
        <td>${dataSalida.lastName}</td>
        <td>${dataSalida.firstName}</td>
        <td>${dataSalida.birthday}</td>
        <td>${dataSalida.passportNumber}</td>
        <td>${dataSalida.phone}</td>
        <td>${dataSalida.email}</td>
        <td>
          <button type="button" class="btn btn-secondary" onclick="eliminarArray('${dataSalida.passportNumber}', 'salida')">
            Eliminar
          </button>
          <button type="button" class="btn btn-secondary" onclick="showImageModal('${dataSalida.passportPhoto}')">
            Ver Imagen
          </button>
        </td>
      </tr>`;
  });

  // Crear HTML para mostrar los datos de retorno
  dataRetorno.forEach(function(dataRetorno) {
    html += `
      <tr>
        <td>${dataRetorno.lastName}</td>
        <td>${dataRetorno.firstName}</td>
        <td>${dataRetorno.birthday}</td>
        <td>${dataRetorno.passportNumber}</td>
        <td>${dataRetorno.phone}</td>
        <td>${dataRetorno.email}</td>
        <td>
          <button type="button" class="btn btn-secondary" onclick="showImageModal('${dataRetorno.passportPhoto}')">
            Ver Imagen
          </button>
          <button type="button" class="btn btn-secondary" onclick="eliminarArray('${dataRetorno.passportNumber}', 'retorno')">
            Eliminar
          </button>
        </td>
      </tr>`;
  });

  $("#resultData").html(html); // Insertar HTML en la tabla
}

// Función para eliminar los registros seleccionados
function eliminarArray(passportNumber, tipo) {
  var dataIda = JSON.parse(localStorage.getItem("dataIda")) || [];
  var dataRetorno = JSON.parse(localStorage.getItem("dataRetorno")) || [];

  if (tipo === "salida") {
    // Filtrar el array para eliminar el registro
    dataIda = dataIda.filter(dataSalida => dataSalida.passportNumber !== passportNumber);
    localStorage.setItem("dataIda", JSON.stringify(dataIda));
  } else if (tipo === "retorno") {
    // Filtrar el array para eliminar el registro
    dataRetorno = dataRetorno.filter(dataRetorno => dataRetorno.passportNumber !== passportNumber);
    localStorage.setItem("dataRetorno", JSON.stringify(dataRetorno));
  }

  loadData(); // Volver a cargar los datos en la tabla después de la eliminación
}

  // JavaScript for validation without page reload

// Función para manejar la selección de checkboxes
function toggleSeleccion(id, tipo) {
  if (tipo === 'salida') {
    if (selectedIds.salida.includes(id)) {
      selectedIds.salida = selectedIds.salida.filter(selectedId => selectedId !== id);
    } else {
      selectedIds.salida.push(id);
    }
  } else if (tipo === 'retorno') {
    if (selectedIds.retorno.includes(id)) {
      selectedIds.retorno = selectedIds.retorno.filter(selectedId => selectedId !== id);
    } else {
      selectedIds.retorno.push(id);
    }
  }
}




function showImageModal(imageBase64) {
  // Eliminar modal existente si hay uno abierto
  $("#imageModal").remove();

  // Crear el HTML del nuevo modal con la imagen proporcionada
  var modalHtml = `
    <div class="modal fade" id="imageModal" tabindex="-1" aria-labelledby="imageModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="imageModalLabel">Imagen del Pasaporte</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <img src="${imageBase64}" alt="Passport Image" class="img-fluid">
          </div>
        </div>
      </div>
    </div>`;

  // Agregar el modal al cuerpo del documento
  $("body").append(modalHtml);

  // Obtener la instancia del modal y mostrarlo
  var imageModal = new bootstrap.Modal(document.getElementById("imageModal"));
  imageModal.show();

  // Remover modal del DOM al cerrarlo
  $("#imageModal").on("hidden.bs.modal", function() {
    $(this).remove();
  });
}
//lamar a loadData para inicializar la tabla al cargar la página
function eliminar(){
  localStorage.removeItem("idSeleccionadoRetorno");
  localStorage.removeItem("dataRetorno");
  localStorage.removeItem("dataIda");
  localStorage.removeItem("cantidadTiket");
  localStorage.removeItem("idSeleccionadoIda");
  window.open("../../view/Operational/Reserva.html")
}

var rutaIm = "";

 
  

