$(document).ready(function () {
    const listaPosti = []
	var stringaPosti = ""

    $(document).on('click', '.seat', function () {
        var posto = $(this).attr('id')
        console.log("sto prenotando il posto " + posto)

        if (!($(this).hasClass('occupied'))) {

            if ($(this).hasClass('selected')) {
                listaPosti.splice(listaPosti.indexOf(posto))
                console.log(listaPosti)
            }
            else {
                listaPosti.push(posto)
                console.log(listaPosti)
            }
            $(this).toggleClass('selected')
        }
    })
	$(document).on('click', '#prosegui',function(event){
		if(listaPosti.length>0){
			$('#riepilogo-posti').text(listaPosti.length)
			
			listaPosti.forEach(element => {
	            stringaPosti += element + "-"
	        });
			
			$('#riepilogo-posti-codice').text(stringaPosti)
			$('#riepilogo-prezzo').text($('#prezzo').val()*listaPosti.length)
			$('#riepilogone-posti').modal('toggle');
		}
		else{
			event.preventDefault()
			alert("Devi selezionare almeno un posto!")
		}
	})

    $(document).on('click', '#conferma-posti', function (event) {
		if(listaPosti.length>0){
	        $('#inputNumPosti').val(listaPosti.length)			
			/*
	        var stringaPosti = ""
	
	        listaPosti.forEach(element => {
	            stringaPosti += element + "-"
	        });
			*/
	        $('#inputPostiSpecifici').val(stringaPosti)			
			$('#inviaPosti').submit()
		}		
    })
})