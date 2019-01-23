import javax.swing.JSplitPane

import static javax.swing.JFrame.EXIT_ON_CLOSE
import java.awt.*
import groovy.swing.SwingBuilder

def tableData = [
        ["ATHLETEID": 1, "FIRSTNAME": "Bob", "LASTNAME": "Jones", "DATEOFBIRTH": '1875-05-20'],
        ["ATHLETEID": 2, "FIRSTNAME": "Sam", "LASTNAME": "Wilson", "DATEOFBIRTH": '1876-12-15'],
        ["ATHLETEID": 3, "FIRSTNAME": "Jessie", "LASTNAME": "James", "DATEOFBIRTH": '1877-06-12'],
        ["ATHLETEID": 4, "FIRSTNAME": "Jessie", "LASTNAME": "James", "DATEOFBIRTH": '1877-06-12'],
        ["ATHLETEID": 5, "FIRSTNAME": "Jessie", "LASTNAME": "James", "DATEOFBIRTH": '1877-06-12'],
        ["ATHLETEID": 6, "FIRSTNAME": "Jessie", "LASTNAME": "James", "DATEOFBIRTH": '1877-06-12'],
        ["ATHLETEID": 7, "FIRSTNAME": "Jessie", "LASTNAME": "James", "DATEOFBIRTH": '1877-06-12'],
        ["ATHLETEID": 8, "FIRSTNAME": "Jessie", "LASTNAME": "James", "DATEOFBIRTH": '1877-06-12'],
        ["ATHLETEID": 9, "FIRSTNAME": "Jessie", "LASTNAME": "James", "DATEOFBIRTH": '1877-06-12'],
        ["ATHLETEID": 10, "FIRSTNAME": "Jessie", "LASTNAME": "James", "DATEOFBIRTH": '1877-06-12'],
        ["ATHLETEID": 11, "FIRSTNAME": "Jessie", "LASTNAME": "James", "DATEOFBIRTH": '1877-06-12'],
        ["ATHLETEID": 12, "FIRSTNAME": "Jessie", "LASTNAME": "James", "DATEOFBIRTH": '1877-06-12'],
        ["ATHLETEID": 13, "FIRSTNAME": "Jessie", "LASTNAME": "James", "DATEOFBIRTH": '1877-06-12']
]

def swing = new SwingBuilder()
swing.edt {
    lookAndFeel 'nimbus'
    def border = compoundBorder([emptyBorder(10), titledBorder('?:')])
    frame(title: 'Address', size: [1000, 600], show: true, locationRelativeTo: null, defaultCloseOperation: EXIT_ON_CLOSE, resizable: true) {
        borderLayout(vgap: 5)
        panel(constraints: BorderLayout.WEST, border: compoundBorder([emptyBorder(10), titledBorder('WEST:')])) {
            tableLayout {
                tr { td { button 'Street:' } }
                tr { td { button 'Street:' } }
                tr { td { button 'Street:' } }
                tr { td { button 'Street:' } }
            }
        }
        splitPane(constraints: BorderLayout.CENTER, orientation: JSplitPane.VERTICAL_SPLIT, dividerLocation: 300, border: compoundBorder([emptyBorder(10), titledBorder('Center:')])) {
            scrollPane(id: 'topPane') {
                scrollPane(){
                    table(id: 'table01') {
                        tableModel(list: tableData, id: 'tableModel01') {
                            propertyColumn(header: 'Athlete ID', propertyName: 'ATHLETEID')
                            propertyColumn(header: 'First Name', propertyName: 'FIRSTNAME')
                            propertyColumn(header: 'Last Name', propertyName: 'LASTNAME')
                            propertyColumn(header: 'Date Of Birth', propertyName: 'DATEOFBIRTH')
                        }
                    }
                }
            }
            scrollPane(id: 'bottomPane') {
                table(id: 'table02') {
                    tableModel(list: tableData, id: 'tableModel01') {
                        propertyColumn(header: 'Athlete ID', propertyName: 'ATHLETEID')
                        propertyColumn(header: 'First Name', propertyName: 'FIRSTNAME')
                        propertyColumn(header: 'Last Name', propertyName: 'LASTNAME')
                        propertyColumn(header: 'Date Of Birth', propertyName: 'DATEOFBIRTH')
                    }
                }
            }
        }

        panel(constraints: BorderLayout.EAST, border: compoundBorder([emptyBorder(10), titledBorder('East:')])) {
            tableLayout {
                tr { td { button 'Street:' } }
                tr { td { button 'Street:' } }
                tr { td { button 'Street:' } }
                tr { td { button 'Street:' } }
            }
        }

        panel(constraints: BorderLayout.SOUTH, border: compoundBorder([emptyBorder(10), titledBorder('South:')])) {
            tableLayout(cellpadding: 1) {
                tr() {
                    td() {
                        label 'Status:'
                    }
                    td() {
                        progressBar()
                    }
                }
            }

        }
    }
}