package pingpong

class PingController {
    def model

    def onPing = { evt = null ->
        edt { model.message = 'Ping' }
        sleep(1000)
        edt { model.message = '' }
        app.event('Pong')
    }
}
