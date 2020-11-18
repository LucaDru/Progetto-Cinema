let tables = [];

$(document).ready(function () {

    /* FUNZIONI ORDINAMENTO ELEMENTI PRIMA TABELLA*/
    $('#ordineTitolo').on('click', function () {
        tables = [];
        let rows = $('.riga');
        for (let row of rows) {
            tables.push({
                numero: $(row).find('.col-numero').text(),
                titolo: $(row).find('.col-titolo').text(),
                durata: $(row).find('.col-durata').text(),
                giorno: $(row).find('.col-giorno').text(),
                ora: $(row).find('.col-ora').text(),
                posti: $(row).find('.col-posti').text(),
                bottone: $(row).find('.col-button').text()
            });
        }
        tables.sort(function (a, b) {
            return a.titolo.localeCompare(b.titolo)
        });
        let i = 0;
        for (let row of rows) {
            $(row).find('.col-numero').text(tables[i].numero)
            $(row).find('.col-titolo').text(tables[i].titolo)
            $(row).find('.col-durata').text(tables[i].durata)
            $(row).find('.col-giorno').text(tables[i].giorno)
            $(row).find('.col-ora').text(tables[i].ora)
            $(row).find('.col-posti').text(tables[i].posti)
            $(row).find('.col-button')
            i++;
        }

    })

    $('#ordineNumero').on('click', function () {
        tables = [];
        let rows = $('.riga');
        for (let row of rows) {
            tables.push({
                numero: $(row).find('.col-numero').text(),
                titolo: $(row).find('.col-titolo').text(),
                durata: $(row).find('.col-durata').text(),
                giorno: $(row).find('.col-giorno').text(),
                ora: $(row).find('.col-ora').text(),
                posti: $(row).find('.col-posti').text(),
                bottone: $(row).find('.col-button').text()
            });
        }
        tables.sort(function (a, b) {
            if (parseInt(a.numero) > parseInt(b.numero)) {
                return 1;
            } else if (parseInt(b.numero) > parseInt(a.numero)) {
                return -1;
            } else {
                return 0;
            }
        });
        let i = 0;
        for (let row of rows) {
            $(row).find('.col-numero').text(tables[i].numero)
            $(row).find('.col-titolo').text(tables[i].titolo)
            $(row).find('.col-durata').text(tables[i].durata)
            $(row).find('.col-giorno').text(tables[i].giorno)
            $(row).find('.col-ora').text(tables[i].ora)
            $(row).find('.col-posti').text(tables[i].posti)
            $(row).find('.col-button')
            i++;
        }

    })

    $('#ordineDurata').on('click', function () {
        tables = [];
        let rows = $('.riga');
        for (let row of rows) {
            tables.push({
                numero: $(row).find('.col-numero').text(),
                titolo: $(row).find('.col-titolo').text(),
                durata: $(row).find('.col-durata').text(),
                giorno: $(row).find('.col-giorno').text(),
                ora: $(row).find('.col-ora').text(),
                posti: $(row).find('.col-posti').text(),
                bottone: $(row).find('.col-button').text()
            });
        }
        tables.sort(function (a, b) {
            if (parseInt(a.durata) > parseInt(b.durata)) {
                return 1;
            } else if (parseInt(b.durata) > parseInt(a.durata)) {
                return -1;
            } else {
                return 0;
            }
        });
        let i = 0;
        for (let row of rows) {
            $(row).find('.col-numero').text(tables[i].numero)
            $(row).find('.col-titolo').text(tables[i].titolo)
            $(row).find('.col-durata').text(tables[i].durata)
            $(row).find('.col-giorno').text(tables[i].giorno)
            $(row).find('.col-ora').text(tables[i].ora)
            $(row).find('.col-posti').text(tables[i].posti)
            $(row).find('.col-button')
            i++;
        }

    })

    $('#ordineGiorno').on('click', function () {
        tables = [];
        let rows = $('.riga');
        for (let row of rows) {
            tables.push({
                numero: $(row).find('.col-numero').text(),
                titolo: $(row).find('.col-titolo').text(),
                durata: $(row).find('.col-durata').text(),
                giorno: $(row).find('.col-giorno').text(),
                ora: $(row).find('.col-ora').text(),
                posti: $(row).find('.col-posti').text(),
                bottone: $(row).find('.col-button').text()
            });
        }
        tables.sort(function (a, b) {
            let x = a.giorno.split('/');
            let y = b.giorno.split('/');
            if (parseInt(x[0]) > parseInt(y[0])) return 1;
            else if (parseInt(x[0]) < parseInt(y[0])) return -1;
            else if (parseInt(x[0]) == parseInt(y[0])) {
                if (parseInt(x[1]) > parseInt(y[1])) return 1;
                else if (parseInt(x[1]) < parseInt(y[1])) return -1;
                else if (parseInt(x[1]) == parseInt(y[1])) {
                    if (parseInt(x[2]) > parseInt(y[2])) return 1;
                    else if (parseInt(x[2]) < parseInt(y[2])) return -1;
                    else if (parseInt(x[2]) == parseInt(y[2])) return 0;
                }
            }
        }); 
        let i = 0;
        for (let row of rows) {
            $(row).find('.col-numero').text(tables[i].numero)
            $(row).find('.col-titolo').text(tables[i].titolo)
            $(row).find('.col-durata').text(tables[i].durata)
            $(row).find('.col-giorno').text(tables[i].giorno)
            $(row).find('.col-ora').text(tables[i].ora)
            $(row).find('.col-posti').text(tables[i].posti)
            $(row).find('.col-button')
            i++;
        }

    })

    $('#ordineOrario').on('click', function () {
        tables = [];
        let rows = $('.riga');
        for (let row of rows) {
            tables.push({
                numero: $(row).find('.col-numero').text(),
                titolo: $(row).find('.col-titolo').text(),
                durata: $(row).find('.col-durata').text(),
                giorno: $(row).find('.col-giorno').text(),
                ora: $(row).find('.col-ora').text(),
                posti: $(row).find('.col-posti').text(),
                bottone: $(row).find('.col-button').text()
            });
        }
        tables.sort(function (a, b) {
            let x = a.ora.split(':');
            let y = b.ora.split(':');
            if (parseInt(x[0]) > parseInt(y[0])) return 1;
            else if (parseInt(x[0]) < parseInt(y[0])) return -1;
            else if (parseInt(x[0]) == parseInt(y[0])) {
                if (parseInt(x[1]) > parseInt(y[1])) return 1;
                else if (parseInt(x[1]) < parseInt(y[1])) return -1;
                else if (parseInt(x[1]) == parseInt(y[1])) return 0;
            }
        });
        let i = 0;
        for (let row of rows) {
            $(row).find('.col-numero').text(tables[i].numero)
            $(row).find('.col-titolo').text(tables[i].titolo)
            $(row).find('.col-durata').text(tables[i].durata)
            $(row).find('.col-giorno').text(tables[i].giorno)
            $(row).find('.col-ora').text(tables[i].ora)
            $(row).find('.col-posti').text(tables[i].posti)
            $(row).find('.col-button')
            i++;
        }

    })

    $('#ordinePosti').on('click', function () {
        tables = [];
        let rows = $('.riga');
        for (let row of rows) {
            tables.push({
                numero: $(row).find('.col-numero').text(),
                titolo: $(row).find('.col-titolo').text(),
                durata: $(row).find('.col-durata').text(),
                giorno: $(row).find('.col-giorno').text(),
                ora: $(row).find('.col-ora').text(),
                posti: $(row).find('.col-posti').text(),
                bottone: $(row).find('.col-button').text()
            });
        }
        tables.sort(function (a, b) {
            return a.posti.localeCompare(b.posti)
        });
        let i = 0;
        for (let row of rows) {
            $(row).find('.col-numero').text(tables[i].numero)
            $(row).find('.col-titolo').text(tables[i].titolo)
            $(row).find('.col-durata').text(tables[i].durata)
            $(row).find('.col-giorno').text(tables[i].giorno)
            $(row).find('.col-ora').text(tables[i].ora)
            $(row).find('.col-posti').text(tables[i].posti)
            $(row).find('.col-button')
            i++;
        }

    })

    /* FUNZIONI ORDINAMENTO ELEMENTI SECONDA TABELLA*/
    $('#ordineTitoloPast').on('click', function () {
        tables = [];
        let rows = $('.riga1');
        for (let row of rows) {
            tables.push({
                numero: $(row).find('.col-numero-past').text(),
                titolo: $(row).find('.col-titolo-past').text(),
                durata: $(row).find('.col-durata-past').text(),
                giorno: $(row).find('.col-giorno-past').text(),
                ora: $(row).find('.col-ora-past').text(),
                posti: $(row).find('.col-posti-past').text(),
            });
        }
        tables.sort(function (a, b) {
            return a.titolo.localeCompare(b.titolo)
        });
        let i = 0;
        for (let row of rows) {
            $(row).find('.col-numero-past').text(tables[i].numero)
            $(row).find('.col-titolo-past').text(tables[i].titolo)
            $(row).find('.col-durata-past').text(tables[i].durata)
            $(row).find('.col-giorno-past').text(tables[i].giorno)
            $(row).find('.col-ora-past').text(tables[i].ora)
            $(row).find('.col-posti-past').text(tables[i].posti)
            i++;
        }

    })

    $('#ordineNumeroPast').on('click', function () {
        tables = [];
        let rows = $('.riga1');
        for (let row of rows) {
            tables.push({
                numero: $(row).find('.col-numero-past').text(),
                titolo: $(row).find('.col-titolo-past').text(),
                durata: $(row).find('.col-durata-past').text(),
                giorno: $(row).find('.col-giorno-past').text(),
                ora: $(row).find('.col-ora-past').text(),
                posti: $(row).find('.col-posti-past').text(),
            });
        }
        tables.sort(function (a, b) {
            if (parseInt(a.numero) > parseInt(b.numero)) {
                return 1;
            } else if (parseInt(b.numero) > parseInt(a.numero)) {
                return -1;
            } else {
                return 0;
            }
        });
        let i = 0;
        for (let row of rows) {
            $(row).find('.col-numero-past').text(tables[i].numero)
            $(row).find('.col-titolo-past').text(tables[i].titolo)
            $(row).find('.col-durata-past').text(tables[i].durata)
            $(row).find('.col-giorno-past').text(tables[i].giorno)
            $(row).find('.col-ora-past').text(tables[i].ora)
            $(row).find('.col-posti-past').text(tables[i].posti)
            i++;
        }

    })

    $('#ordineDurataPast').on('click', function () {
        tables = [];
        let rows = $('.riga1');
        for (let row of rows) {
            tables.push({
                numero: $(row).find('.col-numero-past').text(),
                titolo: $(row).find('.col-titolo-past').text(),
                durata: $(row).find('.col-durata-past').text(),
                giorno: $(row).find('.col-giorno-past').text(),
                ora: $(row).find('.col-ora-past').text(),
                posti: $(row).find('.col-posti-past').text(),
            });
        }
        tables.sort(function (a, b) {
            if (parseInt(a.durata) > parseInt(b.durata)) {
                return 1;
            } else if (parseInt(b.durata) > parseInt(a.durata)) {
                return -1;
            } else {
                return 0;
            }
        });
        let i = 0;
        for (let row of rows) {
            $(row).find('.col-numero-past').text(tables[i].numero)
            $(row).find('.col-titolo-past').text(tables[i].titolo)
            $(row).find('.col-durata-past').text(tables[i].durata)
            $(row).find('.col-giorno-past').text(tables[i].giorno)
            $(row).find('.col-ora-past').text(tables[i].ora)
            $(row).find('.col-posti-past').text(tables[i].posti)
            i++;
        }

    })

    $('#ordineGiornoPast').on('click', function () {
        tables = [];
        let rows = $('.riga1');
        for (let row of rows) {
            tables.push({
                numero: $(row).find('.col-numero-past').text(),
                titolo: $(row).find('.col-titolo-past').text(),
                durata: $(row).find('.col-durata-past').text(),
                giorno: $(row).find('.col-giorno-past').text(),
                ora: $(row).find('.col-ora-past').text(),
                posti: $(row).find('.col-posti-past').text(),
            });
        }
        tables.sort(function (a, b) {
            let x = a.giorno.split('/');
            let y = b.giorno.split('/');
            if (parseInt(x[0]) > parseInt(y[0])) return 1;
            else if (parseInt(x[0]) < parseInt(y[0])) return -1;
            else if (parseInt(x[0]) == parseInt(y[0])) {
                if (parseInt(x[1]) > parseInt(y[1])) return 1;
                else if (parseInt(x[1]) < parseInt(y[1])) return -1;
                else if (parseInt(x[1]) == parseInt(y[1])) {
                    if (parseInt(x[2]) > parseInt(y[2])) return 1;
                    else if (parseInt(x[2]) < parseInt(y[2])) return -1;
                    else if (parseInt(x[2]) == parseInt(y[2])) return 0;
                }
            }
        });
        let i = 0;
        for (let row of rows) {
            $(row).find('.col-numero-past').text(tables[i].numero)
            $(row).find('.col-titolo-past').text(tables[i].titolo)
            $(row).find('.col-durata-past').text(tables[i].durata)
            $(row).find('.col-giorno-past').text(tables[i].giorno)
            $(row).find('.col-ora-past').text(tables[i].ora)
            $(row).find('.col-posti-past').text(tables[i].posti)
            i++;
        }

    })

    $('#ordineOrarioPast').on('click', function () {
        tables = [];
        let rows = $('.riga1');
        for (let row of rows) {
            tables.push({
                numero: $(row).find('.col-numero-past').text(),
                titolo: $(row).find('.col-titolo-past').text(),
                durata: $(row).find('.col-durata-past').text(),
                giorno: $(row).find('.col-giorno-past').text(),
                ora: $(row).find('.col-ora-past').text(),
                posti: $(row).find('.col-posti-past').text(),
            });
        }
        tables.sort(function (a, b) {
            let x = a.ora.split(':');
            let y = b.ora.split(':');
            if (parseInt(x[0]) > parseInt(y[0])) return 1;
            else if (parseInt(x[0]) < parseInt(y[0])) return -1;
            else if (parseInt(x[0]) == parseInt(y[0])) {
                if (parseInt(x[1]) > parseInt(y[1])) return 1;
                else if (parseInt(x[1]) < parseInt(y[1])) return -1;
                else if (parseInt(x[1]) == parseInt(y[1])) return 0;
            }
        });
        let i = 0;
        for (let row of rows) {
            $(row).find('.col-numero-past').text(tables[i].numero)
            $(row).find('.col-titolo-past').text(tables[i].titolo)
            $(row).find('.col-durata-past').text(tables[i].durata)
            $(row).find('.col-giorno-past').text(tables[i].giorno)
            $(row).find('.col-ora-past').text(tables[i].ora)
            $(row).find('.col-posti-past').text(tables[i].posti)
            i++;
        }

    })

    $('#ordinePostiPast').on('click', function () {
        tables = [];
        let rows = $('.riga1');
        for (let row of rows) {
            tables.push({
                numero: $(row).find('.col-numero-past').text(),
                titolo: $(row).find('.col-titolo-past').text(),
                durata: $(row).find('.col-durata-past').text(),
                giorno: $(row).find('.col-giorno-past').text(),
                ora: $(row).find('.col-ora-past').text(),
                posti: $(row).find('.col-posti-past').text(),
            });
        }
        tables.sort(function (a, b) {
            return a.posti.localeCompare(b.posti)
        });
        let i = 0;
        for (let row of rows) {
            $(row).find('.col-numero-past').text(tables[i].numero)
            $(row).find('.col-titolo-past').text(tables[i].titolo)
            $(row).find('.col-durata-past').text(tables[i].durata)
            $(row).find('.col-giorno-past').text(tables[i].giorno)
            $(row).find('.col-ora-past').text(tables[i].ora)
            $(row).find('.col-posti-past').text(tables[i].posti)
            i++;
        }

    })




})