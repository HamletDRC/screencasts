package pingpong

class PongController {
    // these will be injected by Griffon
    def model
    def view

    // void mvcGroupInit(Map args) {
    //    // this method is called after model and view are injected
    // }

    // void mvcGroupDestroy() {
    //    // this method is called when the group is destroyed
    // }

    def onPong = { evt = null ->
        edt { model.message = 'Pong' }
        sleep(1000)
        edt { model.message = ''}
        app.event('Ping')
    }
}
