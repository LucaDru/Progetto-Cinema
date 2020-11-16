$(document).ready(function(){
    $(document).on('submit','.formPrenotazione',function(event){
        if($('#userLog').val()==0){
            event.preventDefault()
            $('#bottoneLog').click()
        }
    })
})