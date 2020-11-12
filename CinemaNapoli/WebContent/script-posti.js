$(document).ready(function () {
    const listaPosti = []

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

    $(document).on('submit', '#confermaPosti', function (event) {

        $('#inputNumPosti').val(listaPosti.length)

        var stringaPosti = ""

        listaPosti.forEach(element => {
            stringaPosti += element + "-"
        });
        $('#inputPostiSpecifici').val(stringaPosti)
    })
})