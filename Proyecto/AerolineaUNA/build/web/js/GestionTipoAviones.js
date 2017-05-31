

$(document).ready(function () {
    consultarAviones();
});

$(function () {
 $("#enviar").click(function () {
        enviar();
    });
    
 $("#cancelar").click(function () {
    limpiarForm();
        });
    });

function consultarAviones() {
    mostrarModal("myModal", "Espere por favor..", "Consultando la información de Aviones en la base de datos","false");
    //Se envia la información por ajax
    $.ajax({
        url: 'AvionServlet',
        data: {
            accion: 'consultarAviones'
        },
        error: function () { //si existe un error en la respuesta del ajax
            alert("Se presento un error a la hora de cargar la información de los Aviones en la base de datos");
        },
        success: function (data) { //si todo esta correcto en la respuesta del ajax, la respuesta queda en el data
            dibujarTabla(data);
            // se oculta el modal esta funcion se encuentra en el utils.js
            ocultarModal("myModal");

        },
        type: 'POST',
        dataType: "json"
    });
}

function dibujarTabla(dataJson) {
    //limpia la información que tiene la tabla
    $("#tablaAviones").html(""); 
    
    //muestra el enzabezado de la tabla
    var head = $("<thead />");
    var row = $("<tr />");
    head.append(row);
    $("#tablaAviones").append(head);
    row.append($("<th><b>ID</b></th>"));
    row.append($("<th><b>ANNO</b></th>"));
    row.append($("<th><b>MODELO</b></th>"));
    row.append($("<th><b>MARCA</b></th>"));
    row.append($("<th><b>CANT FILAS</b></th>"));
    row.append($("<th><b>CANT ASIENTOS FILA</b></th>"));
    row.append($("<th><b>CAPACIDAD</b></th>"));
    row.append($("<th><b>ACCIÓN</th>"));
    
    //carga la tabla con el json devuelto
    for (var i = 0; i < dataJson.length; i++) {
        dibujarFila(dataJson[i]);
    }
}

function dibujarFila(rowData) {
    //Cuando dibuja la tabla en cada boton se le agrega la funcionalidad de cargar o eliminar la informacion
    //de una persona
    
    var row = $("<tr />");
   $("#tablaAviones").append(row);
    row.append($("<td>" + rowData.idAvion + "</td>"));
    row.append($("<td>" + rowData.ano + "</td>"));
    row.append($("<td>" + rowData.modelo + "</td>"));
    row.append($("<td>" + rowData.marca + "</td>"));
    row.append($("<td>" + rowData.cantidadFila + "</td>"));
    row.append($("<td>" + rowData.cantidadAsientosFila + "</td>"));
    row.append($("<td>" + rowData.cantidadFila * rowData.cantidadAsientosFila + "</td>"));
    row.append($('<td><button type="button" class="btn btn-default btn-xs" aria-label="Left Align" onclick="consultarAvionByID('+"'"+rowData.idAvion+"'"+');">'+
                        '<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>'+
                    '</button>'+
                    '<button type="button" class="btn btn-default btn-xs" aria-label="Left Align" onclick="eliminarAvion('+"'"+rowData.idAvion+"'"+');">'+
                        '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>'+
                    '</button></td>'));
}

function mostrarMensaje(classCss, msg, neg) {
    //se le eliminan los estilos al mensaje
    $("#mesajeResult").removeClass();

    //se setean los estilos
    $("#mesajeResult").addClass(classCss);

    //se muestra la capa del mensaje con los parametros del metodo
    $("#mesajeResult").fadeIn("slow");
    $("#mesajeResultNeg").html(neg);
    $("#mesajeResultText").html(msg);
    $("#mesajeResultText").html(msg);
}

function eliminarAvion(idAvion) {
   $("#myModalTitle").html("Eliminar Avion");
     $("#myModalMessage").html("Esta Seguro que desea Eliminar avion "+idAvion+" ?");
      $("#myModalFooter").html('<button class="btn btn-primary" onclick="eliminar('+"'"+idAvion+"'"+');">Aceptar</button>'+
              "<button  class='btn btn-danger' data-dismiss='modal' >Cancelar</button>");
         $("#myModal").modal("show");
        

}

