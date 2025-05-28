$(document).ready(function(){
	listar();
});

$("#save").click(function() {
	let fac = $("#facNuevo").val();
	$.post("facultad", { "nombre": fac, "opc": 3 }, function() {
		listar();
	});
	limpiar();
	cerrarNuevo();

});
$("#edit").click(function() {
	let fac = $("#facEdit").val();
	let id = $("#idEdit").val();
	$.post("facultad", { "id": id, "nombre": fac, "opc": 4 }, function() {
		listar();
	});
	cerrarEdit();

});
function editar(id) {
	$.get("facultad", { "id": id, "opc": 2 }, function(data) {
		var x = JSON.parse(data);
		$("#facEdit").val(x.nombre);
		$("#idEdit").val(x.idfacultad);
	});
	mostrarEdit();
}
function listar() {
	$.get("facultad", { "opc": 1 }, function(data) {
		var x = JSON.parse(data);
		$("#tablafac tbody tr").remove();
		x.forEach(function(item) {
			$("#tablafac").append("<tr><td>" + item.nombre + "</td><td><a href='#' onclick='editar(" + item.idfacultad + ")' class='btn btn-warning'><i class='far fa-edit'></i></a></td><td><a href='#' onclick='eliminar(" + item.idfacultad + ")' class='btn btn-danger'><i class='fas fa-trash-alt'></i></a></td></tr>"
			);
		});
	});
}
function eliminar(id) {

	$.get("facultad", { "id": id, "opc": 5 }, function() {
		listar();
	});
}
function limpiar() {
	$("#facNuevo").val("");
}
function cerrarNuevo() {
	const modalInstance = bootstrap.Modal.getInstance(document.getElementById('facModalNuevo')); //cuidado
	if (modalInstance) {
		modalInstance.hide();
	}
}
function cerrarEdit() {
	const modalInstance = bootstrap.Modal.getInstance(document.getElementById('facModalEdit'));
	if (modalInstance) {
		modalInstance.hide();
	}
}
function mostrarEdit() {
	const modal = new bootstrap.Modal(document.getElementById('facModalEdit'));
	modal.show();

}