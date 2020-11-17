$(document).ready(function(){

    if($('#controllo').val()=='2'){

        $('#users-tab').click()
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