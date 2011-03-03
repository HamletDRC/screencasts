application {
    title = 'PingPong'
    startupGroups = ['PingPong']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "Pong"
    'Pong' {
        model = 'pingpong.PongModel'
        controller = 'pingpong.PongController'
        view = 'pingpong.PongView'
    }

    // MVC Group for "Ping"
    'Ping' {
        model = 'pingpong.PingModel'
        controller = 'pingpong.PingController'
        view = 'pingpong.PingView'
    }

    // MVC Group for "PingPong"
    'PingPong' {
        model = 'pingpong.PingPongModel'
        controller = 'pingpong.PingPongController'
        view = 'pingpong.PingPongView'
    }

}
