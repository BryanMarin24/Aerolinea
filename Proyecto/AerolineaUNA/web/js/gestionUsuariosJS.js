//******************************************************************************
// // Funcion para generar el datetimepicker
// Además de agregar los eventos a las respectivas etiquetas
//******************************************************************************
$(function () {
    //Genera el datapicker
    $('#fechaNacimiento').datetimepicker({
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });

    //agrega los eventos las capas necesarias
    $("#enviar").click(function () {
        enviar();
    });

    $("#buscar").click(function () {
        consultarPersonasByNombre();
    });

    //agrega los eventos las capas necesarias
    $("#cancelar").click(function () {
        limpiarForm();
        $("#myModal").modal("hide");
    });

});

//******************************************************************************
//Se ejecuta cuando la página esta completamente cargada
//******************************************************************************

$(document).ready(function () {
    consultarUsuarios();
});

//******************************************************************************
//******************************************************************************
//metodos para consultas el listado de las personas
//******************************************************************************
//******************************************************************************

function consultarUsuarios() {
    mostrarModal("myModal", "Espere por favor..", "Consultando la información de usuarios en la base de datos");
    //Se envia la información por ajax
    $.ajax({
        url: 'UsuarioServlet',
        data: {
            accion: "consultarUsuarios"
        },
        error: function () { //si existe un error en la respuesta del ajax
            alert("Se presento un error a la hora de cargar la información de los usuarios en la base de datos");
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
    $("#tablaUsuarios").html("");

    //muestra el enzabezado de la tabla
    var head = $("<thead />");
    var row = $("<tr />");
    head.append(row);
    $("#tablaUsuarios").append(head);
    row.append($("<th><b>ID</b></th>"));
    row.append($("<th><b>CORREO</b></th>"));
    row.append($("<th><b>NOMBRE</b></th>"));
    row.append($("<th><b>PRIMER APELLIDO</b></th>"));
    row.append($("<th><b>SEGUNDO APELLIDO</b></th>"));
    row.append($("<th><b>TELEFONO 1</b></th>"));
    row.append($("<th><b>TELEFONO 2</b></th>"));
    row.append($("<th><b>DIRECCION</b></th>"));
    row.append($("<th><b>FEC. NAC.</b></th>"));
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
    $("#tablaUsuarios").append(row);
    row.append($("<td>" + rowData.idUsuario + "</td>"));
    row.append($("<td>" + rowData.correo + "</td>"));
    row.append($("<td>" + rowData.nombre + "</td>"));
    row.append($("<td>" + rowData.apellido1 + "</td>"));
    row.append($("<td>" + rowData.apellido2 + "</td>"));
    row.append($("<td>" + rowData.telefonoCelular + "</td>"));
    row.append($("<td>" + rowData.telefonoLocal + "</td>"));
    row.append($("<td>" + rowData.fechaNacimiento + "</td>"));
    row.append($('<td><button type="button" class="btn btn-default btn-xs" aria-label="Left Align" onclick="consultarPersonaByID(' + rowData.pkCedula + ');">' +
            '<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>' +
            '</button>' +
            '<button type="button" class="btn btn-default btn-xs" aria-label="Left Align" onclick="eliminarPersona(' + rowData.pkCedula + ');">' +
            '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>' +
            '</button></td>'));
}

//******************************************************************************
//******************************************************************************
//El metodo enviar funciona tanto para el insertar como para el modificar
//******************************************************************************
//******************************************************************************

function enviar() {
    if (!validar()) {
        mostrarMensaje("alert alert-danger", "Debe digitar los campos del formulario", "Error!");
    }
    else if (!validarTamCampos()) {
        mostrarMensaje("alert alert-danger", "Tamaño de los campos marcados Excedido", "Error!");
    }

    else if (!validarCedula()) {
        mostrarMensaje("alert alert-danger", "Formato de cedula Erroneo, solo numeros permitidos", "Error!");
    }

    else {
        //Se envia la información por ajax
        $.ajax({
            url: 'UsuarioServlet',
            data: {
                accion: $("#usuariosAction").val(),
                correo: $("#correo").val(),
                password: $("#password").val(),
                nombre: $("#nombre").val(),
                apellido1: $("#primerApellido").val(),
                apellido2: $("#segundoApellido").val(),
                telefono1: $("#telefono1").val(),
                telefono2: $("#telefono2").val(),
                direccion: $("#direccion").val(),
                fechaNacimiento: $("#fechaNacimiento").data('date')
            },
            error: function () { //si existe un error en la respuesta del ajax
                mostrarMensaje("alert alert-danger", "Se genero un error, contacte al administrador (Error del ajax)", "Error!");
            },
            success: function (data) { //si todo esta correcto en la respuesta del ajax, la respuesta queda en el data
                var respuestaTxt = data.substring(2);
                var tipoRespuesta = data.substring(0, 2);
                if (tipoRespuesta === "C~") {
                    mostrarMensaje("alert alert-success", respuestaTxt, "Correcto!");
                    $("#myModal").modal("hide");
                    consultarPersonas();
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
    $("#groupCorreo").removeClass("has-error");
    $("#groupPassword").removeClass("has-error");
    $("#groupNombre").removeClass("has-error");
    $("#groupPrimerApellido").removeClass("has-error");
    $("#groupSegundoApellido").removeClass("has-error");
    $("#groupTelefono1").removeClass("has-error");
    $("#groupTelefono2").removeClass("has-error");
    $("#groupDireccion").removeClass("has-error");
    $("#groupFechaNac").removeClass("has-error");
    

    //valida cada uno de los campos del formulario
    //Nota: Solo si fueron digitados
    if ($("#correo").val() === "") {
        $("#groupCorreo").addClass("has-error");
        validacion = false;
    }
    
    if ($("#password").val() === "") {
        $("#groupPassword").addClass("has-error");
        validacion = false;
    }
    
    if ($("#nombre").val() === "") {
        $("#groupNombre").addClass("has-error");
        validacion = false;
    }
    
    if ($("#primerApellido").val() === "") {
        $("#groupPrimerApellido").addClass("has-error");
        validacion = false;
    }
    if ($("#segundoApellido").val() === "") {
        $("#groupSegundoApellido").addClass("has-error");
        validacion = false;
    }
     if ($("#telefono1").val() === "") {
        $("#groupTelefono1").addClass("has-error");
        validacion = false;
    }
     if ($("#telefono2").val() === "") {
        $("#groupTelefono2").addClass("has-error");
        validacion = false;
    }
    if ($("#fechaNacimiento").data('date') === "") {
        $("#groupFechaNac").addClass("has-error");
        validacion = false;
    }

    return validacion;
}

//******************************************************************************
//******************************************************************************
//metodos para eliminar personas
//******************************************************************************
//******************************************************************************

function eliminarUsuario(idUsuario) {
    $("#myModalTitle").html("Eliminar Usuario");
    $("#myModalMessage").html("Esta Seguro que desea Eliminar a " + idUsuario + " ?");
    $("#myModalFooter").html("<button class='btn btn-primary' onclick='eliminar(" + idUsuario + ")'>Aceptar</button>" +
            "<button  class='btn btn-danger' data-dismiss='modal' >Cancelar</button>");
    $("#myModal").modal("show");


}

//******************************************************************************
//******************************************************************************
//metodos para eliminar personas
//******************************************************************************
//******************************************************************************

/*function consultarUsuarioByID(idUsuario) {
    mostrarModal("myModal", "Espere por favor..", "Consultando el usuario seleccionada");
    //Se envia la información por ajax
    $.ajax({
        url: 'UsuariosServlet',
        data: {
            accion: "consultarUsuariosByID",
            idUsuario: idUsuario
        },
        error: function () { //si existe un error en la respuesta del ajax
            cambiarMensajeModal("myModal", "Resultado acción", "Se presento un error, contactar al administador");
        },
        success: function (data) { //si todo esta correcto en la respuesta del ajax, la respuesta queda en el data
            // se oculta el mensaje de espera
            ocultarModal("myModal");
            limpiarForm();
            //se muestra el formulario
            $("#myModalFormulario").modal();

            //************************************************************************
            //carga información de la persona en el formulario
            //************************************************************************
            //se indicar que la cédula es solo readOnly
            $("#cedula").attr('readonly', 'readonly');

            //se modificar el hidden que indicar el tipo de accion que se esta realizando
            $("#personasAction").val("modificarPersona");

            //se carga la información en el formulario
            $("#cedula").val(data.pkCedula);
            $("#nombre").val(data.nombre);
            $("#apellido1").val(data.apellido1);
            $("#apellido2").val(data.apellido2);

            //carga de fecha
            var fecha = new Date(data.fecNacimiento);


            var fechatxt = fecha.getDate() + "/" + fecha.getMonth() + 1 + "/" + fecha.getFullYear();
            $("#dpFechaNacimiento").data({date: fechatxt});
            $("#dpFechaNacimientoText").val(fechatxt);

            //$("#dpFechaNacimiento")$('.datepicker').datepicker('update', new Date(2011, 2, 5));
            $("#sexo").val(data.sexo);
            $("#observaciones").val(data.observaciones);
        },
        type: 'POST',
        dataType: "json"
    });
}*/

function consultarUsuariosByNombre() {
    var nombreUsuario = $("#nombreUsuario").val();
    mostrarModal("myModal", "Espere por favor..", "Consultando el usuario seleccionada");
    //Se envia la información por ajax
    $.ajax({
        url: 'UsuarioServlet',
        data: {
            accion: "consultarUsuariosByNombre",
            nombreUsuario: nombreUsuario
        },
        error: function () { //si existe un error en la respuesta del ajax
            cambiarMensajeModal("myModal", "Resultado acción", "Se presento un error, contactar al administador");
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

//******************************************************************************
//******************************************************************************

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

//******************************************************************************
//******************************************************************************

function limpiarForm() {
    //setea el focus del formulario
    $('#correo').focus();
    $("#correo").removeAttr("readonly"); //elimina el atributo de solo lectura

    //se cambia la accion por agregarPersona
    $("#usuariosAction").val("agregarUsuario");

    //esconde el div del mensaje
    mostrarMensaje("hiddenDiv", "", "");

    //Resetear el formulario
    $('#formUsuarios').trigger("reset");
}

function validarCorreo() {
    $("#groupCorreo").removeClass("has-error");

    var contenido = $("#correo").val();
    if (isNaN(contenido)) {
        $("#groupCorreo").addClass("has-error");
        return false;
    } else {
        return true;
    }
}

function validarTamCampos() {
    var validacion = true;

    //Elimina estilo de error en los css
    //notese que es sobre el grupo que contienen el input
    $("#groupCorreo").removeClass("has-error");
    $("#groupPassword").removeClass("has-error");
    $("#groupNombre").removeClass("has-error");
    $("#groupPrimerApellido").removeClass("has-error");
    $("#groupSegundoApellido").removeClass("has-error");
    $("#groupTelefono1").removeClass("has-error");
    $("#groupTelefono2").removeClass("has-error");
    $("#groupDireccion").removeClass("has-error");
    $("#groupFechaNacimiento").removeClass("has-error");

    //valida cada uno de los campos del formulario
    //Nota: Solo si fueron digitados
    if ($("#correo").val().length > 11) {
        $("#groupCorreo").addClass("has-error");
        validacion = false;
    }
    if ($("#password").val().length > 45) {
        $("#groupPassword").addClass("has-error");
        validacion = false;
    }
    if ($("#nombre").val().length > 45) {
        $("#groupNombre").addClass("has-error");
        validacion = false;
    }
    if ($("#primerApellido").val().length > 45) {
        $("#groupPrimerApellido").addClass("has-error");
        validacion = false;
    }
    if ($("#segundoApellido").val().length > 45) {
        $("#groupSegundoApellido").addClass("has-error");
        validacion = false;
    }
    if ($("#telefono1").val().length > 45) {
        $("#groupTelefono1").addClass("has-error");
        validacion = false;
    }
    if ($("#telefono2").val().length > 45) {
        $("#groupTelefono2").addClass("has-error");
        validacion = false;
    }
    if ($("#direccion").val().length > 45) {
        $("#groupDireccion").addClass("has-error");
        validacion = false;
    }


    return validacion;
}

function eliminar(idUsuario) {

    $.ajax({
        url: 'UsuarioServlet',
        data: {
            accion: "eliminarUsuarios",
            idPersona: idUsuario
        },
        error: function () { //si existe un error en la respuesta del ajax
            cambiarMensajeModal("myModal", "Resultado acción", "Se presento un error, contactar al administador");
        },
        success: function (data) { //si todo esta correcto en la respuesta del ajax, la respuesta queda en el data
            // se cambia el mensaje del modal por la respuesta del ajax
            var respuestaTxt = data.substring(2);
            var tipoRespuesta = data.substring(0, 2);
            if (tipoRespuesta === "E~") {
                cambiarMensajeModal("myModal", "Resultado acción", respuestaTxt);
            } else {
                setTimeout(consultarUsuarios, 3000);// hace una pausa y consulta la información de la base de datos
            }
        },
        type: 'POST',
        dataType: "text"
    });
}

