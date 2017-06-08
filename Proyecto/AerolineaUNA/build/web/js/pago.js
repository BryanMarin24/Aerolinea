$(document).ready(function () {
    consultarTipoCambio();
});




function consultarTipoCambio() {
    mostrarModal("myModal", "Espere por favor..", "Consultando la información de personas en la base de datos");
    //Se envia la información por ajax
    $.ajax({
        url: 'PagoServlet',
        data: {
            accion: "consultarTipoCambio"
        },
        error: function () { //si existe un error en la respuesta del ajax
            alert("Indicar el tipo de cambio en 500");
        },
        success: function (data) { //si todo esta correcto en la respuesta del ajax, la respuesta queda en el data
            //find("ParentNode").attr("Symbol");
            var xmlResponseServer = $(data).find("obtenerindicadoreseconomicosxmlresponse");
            var xmlResponseSW = xmlResponseServer.prevObject.context.childNodes["0"].firstElementChild;
            var xmlResponseSWText = xmlResponseSW.childNodes["0"].data;
            
            var xmlDoc = jQuery.parseXML(xmlResponseSWText);
            var tipoCambioChild = $(xmlDoc).find('NUM_VALOR');
            var tipoCambio = tipoCambioChild.context.lastChild.lastElementChild.lastElementChild.innerHTML;
           //$("#tipoDeCambio").val(tipoCambio);
           alert(tipoCambio);

        },
        type: 'POST',
        dataType: "xml"
    });
}

