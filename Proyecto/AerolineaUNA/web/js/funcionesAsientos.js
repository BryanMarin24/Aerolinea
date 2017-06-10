var firstSeatLabel = 1;

$(document).ready(function () {
    var $cart = $('#selected-seats'),
            $counter = $('#counter'),
            $total = $('#total'),
            sc = $('#seat-map').seatCharts({
        map: [
            'fff_fff_fff',
            'fff_fff_fff',
            'eee_eee_eee',
            'eee_eee_eee',
            'eee_eee_eee',
            'eee_eee_eee',
            'eee_eee_eee',
            'eee_eee_eee',
            'eee_eee_eee',
            'eee_eee_eee',
            'eee_eee_eee',
            'eee_eee_eee',
            'eee_eee_eee',
            'eee_eee_eee',
            'eee_eee_eee',
            'eee_eee_eee',
            'eee_eee_eee',
            'eee_eee_eee',
            'eee_eee_eee',
            'eee_eee_eee',
            'eee_eee_eee',
            'eee_eee_eee'
        ],
        seats: {
            f: {
                price: 100,
                classes: 'first-class', //your custom CSS class
                category: 'Primera Clase'
            },
            e: {
                price: 40,
                classes: 'economy-class', //your custom CSS class
                category: 'Clase económica'
            }

        },
        naming: {
            top: false,
            getLabel: function (character, row, column) {
                return firstSeatLabel++;
            },
        },
        legend: {
            node: $('#legend'),
            items: [
                ['f', 'available', 'Primera Clase'],
                ['e', 'available', 'Clase Económica'],
                ['f', 'unavailable', 'Reservados']
            ]
        },
        click: function () {
            if (this.status() == 'available') {
                //let's create a new <li> which we'll add to the cart items
                $('<li>' + this.data().category + ' Asiento # ' + this.settings.label +
                        ': <b>$' + this.data().price + '</b> <a href="#" class="cancel-cart-item">[cancelar]</a></li>')
                        .attr('id', 'cart-item-' + this.settings.id)
                        .data('seatId', this.settings.id)
                        .appendTo($cart);

                /*
                 * Lets update the counter and total
                 *
                 * .find function will not find the current seat, because it will change its stauts only after return
                 * 'selected'. This is why we have to add 1 to the length and the current seat price to the total.
                 */
                $counter.text(sc.find('selected').length + 1);
                $total.text(recalculateTotal(sc) + this.data().price);
                
                $("#amount").val((recalculateTotal(sc) + this.data().price));
                
                /*
                document.getElementById("amount").value = $total.text(recalculateTotal(sc) + this.data().price);
                console.log($total.text(recalculateTotal(sc) + this.data().price));
                console.log(1);
                */
                
                return 'selected';
            } else if (this.status() == 'selected') {
                //update the counter
                $counter.text(sc.find('selected').length - 1);
                //and total
                $total.text(recalculateTotal(sc) - this.data().price);
                $("#amount").val((recalculateTotal(sc) + this.data().price));
/*
                document.getElementById("amount").value = $total.text(recalculateTotal(sc) + this.data().price);
                console.log($total.text(recalculateTotal(sc) + this.data().price));
                console.log(1);
*/              
                
                //remove the item from our cart
                $('#cart-item-' + this.settings.id).remove();

                //seat has been vacated
                return 'available';
            } else if (this.status() == 'unavailable') {
                //seat has been already booked
                return 'unavailable';
            } else {
                return this.style();
            }
        }
    });

    //this will handle "[cancel]" link clicks
    $('#selected-seats').on('click', '.cancel-cart-item', function () {
        //let's just trigger Click event on the appropriate seat, so we don't have to repeat the logic here
        sc.get($(this).parents('li:first').data('seatId')).click();
    });

    //let's pretend some seats have already been booked
    //sc.get(['1_2', '4_1', '7_1', '7_2']).status('unavailable');

});

function recalculateTotal(sc) {
    var total = 0;

    //basically find every selected seat and sum its price
    sc.find('selected').each(function () {
        total += this.data().price;
    });

    return total;
}