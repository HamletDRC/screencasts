package pingpong

class PongController {
    def model

    def onPong = { evt = null ->
        edt { model.message = 'Pong' }
        sleep(1000)
        edt { model.message = '' }
        app.event('Ping')
    }
}
