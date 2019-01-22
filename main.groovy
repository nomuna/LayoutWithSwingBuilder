import groovy.swing.SwingBuilder
import groovy.beans.Bindable
import static javax.swing.JFrame.EXIT_ON_CLOSE
import java.awt.*
import groovy.swing.SwingBuilder

@Bindable
class Address {
    String street, number, city
    String toString() { "address[street=$street,number=$number,city=$city]" }
}

def address = new Address(street: 'Evergreen Terrace', number: '742', city: 'Springfield')

def swing = new SwingBuilder()
swing.edt {
    lookAndFeel 'nimbus'
    frame(title: 'Address', size: [420, 250], show: true, locationRelativeTo: null, defaultCloseOperation: EXIT_ON_CLOSE) {
        borderLayout(vgap: 5)
        panel(constraints: BorderLayout.CENTER, border: compoundBorder([emptyBorder(10), titledBorder('Enter your address:')])) {
            tableLayout {
                tr {
                    td {
                        label 'Street:'
                    }
                    td {
                        textField address.street, id: 'streetField', columns: 20
                    }
                }
                tr {
                    td {
                        label 'Number:'
                    }
                    td {
                        textField id: 'numberField', columns: 20, text: address.number
                    }
                }
                tr {
                    td {
                        label 'City:'
                    }
                    td {
                        textField id: 'cityField', columns: 20, address.city
                    }
                }
            }

        }

        panel(constraints: BorderLayout.SOUTH) {
            button text: 'Save', actionPerformed: {
                println address
            }
        }

        // Binding of textfield's to address object.
        bean address,
                street: bind { streetField.text },
                number: bind { numberField.text },
                city: bind { cityField.text }
    }
}