document.addEventListener("DOMContentLoaded", function() {
	document.getElementById("formulario").addEventListener('submit', validarFormulario); 
  });
  
  function validarFormulario(evento) {
	evento.preventDefault();
	let tamaño = document.getElementById('tamaño').value;
	if(tamaño == 0) {
	  alert('No has escrito nada en el tamaño');
	  return;
	}
	let hora = document.getElementById('hora').value;
	if (hora.length == 0) {
	  alert('No has escrito nada en la hora');
	  return;
	}
	let tiempo = document.getElementById('tiempo').value;
	if (tiempo.length == 0){
		alert('No has escrito nada en el tiempo previsto.');
		return;
	}
	let precio = document.getElementById('precio').value;
	if(precio <= 0){
		alert('No has introducido ningún precio');
		return;
	}
  if(precio < 20){
    alert('El precio mínimo es de 20€');
    return;
  }
	this.submit();
  }