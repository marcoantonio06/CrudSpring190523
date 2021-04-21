function eliminar(id){
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
  		url:"/eliminar/"+id,
  		success: function(res){
  			console.log(res);
  		}
  		});
    swal("Registro eliminado correctamente", {
      icon: "success",
    }).then((ok)=>{
    if(ok){
    location.href="/listar";
    }
    });
  } else {
    swal("Tu registro sigue seguro");
  }
});
}