//******************************************************************************
//******************************************************************************
//metodos para eliminar personas
//******************************************************************************
//******************************************************************************

function consultarAvionByID(idAvion) {
    mostrarModal("myModal", "Espere por favor..", "Consultando el Avion seleccionado","false");
    //Se envia la información por ajax
    $.ajax({
        url: 'AvionServlet',
        data: {
            accion: "consultarAvionByID",
            idAvion: idAvion
        },
        error: function () { //si existe un error en la respuesta del ajax
            cambiarMensajeModal("myModal","Resultado acción","Se presento un error, contactar al administador");
        },
        success: function (data) { //si todo esta correcto en la respuesta del ajax, la respuesta queda en el data
            // se oculta el mensaje de espera
            ocultarModal("myModal");
            limpiarForm();
       
            
            //************************************************************************
            //carga información de la persona en el formulario
            //************************************************************************
            //se indicar que la cédula es solo readOnly
            $("#identificador").attr('readonly', 'readonly');
            
            //se modificar el hidden que indicar el tipo de accion que se esta realizando
            $("#avionesAction").val("modificarAvion"); 
            $("#cancelar").removeClass("hidden");
            //se carga la información en el formulario
            $("#identificador").val(data.idAvion);
            $("#ano").val(data.ano);
            $("#marca").val(data.marca);
            $("#modelo").val(data.modelo);
            $("#cantFilas").val(data.cantidadFila);
            $("#cantAsientosFila").val(data.cantidadAsientosFila);
            
        },
        type: 'POST',
        dataType: "json"
    });
}

function eliminar(idAvion) {
    
    $.ajax({
        url: 'AvionServlet',
        data: {
            accion: "eliminarAvion",
            idAvion: idAvion
        },
        error: function () { //si existe un error en la respuesta del ajax
            cambiarMensajeModal("myModal","Resultado acción","Se presento un error, contactar al administador");
        },
        success: function (data) { //si todo esta correcto en la respuesta del ajax, la respuesta queda en el data
            // se cambia el mensaje del modal por la respuesta del ajax
            var respuestaTxt = data.substring(2);
            var tipoRespuesta = data.substring(0, 2);
            if (tipoRespuesta === "E~") {
                cambiarMensajeModal("myModal","Resultado acción",respuestaTxt);
            }else{
                setTimeout(consultarAviones, 3000);// hace una pausa y consulta la información de la base de datos
            }
        },
        type: 'POST',
        dataType: "text"
    });
}

function enviar() {
    if(!validar()){
        mostrarMensaje("alert alert-danger", "Debe digitar los campos del formulario", "Error!");
    }
    else if(!validarTamCampos()){
        mostrarMensaje("alert alert-danger", "Tamaño de los campos marcados Excedido", "Error!");
    }
    
    else if(!validarNumeros()){
        mostrarMensaje("alert alert-danger", "Solo numeros permitidos", "Error!");
    }
        
    else {
        //Se envia la información por ajax
        $.ajax({
            url: 'AvionServlet',
            data: {
                accion: $("#avionAction").val(),
                idAvion: $("#identificador").val(),
                ano: $("#ano").val(),
                marca: $("#marca").val(),
                modelo: $("#modelo").val(),
                cantFilas: $("#cantFilas").val(),
                cantAsientosFila: $("#cantAsientosFila").val()
                
            },
            error: function () { //si existe un error en la respuesta del ajax
                mostrarMensaje("alert alert-danger", "Se genero un error, contacte al administrador (Error del ajax)", "Error!");
            },
            success: function (data) { //si todo esta correcto en la respuesta del ajax, la respuesta queda en el data
                var respuestaTxt = data.substring(2);
                var tipoRespuesta = data.substring(0, 2);
                if (tipoRespuesta === "C~") {
                    if($("#avionAction").val() == "agregarAvion")
                    mostrarModal("myModal", "Exito", "Avion agregado Correctamente!","true");
                else
                    mostrarModal("myModal", "Exito", "Avion Modificado Correctamente!","true");
                
                    limpiarForm();
                    setTimeout(consultarAviones, 3000);
                } else {
                    if (tipoRespuesta === "E~") {
                        mostrarMensaje("alert alert-danger", respuestaTxt, "Error!");
                    } else {
                        mostrarMensaje("alert alert-danger", "Se genero un error, contacte al administrador", "Error!");
                    }
                }

            },
            type: 'POST'
        });
    } 
}

