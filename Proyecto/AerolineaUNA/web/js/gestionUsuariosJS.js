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

    //agrega los eventos las capas necesarias
    $("#cancelar").click(function () {
        limpiarForm();
        $("#myModal").modal("hide");
    });

});

//******************************************************************************
//******************************************************************************
//El metodo enviar funciona tanto para el insertar como para el modificar
//******************************************************************************
//******************************************************************************

function enviar() {
    if (!validar()) {
        mostrarMensaje("alert alert-danger", "Debe digitar los campos del formulario", "Error!");
    } else if (!validarTamCampos()) {
        mostrarMensaje("alert alert-danger", "Tamaño de los campos marcados Excedido", "Error!");
    } else if (!validarCedula()) {
        mostrarMensaje("alert alert-danger", "Formato de cedula Erroneo, solo numeros permitidos", "Error!");
    } else {
        //Se envia la información por ajax
        $.ajax({
            url: 'UsuarioServlet',
            data: {
                accion: $("#usuariosAction").val(),
                idUsuario: $("idUsuario").val(),
                correo: $("#correo").val(),
                password: $("#password").val(),
                nombre: $("#nombre").val(),
                apellido1: $("#primerApellido").val(),
                apellido2: $("#segundoApellido").val(),
                telefono1: $("#telefono1").val(),
                telefono2: $("#telefono2").val(),
                direccion: $("#direccion").val(),
                fechaNacimiento: $("#fechaNacimiento").data('date'),
                tipo: "administrador"
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
    $("#groupID").removeClass("has-error");
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
    if ($("#idUsuario").val() === "") {
        $("#groupID").addClass("has-error");
        validacion = false;
    }
    
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


