package pingpong

class PingPongController {

    void mvcGroupInit(Map args) {
        createMVCGroup('Ping', 'ping')
        createMVCGroup('Pong', 'pong')
    }

    def serve = { evt = null ->
        app.event('Ping')
    }
}
