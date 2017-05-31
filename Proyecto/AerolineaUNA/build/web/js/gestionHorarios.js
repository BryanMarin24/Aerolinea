

$(document).ready(function () {
    consultarHorarios();
});

$(function () {
 $("#enviar").click(function () {
        enviar();
    });
    
 $("#cancelar").click(function () {
    limpiarForm();
        });
    });

function consultarRutas() {
    mostrarModal("myModal", "Espere por favor..", "Consultando la información de rutas en la base de datos","false");
    //Se envia la información por ajax
    $.ajax({
        url: 'RutaServlet',
        data: {
            accion: 'consultarRutas'
        },
        error: function () { //si existe un error en la respuesta del ajax
            alert("Se presento un error a la hora de cargar la información de las rutas en la base de datos");
        },
        success: function (data) { //si todo esta correcto en la respuesta del ajax, la respuesta queda en el data
            anadirRutasSelect(data);
            ocultarModal("myModal");

        },
        type: 'POST',
        dataType: "json"
    });
}

function anadirRutasSelect(dataJson) {
    //limpia la información que tiene la tabla
    $("#idRuta").html(""); 
    
    for (var i = 0; i < dataJson.length; i++) {
        if(dataJson[i].idHorario == null){
         $("#idRuta").append("<option value='"+dataJson[i].idRuta+"'>"+dataJson[i].idRuta+"</option>");
    }
    }
}

function consultarHorarios() {
    mostrarModal("myModal", "Espere por favor..", "Consultando la información de Horarios en la base de datos","false");
    //Se envia la información por ajax
    $.ajax({
        url: 'HorarioServlet',
        data: {
            accion: 'consultarHorarios'
        },
        error: function () { //si existe un error en la respuesta del ajax
            alert("Se presento un error a la hora de cargar la información de las rutas en la base de datos");
        },
        success: function (data) { //si todo esta correcto en la respuesta del ajax, la respuesta queda en el data
            dibujarTabla(data);
            // se oculta el modal esta funcion se encuentra en el utils.js
            ocultarModal("myModal");

        },
        type: 'POST',
        dataType: "json"
    });
    consultarRutas();
}

function dibujarTabla(dataJson) {
    //limpia la información que tiene la tabla
    $("#tablaHorarios").html(""); 
    
    //muestra el enzabezado de la tabla
    var head = $("<thead />");
    var row = $("<tr />");
    head.append(row);
    $("#tablaHorarios").append(head); 
    row.append($("<th><b>ID</b></th>"));
    //row.append($("<th><b>ID RUTA</b></th>"));
    row.append($("<th><b>FECHA SALIDA</b></th>"));
    //row.append($("<th><b>FECHA LLEGADA</b></th>"));
    //row.append($("<th><b>COSTO</b></th>"));
    row.append($("<th><b>ACCION</b></th>"));
    
    //carga la tabla con el json devuelto
    for (var i = 0; i < dataJson.length; i++) {
        dibujarFila(dataJson[i]);
    }
}

function dibujarFila(rowData) {
    //Cuando dibuja la tabla en cada boton se le agrega la funcionalidad de cargar o eliminar la informacion
    //de una persona
    var ruta =consultaRutaHorario(rowData.idHorario);
    var row = $("<tr />");
    $("#tablaHorarios").append(row); 
    row.append($("<td>" + rowData.idHorario + "</td>"));
   // row.append($("<td>" + ruta.idRuta + "</td>"));
    row.append($("<td>" + rowData.dia +" a las "+rowData.hora+ "</td>"));
   // var llegada = consultarLlegada(rowData.dia,rowData.hora);
   // row.append($("<td> $" + llegada + "</td>"));
    //row.append($("<td> $" + ruta.costo +"min</td>"));
    row.append($('<td><button type="button" class="btn btn-default btn-xs" aria-label="Left Align" onclick="consultarHorarioByID('+"'"+rowData.idHorario+"'"+');">'+
                        '<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>'+
                    '</button>'+
                    '<button type="button" class="btn btn-default btn-xs" aria-label="Left Align" onclick="eliminarHorario('+"'"+rowData.idHorario+"'"+');">'+
                        '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>'+
                    '</button></td>'));
}

function consultarLlegada(dia,hora){
    return " n / d";
}

