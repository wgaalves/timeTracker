package br.com.imaxTimetracker

import grails.converters.JSON

class UnityUIController {

    def index() {}


    def insertNewWorked(){

        def worker = Worker.findAllByPassword(params.password)
        def worked
        def listIntervals = Worked.findAllWhere(end: null,worker: worker[0])
        def response


        try {

            if (listIntervals.empty()) {
                worked = new Worked()
                worked.start = new Date()
                worked.end = null
                worked.worker = worker[0]
                worked.save(failOnError: true, flush: true)
            } else {
                worked = listIntervals[0]
                worked.end = new Date()
                worked.save(failOnError: true, flush: true)
            }
            response = "Success"
        }catch (Exception e){
            log.debug(e)
            response = "Error"
        }

        def jsonResponse = [response:response,date:new Date()]
        render jsonResponse as JSON

    }
}
