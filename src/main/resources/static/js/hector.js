/*
 *  Metodos para 
 *              el xml
 */

$(document).ready(function() {

	var pais = $(".pais").val();
	//alert(pais);
	console.log("pais = "+pais);
	$("#xmlCambiar").click(function(){
		
		var dato = $(".formXML").val();
		xmlDoc = $.parseXML(dato);
		  xml = $( xmlDoc );
		  title = xml.find( "title" );
		$(".form").html(title);
	});
});