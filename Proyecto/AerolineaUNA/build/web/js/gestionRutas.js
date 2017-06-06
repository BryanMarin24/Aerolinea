

$(document).ready(function () {
    consultarRutas();
});

$(function () {
 $("#enviar").click(function () {
        enviar();
    });
    
 $("#cancelar").click(function () {
    limpiarForm();
        });
    });
    
    /******AVIONES********/
    
function consultarAviones() {
    mostrarModal("myModal", "Espere por favor..", "Consultando la información de aviones en la base de datos","false");
    //Se envia la información por ajax
    $.ajax({
        url: 'AvionServlet',
        data: {
            accion: 'consultarAviones'
        },
        error: function () { //si existe un error en la respuesta del ajax
            alert("Se presento un error a la hora de cargar la información de las aviones en la base de datos");
        },
        success: function (data) { //si todo esta correcto en la respuesta del ajax, la respuesta queda en el data
            anadirAvionesSelect(data);
            ocultarModal("myModal");

        },
        type: 'POST',
        dataType: "json"
    });
}

function anadirAvionesSelect(dataJson) {
    //limpia la información que tiene la tabla
    $("#idAvion").html(""); 
    
    for (var i = 0; i < dataJson.length; i++) {
        if(dataJson[i].idRuta == null){
         $("#idAvion").append("<option value='"+dataJson[i].idAvion+"'>"+dataJson[i].idAvion+"</option>");
    }
    }
}

function consultaAvionRuta(idH){ $.ajax({
        url: 'AvionServlet',
        data: {
            accion: 'consultarAvion'
        },
        error: function () { //si existe un error en la respuesta del ajax
            alert("Se presento un error a la hora de cargar la información de las rutas en la base de datos");
        },
        success: function (data) { //si todo esta correcto en la respuesta del ajax, la respuesta queda en el data
            for (var i = 0; i < data.length; i++) {
        if(data[i].idRuta == idH)
            return data[i];
        
       }
            

        },
        type: 'POST',
        dataType: "json"
    });
}
    
     /******HORARIOS********/
     
function consultarHorarios() {
    mostrarModal("myModal", "Espere por favor..", "Consultando la información de horarios en la base de datos","false");
    //Se envia la información por ajax
    $.ajax({
        url: 'HorarioServlet',
        data: {
            accion: 'consultarHorarios'
        },
        error: function () { //si existe un error en la respuesta del ajax
            alert("Se presento un error a la hora de cargar la información de las horarios en la base de datos");
        },
        success: function (data) { //si todo esta correcto en la respuesta del ajax, la respuesta queda en el data
            anadirHorariosSelect(data);
            ocultarModal("myModal");

        },
        type: 'POST',
        dataType: "json"
    });
}

function anadirHorariosSelect(dataJson) {
    //limpia la información que tiene la tabla
    $("#idHorario").html(""); 
    
    for (var i = 0; i < dataJson.length; i++) {
        if(dataJson[i].idRuta == null){
         $("#idHorario").append("<option value='"+dataJson[i].idHorario+"'>"+dataJson[i].idHorario+"</option>");
    }
    }
}

function consultaHorarioRuta(idH) {
    $.ajax({
        url: 'HorarioServlet',
        data: {
            accion: 'consultarHorario'
        },
        error: function () { //si existe un error en la respuesta del ajax
            alert("Se presento un error a la hora de cargar la información de las rutas en la base de datos");
        },
        success: function (data) { //si todo esta correcto en la respuesta del ajax, la respuesta queda en el data
            for (var i = 0; i < data.length; i++) {
                if (data[i].idRuta == idH)
                    return data[i];

            }


        },
        type: 'POST',
        dataType: "json"
    });
}
    
     /******RUTAS********/

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
            dibujarTabla(data);
            // se oculta el modal esta funcion se encuentra en el utils.js
            ocultarModal("myModal");

        },
        type: 'POST',
        dataType: "json"
    });
    consultarAviones();
    consultarHorarios();
}

