package br.com.imaxTimetracker

import java.sql.Time

class Worked {


    Worker worker
    Date start
    Date end = null
    String Obs
    User lastChangeBy = null


    static constraints = {

        lastChangeBy nullable: true
        end nullable: true
    }
}
