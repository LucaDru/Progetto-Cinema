$(document).ready(function(){

    if($('#controllo').val()=='1'){

        $('#users-tab').click()
    }
	else if($('#controllo').val()=='2'){
		$('#proiezioni-tab').click()
	}
	else if($('#controllo').val()=='3'){
		$('#film-tab').click()
	}
	else if($('#controllo').val()=='4'){
		$('#sale-tab').click()
	}
	else if($('#controllo').val()=='5'){
		$('#profilo-tab').click()
	}
	else{
		$('#home-tab').click()
	}

    $(document).on('mouseover','.punti',function(){
        $(this).children().css('color','#460630')
    })
    $(document).on('mouseleave','.punti',function(){
        $(this).children().css('color','gray')
    })
    /*
    $(document).on('click','#miao',function(){
        if($('#controllo').val()=='2'){

            $('#users-tab').click()
        }
    })
    */
})