function dibujarTabla(dataJson) {
    //limpia la información que tiene la tabla
    $("#tablaRutas").html(""); 
    
    //muestra el enzabezado de la tabla
    var head = $("<thead />");
    var row = $("<tr />");
    head.append(row);
    $("#tablaRutas").append(head); 
    row.append($("<th><b>ID</b></th>"));
    row.append($("<th><b>ORIGEN</b></th>"));
    row.append($("<th><b>DESTINO</b></th>"));
    row.append($("<th><b>COSTO</b></th>"));
    row.append($("<th><b>DURACION</b></th>"));
    row.append($("<th><b>ID AVION</b></th>"));
    row.append($("<th><b>ID HORARIO</b></th>"));
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
    $("#tablaRutas").append(row); 
    row.append($("<td>" + rowData.idRuta + "</td>"));
    row.append($("<td>" + rowData.origen + "</td>"));
    row.append($("<td>" + rowData.destino + "</td>"));
    row.append($("<td> $" + rowData.costo + "</td>"));
    row.append($("<td>" + rowData.horas + "h y "+ rowData.minutos +"min</td>"));
    row.append($("<td> " + rowData.idAvion + "</td>"));
    row.append($("<td> " + rowData.idHorario + "</td>"));
    row.append($('<td><button type="button" class="btn btn-default btn-xs" aria-label="Left Align" onclick="consultarRutaByID('+"'"+rowData.idRuta+"'"+');">'+
                        '<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>'+
                    '</button>'+
                    '<button type="button" class="btn btn-default btn-xs" aria-label="Left Align" onclick="eliminarRuta('+"'"+rowData.idRuta+"'"+');">'+
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

function consultarRutaByID(idRuta) {
    mostrarModal("myModal", "Espere por favor..", "Consultando la Ruta seleccionada","false");
    //Se envia la información por ajax
    $.ajax({
        url: 'RutaServlet',
        data: {
            accion: "consultarRutaByID",
            idRuta: idRuta
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
            $("#rutasAction").val("modificarRuta"); 
            $("#cancelar").removeClass("hidden");
            //se carga la información en el formulario
            $("#identificador").val(data.idRuta);
            $("#origen").val(data.origen);
            $("#destino").val(data.destino);
            $("#costo").val(data.costo);
            $("#horas").val(data.horas);
            $("#minutos").val(data.minutos);
            
        },
        type: 'POST',
        dataType: "json"
    });
}

function eliminar(idRuta) {
    
    $.ajax({
        url: 'RutaServlet',
        data: {
            accion: "eliminarRuta",
            idRuta: idRuta
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
                setTimeout(consultarRutas, 3000);// hace una pausa y consulta la información de la base de datos
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
    
    else if(!validarLetras()){
        mostrarMensaje("alert alert-danger", "Solo Letras permitidas", "Error!");
    }
        
    else {
        //Se envia la información por ajax
        $.ajax({
            url: 'RutaServlet',
            data: {
                accion: $("#rutasAction").val(),
                idRuta: $("#identificador").val(),
                origen: $("#origen").val(),
                destino: $("#destino").val(),
                costo: $("#costo").val(),
                horas: $("#horas").val(),
                minutos: $("#minutos").val(),
                idAvion: $("#idAvion").val(),
                idHorario: $("#idHorario").val()
            },
            error: function () { //si existe un error en la respuesta del ajax
                mostrarMensaje("alert alert-danger", "Se genero un error, contacte al administrador (Error del ajax)", "Error!");
            },
            success: function (data) { //si todo esta correcto en la respuesta del ajax, la respuesta queda en el data
                var respuestaTxt = data.substring(2);
                var tipoRespuesta = data.substring(0, 2);
                if (tipoRespuesta === "C~") {
                    if($("#rutasAction").val() == "agregarRuta")
                    mostrarModal("myModal", "Exito", "Ruta agregada Correctamente!","true");
                else
                    mostrarModal("myModal", "Exito", "Ruta Modificada Correctamente!","true");
                
                    limpiarForm();
                    setTimeout(consultarRutas, 3000);
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
    $("#groupOrigen").removeClass("has-error");
    $("#groupDestino").removeClass("has-error");
    $("#groupHoras").removeClass("has-error");
    $("#groupMinutos").removeClass("has-error");
    $("#groupCosto").removeClass("has-error");
    

    //valida cada uno de los campos del formulario
    //Nota: Solo si fueron digitados
    if ($("#identificador").val() === "") {
        $("#groupId").addClass("has-error");
        validacion = false;
    }
    if ($("#origen").val() === "") {
        $("#groupOrigen").addClass("has-error");
        validacion = false;
    }
    if ($("#destino").val() === "") {
        $("#groupDestino").addClass("has-error");
        validacion = false;
    }
    if ($("#costo").val() === "") {
        $("#groupCosto").addClass("has-error");
        validacion = false;
    }
    if ($("#horas").val() === "") {
        $("#groupHoras").addClass("has-error");
        validacion = false;
    }
    if ($("#minutos").val() === "") {
        $("#groupMinutos").addClass("has-error");
        validacion = false;
    }
   

    return validacion;
}

function limpiarForm() {
    //setea el focus del formulario
    $('#Identificador').focus();
     $("#cancelar").addClass("hidden");
    //se cambia la accion por agregarPersona
    $("#rutasAction").val("agregarRuta"); 
    $("#identificador").removeAttr("readonly");

    //esconde el div del mensaje
    mostrarMensaje("hiddenDiv", "", "");

    //Resetear el formulario
    $('#formRuta').trigger("reset");
}

function validarNumeros(){
    $("#groupHoras").removeClass("has-error");
    $("#groupMinutos").removeClass("has-error");
    var validacion =true;
   var contenido = $("#horas").val();
    if(isNaN(contenido)){
         $("#groupHoras").addClass("has-error");
       validacion = false;
   }
    contenido = $("#minutos").val();
    if(isNaN(contenido)){
         $("#groupMinutos").addClass("has-error");
       validacion = false;
   }
   contenido = $("#costo").val();
    if(isNaN(contenido)){
         $("#groupCosto").addClass("has-error");
       validacion = false;
   }

   return validacion;
}

function validarTamCampos() {
    var validacion = true;

    //Elimina estilo de error en los css
    //notese que es sobre el grupo que contienen el input
    $("#groupId").removeClass("has-error");
    $("#groupOrigen").removeClass("has-error");
    $("#groupDestino").removeClass("has-error");
    $("#groupHoras").removeClass("has-error");
    $("#groupMinutos").removeClass("has-error");
    $("#groupCosto").removeClass("has-error");
    

    //valida cada uno de los campos del formulario
    //Nota: Solo si fueron digitados
    if ($("#identificador").val().length >8) {
        $("#groupId").addClass("has-error");
        validacion = false;
    }
    if ($("#origen").val().length >25) {
        $("#groupOrigen").addClass("has-error");
        validacion = false;
    }
    if ($("#destino").val().length >25) {
        $("#groupDestino").addClass("has-error");
        validacion = false;
    }
    if ($("#costo").val().length>25) {
        $("#groupCosto").addClass("has-error");
        validacion = false;
    }
    if ($("#horas").val().length>2) {
        $("#groupHoras").addClass("has-error");
        validacion = false;
    }
    
    if ($("#minutos").val().length>2 || $("#minutos").val()>59 || $("#minutos").val()<0 ) {
        $("#groupMinutos").addClass("has-error");
        validacion = false;
    }
    

    return validacion;
}

function validarLetras() {
    var validacion = true;

    //Elimina estilo de error en los css
    //notese que es sobre el grupo que contienen el input
    $("#groupId").removeClass("has-error");
    $("#groupOrigen").removeClass("has-error");
    $("#groupDestino").removeClass("has-error");
    $("#groupHoras").removeClass("has-error");
    $("#groupMinutos").removeClass("has-error");
    $("#groupCosto").removeClass("has-error");
    
    var cont = $("#origen").val();
    for(var i = 0;i<cont.length;i++)
    if (cont.charAt(i)!=" " && !isNaN(cont.charAt(i))) {
        $("#groupOrigen").addClass("has-error");
        validacion = false;
        break;
    }
    cont = $("#destino").val();
    for(var i = 0;i<cont.length;i++)
    if (cont.charAt(i)!=" " && !isNaN(cont.charAt(i))) {
        $("#groupDestino").addClass("has-error");
        validacion = false;
        break;
    }
  

    return validacion;
}



