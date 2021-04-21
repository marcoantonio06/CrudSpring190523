function borrar(id){
swal({
  title: "¿Estas seguro de Eliminar?",
  text: "Ya no podra deshacer la acción",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
  		$.ajax({
  		url:"/borrar/"+id,
  		success: function(res){
  			console.log(res);
  		}
  		});
    swal("Registro eliminado correctamente", {
      icon: "success",
    }).then((ok)=>{
    if(ok){
    location.href="/mostrar";
    }
    });
  } else {
    swal("Tu registro sigue seguro");
  }
});
}