function validar() {
    var validacion = true;

    //Elimina estilo de error en los css
    //notese que es sobre el grupo que contienen el input
    $("#groupId").removeClass("has-error");
    $("#groupAno").removeClass("has-error");
    $("#groupMarca").removeClass("has-error");
    $("#groupModelo").removeClass("has-error");
    $("#groupCantFilas").removeClass("has-error");
    $("#groupCantAsientosFila").removeClass("has-error");
    
    

    //valida cada uno de los campos del formulario
    //Nota: Solo si fueron digitados
    if ($("#identificador").val() === "") {
        $("#groupId").addClass("has-error");
        validacion = false;
    }
    
    if ($("#ano").val() === "") {
        $("#groupAno").addClass("has-error");
        validacion = false;
    }
    
    if ($("#marca").val() === "") {
        $("#groupMarca").addClass("has-error");
        validacion = false;
    }
    if ($("#modelo").val() === "") {
        $("#groupModelo").addClass("has-error");
        validacion = false;
    }
    if ($("#cantFilas").val() === "") {
        $("#groupCantFilas").addClass("has-error");
        validacion = false;
    }
    if ($("#cantAsientosFila").val() === "") {
        $("#groupCantAsientosFila").addClass("has-error");
        validacion = false;
    }
    

    return validacion;
}

function limpiarForm() {
    //setea el focus del formulario
    $('#Identificador').focus();
     $("#cancelar").addClass("hidden");
    //se cambia la accion por agregarPersona
    $("#avionAction").val("agregarAvion"); 
    $("#identificador").removeAttr("readonly");

    //esconde el div del mensaje
    mostrarMensaje("hiddenDiv", "", "");

    //Resetear el formulario
    $('#formAvion').trigger("reset");
}



function validarNumeros(){
    $("#groupAno").removeClass("has-error");
    $("#groupCantFilas").removeClass("has-error");
    $("#groupCantAsientosFila").removeClass("has-error");
    var validacion =true;
   var contenido = $("#cantFilas").val();
    if(isNaN(contenido)){
         $("#groupCantFilas").addClass("has-error");
       validacion = false;
   }
   contenido = $("#ano").val();
    if(isNaN(contenido)){
         $("#groupAno").addClass("has-error");
       validacion = false;
   }
    contenido = $("#cantAsientosFila").val();
    if(isNaN(contenido)){
         $("#groupCantAsientosFila").addClass("has-error");
       validacion = false;
   }
   
   return validacion;
}

function validarTamCampos() {
    var validacion = true;

    //Elimina estilo de error en los css
    //notese que es sobre el grupo que contienen el input
    $("#groupId").removeClass("has-error");
    $("#groupMarca").removeClass("has-error");
    $("#groupModelo").removeClass("has-error");
    $("#groupAno").removeClass("has-error");
    $("#groupCantFilas").removeClass("has-error");
    $("#groupCantAsientosFila").removeClass("has-error");
    
    

    //valida cada uno de los campos del formulario
    //Nota: Solo si fueron digitados
    if ($("#identificador").val().length >8) {
        $("#groupId").addClass("has-error");
        validacion = false;
    }
    if ($("#marca").val().length >8) {
        $("#groupMarca").addClass("has-error");
        validacion = false;
    }
    if ($("#modelo").val().length >8) {
        $("#groupModelo").addClass("has-error");
        validacion = false;
    }
    if ($("#ano").val().length >4) {
        $("#groupAno").addClass("has-error");
        validacion = false;
    }
    if ($("#cantFilas").val().length>2) {
        $("#groupCantFilas").addClass("has-error");
        validacion = false;
    }
    if ($("#cantAsientosFila").val().length>2) {
        $("#groupCantAsientosFila").addClass("has-error");
        validacion = false;
    }
    
    

    return validacion;
}