function consultaRutaHorario(idH){ $.ajax({
        url: 'RutaServlet',
        data: {
            accion: 'consultarRutas'
        },
        error: function () { //si existe un error en la respuesta del ajax
            alert("Se presento un error a la hora de cargar la información de las rutas en la base de datos");
        },
        success: function (data) { //si todo esta correcto en la respuesta del ajax, la respuesta queda en el data
            for (var i = 0; i < data.length; i++) {
        if(data[i].idHorario == idH)
            return data[i];
        
       }
            

        },
        type: 'POST',
        dataType: "json"
    });
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

function eliminarHorario(idHorario) {
   $("#myModalTitle").html("Eliminar Horario");
     $("#myModalMessage").html("Esta Seguro que desea Eliminar Horario "+idHorario+" ?");
      $("#myModalFooter").html('<button class="btn btn-primary" onclick="eliminar('+"'"+idHorario+"'"+');">Aceptar</button>'+
              "<button  class='btn btn-danger' data-dismiss='modal' >Cancelar</button>");
         $("#myModal").modal("show");
        

}

//******************************************************************************
//******************************************************************************
//metodos para eliminar personas
//******************************************************************************
//******************************************************************************

function consultarHorarioByID(idHorario) {
    mostrarModal("myModal", "Espere por favor..", "Consultando el horario seleccionado","false");
    //Se envia la información por ajax
    $.ajax({
        url: 'HorarioServlet',
        data: {
            accion: "consultarHorarioByID",
            idHorario: idHorario
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
            $("#horariosAction").val("modificarHorario"); 
            $("#cancelar").removeClass("hidden");
            //se carga la información en el formulario
            $("#identificador").val(data.idHorario);
            $("#dia").val(data.dia);
            $("#hora").val(data.hora);
            
        },
        type: 'POST',
        dataType: "json"
    });
}

function eliminar(idHorario) {
    
    $.ajax({
        url: 'HorarioServlet',
        data: {
            accion: "eliminarHorario",
            idHorario: idHorario
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
                setTimeout(consultarHorarios, 3000);// hace una pausa y consulta la información de la base de datos
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
    
    else {
        //Se envia la información por ajax
        $.ajax({
            url: 'HorarioServlet',
            data: {
                accion: $("#horariosAction").val(),
                idHorario: $("#identificador").val(),
                idRuta: $("#idRuta").val(),
                dia: $("#dia").val(),
                hora: $("#hora").val()
            },
            error: function () { //si existe un error en la respuesta del ajax
                mostrarMensaje("alert alert-danger", "Se genero un error, contacte al administrador (Error del ajax)", "Error!");
            },
            success: function (data) { //si todo esta correcto en la respuesta del ajax, la respuesta queda en el data
                var respuestaTxt = data.substring(2);
                var tipoRespuesta = data.substring(0, 2);
                if (tipoRespuesta === "C~") {
                    if($("#horariosAction").val() == "agregarHorario")
                    mostrarModal("myModal", "Exito", "Horario agregada Correctamente!","true");
                else
                    mostrarModal("myModal", "Exito", "Horario Modificada Correctamente!","true");
                
                    limpiarForm();
                     setTimeout(consultarHorarios, 3000);
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
    $("#groupDia").removeClass("has-error");
    $("#groupHora").removeClass("has-error");
    $("#groupIdRuta").removeClass("has-error");
    
    

    //valida cada uno de los campos del formulario
    //Nota: Solo si fueron digitados
    if ($("#identificador").val() === "") {
        $("#groupId").addClass("has-error");
        validacion = false;
    }
    if ($("#dia").val() == "") {
        $("#groupDia").addClass("has-error");
        validacion = false;
    }
    if ($("#idRuta").val() == null) {
        $("#groupIdRuta").addClass("has-error");
        validacion = false;
    }
    if ($("#hora").val()=="") {
        $("#groupHora").addClass("has-error");
        validacion = false;
    }
   
    return validacion;
}

function limpiarForm() {
    //setea el focus del formulario
    $('#Identificador').focus();
     $("#cancelar").addClass("hidden");
    //se cambia la accion por agregarPersona
    $("#horariosAction").val("agregarHorario"); 
    $("#identificador").removeAttr("readonly");

    //esconde el div del mensaje
    mostrarMensaje("hiddenDiv", "", "");

    //Resetear el formulario
    $('#formHorario').trigger("reset");
}




function validarTamCampos() {
    var validacion = true;

    //Elimina estilo de error en los css
    //notese que es sobre el grupo que contienen el input
    $("#groupId").removeClass("has-error");

    //valida cada uno de los campos del formulario
    //Nota: Solo si fueron digitados
    if ($("#identificador").val().length >8) {
        $("#groupId").addClass("has-error");
        validacion = false;
    }
 
    return validacion;
}



