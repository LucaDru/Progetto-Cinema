$(document).ready(function(){

    if($('#controllo').val()=='1'){

        $('#bottoneLog').click()
    }
  	
	$(document).on('click','#pwd-dimenticata',function(event){
		event.preventDefault()
		$('#chiudi-modale').click()
		$('#recupero-password').modal('show')
	})
})