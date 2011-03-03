package pingpong

class PingPongController {
    // these will be injected by Griffon
    def model
    def view

    void mvcGroupInit(Map args) {
        createMVCGroup('Ping', 'ping')
        createMVCGroup('Pong', 'pong')
    }

    // void mvcGroupDestroy() {
    //    // this method is called when the group is destroyed
    // }

    def serve = { evt = null ->
        app.event('Ping')
    }
}
