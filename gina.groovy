import groovy.swing.SwingBuilder
import static java.awt.BorderLayout.NORTH
import static java.awt.BorderLayout.CENTER
import static java.awt.BorderLayout.EAST
import static java.awt.BorderLayout.WEST

def swing = new SwingBuilder()
swing.edt {
    frame = swing.frame(id:'frame', title: 'Layout Demo', size: [500, 500], show: true) {
        panel() {
            tableLayout(){
                tr {
                    td { button 'one' }
                    td { button 'two' }
                }
                tr {
                    td(colspan:2) { button 'three' }
                }
            }
//            button(constraints: NORTH, 'North')
//            button(constraints: CENTER, 'Center')
//            button(constraints: SOUTH, 'South')
//            button(constraints: EAST, 'East')
//            button(constraints: WEST, 'West')
        }
    }
}
//swing.doLater {
//    frame.preferredSize = [500, 500]
//}
